import java.util.Scanner;

public class BOJ_2231_분해합 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		
		int constructor = 0;
	
		for(int i=1;i<N;i++) {
			int tmpN = i;
			int tmpS = i;
			
			while(tmpN>0) {
				tmpS += tmpN%10;
				tmpN /= 10;
			}
			
			if(tmpS==N) {
				constructor = i;
				break;
			}
			
		}
		
		System.out.println(constructor);
	}

}
