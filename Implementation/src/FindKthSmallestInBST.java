class Tnode{
    int key;
    Tnode left;
    Tnode right;
    int lcount;
    Tnode(int k){
        key=k;
    }
}
public class FindKthSmallestInBST {
    public static Tnode insert(Tnode root, int x){
        if (root==null){
            return new Tnode(x);
        }
        if (x<root.key){
            root.left=insert(root.left,x);
            root.lcount++;
        } else if (x>root.key){
            root.right=insert(root.right,x);
        }
        return root;
    }
    public static Tnode KthSmallest(Tnode root, int k){
        if (root==null){
            return null;
        }
        int count=root.lcount+1;
        if (count==k){
            return root;
        }
        if (count>k){
            return KthSmallest(root.left,k);
        }
        return KthSmallest(root.right,k-count);
    }

    public static void main(String[] args) {
        Tnode root=null;
        int arr[]={ 20, 8, 22, 4, 12, 10, 14 };
        for (int x: arr) {
            root = insert(root,x);
        }
        int k=4;
        Tnode res = KthSmallest(root,4);
        //System.out.println(res.key);
        if (res==null){
            System.out.println("There are less than k nodes in the tree");
        } else{
            System.out.println("Kth smallest element is" + " " + res.key);
        }
    }
}
