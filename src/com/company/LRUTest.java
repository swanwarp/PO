package com.company;

import org.junit.Before;
import org.junit.Test;

public class LRUTest {
    private LRU<Integer> lru;
    private int size = 10;

    @Before
    public void start() {
        lru = new LRU<>(size);
    }

    @Test
    public void put() throws Exception {
        for(int i = 0; i < size; i++) {
            lru.put(i, i);
        }
    }

    @Test
    public void get() throws Exception {
        for(int i = 0; i < size; i++) {
            lru.put(i, i);
        }

        for(int i = 0; i < size; i++) {
            lru.get(i);
        }
    }

    @Test
    public void set() throws Exception {
        for(int i = 0; i < size; i++) {
            lru.put(i, i);
        }

        for(int i = 0; i < size; i++) {
            lru.set(i, i + 1);
        }
    }

    @Test
    public void delete() throws Exception {
        for(int i = 0; i < size; i++) {
            lru.put(i, i);
        }

        for(int i = 0; i < 10; i++) {
            lru.delete(i);
        }
    }
}