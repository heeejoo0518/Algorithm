import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1018_체스판다시칠하기 {
    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = in.readLine().toCharArray();
        }

        //탐색
        char[] w = "WBWBWBWB".toCharArray();
        char[] b = "BWBWBWBW".toCharArray();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                //시작 인덱스(i,j)
                int wStart = 0;
                int bStart = 0;
                for (int k = i; k < i + 8; k += 2) {
                    for (int l = 0; l < 8; l++) {
                        if (board[k][j + l] != w[l]) wStart++;
                        if (board[k + 1][j + l] != b[l]) wStart++;
                        if (board[k][j + l] != b[l]) bStart++;
                        if (board[k + 1][j + l] != w[l]) bStart++;
                    }
                }
                if (wStart > bStart) min = Math.min(min, bStart);
                else min = Math.min(min, wStart);
            }
        }

        //출력
        System.out.println(min);
    }

}
