public class TrappingRainWater {
    static int trappingWater(int arr[], int n) {
        int res=0;
        int lmax[]=new int[n];
        int rmax[]=new int[n];
        lmax[0]=arr[0];
        rmax[n-1]=arr[n-1];
        for(int i=1;i<n;i++){
            lmax[i]=Math.max(arr[i],lmax[i-1]);
        }
        for(int j=n-2;j>=0;j--){
            rmax[j]=Math.max(arr[j],rmax[j+1]);
        }
        for(int k=1;k<n-1;k++){
            res+=Math.min(lmax[k],rmax[k])-arr[k];
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[]={3,0,1,2,5};
        int n=5;
        System.out.println(trappingWater(arr,n));
    }
}
