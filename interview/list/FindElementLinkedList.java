package list;

import java.util.Scanner;

public class FindElementLinkedList {
    public static void main (String[] args){
        LinkedList list = new LinkedList();
        LinkedList.Node head = list.Head();
        list.add(new LinkedList.Node("1"));
        list.add(new LinkedList.Node("2"));
        list.add(new LinkedList.Node("3"));
        list.add(new LinkedList.Node("4"));
        list.add(new LinkedList.Node("5"));
        list.add(new LinkedList.Node("6"));
        list.add(new LinkedList.Node("7"));
        list.add(new LinkedList.Node("8"));
        list.add(new LinkedList.Node("9"));
        list.add(new LinkedList.Node("10"));
        //list.add(head);

        LinkedList.Node current = head;
        LinkedList.Node middle = head;
        int lenght = 0;
        while(current.getNext() != null){
           current = current.getNext();
           if (current == head) break;
           lenght++;
           if (lenght % 2 == 0){
                middle = middle.getNext();
            }

        }

        if (lenght % 2 == 1){
            middle = middle.getNext();
        }

        System.out.println("lenght:" + lenght);
        System.out.println("middle:" + middle);

        // поиск i элемента с конца
        Scanner sc = new Scanner(System.in);
        int item = sc.nextInt();

        current = head;
        LinkedList.Node find = head;
        lenght = 0;
        while(current.getNext() != null){
            current = current.getNext();
            if (current == head) break;
            lenght++;
            if (lenght > item){
                find = find.getNext();
            }

        }
        System.out.println("find:" + find);

    }
}

class LinkedList{
    private Node head;
    private Node tail;

    public LinkedList(){
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
