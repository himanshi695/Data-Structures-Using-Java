class HeapSort {
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.heapSort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

    void maxHeapify(int arr[], int n, int i){
        int left=2*i+1;
        int right=2*i+2;
        int largest=i;
        if (left<n && arr[left]>arr[largest]){
            largest=left;
        }
        if (right<n && arr[right]>arr[largest]){
            largest=right;
        }
        if (largest!=i){
            swap(arr,i,largest);
            maxHeapify(arr,n,largest);
        }
    }

    void buildHeap(int arr[], int n){
        for (int i = n/2 - 1; i >=0 ; i--) {
            maxHeapify(arr,n,i);
        }
    }

    void swap(int[] arr, int a, int b) {
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }

    void heapSort(int arr[]){
        int n=arr.length;
        buildHeap(arr,n);
        for (int i = n-1; i >0 ; i--) {
            swap(arr,0, i);
            maxHeapify(arr, i,0);
        }
    }
}


