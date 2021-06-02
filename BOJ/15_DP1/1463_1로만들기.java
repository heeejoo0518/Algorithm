import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
	static int[] count;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		count = new int[n+1];
		
		System.out.println(makeOne(n));
	}
	
	public static int makeOne(int n) {
		if(n<=1) return 0;		
		if(count[n]!=0) return count[n];
		
		Integer[] pastValue = new Integer[3];
		pastValue[0] = n%3==0?makeOne(n/3):null;
		pastValue[1] = n%2==0?makeOne(n/2):null;
		pastValue[2] = makeOne(n-1);
		
		return count[n] = min(pastValue)+1;
	}
	
	public static int min(Integer ... compare) {
		//null을 제외한 min값 return
		int m = 1000005;
		for(int i=0;i<compare.length;i++) {
			if(compare[i]==null) continue;
			if(m>compare[i]) m = compare[i];
		}
		return m;
	}
}