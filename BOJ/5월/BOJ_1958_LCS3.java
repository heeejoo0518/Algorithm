import java.io.*;
import java.util.*;

public class BOJ_1958_LCS3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = in.readLine().toCharArray();
		char[] str2 = in.readLine().toCharArray();
		char[] str3 = in.readLine().toCharArray();

		int[][][] lcs = new int[str1.length + 1][str2.length + 1][str3.length + 1];
		for (int i = 1; i <= str1.length; i++) {
			for (int j = 1; j <= str2.length; j++) {
				for (int k = 1; k <= str3.length; k++) {
					if (str1[i - 1] == str2[j - 1] && str2[j - 1] == str3[k - 1]) {
						lcs[i][j][k] = lcs[i - 1][j - 1][k - 1] + 1;
					} else {
						lcs[i][j][k] = Math.max(lcs[i - 1][j][k], Math.max(lcs[i][j - 1][k], lcs[i][j][k - 1]));
					}
				}
			}
		}

		System.out.println(lcs[str1.length][str2.length][str3.length]);
	}
}
