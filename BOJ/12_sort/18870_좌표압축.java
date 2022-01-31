import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Location implements Comparable<Location>{
	int idx;
	int x;
	
	public Location(int idx,int x) {
		this.idx = idx;
		this.x = x;
	}
	
	@Override
	public int compareTo(Location l) {
		return this.x-l.x;
	}
	
}

public class BOJ_18870_좌표압축 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		List<Location> locations = new ArrayList<>();
		
		//입력
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			locations.add(new Location(i,Integer.parseInt(st.nextToken())));
		}
		in.close();
		
		//정렬
		Collections.sort(locations);
		
		//순서 저장
		int rank = 0;
		int[] result = new int[N];
		for(int i=0;i<N;i++) {
			if(i!=0 && locations.get(i-1).x != locations.get(i).x) rank++;
			result[locations.get(i).idx] = rank;
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		for(int res:result) {
			sb.append(res).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
}
