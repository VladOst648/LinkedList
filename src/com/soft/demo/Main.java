package com.soft.demo;

import javafx.beans.binding.ObjectExpression;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        LList l1 = new LList();
        l1.add("test1");
        l1.add("test2");
        l1.add("test3");
        int count = l1.size();
        System.out.println("List size: " + count);
        System.out.println(l1.get(1));
        System.out.println(l1.get(2));
        System.out.println(l1.get(3));
        System.out.println(l1.get(4));
    }
}

class Node {

    Object data;
    Node next;

    public Node(Object item) {
        this.data = item;
    }
}

class LList {
    private Node root;

    public void add(Object obj) {

        if (obj == null) {
            return;
        }
        Node node = new Node(obj);
        Node last = findLast();

        if (last == null) {
            root = node;
        } else {
            last.next = node;
        }
    }

    private Node findLast() {
        if (root == null) {
            return null;
        } else {
            Node currentNode = root;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            return currentNode;
        }
    }

    public int size() {
        if (root == null) {
            return  0;
        }
        int count = 1;
        Node currentNode = root;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            count++;
        }
        return  count;
    }

    public Object get(int id) {

        if (root == null) {
            return null;
        }

        if ((id > this.size()) || id < 1) {
            return null;
        }

        Node currentNode = root;

        for (int i = 1; i < id; i++) {

            currentNode = currentNode.next;

        }
        return currentNode.data;
    }
}




