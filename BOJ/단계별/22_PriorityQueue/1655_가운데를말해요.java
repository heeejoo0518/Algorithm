import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> min_heap = new PriorityQueue<>();
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(max_heap.size()<=min_heap.size()) max_heap.add(num);
			else min_heap.add(num);
			
			if(min_heap.size() != 0 && max_heap.peek() > min_heap.peek()) {
				int tmp = max_heap.poll();
				max_heap.add(min_heap.poll());
				min_heap.add(tmp);
			}
			
			sb.append(max_heap.peek()+"\n");
		}
		
		br.close();
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}