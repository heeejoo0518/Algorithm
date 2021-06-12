import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		int[] sequence = new int[n];
		for(int i=0;i<n;i++) {
			sequence[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		int[] sorted = Arrays.stream(sequence).sorted().toArray();
		
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		int idx=0;
		
		for(int i=0;i<n;i++) {
			stack.push(sorted[i]);
			sb.append("+\n");
			while(!stack.empty() && stack.peek()==sequence[idx]) {
				stack.pop();
				idx++;
				sb.append("-\n");
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		if(stack.empty()) bw.write(sb.toString());
		else bw.write("NO");
		
		bw.flush();
		bw.close();
	}
}