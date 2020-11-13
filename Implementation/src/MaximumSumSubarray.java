import java.util.Scanner;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int arr[]=new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i]=sc.nextInt();
        }
        int res=arr[0];
        int maxEnding=arr[0];
        for (int i = 1; i < arr.length ; i++) {
            maxEnding=Math.max(maxEnding+arr[i],arr[i]);
            res=Math.max(res,maxEnding);
        }
        System.out.println(res);
    }
}
