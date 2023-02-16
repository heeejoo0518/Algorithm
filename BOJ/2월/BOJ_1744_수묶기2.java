import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_1744_수묶기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		int num;
		int positive = 0;
		int negative = 0;
		boolean zero = false;
		for(int i=0;i<N;i++){
			num = Integer.parseInt(in.readLine());
			if(num<0) negative++;
			else if(num>1) positive++;
			else if(num==0) zero = true;
			list.add(num);
		}

		Collections.sort(list);

		if(negative%2!=0 && !zero) {
			negative--;
		}
		if(positive%2!=0){
			positive--;
		}

		int answer = 0;
		for(int i=0;i<negative;i+=2){
			answer += list.get(i)*list.get(i+1);
		}
		for(int i=negative;i<N-positive;i++){
			answer += list.get(i);
		}
		for(int i=N-positive;i<N;i+=2){
			answer += list.get(i)*list.get(i+1);
		}

		System.out.println(answer);

	}

}
