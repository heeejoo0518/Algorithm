import java.io.*;

public class BOJ_15904_UCPC는무엇의약자일까 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		if(str.matches(".*U.*C.*P.*C.*")){
			System.out.println("I love UCPC");
		}else{
			System.out.println("I hate UCPC");
		}
	}
}
