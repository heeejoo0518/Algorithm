import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());		
		br.close();
		
		System.out.println(cntN(n));
	}
	
	public static int cntN(int n) {
		if(n<=99) {
			//99이하인 수는 모두 한수
			return n;
		}
		
		int cnt = 99;
		for(int i=100;i<=n;i++) {
			if(i==1000) break; //n 최대숫자 1000은 한수가 아님
			if(i%10-(i/10)%10 == (i/10)%10-(i/100)%10) cnt++;
		}

		return cnt;
	}
}
