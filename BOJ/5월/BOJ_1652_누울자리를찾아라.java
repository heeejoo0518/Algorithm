import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		char[][] room = new char[N][N];
		for(int i=0;i<N;i++){
			room[i] = in.readLine().toCharArray();
		}

		int w = 0;
		int h = 0;

		int cnt;
		for(int i=0;i<N;i++){
			cnt = 0;
			for(int j=0;j<N;j++){
				if(room[i][j]=='X'){
					if(cnt>=2) w++;
					cnt = 0;
				}else{
					cnt++;
				}
			}
			if(cnt>=2) w++;
		}

		for(int i=0;i<N;i++){
			cnt = 0;
			for(int j=0;j<N;j++){
				if(room[j][i]=='X'){
					if(cnt>=2) h++;
					cnt = 0;
				}else{
					cnt++;
				}
			}
			if(cnt>=2) h++;
		}

		System.out.println(w+" "+h);
	}
}
