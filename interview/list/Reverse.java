package list;

import java.util.ArrayList;
import java.util.List;

public class Reverse {
    public static void main (String[] args){
        List<Integer> ll = new ArrayList<Integer>();
        ll.add(5);
        LinkedList3 linkedList = new LinkedList3();
        linkedList.appendIntoTail(new LinkedList3.Node("101"));
        LinkedList3.Node cycle = new LinkedList3.Node("201");
        linkedList.appendIntoTail(cycle);
        linkedList.appendIntoTail(new LinkedList3.Node("301"));
        linkedList.appendIntoTail(new LinkedList3.Node("401"));
        linkedList.appendIntoTail(new LinkedList3.Node("501"));
        linkedList.appendIntoTail(new LinkedList3.Node("601"));

        linkedList.reverse();
        System.out.println(linkedList);
        linkedList.reverseRecursive();
        System.out.println(linkedList);
        System.out.println(linkedList.length());
        System.out.println(linkedList.lengthRecursive(linkedList.Head()));

    }
}

class LinkedList3{
    private Node head;
    private Node tail;

    public LinkedList3(){
        this.head = new Node("HEAD");
        this.tail = head;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(head).append("-->");
        LinkedList3.Node current = head.next;
        while (current != null){
            sb.append(current).append("-->");
            current = current.next;
        }
        sb.delete(sb.length() - 3, sb.length());
        return sb.toString();
    }

    public Node Head(){
        return head;
    }

    public void add(Node node){
        tail.next = node;
        tail = node;
    }


    public int length(){
        int counter = 1;
        Node current = head;

        while (current.next != null ){
            current = current.next;
            counter++;
        }
        return counter;
    }

    public int lengthRecursive(Node node){
        if (node == null){
            return 0;
        }
        return 1 + lengthRecursive(node.next);
    }

    public void reverse(){
        Node previous = null;
        Node current = head;
        Node forward = null;

        while(current.next != null) {
            forward = current.next;
            current.next = previous;
            previous = current;
            current = forward;
        }

        current.next = previous;
        head = current;
    }


    public Node reverseRecursive(Node node){

        Node newHead;

        if (node.next == null) {
            return node;
        }

        newHead = reverseRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;

    }
    public void reverseRecursive(){
        head = reverseRecursive(head);
    }


    public void appendIntoTail(Node node){

        Node tail = head;
        while(tail.next != null){
            tail = tail.next; ///ПОЧЕМУ ИМЕЮ ДОСТУП?
        }
        tail.next = node;
    }


    public static class Node{
        private Node next;
        private String data;

        public Node(String data){
            this.data = data;
        }

        public Node getNext(){
            return next;
        }

        public String getData(){
            return data;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public void setData(String data){
            this.data = data;
        }

        @Override
        public String toString(){
            return "Node{" +
                    "data='" + data + '\'' +
                    '}';
        }
    }
}
