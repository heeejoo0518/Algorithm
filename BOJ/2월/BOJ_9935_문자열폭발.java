import java.io.*;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
	static Stack<Character> stack = new Stack<>();
	static char[] bomb;
	static int len;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		char[] str = in.readLine().toCharArray();
		bomb = in.readLine().toCharArray();
		len = bomb.length;

		for(char ch:str){
			stack.push(ch);
			if(ch==bomb[len-1]){
				remove();
			}
		}

		if(stack.size()==0) {
			System.out.println("FRULA");
			return;
		}

		StringBuilder answer = new StringBuilder();
		while(!stack.empty()) answer.append(stack.pop());
		System.out.println(answer.reverse());
	}

	public static void remove(){
		for(int i=len-1;i>=0;i--){
			if(stack.empty() || stack.peek()!=bomb[i]){
				for(int j=i+1;j<len;j++){
					stack.push(bomb[j]);
				}
				return;
			}else{
				stack.pop();
			}
		}
	}
}
