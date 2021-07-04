import java.io.*;
import java.util.*;

public class Main{
	static int[] houses;
	static int n,c;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		houses = new int[n];
		
		for(int i=0;i<n;i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		
		br.close();
		
		Arrays.sort(houses);
		
		bw.write(String.valueOf(maxGap()));
		bw.flush();
		bw.close();
	}
	
	public static int maxGap() {
		//gap 찾는 함수
		//최소는 1, 최대는 마지막집-첫번째집 간격
		int min = 1;
		int max = houses[houses.length-1] - houses[0];
		int mid;
		
		while(min<=max) {
			mid = (min+max)/2;
			//mid 간격이 가능한지 체크
			if(checkGap(mid)) {
				//된다면:간격 높이기
				min = mid+1;
			}else {
				//안된다면:간격 줄이기
				max = mid-1;
			}
		}
		return max;
	}
	
	public static boolean checkGap(int gap) {
		//찾은 gap이 가능한지 체크하는 함수
		//첫번째 집은 무조건 설치하는 것으로 설정
		int first = 0;
		int cnt = 1;
		
		//두번째집부터 탐색하면서 gap보다 큰지 체크, 크다면 first 바꾸고 cnt++
		for(int i=1;i<n;i++) {
			if(houses[i]-houses[first] >= gap) {
				first = i;
				cnt++;
			}
		}
		
		if(cnt>=c) return true;
		else return false;
	}
}