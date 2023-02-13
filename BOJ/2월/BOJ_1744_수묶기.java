import java.io.*;
import java.util.*;

//이렇게 안하고 홀수개, 0, 1 등 그레이존 개수를 가운데에서 빼고 한번에 진행해도 됨
public class BOJ_1744_수묶기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
		int num;
		boolean zero = false;
		int one = 0;
		for(int i=0;i<N;i++){
			num = Integer.parseInt(in.readLine());
			if(num<0) minus.add(num);
			else if(num==0) zero = true;
			else if(num==1) one++;
			else plus.add(num);
		}

		Collections.sort(plus,(o1,o2)->o2-o1);
		Collections.sort(minus);

		int answer = 0;
		int psize = plus.size();
		int msize = minus.size();
		for(int i=0;i+1<psize;i+=2){
			answer += plus.get(i)*plus.get(i+1);
		}
		for(int i=0;i+1<msize;i+=2){
			answer += minus.get(i)*minus.get(i+1);
		}
		if(psize%2!=0) answer += plus.get(psize-1);
		if(msize%2!=0 && !zero) answer += minus.get(msize-1);


		System.out.println(answer+one);

	}

}
