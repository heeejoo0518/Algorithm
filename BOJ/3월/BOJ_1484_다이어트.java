import java.io.*;
import java.util.*;

public class BOJ_1484_다이어트 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int G = Integer.parseInt(in.readLine());
		int END = 50001;
		int[] num = new int[END];
		num[1] = 1;
		for(int i=2;i<END;i++) num[i] = i*i;
		ArrayList<Integer> list = new ArrayList<>();

		int l = 1, r = 2, g;
		while(l<r && r<END){
			g = num[r]-num[l];
			if(g==G) list.add(r);

			if(g<G) r++;
			else l++;
		}

		if(list.size()==0) {
			System.out.println(-1);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for(int ans:list) sb.append(ans).append('\n');
		System.out.print(sb);
	}
}
