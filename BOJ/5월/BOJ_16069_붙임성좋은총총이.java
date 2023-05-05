import java.io.*;
import java.util.*;
 
public class BOJ_16069_붙임성좋은총총이 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        Set<String> set = new HashSet<>();
        set.add("ChongChong");
 
        StringTokenizer st;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(in.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            if(set.contains(a) || set.contains(b)){
                set.add(a);
                set.add(b);
            }
        }
 
        System.out.println(set.size());
    }
}
