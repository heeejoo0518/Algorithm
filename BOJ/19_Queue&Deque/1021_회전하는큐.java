import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		
		int[] nums = new int[m];
		for(int i=0;i<m;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		Deque<Integer> deque = new ArrayDeque<>();
		for(int i=1;i<=n;i++) {
			deque.offer(i);
		}
		
		int result = 0;
		for(int num:nums) {
			int left_len = 0;
			
			while(!deque.isEmpty()&& deque.peek() != num) {
				left_len++;
				deque.offer(deque.poll());
			}
			
			if(left_len < deque.size() - left_len) 
				result += left_len;
			else 
				result += (deque.size() - left_len);
			
			deque.poll();
		}
		
		bw.write(String.valueOf(result));
		
		bw.flush();
		bw.close();
	}
}