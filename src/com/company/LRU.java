package com.company;

import java.util.HashMap;

public class LRU<T> {
    private final int capacity;
    private HashMap<Integer, Node<T>> map;
    private Node<T> head = null;
    private Node<T> end = null;

    public LRU(int capacity) {
        assert capacity > 0;

        map = new HashMap<>();
        this.capacity = capacity;
    }

    public T get(int key) {
        assert map.containsKey(key);

        Node<T> n = map.get(key);

        remove(n);
        setHead(n);

        return n.value;
    }

    public T delete(int key) {
        assert map.containsKey(key);

        Node<T> n = map.remove(key);

        remove(n);

        return n.value;
    }

    public void put(int key, T value) {
        assert value != null;
        assert !map.containsKey(key);

        Node<T> created = new Node<>(key, value);

        if(map.size() == capacity) {
            map.remove(end.key);

            remove(end);
        }

        setHead(created);

        map.put(key, created);
    }

    public void set(int key, T value) {
        assert value != null;
        assert map.containsKey(key);

        Node<T> old = map.get(key);
        old.value = value;

        remove(old);
        setHead(old);
    }

    private void remove(Node<T> n){
        assert n != null;

        if(n.pre != null){
            n.pre.next = n.next;
        } else {
            head = n.next;
        }

        if(n.next != null){
            n.next.pre = n.pre;
        } else {
            end = n.pre;
        }
    }

    private void setHead(Node<T> n){
        n.next = head;
        n.pre = null;

        if(head != null) {
            head.pre = n;
        }

        head = n;

        if(end == null) {
            end = head;
        }
    }
}
