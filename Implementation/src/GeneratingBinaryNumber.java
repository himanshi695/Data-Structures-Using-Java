import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GeneratingBinaryNumber {

        static ArrayList<String> generate(int N)
        {
            ArrayList<String> adj=new ArrayList<>();
            Queue<String> q=new LinkedList<String>();
            q.add("1");
            while(N-->0){
                String s1=q.peek();
                q.remove();
                adj.add(s1);
                String s2=s1;
                q.add(s1 + "0");
                q.add(s2 + "1");
            }
            return adj;
        }
}
