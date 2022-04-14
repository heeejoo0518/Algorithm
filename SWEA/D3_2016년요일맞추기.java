import java.io.*;
import java.util.*;

public class D3_2016년요일맞추기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++){
			st = new StringTokenizer(in.readLine());
			int M = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			int days = 3;//금요일 시작
			for(int m=1;m<M;m++){
				switch(m){
					case 1: case 3: case 5: case 7: case 8: case 10: case 12:
						days += 31;
						break;
					case 2:
						days+=29;
						break;
					default:
						days+=30;
						break;
				}
			}

			days+=D;

			sb.append('#').append(tc).append(' ').append(days%7).append('\n');
		}
		System.out.print(sb);
	}
}
