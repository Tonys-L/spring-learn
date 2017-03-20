package com.lt.spring.data.redis;

import java.io.Serializable;
import java.util.Map;

/**
 * 功能：
 *
 * @author：liutao(286269159@qq.com)
 * @create：2017-03-09 12:02:54
 * @version：2017 Version：1.0
 * @company：北京黄羊 Created with IntelliJ IDEA
 */
public class DefaultMessageDelegate implements MessageDelegate {
	public void handleMessage(String message) {
		System.out.println("1:"+message);
	}

	public void handleMessage(Map message) {
		System.out.println("2:"+message);
	}

	public void handleMessage(byte[] message) {
		System.out.println("3:"+message);
	}

	public void handleMessage(Serializable message) {
		System.out.println("4:"+message);
	}

	public void handleMessage(Serializable message, String channel) {
		System.out.println("5:"+message+"----"+channel);
	}
}
