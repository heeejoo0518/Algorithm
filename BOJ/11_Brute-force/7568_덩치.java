import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Body implements Comparable<Body>{
	int weight;
	int height;
	
	public Body(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}	
	
	@Override
	public int compareTo(Body o) {
		if(this.height > o.height && this.weight > o.weight) 
			return 1;
		else if(this.height < o.height && this.weight < o.weight) 
			return -1;
		else 
			return 0;
	}

}


public class Main{	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//값 입력받기
		int n = Integer.parseInt(br.readLine());
		
		List<Body> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			String[] tmpXY = br.readLine().split(" ");
			list.add(new Body(Integer.parseInt(tmpXY[0]),Integer.parseInt(tmpXY[1])));
		}
		
		br.close();
		
		//등수 구하기
		int[] rank = new int[n];
		Arrays.fill(rank, 1);
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(list.get(i).compareTo(list.get(j))<0) rank[i]++;  
			}
		}
		
		//출력
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			sb.append(rank[i]+" ");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.write(sb.toString());		
		
		bw.flush();
		bw.close();
	}
}
