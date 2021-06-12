import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		
		char[] line;
		Stack<Character> stack;
		boolean result;
		while(true) {
			line = br.readLine().toCharArray();
			if(line.length==1 && line[0] == '.') break;
			
			stack = new Stack<>();
			result = true;
			
			for(char c:line) {
				if((c>='a' && c<= 'z')||(c>='A' && c<='Z')|| c==' '|| c=='.') continue;
				
				if(c=='[' || c=='(') {
					stack.push(c);
					continue;
				}
				
				if(stack.empty()) {
					result = false;
					break;
				}
				
				char peek = stack.pop();
				
				if(c==']' && peek!='[') {
					result = false;
					break;
				} 
				
				if(c==')' && peek!='(') {
					result = false;
					break;
				}
				
			}
			
			if(result && stack.empty()) sb.append("yes\n");
			else sb.append("no\n");
		}
		
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
}