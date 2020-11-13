import java.util.Scanner;

public class InversionOfArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        int arr[]=new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i]=sc.nextInt();
        }
        mergesort(arr,n);
    }
    public static int mergesort(int arr[], int size){
        int temp[]=new int[arr.length];
        return sort(arr, temp, 0, size-1);
    }

    public static int sort(int[] arr, int temp[], int l, int r){
        int mid=0;
        int inversion=0;
        if(l<r){
            mid=(l+r)/2;
            inversion = sort(arr,temp, l, r);
            inversion += sort(arr, temp,mid+1,r);
            inversion += merge(arr,temp, mid+1, l, r);
        }
        return inversion;
    }

    public static int merge(int[] arr,int temp[], int mid, int l, int r) {
        int n1=mid-l+1;
        int n2=r-mid;
        int left[]=new int[n1];
        int right[]=new int[n2];
        int inersion_count=0;
        for (int i = 0; i < n1; i++) {
            left[i]=arr[l+i];
        }
        for (int j = 0; j < n2; j++) {
            right[j]=arr[mid+1+j];
        }
        int i=0;
        int j=0;
        int k=l;
        while (i<n1 && j<n2){
            if (left[i]<=right[i]){
                temp[k++]=left[i++];
            } else {
                temp[k++]=right[j++];
                inersion_count+=(mid-i);
            }
        }
        while (i<n1){
            temp[k++]=left[i++];
        }
        while (j<n2){
            temp[k++]=right[j++];
        }
        return inersion_count;
    }
}
