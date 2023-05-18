import java.util.ArrayDeque;
import java.util.Stack;
import java.util.Queue;

public class BSTree {
    Node root;
    class Node{
        int data;
        BSTree.Node left;
        BSTree.Node right;
        BSTree.Node parent;


        Node(int d){
            this.data = d;
            this.parent = null;
            this.left = null;
            this.right = null;

        }


    }


    public void insert(int value) {
        root = insert(root, value);}
    private Node insert(Node current, int value) {
        if (current == null)
            return new Node(value);
        if(value < current.data) {
            current.left = insert(current.left, value);
        }
        else if(value > current.data) {
            current.right = insert(current.right, value);
        }
        return current;
    }
    public void Iterative(){
        Stack<Node> s = new Stack<Node>();
        Node node = this.root;
        while(s.size() > 0) {
            node = s.pop();
            System.out.println(node.data);
            if(node.left != null)
                s.push(node.left);
            if (node.right != null)
                s.push(node.right);

        }
        System.out.println(s);
    }
    public boolean isSubtree(Node root1, Node root2){
        if(root1 == null || root2 == null)
            return false;
        if(root1.data == root2.data)
            return equals(root1,root2);
        if(root1.data > root2.data)
            return isSubtree(root1.left, root2);
        if(root1.data < root2.data)
            return isSubtree(root1.right, root2.right);

        return false;
    }
    boolean equals(Node t1node, Node t2node)
    {
        if (t1node == null && t2node == null)
            return true;

        if (t1node == null || t2node == null)
            return false;

        return (t1node.data == t2node.data && equals(t1node.left, t2node.left) && equals(t1node.right, t2node.right));
    }

    public void preorderIterative(){
        Stack<Node> s = new Stack<Node>();
        s.push(this.root);
        while(s.size() > 0) {
            Node node = s.pop();
            System.out.println(node.data);
            if (node.right != null)
                s.push(node.right);
            if(node.left != null)
                s.push(node.left);
        }
    }



    public static void main(String... args){

        BSTree tree = new BSTree();tree.insert(30);
        tree.insert(25);
        tree.insert(35);
        tree.insert(23);
        tree.insert(34);
        tree.insert(37);
        tree.insert(20);
        tree.insert(24);
        tree.insert(36);
        tree.insert(22);
        tree.insert(21);

        tree.preorderIterative();

        System.out.println("-------------------------------");
        BSTree tree1 = new BSTree();
        tree1.insert(25);
        tree1.insert(23);
        tree1.insert(20);
        tree1.insert(24);
        tree1.insert(22);
        tree1.insert(21);
        tree1.preorderIterative();
        System.out.println("-------------------------------");
        System.out.println("is tree1 a subtree of tree?");
        System.out.println(tree1.isSubtree(tree.root,tree1.root));
    }

}