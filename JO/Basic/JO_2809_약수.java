import java.io.*;
import java.util.*;

public class JO_2809_약수 {
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		StringBuilder front = new StringBuilder();
		ArrayList<Integer> back = new ArrayList<>();
		double sqrt = Math.sqrt(N);
		for(int i=1;i<=sqrt;i++){
			if(N%i==0) {
				front.append(i).append(' ');
				if(i!=sqrt) back.add(N/i);
			}
		}

		for(int i=back.size()-1;i>=0;i--){
			front.append(back.get(i)).append(' ');
		}

		System.out.println(front);
	}

}
