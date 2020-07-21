import java.util.LinkedList;

public class MyStack<T> {
    private final LinkedList<T> stack;

    public MyStack(){
        this.stack = new LinkedList<T>();
    }

    public boolean isEmpty(){
        return (stack.size() == 0);
    }

    public void push(T item){
        stack.addLast(item);
    }

    public T pop(){
        T element = stack.removeLast();
       /*T element2 = stack.remove(stack.size());
       stack.remove(stack.size());*/
        return element;
    }

    @Override
    public String toString(){
        /*StringBuilder sb = new StringBuilder();
        while (....stack....) {
            sb.append(....stack....).append(" ");
       }
        return sb.toString();*/
        return stack.toString();
    }

    public static void main(String[] args){
        MyStack<Character> myStack = new MyStack<Character>();
        String s = "alibaba";
        /*for (int i = s.length() - 1; i >= 0; i--) {
            myStack.push(s.charAt(i));
        }*/
        System.out.println(s);
        for (int i = 0; i <= s.length() - 1; i++) {
            myStack.push(s.charAt(i));
        }
        String rs = "";
        while (!myStack.isEmpty()) rs += myStack.pop();
        System.out.println(rs);
    }
}