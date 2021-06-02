import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	static int nums[][];
	static int MOD = 1000000000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());		
		br.close();
		
		//배열 초기화
		nums = new int[n+1][10];
		Arrays.fill(nums[1], 1);
		nums[1][0] = 0;
		
		//계산
		cntNum(n);

		//출력
		System.out.println(sum(n));
	}
	
	public static long sum(int n) {
		//return 하기 전에 나누기 필수
		long result = 0;
		for(int num:nums[n]) {
			result+=num;
		}
		return result%MOD;
	}
	
	public static void cntNum(int n) {
		//base
		if(n<=1) return;
		
		//recursive
		cntNum(n-1);
		
		for(int i=0;i<10;i++) {
			nums[n][i] += i-1>=0? nums[n-1][i-1]%MOD:0;
			nums[n][i] += i+1<10? nums[n-1][i+1]%MOD:0;
		}

		return;
	}
}