import java.io.*;

public class BOJ_2485_가로수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		//gap 구해서, 전체의 최대공약수를 구해야함
		//(끝위치-처음위치)/최대공약수 + 1 = 추가로 심은 후의 나무 개수
		//추가로 심은 후의 나무 개수 - N = 답

		int[] tree = new int[N];
		int gcd = 0;
		for(int i=0;i<N;i++){
			tree[i] = Integer.parseInt(in.readLine());
			if(i==1) gcd = tree[1]-tree[0];
			if(i<2) continue;
			gcd = gcd(tree[i]-tree[i-1],gcd);
		}

		int total = (tree[N-1]-tree[0])/gcd + 1;
		int answer = total-N;

		System.out.println(answer);
	}
	public static int gcd(int a, int b){
		if(a<b){
			int tmp = a;
			a = b;
			b = tmp;
		}
		if(b==0) return a;
		return gcd(b,a%b);
	}
}
