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
