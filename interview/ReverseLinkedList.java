import java.util.Collections;
import java.util.LinkedList;

public class ReverseLinkedList {


    class Node{
        int value;
        Node next;
    }

    private static LinkedList<Integer> list = new LinkedList<Integer>();

    //N 2N
    public static LinkedList<Integer> reverse()
    {
        LinkedList<Integer> revList = new LinkedList<Integer>();
        for(int i = list.size() - 1; i >= 0; i--){
            revList.add(list.get(i));
        }
        return revList;
    }
    //N/2 1
    public static void reverse2()
    {
        for(int i = 0; i <= list.size()/2; i++){
            int temp = list.get(i);
            list.set(i,(list.get(list.size() - i - 1)));
            list.set(list.size() - i - 1 , temp);
        }
    }

    public static void main(String[] args){

        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        System.out.println(list.toString());
        //LinkedList<Integer> revList = reverse();
        //System.out.println(revList);
        reverse2();
        System.out.println(list.toString());
        Collections.reverse(list);
        System.out.println(list.toString());
    }
}
