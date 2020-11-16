package com.lbt.算法.链表.LRU缓存_146;

/**
 * @Description
 * @Author libitong
 * @Date 2020/11/16 19:32
 * 第146题：运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作：获取数据 get 和 写入数据 put 。
 * LRU是Least Recently Used的缩写，译为最近最少使用。它的理论基础为“最近使用的数据会在未来一段时期内仍然被使用，已经很久没有使用的数据大概率在未来很长一段时间仍然不会被使用”
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 *
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
public class Main {

    //采用hashmap+双向链表的方式进行实现。
}
