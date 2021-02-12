import java.util.Arrays;
import java.util.Comparator;

class Activity{
    int start;
    int end;
    Activity(int s, int e){
        this.start=s;
        this.end=e;
    }
}
class MyCmp implements Comparator<Activity> {

    @Override
    public int compare(Activity t1, Activity t2) {
        return t1.end - t2.end;
    }
}
class ActivitySelectionProblem{
    static int maxActivity(Activity arr[], int n) {
        Arrays.sort(arr,new MyCmp());
        int res=1;
        int prev=0;
        for (int i = 1; i < n ; i++) {
            if (arr[i].start>=arr[prev].end){
                res++;
                prev=i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Activity arr[]={new Activity(12, 25),
                new Activity(10, 20),
                new Activity(20, 30)};
        int n=3;
        System.out.println(maxActivity(arr,n));
    }
}