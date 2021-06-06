import java.io.*;
import java.util.*;

class Line implements Comparable<Line>{
	int a;
	int b;
	
	public Line(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	@Override
	public int compareTo(Line l) {
		return this.a - l.a;
	}
	
	@Override
	public String toString() {
		return a+" "+b;
	}
}

public class Main{
	static ArrayList<Line> list;
	static int dp[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		list.add(new Line(0,0));
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			list.add(new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		br.close();
		
		Collections.sort(list);
		dp = new int[n+1];
		
		getLine(n);

		int max=0;
		for(int i=1;i<n+1;i++) {
			if(max<dp[i]) max=dp[i];
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(n-max+"");
		bw.flush();
		bw.close();
	}
	
	public static int getLine(int n) {
		if(n<1) return 0;
		if(dp[n]!=0) return dp[n];
		
		if(n==1) return dp[1] = 1;
		
		getLine(n-1);
		
		dp[n] = 1;
		
		for(int i=1;i<n;i++) {
			if(dp[n]<=dp[i] && list.get(n).b > list.get(i).b) {
				dp[n]= dp[i]+1;
			}
		}
		
		return dp[n];
	}
}