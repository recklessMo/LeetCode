package com.recklessMo.leetcode;


import java.util.HashMap;
import java.util.LinkedList;

public class Solution_146 {


    private static class Node{
        public int value = -1;
        public Node prev = null;
        public Node next = null;
        public int key = -1;
    }

    private HashMap<Integer, Node> dataMap = null;
    private Node head = null;
    private Node tail = null;
    private int size = 0;


    public void LRUCache(int capacity) {
        size = capacity;
        dataMap = new HashMap<>(capacity);
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node oldNode = dataMap.get(key);
        if(oldNode == null){
            return -1;
        }
        //拿掉
        unlinkCurrent(oldNode);
        //插入
        moveFront(oldNode);
        return oldNode.value;
    }

    public void put(int key, int value) {
        if(size == 0){
            return;
        }
        Node newNode = new Node();
        newNode.value = value;
        newNode.key = key;
        Node oldNode = dataMap.put(key, newNode);
        if(oldNode == null){
            moveFront(newNode);
            if(dataMap.size() > size) {
                dataMap.remove(tail.prev.key);
                unlinkCurrent(tail.prev);
            }
        }else{
            unlinkCurrent(oldNode);
            moveFront(newNode);
        }
    }

    private void unlinkCurrent(Node current){
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    private void moveFront(Node current){
        head.next.prev = current;
        current.next = head.next;
        current.prev = head;
        head.next = current;
    }


    public static void main(String[] args){
        Solution_146 temp = new Solution_146();

        temp.LRUCache(2);

        temp.put(1, 1);
        temp.put(2, 2);
        System.out.println(temp.get(1));
        temp.put(3, 3);
        System.out.println(temp.get(2));
        temp.put(4, 4);
        System.out.println(temp.get(1));
        System.out.println(temp.get(3));
        System.out.println(temp.get(4));
    }


}
