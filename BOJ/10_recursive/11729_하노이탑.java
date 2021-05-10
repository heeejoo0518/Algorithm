import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());		
		br.close();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(hanoi(n,1,2,3)+"\n");
		bw.write(sb.toString());		
		
		bw.flush();
		bw.close();
	}
	
	public static int hanoi(int n, int a, int b, int c) {
		if(n<=0) return 0;
		
		int cnt=0;
		
		//n-1개의 판을 a에서 b로 이동
		cnt += hanoi(n-1,a,c,b);
		
		//1개의 판을 a에서 c로 이동
		sb.append(a+" "+c+"\n");
		cnt += 1;
		
		//n-1개의 판을 다시 b에서 c로 이동
		cnt += hanoi(n-1,b,a,c);
		
		return cnt;
	}
}
