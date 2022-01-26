import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1065_한수 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N<100) {
			System.out.println(N);
			return;
		}
		
		int count = 99;
		for(int i=100;i<=N;i++) {
			if(checkNum(i)) count++;
		}
		
		System.out.println(count);
		
	}

	public static boolean checkNum(int num) {
		if(num<100) return true;
		if(num==1000) return false;		//N<=1000이므로, 실제로 세자리수만 비교하면 되도록 만듦(근데 그렇게 안하고 전부 다 구할 수 있도록 함)
		
		int prevNum = (num/10)%10;		//끝에서 두번째자리 저장
		int dif = num%10 - prevNum;		//끝자리-끝에서 두번째자리
		
		for(int n=num/100;n!=0;n/=10) {
			if(prevNum-n%10 != dif) return false; 
		}
			
		
		return true;
	}
	
}
