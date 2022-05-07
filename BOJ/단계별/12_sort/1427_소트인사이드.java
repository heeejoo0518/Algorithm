import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		char[] num = br.readLine().toCharArray();	
		br.close();
		
		//Arrays.sort(num,Collections.reverseOrder()); //Character[] 타입만 가능
		Arrays.sort(num);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=num.length-1;i>=0;i--) {
			sb.append(num[i]);
		}
		
		System.out.println(Long.parseLong(sb.toString()));
	}
	
}
