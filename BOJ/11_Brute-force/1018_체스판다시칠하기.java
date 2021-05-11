import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//값 입력받기
		String[] tmp = br.readLine().split(" ");
		int n = Integer.parseInt(tmp[0]);//세로 n
		int m = Integer.parseInt(tmp[1]);//가로 m
		
		String[] board = new String[n];
		
		for(int i=0;i<n;i++) {
			board[i] = br.readLine().trim();
		}
		
		br.close();
		
		int minCnt=99999;
		StringBuilder sb;
		for(int i=0;i<=n-8;i++) {
			for(int j=0;j<=m-8;j++) {
				sb = new StringBuilder();
				
				for(int y=i;y<i+8;y++) {
					sb.append(board[y].substring(j, j+8));
				}

				int cnt = compareBoard(sb.toString());
				minCnt = Math.min(minCnt, cnt);
			}
		}
		
		//출력
		System.out.println(minCnt);

	}
	
	public static int compareBoard(String currentBoard) {
		String blackBoard = "BWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWB";
		String whiteBoard = "WBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBWWBWBWBWBBWBWBWBW";
		
		int b_cnt = 0;
		int w_cnt = 0;
		for(int i=0;i<currentBoard.length();i++) {
			if(blackBoard.charAt(i)!=currentBoard.charAt(i)) b_cnt++;
			if(whiteBoard.charAt(i)!=currentBoard.charAt(i)) w_cnt++;
		}
		
		return Math.min(b_cnt,w_cnt);
	}
}
