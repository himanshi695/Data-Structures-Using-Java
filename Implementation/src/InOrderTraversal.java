public class InOrderTraversal {
    public static void inorder(Node root){
        if (root!=null){
            inorder(root.left);
            System.out.println(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left=new Node(20);
        root.left.left=new Node(40);
        root.left.right=new Node(50);
        root.right=new Node(30);
        root.right.right=new Node(70);
        root.right.right.right=new Node(80);
        inorder(root);
    }
}
