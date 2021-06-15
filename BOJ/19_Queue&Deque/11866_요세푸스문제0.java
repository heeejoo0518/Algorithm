import java.io.*;
import java.util.*;

public class Main{
	static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		br.close();
		
		for(int i=1;i<=n;i++) {
			queue.offer(i);
		}
		
		StringBuilder sb = new StringBuilder("<");
		int size = queue.size();
		for(int i=1;size>0;i++) {
			if(i%k==0) {
				if(size!=1) sb.append(queue.poll()+", ");
				else sb.append(queue.poll());
				size--;
			}
			else {
				queue.offer(queue.poll());
			}
		}
		sb.append(">");
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}