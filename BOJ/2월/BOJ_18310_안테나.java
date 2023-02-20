import java.io.*;
import java.util.*;

public class BOJ_18310_안테나 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());

		int[] house = new int[N];
		for (int i = 0; i < N; i++) house[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(house);

		if(N%2==0) System.out.println(house[N/2-1]);
		else System.out.println(house[N/2]);
	}

}
