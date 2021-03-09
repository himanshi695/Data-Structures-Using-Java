public class TripletsWithSumZero {
    public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);
        for(int i=0;i<n;i++){
            int low=i+1;
            int high=n-1;
            int x=arr[i];
            while(low<high){
                if(x+arr[low]+arr[high]==0){
                    return true;

                } else if(x+arr[low]+arr[high]<0){
                    low++;
                }else{
                    high--;
                }
            }
        }
        return false;
    }
}
