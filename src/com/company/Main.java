package com.company;

public class Main {

    public static void main(String[] args) {
        LRU lru = new LRU(10);

	    for(int i = 0; i < 10; i++) {
            lru.put(i, i);
        }

        for(int i = 0; i < 10; i++) {
            lru.delete(i);
        }

        int a = 0;
    }
}
