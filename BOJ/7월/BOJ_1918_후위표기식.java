import java.io.*;
import java.util.*;

public class BOJ_1918_후위표기식 {
	public static void main(String[] args) throws IOException {
		Map<Character, Integer> map = new HashMap<>();
		map.put('*',3);
		map.put('/',3);
		map.put('+',2);
		map.put('-',2);
		map.put('(',1);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = in.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (char c : arr) {
			if (c >= 'A' && c <= 'Z') sb.append(c);
			else if (c == '(') stack.push(c);
			else if (c == ')') {
				while (stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
			} else {
				while (!stack.isEmpty() && map.get(stack.peek()) >= map.get(c)) {
					sb.append(stack.pop());
				}
				stack.push(c);
			}
		}

		while(!stack.isEmpty()) sb.append(stack.pop());

		System.out.println(sb);
	}
}
