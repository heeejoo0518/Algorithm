import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack;
		char[] str;
		boolean result;
		for(int i=0;i<t;i++) {
			stack = new Stack<>();
			str = br.readLine().toCharArray();
			result = true;
			for(char s:str) {
				if(s=='(') {
					stack.push(s);
					continue;
				}
				
				if(stack.empty()) {
					result = false;
					break;
				}
				
				stack.pop();
			}
			
			if(!stack.empty()) result = false;
			
			if(result) sb.append("YES\n");
			else sb.append("NO\n");
		}
		
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}