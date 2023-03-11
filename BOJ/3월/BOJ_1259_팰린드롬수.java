import java.io.*;

public class BOJ_1259_팰린드롬수 {
	static final String zero = "0", no="no\n",yes="yes\n";
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(!(str = in.readLine()).equals(zero)){
			if(!check()) sb.append(no);
			else sb.append(yes);
		}
		System.out.print(sb);
	}
	public static boolean check(){
		int len = str.length();
		for(int i=0;i<=len>>1;i++){
			if(str.charAt(i) != str.charAt(len-i-1)) return false;
		}
		return true;
	}
}
