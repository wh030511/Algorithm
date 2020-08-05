package leetcode;

import java.util.HashMap;

/**
 * @author WuHao
 * @create 2020-04-30-12:56
 */
public class LRUCache { // 实现LRU最近最少使用缓存

    private HashMap<Integer , Node> cache = new HashMap<>();

    private int size;
    private int capacity;
    private Node head; // 左哨兵
    private Node tail; // 右哨兵

    class Node{ // 双向链表
        int key;
        int value;
        Node prev;
        Node next;
    }

    private void addElement(Node node){ // 添加元素到首部
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void delElement(Node node){ // 删除元素
        Node left = node.prev;
        Node right = node.next;

        left.next = right;
        right.prev = left;
    }

    private void moveToHead(Node node){ // 将元素移到首部
        delElement(node);
        addElement(node);
    }

    private Node pop(){ // 删除尾部元素
        Node res = tail.prev;
        delElement(res);
        return res;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1; // 没找到
        moveToHead(node); // 移到首部代表最近使用
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null){
            node = new Node();
            node.key = key;
            node.value = value;

            addElement(node); // 双向链表添加元素
            cache.put(key, node); // 缓存中添加元素

            size++;

            if (size > capacity){ // 如果容量不够
                Node tail = pop(); // 链表删除
                cache.remove(tail.key); // 缓存删除
                size--;
            }

        }
        else{ // 存在该元素
            node.value = value; // 更新
            moveToHead(node); // 移到最前
        }
    }
}
