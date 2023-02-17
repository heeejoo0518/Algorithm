import java.io.*;

public class BOJ_5904_Moo게임 {
	static int N;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

		//몇번째 수열인지 알아내기
		int len = 3;
		int root = 3;
		while(N>len){
			len = len*2+(++root);
		}

		//함수호출
		moo(len,root);

		//결과
		if(N==1) System.out.println('m');
		else System.out.println('o');

	}
	public static void moo(int len, int root){
		//앞부분 길이
		int front = (len-root)/2;

		if(front>=N){//N이 앞부분에 속한다면
			moo(front,root-1);
		}
		else if(front+root<N){//N이 뒷부분에 속한다면
			N-=(front+root);
			moo(front,root-1);
		}else{//N이 중간부분에 속한다면
			N-=front;
		}
	}
}
