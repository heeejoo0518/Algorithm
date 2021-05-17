import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Coordinate implements Comparable<Coordinate>{
	int x,y;
	
	public Coordinate(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public int compareTo(Coordinate c) {
		if(this.x>c.x) return 1;
		else if(this.x==c.x && this.y > c.y) return 1;
		else if(this.x==c.x && this.y==c.y) return 0;
		else return -1;
	}
	
	@Override
	public String toString() {
		return this.x+" "+this.y;
	}
}

public class Main{		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		
		List<Coordinate> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			list.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<n;i++) {
			sb.append(list.get(i)+"\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
	}
	
}
