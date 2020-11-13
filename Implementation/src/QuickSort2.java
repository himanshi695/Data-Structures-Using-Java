import java.util.Scanner;
//Hoare's partition....../////////////////////////////////////////////////////////////////
public class QuickSort2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int arr[]=new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i]=sc.nextInt();
        }
        int l=sc.nextInt(); int h=sc.nextInt();
        sc.nextLine();
        quickSort2(arr,l,h);
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort2(int arr[], int l, int h){
        if (l<h){
            int p =partioning2(arr, l, h);
            quickSort2(arr,l,p);
            quickSort2(arr,p+1,h);
        }
    }
    public static int partioning2(int arr[], int l, int h){
        int pivot=arr[l];
        int i=l-1;
        int j=h+1;
        while (true){
            do{
                i++;
            } while (arr[i]<pivot);
            do {
                j--;
            } while (arr[j]>pivot);
            if (i>=j){
                return j;
            } else{
                swap(arr, i,j);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
