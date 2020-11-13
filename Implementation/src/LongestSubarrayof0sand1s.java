import java.util.HashMap;
import java.util.Scanner;

public class LongestSubarrayof0sand1s {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[]={0,0,1,1,1,1,1,0};
        int n=8;
        System.out.println(longestZeroSubarray(arr,n));

    }
    public static int longestZeroSubarray(int arr[], int n){
        HashMap<Integer,Integer> hm=new HashMap<Integer, Integer>();
        int pre_sum=0;
        int res=0;
        for (int i = 0; i < arr.length ; i++) {
            if (arr[i]==0){
                arr[i]=-1;
            }
        }
        for (int i = 0; i < n ; i++) {
            pre_sum+=arr[i];
            if (pre_sum==0){
                res=i+1;
            } else if(hm.containsKey(pre_sum)==false){
                hm.put(pre_sum,i);
            } else{
                res=Math.max(res,i-hm.get(pre_sum-0));
            }
        }
        return res;
    }
}

