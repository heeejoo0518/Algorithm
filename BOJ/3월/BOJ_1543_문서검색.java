import java.io.*;

public class BOJ_1543_문서검색 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String doc = in.readLine();
		String find = in.readLine();

		int diff = doc.length() - doc.replace(find,"").length();

		System.out.println(diff/find.length());
	}
}
