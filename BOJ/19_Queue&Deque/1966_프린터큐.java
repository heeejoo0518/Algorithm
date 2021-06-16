import java.io.*;
import java.util.*;

public class Main{
	public static class Printer{
		int priority;
		int index;
		public Printer(int priority, int index) {
			this.priority = priority;
			this.index = index;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		Queue<Printer> queue;
		PriorityQueue<Integer> pQueue;
		
		int[] doc;
		
		StringBuilder sb = new StringBuilder();
		
		while(t-->0) {
			queue = new LinkedList<>();
			pQueue = new PriorityQueue<>(Collections.reverseOrder());
			st = new StringTokenizer(br.readLine()," ");
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			doc = new int[n];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<n;i++) {
				int num = Integer.parseInt(st.nextToken());
				doc[i] = num;
				queue.offer(new Printer(num,i));
				pQueue.offer(num);
			}
			
			int cnt = 0;
			while(!queue.isEmpty()) {
				int curP = queue.peek().priority;
				int curI = queue.peek().index;
				queue.poll();
				
				if(curP != pQueue.peek()) {
					queue.offer(new Printer(curP, curI));
				}else {
					pQueue.poll();
					cnt++;
					
					if(curI==m) break;
				}
			}
			
			sb.append(cnt+"\n");
		}
		
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}