import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
//		int[] stack = new int[10001];
		Stack<Integer> st = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
//		int top = -1;
		
		for(int i=0;i<n;i++) {
			String command = br.readLine();
			if(command.equals("pop")) {
				if(!st.empty()) sb.append(st.pop()+"\n");
				else sb.append("-1\n");
				
//				if(top==-1) sb.append("-1\n");
//				else {
//					sb.append(stack[top]+"\n");
//					stack[top--] = 0;
//				}
			}else if(command.equals("top")) {
				if(!st.empty()) sb.append(st.peek()+"\n");
				else sb.append("-1\n");
				
//				if(top==-1) sb.append("-1\n");
//				else sb.append(stack[top]+"\n");
			}else if(command.equals("size")) {
				sb.append(st.size()+"\n");
				
//				sb.append(top+1+"\n");
			}else if(command.equals("empty")){
				sb.append(st.empty()+"\n");
				
//				if(top==-1) sb.append("1\n");
//				else sb.append("0\n");
			}else { // push x
				st.push(Integer.parseInt(command.split(" ")[1]));
//				stack[++top] = Integer.parseInt(command.split(" ")[1]);
			}
		}
		
		
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}