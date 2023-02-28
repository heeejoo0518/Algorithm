import java.io.*;

public class BOJ_5585_거스름돈 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int money = 1000-Integer.parseInt(in.readLine());

		int answer = 0;

		while(money > 0){
			if(money >= 500) money-=500;
			else if(money >= 100) money -= 100;
			else if(money >= 50) money -= 50;
			else if(money >= 10) money -= 10;
			else if(money >= 5) money -= 5;
			else money -= 1;
			answer++;
		}

		System.out.println(answer);
	}
}
