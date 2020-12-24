class TreeNode {
        public int key;
        Node left;
        Node right;
        public TreeNode(int k){
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
class PrintKDistance{
    public static void printKdist(Node root, int k){

        if (root==null){
            return;
        }
        if (k==0){
            System.out.println(root.getKey() + " ");
        } else {
            printKdist(root.getLeft(),k-1);
            printKdist(root.getRight(), k-1);
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
        int k=2;
        printKdist(root,k);
    }
}

