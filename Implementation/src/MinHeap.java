class MinHeap {
    int arr[];
    int size;
    int capacity;
    MinHeap(int c){
        arr=new int[c];
        capacity=c;
        size=0;
    }

    public static void main(String[] args) {
        MinHeap h=new MinHeap(11);
        h.insert(3);
        h.insert(2);
        h.delete(0);
        h.insert(15);
        h.insert(20);
        System.out.println(h.extractMin());
        h.decreaseKey(2, 1);
        System.out.println(h.extractMin());
    }

    int left(int i){
        return 2*i+1;
    }

    int right(int i){
        return 2*i+2;
    }

    int parent(int i){
        return (i-1)/2;
    }

    void insert(int x){
        if (size==capacity){
            return;
        }
        size++;
        arr[size-1]=x;
        for (int i = size-1; i !=0 && arr[parent(i)]>arr[i]; ) {
            swap(arr, i,parent(i));
            i=parent(i);
        }
    }

    void swap(int arr[],int i, int i1) {
        int temp=0;
        temp=arr[i];
        arr[i]=arr[i1];
        arr[i1]=temp;
    }

    void minHeapify(int i){
        int lt=left(i);
        int rt=right(i);
        int smallest=i;
        if (lt<size && arr[lt]<arr[i]){
            smallest=lt;
        }
        if (rt<size && arr[rt]<arr[smallest]){
            smallest=rt;
        }
        if (smallest!=i){
            swap(arr,i,smallest);
            minHeapify(smallest);
        }
    }

    int extractMin(){
        if (size==0){
            return Integer.MAX_VALUE;
        }
        if (size==1){
            return arr[0];
        }
        swap(arr,0,size-1);
        size--;
        minHeapify(0);
        return arr[size];
    }

    void decreaseKey(int i, int x){
        arr[i]=x;
        while (i!=0 && arr[parent(i)]>arr[i]){
            swap(arr,i,parent(i));
            i=parent(i);
        }
    }

    void delete(int i){
        decreaseKey(i,Integer.MIN_VALUE);
        extractMin();
    }

    void buildHeap(int size){
        for (int i = (size-2)/2; i >=0 ; i--) {
            minHeapify(i);
        }
    }
}
