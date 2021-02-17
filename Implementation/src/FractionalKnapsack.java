import java.lang.reflect.Array;
import java.util.Arrays;

public class FractionalKnapsack {
    static double fractionalKnapsack(Item arr[], int given_wt){
        Arrays.sort(arr);
        double res=0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i].wt<=given_wt){
                res=res+arr[i].val;
                given_wt=given_wt-arr[i].wt;
            } else{
                res=res+arr[i].val*(double)given_wt/(double)arr[i].wt;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Item arr[] = {new Item(10, 60),
                new Item(40, 40),
                new Item(20, 100),
                new Item(30, 120)};

        int W = 50;

        System.out.println(fractionalKnapsack(arr,W));
    }
}
class Item implements Comparable<Item>{
    int wt, val;
    public Item(int w, int v){
        this.wt=w;
        this.val=v;
    }
    @Override
    public int compareTo(Item item) {
        return (this.wt*item.val)-(this.val*item.wt);
    }
}