import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int k = Integer.parseInt(br.readLine());
		
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<k;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0 && !stack.empty()) stack.pop();
			else stack.push(num);
		}
		
		br.close();
		
		int sum = 0;
		while(!stack.empty()) {
			sum += stack.pop();
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(sum));
		
		bw.flush();
		bw.close();
	}
}