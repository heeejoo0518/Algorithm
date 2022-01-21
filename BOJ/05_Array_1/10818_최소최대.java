import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10818_최소최대 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		while(st.hasMoreTokens()) {
			int tmp = Integer.parseInt(st.nextToken());
			if(tmp>max) max = tmp;
			if(tmp<min) min = tmp;
		}
		
		System.out.println(min+" "+max);
	}
}
