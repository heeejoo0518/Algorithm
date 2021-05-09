import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		
		in.close();
		
		int len = (int)(Math.log10(n)+1);
		
		//n-자릿수*9부터 시작
		for(int i=n-len*9;i<n;i++) {
			int sum = i;
			int x = i;
			
			for(int j = (int)Math.pow(10,len);j>0;j/=10) {
				sum+=x/j;
				x%=j;
			}
			
			if(sum==n) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);
	}
}
