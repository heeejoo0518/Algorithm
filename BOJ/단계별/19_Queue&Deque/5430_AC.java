import java.io.*;
import java.util.*;

public class Main{
	static final int RORDER = 0;
	static final int ORDER = 1;
	static final int ERROR = 2;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		Deque<Integer> deque;
		int status;
		
		int len;
		char[] fnc;
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			deque = new ArrayDeque<>();
			status = ORDER;
			
			fnc = br.readLine().toCharArray();
			len = Integer.parseInt(br.readLine());
			
			//배열입력
			st = new StringTokenizer(br.readLine(),",|[|]");
			while(st.hasMoreTokens()) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			
			//함수실행
			for(char f:fnc) {
				if(status==ERROR) break;
				switch(f) {
				case 'R':
					status = status==ORDER? RORDER:ORDER;
					break;
				case 'D':
					if(deque.isEmpty()) {
						status = ERROR;
						break;
					}
					if(status==ORDER) deque.poll();
					else deque.pollLast();
					break;
				}
			}
			
			//출력
			if(status==ERROR) sb.append("error\n");
			else {
				sb.append("[");
				while(!deque.isEmpty()) {
					if(status==ORDER) sb.append(deque.poll());
					else sb.append(deque.pollLast());
					
					if(deque.size()!=0) sb.append(","); 
				}
				sb.append("]\n");
			}
		}
		
		br.close();
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}