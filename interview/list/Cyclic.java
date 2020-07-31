package list;

import java.util.Scanner;

public class Cyclic {
    public static void main (String[] args){
        LinkedList2 linkedList = new LinkedList2();
        linkedList.appendIntoTail(new LinkedList2.Node("101"));
        LinkedList2.Node cycle = new LinkedList2.Node("201");
        linkedList.appendIntoTail(cycle);
        linkedList.appendIntoTail(new LinkedList2.Node("301"));
        linkedList.appendIntoTail(new LinkedList2.Node("401"));
        linkedList.appendIntoTail(new LinkedList2.Node("501"));
        linkedList.appendIntoTail(new LinkedList2.Node("601"));
        linkedList.appendIntoTail(cycle);

        System.out.println("Linked List : " + linkedList);

        if(linkedList.isCyclic()){
            System.out.println("Linked List is cyclic");
        }

    }
}

class LinkedList2{
    private Node head;
    private Node tail;

    public LinkedList2(){
        this.head = new Node("HEAD");
        this.tail = head;
    }

    public Node Head(){
        return head;
    }

    public void add(Node node){
        tail.next = node;
        tail = node;
    }

    public boolean isCyclic(){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next!= null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
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
