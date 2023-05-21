import java.io.*;
import java.util.*;

public class BOJ_2947_나무조각 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] order = new int[5];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<5;i++) order[i] = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<4;i++){
			for(int j=0;j<4-i;j++){
				if(order[j] > order[j+1]){
					int tmp = order[j];
					order[j] = order[j+1];
					order[j+1] = tmp;

					for(int o:order){
						sb.append(o).append(' ');
					}
					sb.append('\n');
				}
			}

		}
		System.out.print(sb);
	}

}
