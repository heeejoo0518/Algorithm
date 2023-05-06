import java.io.*;

public class BOJ_9251_LCS {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = in.readLine().toCharArray();
		char[] str2 = in.readLine().toCharArray();

		int[][] lcs = new int[str1.length+1][str2.length+1];
		for(int i=1;i<=str1.length;i++){
			for(int j=1;j<=str2.length;j++){
				if(str1[i-1]==str2[j-1]) lcs[i][j] = lcs[i-1][j-1]+1;
				else lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}

		System.out.println(lcs[str1.length][str2.length]);
	}
}
