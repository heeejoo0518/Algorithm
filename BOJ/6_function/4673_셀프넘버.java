import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		boolean[] result = new boolean[10000];
		Arrays.fill(result,true);//true면 셀프넘버
		
		for(int i=0;i<result.length;i++) {
			if(result[i]) result = d(i+1, result);
		}	
		
		for(int i=0;i<result.length;i++) {
			if(result[i]) System.out.println(i+1);
		}
	}
	
	public static boolean[] d(int x,boolean[] result) {
		int n=x;
		
		for(int i=10000;i>0;i/=10) {
			if(x<i) continue;
			n+=x/i;
			x=x%i;
		}
		
		if(n-1>=result.length) return result;
		
		result[n-1] = false;
		result = d(n,result);
		
		return result;
	}
}
