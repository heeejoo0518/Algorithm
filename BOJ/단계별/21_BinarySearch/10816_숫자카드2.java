import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Map<Integer,Integer> cards = new HashMap<>();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			Integer cnt = cards.get(num);
			if(cnt != null) {
				cards.put(num, cnt+1);
			} else {
				cards.put(num, 1);
			}
			new TreeMap<>().get(cnt);
		}
		
		int m = Integer.parseInt(br.readLine());		

		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<m;i++) {
			int num = Integer.parseInt(st.nextToken());
			Integer cnt = cards.get(num);
			if(cnt != null) sb.append(cnt+" ");
			else sb.append("0 ");
		}
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}