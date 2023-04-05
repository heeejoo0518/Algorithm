import java.io.*;
import java.util.*;

public class BOJ_11478_서로다른부분문자열의개수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String S  = in.readLine();
		Set<String> set = new HashSet<>();
		for(int i=0;i<S.length();i++){
			for(int j=i;j<S.length();j++){
				set.add(S.substring(i,j+1));
			}
		}

		System.out.println(set.size());
	}
}
