import java.io.*;
import java.util.*;

public class BOJ_11723_집합 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int S = 0;
		for(int i=0;i<M;i++){
			st = new StringTokenizer(in.readLine());
			switch(st.nextToken()){
				case "add":
					S = S|1<<Integer.parseInt(st.nextToken());
					break;
				case "remove":
					S = S&~(1<<Integer.parseInt(st.nextToken()));
					break;
				case "check":
					if((S&(1<<Integer.parseInt(st.nextToken())))!=0) sb.append("1\n");
					else sb.append("0\n");
					break;
				case"toggle":
					S = S^(1<<Integer.parseInt(st.nextToken()));
					break;
				case "all":
					S = (1<<21)-1;
					break;
				case "empty":
					S = 0;
					break;
			}
		}
		System.out.print(sb);
	}
}
