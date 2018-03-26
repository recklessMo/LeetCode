package com.recklessMo.leetcode;


import java.util.*;

public class Test {

    private static class Node{
        public Node next;
        public Node extra;
    }


    public static Node deepCopy(Node head){
        //浅拷贝，保存新旧节点的对应关系
        Map<Node, Node> nodeMap = new HashMap<>();
        Node dummy = new Node();
        Node last = dummy;
        while(head != null){
            Node temp = new Node();
            temp.next = head.next;
            temp.extra = head.extra;
            last.next = temp;
            last = temp;
            nodeMap.put(head, temp);
            head = head.next;
        }
        //深拷贝，将指向老节点的指针指向新节点。
        Node pos = dummy.next;
        while(pos != null){
            if(pos.extra != null){
                pos.extra = nodeMap.get(pos.extra);
            }
            pos = pos.next;
        }
        return dummy.next;
    }



    public static void main(String[] args){

//        Node a2 = new Node();
//        a2.next=null;
//        a2.extra = null;
//
//        deepCopy(a2);


//        Double a = 0.1;


        List<String>[] data = (List<String>[])new ArrayList[100];
        Object[] a = data;
        a[1] = new LinkedList<Integer>();





    }

}
