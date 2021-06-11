import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		char[] expression = br.readLine().toCharArray();
		br.close();
		
		int result = 0;
		boolean minus = false;

		StringBuilder num = new StringBuilder();
		for(int i=0;i<expression.length;i++) {
			if((int)'0'<=expression[i] && expression[i] <= (int)'9') {
				num.append(expression[i]);
				continue;
			}
			
			result += minus?-Integer.parseInt(num.toString()):Integer.parseInt(num.toString());
			num = new StringBuilder();
			
			if(expression[i]=='-') minus = true;
		}
		
		result += minus?-Integer.parseInt(num.toString()):Integer.parseInt(num.toString());
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(String.valueOf(result));
		
		bw.flush();
		bw.close();
	}
}