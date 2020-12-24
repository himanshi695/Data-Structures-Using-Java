class Node {
    public int key;
    Node left;
    Node right;
    public Node(int k){
        this.key=k;
        left=right=null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
class HeightOfTheTree{
    public static void main(String[] args) {
        Node root = new Node(30);
        root.left=new Node(40);
        root.left.left=new Node(70);
        root.left.left.left=new Node(80);
        root.right =new Node(60);
        System.out.println(height(root));
    }
    public static int height(Node root){
        if (root==null){
            return 0;
        } else {
            return (Math.max(height(root.getLeft()),height(root.getRight()))+1);
        }
    }
}
