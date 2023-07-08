import java.io.*;

public class BOJ_9656_돌게임2 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		if(Integer.parseInt(in.readLine())%2==0){
			System.out.println("SK");
		}else{
			System.out.println("CY");
		}
	}
}
