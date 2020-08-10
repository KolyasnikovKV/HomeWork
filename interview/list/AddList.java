package list;

public class AddList {

    public String printList(Node current){

        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }

        return sb.toString();
    }

    public class Node {
        Node next;
        int data;

        public Node(int data){
            this.data = data;
        }
    }

    Node head1 = null;
    Node head2 = null;
    Node result = null;
    int carry = 0;
    Node delta1 = null;



    public void push(int data, int list){
        if (list == 1) {
            Node newNode = new Node(data);
            newNode.next = head1;
            head1 = newNode;
        }
        else if(list == 2){
            Node newNode = new Node(data);
            newNode.next = head2;
            head2 = newNode;
        }
        else{
            Node newNode = new Node(data);
            newNode.next = result;
            result = newNode;
        }
    }

    public int getSize(Node head){
        int count = 0;

        while (head != null ){
            count++;
            head = head.next;

        }
        return count;
    }

    void propogateCarry(Node node1){
        if (node1 == delta1) {
            return;
        }
        propogateCarry(head1.next);

        int sum = node1.data + carry;
        carry = sum / 10;
        sum = sum % 10;
        push(sum, 3);

    }

    void sumList(Node node1, Node node2){

        if (node1 == null) return;

        sumList(node1.next, node2.next);
        int sum = node1.data + node2.data + carry;
        carry = sum / 10;
        sum = sum % 10;
        push(sum, 3);
    }

    void add(){

        int size1 = getSize(head1);
        int size2 = getSize(head2);

        if(size1 == size2){
            sumList(head1, head2);
        }
        else{
            if (size1 < size2) {
                Node temp = head1;
                head1 = head2;
                head2 = temp;
            }

            int diff = Math.abs(size1 - size2);

            delta1 = head1;
            while(--diff >= 0){
                delta1 = delta1.next;
            }

            sumList(delta1, head2);
            propogateCarry(head1);
        }
        if (carry > 0) {
            push(carry, 3);
        }

    }

    void addTwoLists(){
        Node node1 = head1;
        Node node2 = head2;
        while (node1 != null || node2 != null){

            int sum =  carry + (node1 == null ? 0 : node1.data) +(node2 == null ? 0 : node2.data);
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            push(sum, 3);

            if(node1 != null) {
                node1 = node1.next;
            }
            if(node2 != null) {
                node2 = node2.next;
            }

        }

        if (carry > 0) {
            push(carry, 3);
        }

    }


    public static void main(String[] arg){

        AddList list = new AddList();
        //int[] arr1 = new int[] {9, 9 ,9};
        //int[] arr2 = new int[] {1, 8};
        int[] arr1 = new int[] {9, 9 ,9};
        int[] arr2 = new int[] {8, 1};

        for (int i = arr1.length - 1; i >= 0; i--){
            list.push(arr1[i], 1);
        }
        for (int i = arr2.length - 1; i >= 0; --i){
            list.push(arr2[i], 2);
        }

        //int[] arr1 = new int[] {9, 9 ,9};
        //int[] arr2 = new int[] {1, 8};
        //list.add();
        list.addTwoLists();
        System.out.println(list.printList(list.result));

    }
}
