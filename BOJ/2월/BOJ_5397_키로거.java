import java.io.*;
import java.util.*;

public class BOJ_5397_키로거 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder answer = new StringBuilder();

		Stack<Character> front = new Stack<>();
		Stack<Character> back = new Stack<>();
		for(int i=0;i<N;i++){
			StringBuilder sb = new StringBuilder();

			for(char ch:in.readLine().toCharArray()){
				switch(ch){
					case '<':
						if(!front.empty())back.push(front.pop());
						break;
					case '>':
						if(!back.empty()) front.push(back.pop());
						break;
					case '-':
						if(!front.empty()) front.pop();
						break;
					default:
						front.push(ch);
						break;
				}
			}

			while(!front.empty()) sb.append(front.pop());
			sb.reverse();
			while(!back.empty()) sb.append(back.pop());
			answer.append(sb).append('\n');
		}

		System.out.print(answer);
	}
}
