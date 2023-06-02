import java.io.*;
import java.util.*;

public class BOJ_25206_너의평점은 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		double total = 0, count = 0;
		String score;
		for(int i=0;i<20;i++){
			st = new StringTokenizer(in.readLine());
			st.nextToken();
			double tmp = 0;
			double point = Double.parseDouble(st.nextToken());
			score = st.nextToken();
			if(score.equals("P")){
				continue;
			}
			count += point;
			switch (score.charAt(0)){
				case 'A':tmp++;
				case 'B':tmp++;
				case 'C':tmp++;
				case 'D':tmp++;
			}

			if(score.length() > 1 && score.charAt(1)=='+') tmp+=0.5;

			total += tmp*point;
		}

		System.out.println(total/count);
	}
}
