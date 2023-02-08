import java.io.*;
import java.util.*;

public class BOJ_2331_반복수열 {
	public static void main(String[] args) throws Exception {
		StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
		int prev = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();
		list.add(prev);
		int next;int idx;
		for(int i=0;i<1000000;i++){
			next = 0;
			for(int tmp = prev;tmp!=0;tmp/=10){
				next += Math.pow(tmp%10,P);
			}
			prev = next;
			if((idx = list.indexOf(prev))>=0) {
				System.out.println(idx);
				return;
			}
			list.add(prev);
		}

	}
}
