import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		int card[] = new int[n];
		
		for(int i=0;i<n;i++) {
			card[i] = in.nextInt();
		}
		
		int result = 0;
		
		for(int i=0;i<n-2;i++) {
			for(int j=i+1;j<n;j++) {
				for(int k=j+1;k<n;k++) {
					int tmp = card[i]+card[j]+card[k];
					if(tmp <= m) result = Math.max(result, tmp);
				}
			}
		}
		
		in.close();
		
		System.out.println(result);
		
	}
}
