package com.lbt.算法.链表.LRU缓存_146;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description
 * @Author libitong
 * @Date 2020/11/16 19:32
 * 第146题：运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作：获取数据 get 和 写入数据 put 。
 * LRU是Least Recently Used的缩写，译为最近最少使用。它的理论基础为“最近使用的数据会在未来一段时期内仍然被使用，已经很久没有使用的数据大概率在未来很长一段时间仍然不会被使用”
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 *
 *输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *

 *
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 *
 *
 * 进阶:你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * 示例:
 *
 * LRUCache cache = new LRUCache( 2 -缓存容量  );
 *
 *cache.put(1,1);
 *
 *cache.put(2,2);
 *
 *cache.get(1);       // 返回  1
 *
 *cache.put(3,3);    // 该操作会使得密钥 2 作废
 *
 *cache.get(2);       // 返回 -1 (未找到)
 *
 *cache.put(4,4);    // 该操作会使得密钥 1 作废
 *
 *cache.get(1);       // 返回 -1 (未找到)
 *
 *cache.get(3);       // 返回  3
 *
 *cache.get(4);       // 返回  4
 */
public class LRUCache {

    private int cap;
    //采用LinkedHashMap
    private Map<Integer,Integer> map = new LinkedHashMap<>();


    public LRUCache(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        //查看是否有
        if (map.get(key) !=null){
            //有，则先删除
            Integer value = map.remove(key);
            //然后在put
            map.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {

        //判断是否存在
        if (map.get(key) !=null){
            //存在则删除
            map.remove(key);
        }
        //判断缓存是否够
        if (map.size()== cap){
            //不够则移除最少使用的
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            iterator.next();
            iterator.remove();
        }
        //然后put
        map.put(key,value);

    }

    public static void main(String[] args) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        map.put(1,1);
        map.put(2,1);
        map.put(3,1);
        map.put(4,1);
        System.out.println(map.get(4)+"  "+map.get(5));
    }
}
