package list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicate {
    public static void main (String[] args){

        LinkedList4 linkedList = new LinkedList4();
        linkedList.appendIntoTail(new LinkedList4.Node("101"));
        LinkedList4.Node cycle = new LinkedList4.Node("201");
        linkedList.appendIntoTail(cycle);
        linkedList.appendIntoTail(new LinkedList4.Node("301"));
        linkedList.appendIntoTail(new LinkedList4.Node("401"));
        linkedList.appendIntoTail(new LinkedList4.Node("501"));
        linkedList.appendIntoTail(new LinkedList4.Node("601"));
        linkedList.appendIntoTail(new LinkedList4.Node("701"));
        linkedList.appendIntoTail(new LinkedList4.Node("501"));
        linkedList.appendIntoTail(new LinkedList4.Node("501"));

        System.out.println(linkedList);
        linkedList.removeDuplicate2();
        System.out.println(linkedList);

    }
}

class LinkedList4{
    private Node head;
    private Node tail;

    public LinkedList4(){
        this.head = new Node("HEAD");
        this.tail = head;
    }

    public void removeDuplicate(){

        Node pointer1 = head;
        Node pointer2 = null;

        while(pointer1 != null && pointer1.next !=null){
            pointer2 = pointer1;
            while(pointer2.next != null){
                if (pointer1.data == pointer2.next.data){
                    pointer2.next = pointer2.next.next;
                    System.gc();
                }else {
                    pointer2 = pointer2.next;
                }
            }
            pointer1 = pointer1.next;
        }
    }

    static void removeDuplicate3 (Node head)
    {
        // Hash to store seen values
        HashSet<String> hs = new HashSet<>();

        /* Pick elements one by one */
        Node current = head;
        Node prev = null;
        while (current != null)
        {
            String curval = current.data;

            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }

    }
    public void removeDuplicate2(){

        Node current = head;
        Node previous = null;
        Set<String> set = new HashSet<String>();


        while(current != null){

            if (set.contains(current.data)){
                previous.next = current.next;
            }else
            {
                set.add(current.data);
                previous = current;
            }
            current = current.next;

           }
    }


    void remove_duplicates() {
        Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;

        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;

            /* Compare the picked element with rest
                of the elements */
            while (ptr2.next != null) {

                /* If duplicate then delete it */
                if (ptr1.data == ptr2.next.data) {

                    /* sequence of steps is important here */
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else /* This is tricky */ {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(head).append("-->");
        Node current = head.next;
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

    public Node getHead(){
        return head;
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
