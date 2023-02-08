import java.io.*;
import java.util.*;

public class BOJ_2504_괄호의값 {
	public static void main(String[] args) throws IOException {
		char[] input = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
		Stack<Item> stack = new Stack<>();
		int tmp;
		for(int i=0;i<input.length;i++){
			if(input[i]=='(' || input[i]=='[') {
				stack.push(new Item(input[i]));
			}
			else if(input[i]==')'){
				tmp = 0;
				while(!stack.empty() && stack.peek().num !=0){
					tmp += stack.pop().num;
				}
				if(!stack.empty() && stack.pop().ch=='(') stack.push(new Item(2 * Math.max(tmp,1)));
				else{
					System.out.println(0);
					return;
				}
			}else if(input[i]==']'){
				tmp = 0;
				while(!stack.empty() && stack.peek().num != 0){
					tmp += stack.pop().num;
				}
				if(!stack.empty() && stack.pop().ch=='[') stack.push(new Item(3*Math.max(tmp,1)));
				else{
					System.out.println(0);
					return;
				}
			}
		}

		int result = 0;

		while(!stack.empty()) {
			result += stack.peek().num;
			if(stack.pop().num==0){
				System.out.println(0);
				return;
			}
		}
		System.out.println(result);
	}
	private static class Item {
		char ch = ' ';
		int num = 0;
		Item (char ch){
			this.ch=ch;
		}
		Item (int num){
			this.num = num;
		}
	}
}
