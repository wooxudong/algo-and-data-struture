package com.xudong.algo.linkedlist;


import java.util.HashMap;
import java.util.Map;


/**
 * This can be easily sovled by the {@link java.util.LinkedHashMap} to maintain the insertion
 * order, that seems to be quite a cheat. So I will try the version myself.
 * @author wooxudong
 */
public class LRUCache {

    private final int capacity;
    private final Map<Integer, BiListNode> map;
    private final BiListNode head;
    private final BiListNode tail;

    public LRUCache(int i) {
        this.capacity = i;
        this.map = new HashMap<>(capacity);
        this.head = new BiListNode(-1, -1);
        this.tail = new BiListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    private void removeNode(BiListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToTail(BiListNode node){
        tail.pre.next = node;
        node.pre = tail.pre;
        node.next = tail;
        tail.pre = node;
    }

    private void removeHead(){
        map.remove(head.next.key);
        removeNode(head.next);
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            BiListNode current = map.get(key);
            current.value = value;
            removeNode(current);
            addToTail(current);
        }else{
            BiListNode newNode = new BiListNode(key, value);
            map.put(key, newNode);
            addToTail(newNode);
        }

        if(map.size() > capacity){
            removeHead();
        }
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        BiListNode current = map.get(key);
        removeNode(current);
        addToTail(current);
        return current.value;
    }

    private static class BiListNode {
        BiListNode pre;
        BiListNode next;
        int key;
        int value;

        BiListNode(int key, int value) {
           this.key = key;
           this.value = value;
           pre = null;
           next = null;
        }
    }
}
