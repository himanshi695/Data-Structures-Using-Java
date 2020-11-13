import java.util.Scanner;

public class MergeSortOfSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        sc.nextLine();
        int a[]=new int[m];
        int b[]=new int[n];
        for (int i = 0; i < m; i++) {
            a[i]=sc.nextInt();
        }
        for (int i = 0; i < n ; i++) {
            b[i]=sc.nextInt();
        }
        int i=0;
        int j=0;
        while (i<m && j<n){
            if (a[i]<b[j]){
                System.out.print(a[i++] + " ");
            } else{
                System.out.print(b[j++] + " ");
            }
        }
        while (i<m){
            System.out.print(a[i++] + " ");
        }
        while (j<n){
            System.out.print(b[j++] + " ");
        }
    }
}
