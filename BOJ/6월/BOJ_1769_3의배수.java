import java.io.*;

public class BOJ_1769_3의배수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] X = in.readLine().toCharArray();
		if(X.length==1){
			System.out.println(0+check(X[0]-'0'));
			return;
		}

		int change = 0;
		for(char x:X) change += x-'0';

		int count = 1;
		int num;
		while(change>=10){
			num = change;
			change = 0;
			while(num>0) {
				change += num%10;
				num/=10;
			}
			count++;
		}

		System.out.println(count+check(change));
	}

	public static String check(int x){
		return x%3==0?"\nYES":"\nNO";
	}
}
