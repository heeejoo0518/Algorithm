import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) heap.offer(num);
			else if(heap.isEmpty()) sb.append("0\n");
			else sb.append(heap.poll()+"\n");
		}
		
		br.close();
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}