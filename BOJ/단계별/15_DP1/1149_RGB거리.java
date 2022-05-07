import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][] colorCase;
	static int[][] house;
	static final int RED = 0;
	static final int GREEN = 1;
	static final int BLUE = 2;
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int n = Integer.parseInt(br.readLine());	
		house = new int[n+1][3];
		colorCase = new int[n+1][3];
		
		for(int i=1;i<n+1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			
			house[i][RED] = Integer.parseInt(st.nextToken());
			house[i][GREEN] = Integer.parseInt(st.nextToken());
			house[i][BLUE] = Integer.parseInt(st.nextToken());
			
			if(i==1) {
				colorCase[1][RED] = house[1][RED];
				colorCase[1][GREEN] = house[1][GREEN];
				colorCase[1][BLUE] = house[1][BLUE];
			}
		}
		
		br.close();
		
		//경우의 수 탐색
		for(int i=2;i<n+1;i++) {
			colorCase[i][RED] = Math.min(colorCase[i-1][GREEN],colorCase[i-1][BLUE])+house[i][RED];
			colorCase[i][GREEN] = Math.min(colorCase[i-1][RED],colorCase[i-1][BLUE])+house[i][GREEN];
			colorCase[i][BLUE] = Math.min(colorCase[i-1][RED],colorCase[i-1][GREEN])+house[i][BLUE];
		}
		
		//출력
		System.out.println(min(colorCase[n]));
	}
	
	public static int min(int[] arr) {
		int min = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(min>arr[i]) min = arr[i];
		}
		return min;
	}
	
	
}