import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<n;i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		br.close();
		
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[n];
		for(int i=n-1;i>=0;i--) {
			//A[i]보다 큰 수가 나올 때까지 pop
			while(!stack.empty() && stack.peek()<=A[i]) {
				stack.pop();
			}
			
			//비어있으면 큰 수가 없는 것이므로 -1
			if(stack.empty()) ans[i] = -1;//sb.insert(0,"-1 ");
			else ans[i] = stack.peek(); //sb.insert(0,stack.peek()+" ");
			
			//다음 비교를 위해 A[i] push
			stack.push(A[i]);
		}
		
		for(int i=0;i<n;i++) {
			sb.append(ans[i]+" ");
		}
		
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}