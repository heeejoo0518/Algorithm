import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int[] stairs;
	static int[] score;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());	
		
		stairs = new int[n+1];
		score = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		System.out.println(step(n));
	}
	
	public static int step(int n) {
		//범위 체크, 존재여부 체크
		if(n<1) return 0;
		if(score[n]!=0) return score[n];
		
		//1,2,3 base case 설정
		if(n==1) return score[1] = stairs[1];
		if(n==2) return score[2] = Math.max(stairs[1]+stairs[2],stairs[2]);
		if(n==3) return score[3] = Math.max(stairs[1], stairs[2])+stairs[3];
		
		//재귀
		return score[n] = Math.max(step(n-2), stairs[n-1]+step(n-3))+stairs[n];
	}
}