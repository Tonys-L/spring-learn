package com.lt.spring.data.redis;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Component;

@Component("example")
public class Example {

  @Resource(name = "redisTemplate")
  HashOperations<String, byte[], byte[]> hashOperations;

  @Resource(name = "redisTemplate")
  HashOperations<String, String, Object> jsonHashOperations;

  HashMapper<Object, byte[], byte[]> hashMapper = new ObjectHashMapper();

  HashMapper<Object, String, Object> jackson2HashMapper = new Jackson2HashMapper(false);

  // inject the actual template
  @Autowired
  private RedisTemplate<String, Map<byte[],byte[]>> template;

  // inject the template as ListOperations
  @Resource(name = "redisTemplate")
  private ListOperations<String, String> listOps;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  public void addLink(String userId, URL url) {
    listOps.leftPush(userId, url.toExternalForm());
  }

  public void getLisk() {
    List<String> strings = listOps.range("1234333", 0, 100);
    System.out.println(strings.size());
    System.out.println(strings.get(0));
    for (String s : strings) {
      System.out.println(s);
    }
  }

  public void addString(String key, String value) {
    ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
    valueOperations.set(key, value);
  }

  public void addHash(String key,Person person) {
    Map<byte[],byte[]> map = hashMapper.toHash(person);
    template.opsForHash().putAll(key,map);
  }

  public Person loadHash(String key) {
    Arrays.parallelPrefix();
    Map<byte[],byte[]> map = hashOperations.entries(key);
    return (Person) hashMapper.fromHash(map);
  }

  public void addJsonHash(String key,Person person) {
    Map<String,Object> map = jackson2HashMapper.toHash(person);
    jsonHashOperations.putAll(key, map);
  }

  public void publishMsg(String channel,Object msg) {
    redisTemplate.convertAndSend(channel,msg);
  }

  public Person loadJsonHash(String key) {
    Map<String,Object> map = jsonHashOperations.entries(key);
    return (Person) jackson2HashMapper.fromHash(map);
  }

  @Cacheable(value = {"cacheName"},key = "'getPerson'")
  public String getPerson(String id) {
    return new Person().toString();
  }

}