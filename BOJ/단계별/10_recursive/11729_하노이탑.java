import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_11729_하노이탑이동순서 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		in.close();
		
		sb.insert(0, moveTower(1, 2, 3, N) + "\n"); // 맨 앞에 끼워넣기
		System.out.print(sb.toString());
	}

	private static int moveTower(int a, int b, int c, int n) {
		if (n <= 0) return 0;

		// 탑 이동
		// n-1개의 판을 a에서 b로 이동
		int cnt = moveTower(a, c, b, n - 1);

		// 1개의 판을 a에서 c로 이동
		sb.append(a + " " + c + "\n");
		cnt++;

		// n-1개의 판을 다시 b에서 c로 이동
		cnt += moveTower(b, a, c, n - 1);

		return cnt;
	}
}

//System.out.print가 느린가 싶어서 테스트 --> BufferedWriter가 메모리를 아주 조금 덜 먹지만 시간은 비슷비슷
//답은 sb.append(String.format())이었음. 느린가봄..ㅜㅜ
