package com.chuanghai.common;

import java.io.Serializable;
import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by david on 2014/8/31.
 */
public final class SyncGet {
	private static SyncGet instance = new SyncGet();

	private Map<Object, LockItem> lockerMap = new ConcurrentHashMap<Object, LockItem>();

	public static <T> T exec(Object syncKey, IGetter<T> getter) {
		return instance.doExec(syncKey, getter);
	}

	private <T> LockItem<T> findLockItem(Object syncKey, IGetter<T> getter) {
		LockItem<T> lockItem = lockerMap.get(syncKey);
		if (lockItem == null) {
			lockItem = new LockItem<T>(getter);
			lockerMap.put(syncKey, lockItem);
		}
		lockItem.lockCount += 1;
		return lockItem;
	}

	private void realeaseLockItem(Object syncKey, LockItem lockItem) {
		lockItem.lockCount -= 1;
		if (lockItem.lockCount == 0) {
			lockerMap.remove(syncKey);
		}
	}

	private <T> T doExec(Object syncKey, IGetter<T> getter) {
		LockItem<T> lockItem = this.findLockItem(syncKey, getter);
		try {
			return lockItem.doGet();
		} finally {
			this.realeaseLockItem(syncKey, lockItem);
		}
	}

	class LockItem<T> implements Serializable {
		private static final long serialVersionUID = 2213458220023131912L;
		final IGetter<T> delegate;
		transient volatile boolean initialized;
		transient T value;
		private int lockCount = 0;

		LockItem(IGetter<T> delegate) {
			this.delegate = delegate;
		}

		// 参考： com.google.common.base.Suppliers.MemoizingSupplier 实现
		private T doGet() {
			// A 2-field variant of Double Checked Locking.
			if (!initialized) {
				synchronized (this) {
					if (!initialized) {
						T t = delegate.get();
						value = t;
						initialized = true;
						return t;
					}
				}
			}
			return value;
		}
	}

	public static void main1(String[] args) {
		final List<Thread> threads = new ArrayList < Thread>();
		final List<Thread> threads1 = new ArrayList<Thread>();
		int count = 10;
		for (int i=0;i<count;i++) {
			final int finalI = i;
			Thread t = new Thread(new Runnable() {
				public void run() {
					SyncGet.exec(finalI, new IGetter<String>() {
						public String get() {
							System.out.println(Thread.currentThread().getName() + "开始执行");
							try {
								/*if (finalI == 5) {
									Thread.sleep(10000);
								}*/
								Thread.sleep(10000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}

							Thread thread = threads1.get(finalI);
							System.out.println(Thread.currentThread().getName() + "执行完成   "+ thread.getName() + ":"+thread.getState() + (!thread.getState().equals(State.BLOCKED)?"************************":""));
							return "finalI"+finalI;
						}
					});
				}
			},"Thread"+finalI);
			threads.add(t);
			t.start();
		}

		for (int j = 0;  j< count; j++) {
			final int finalJ = j;
			Thread t = new Thread(new Runnable() {
				boolean state = true;
				public void run() {
					try {
						Thread.sleep(10);
						System.out.println(Thread.currentThread().getName() + "开始执行");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					while (state) {
						SyncGet.exec(finalJ, new IGetter<String>() {
							public String get() {
								state = false;
								Thread  t= threads.get(finalJ);
								System.out.println("--[Thread]"+finalJ+"执行完成" + "  " + t.getName() + ":"+t.getState() + (!t.getState().equals(State.TERMINATED)?"++++++++++++++++++":""));
								return "--------";
							}
						});
					}
				}
			},"--[Thread]"+finalJ);
			threads1.add(t);
			t.start();
		}

		/*new Thread(new Runnable() {
			boolean state = true;
			public void run() {
				while (state) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					SyncGet.exec(5, new IGetter<String>() {
						public String get() {
							state = false;
							System.out.println("--[Thread]"+5+"执行完成");
							return "--------";
						}
					});
				}
			}
		},"--[Thread]"+5).start();*/

	}

	public static void main(String[] args) throws Exception {
		int count =10;
		for (int i = 0; i <=count; i++) {
			Thread t = new Thread(new Runnable() {
				public void run() {
					final  String threadName=Thread.currentThread().getName();
					final  int threadId=Integer.parseInt(threadName);
					final  int syncKey=threadId%2;
					System.out.println("线程"+threadName+ "开始执行 SyncKey:"+syncKey);

					String syncGetResult=SyncGet.exec(syncKey, new IGetter<String>() {
						public String get() {

							try {
								System.out.println("线程"+threadName+ " 进入回调函数，将返回"+threadId+" SyncKey:"+syncKey);
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							return threadId+"";
						}
					});
					System.out.println("线程"+threadName+ " syncGetResult:"+syncGetResult);
				}
			}, i+"");
			t.start();
		}
	}


}
