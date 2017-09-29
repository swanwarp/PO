package com.company;

public class Node<T> {
    int key;
    T value;
    Node<T> pre;
    Node<T> next;

    public Node(int key, T value){
        this.key = key;
        this.value = value;
    }
}
