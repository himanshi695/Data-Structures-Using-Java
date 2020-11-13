import java.util.Scanner;
//Lomuto's partioning.....////////////////////////////////////////////////////////////////////
public class QuickSort {
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
        quickSort(arr,l,h);
        printArray(arr);
    }
    public static void quickSort(int arr[], int l, int h){
        if (l<h){
            int p=partioning(arr,l,h);
            quickSort(arr,l,p-1);
            quickSort(arr,p+1,h);
        }
    }
    public static int partioning(int arr[], int l, int h){
        int pivot=arr[h];
        int i=l-1;
        for (int j = l; j <=h ; j++) {
            if (arr[j]<pivot){
                i++;
                swap(arr, i , j);
            }
        }
        swap(arr, i+1, h);
        return i+1;
    }

    private static void swap(int arr[], int i, int i1) {
        int temp=arr[i];
        arr[i]=arr[i1];
        arr[i1]=temp;
    }
    public static void printArray(int arr[]){
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
