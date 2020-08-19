package tree;

import com.sun.deploy.util.SyncAccess;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String [] arg)throws Exception{
        BinaryTree bt = new BinaryTree();
        BinaryTree.TreeNode root = new BinaryTree.TreeNode("4");
        bt.root = root;
        bt.root.left = new BinaryTree.TreeNode("2");
        bt.root.left.left = new BinaryTree.TreeNode("1");
        bt.root.left.right = new BinaryTree.TreeNode("3");
        bt.root.right = new BinaryTree.TreeNode("5");
        bt.root.right.right = new BinaryTree.TreeNode("6");



        System.out.printf("%nRecusion preOrder %n");
        bt.preOrder();
        System.out.printf("%nRecusion inOrder %n");
        bt.inOrder();
        System.out.printf("%nRecusion postOrder %n");
        bt.postOrder();
        BinaryTree bt2 = BinaryTree.create();
        System.out.printf("%nRecusion postOrder2 %n");
        bt2.postOrder();
        System.out.printf("%nIteration preOrderWithouRecursion %n");
        bt.preOrderWithouRecursion();
        System.out.printf("%nIteration inOrderWithouRecursion %n");
        bt.inOrderWithouRecursion();
        System.out.printf("%nIteration postOrderWithouRecursion %n");
        bt2.postOrderWithouRecursion2();
        System.out.printf("%nIteration postOrderWithouRecursion %n");
        bt2.postOrderWithouRecursion();
        //System.out.println(bt.size());


    }

}

class BinaryTree{
    static class TreeNode{
        String data;
        TreeNode left, right;

        TreeNode(String value){
            this.data = value;
            left = right = null;
        }

        boolean isLeaf() {
            return left == null ? right == null : false;
        }
    }

    TreeNode root;


    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(TreeNode node){
        if (node == null){
            return;
        }

        System.out.printf("%s ", node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(TreeNode node){
        if (node == null){
            return;
        }

        inOrder(node.left);
        System.out.printf("%s ", node.data);
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(TreeNode node){
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.printf("%s ", node.data);
    }





    public void inOrderWithouRecursion(){
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode current = root;

        while(!nodes.isEmpty() || current != null){

            if (current != null){
                nodes.push(current);
                current = current.left;
            } else {
                current = nodes.pop();
                System.out.printf("%s ", current.data);
                current = current.right;
            }

        }
    }

    public void preOrderWithouRecursion(){
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        while(!nodes.isEmpty()){
            TreeNode current = nodes.pop();

            System.out.printf("%s ", current.data);

            if(current.right != null){
                nodes.push(current.right);
            }

            if(current.left != null){
                nodes.push(current.left);
            }


        }
    }


    public void postOrderWithouRecursion(){
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        while(!nodes.isEmpty()){
            TreeNode current = nodes.peek();

            if (current.isLeaf()){
                TreeNode node = nodes.pop();
                System.out.printf("%s ", node.data);
            } else {
                if(current.right != null){
                    nodes.push(current.right);
                    current.right = null;
                }
                if(current.left != null){
                    nodes.push(current.left);
                    current.left = null;
                }
            }

        }
    }

    public void postOrderWithouRecursion2(){
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        TreeNode lastPrintedNode = root;
        TreeNode current;
        while(!nodes.isEmpty()){
            current = nodes.pop();
             if (current.isLeaf() || lastPrintedNode == current.left || lastPrintedNode == current.right){
                System.out.printf("%s ", current.data);
                lastPrintedNode = current;
            } else {

                 nodes.push(current);

                if(current.right != null){
                    nodes.push(current.right);
                }
                if(current.left != null){
                    nodes.push(current.left);
                }
            }

        }
    }


    public int size(){
        TreeNode current = root;
        int size = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (!stack.isEmpty() || current != null){
            if(current != null){
                stack.push(current);
                current = current.left;
            } else {
                size++;
                current = stack.pop();
                System.out.println(current.data);
                current = current.right;
            }

        }
        return size;
    }

    public static BinaryTree create() {
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode("55");
        tree.root = root;
        tree.root.left = new TreeNode("35");
        tree.root.left.left = new TreeNode("25");
        tree.root.left.left.left = new TreeNode("15");
        tree.root.left.right = new TreeNode("45");
        tree.root.right = new TreeNode("65");
        tree.root.right.right = new TreeNode("75");
        tree.root.right.right.left = new TreeNode("87");
        tree.root.right.right.right = new TreeNode("98");
        return tree; }


    
}