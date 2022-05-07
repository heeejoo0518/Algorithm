import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][][] valueW = new int[21][21][21];
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		

		int[] input = new int[3];
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<3;i++) input[i] = Integer.parseInt(st.nextToken());
			if(input[0] == -1 && input[1] == -1 && input[2] == -1) break;
			sb.append(String.format("w(%d, %d, %d) = %d\n",input[0],input[1],input[2],fncW(input[0],input[1],input[2])));
		}

		br.close();
		
		System.out.println(sb);
	}
	
	public static int fncW(int a, int b, int c) {
		if(a<=0 || b<=0 || c<=0) return 1;
		if(a>20 || b>20 || c>20) return fncW(20,20,20);
		
		if(valueW[a][b][c]!=0) return valueW[a][b][c];
		
		if(a<b && b<c) return valueW[a][b][c] = fncW(a,b,c-1)+fncW(a,b-1,c-1)-fncW(a,b-1,c);
		
		return valueW[a][b][c] = fncW(a-1,b,c)+fncW(a-1,b-1,c)+fncW(a-1,b,c-1)-fncW(a-1,b-1,c-1);
		
	}
}