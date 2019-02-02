package submitted;

import java.util.HashMap;

/**
 * https://leetcode.com/submissions/detail/205185038/
 * 1. Access to a random key in O(1) -> hashmap
 * 2. Remove the last entry in LRU cache in O(1) -> doubly linked list
 * 3. Add/move an entry to the front of LRU cache in O(1) -> doubly linked list
 */
public class LRUCache {
    private HashMap<Integer, Node> map = new HashMap<>();
    private int capacity;
    private Node head;
    private Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            Node created = new Node(key, value);
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }

    void remove(Node node) {
        if (node.pre != null) {
            node.pre.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.pre = node.pre;
        } else {
            tail = node.pre;
        }
    }

    void setHead(Node node) {
        node.next = head;
        node.pre = null;
        if (head != null) {
            head.pre = node;
        }

        head = node;
        if (tail == null) {
            tail = head;
        }
    }
}

class Node {
    int key;
    int value;
    Node next;
    Node pre;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}