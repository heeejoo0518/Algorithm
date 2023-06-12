import java.io.*;
import java.util.*;

public class BOJ_18110_solvedac {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[] score = new int[N];
		for(int i=0;i<N;i++) score[i] = Integer.parseInt(in.readLine());
		Arrays.sort(score);
		int out = (int)Math.round(N*0.15);

		int sum = 0;
		for(int i=out;i<N-out;i++) sum += score[i];
		int avg = (int)Math.round((double)sum/(N-2*out));
		System.out.println(avg);
	}
}
