class TNode{
    int key;
    TNode left;
    TNode right;
    TNode(int k){
        key=k;
    }
}
public class CheckForBST {
    public static boolean isBST(TNode root, int min, int max){
        if (root==null){
            return true;
        }
        return root.key>min && root.key<max && isBST(root.left,min,root.key) && isBST(root.right,root.key,max);
    }

    public static void main(String[] args) {
        TNode root = new TNode(4);
        root.left = new TNode(2);
        root.right = new TNode(5);
        root.left.left = new TNode(1);
        root.left.right = new TNode(3);
        if (isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
            System.out.println("It is a BST");
        } else{
            System.out.println("It is not a BST");
        }
    }
}
