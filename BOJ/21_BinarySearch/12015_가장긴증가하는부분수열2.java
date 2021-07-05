import java.io.*;
import java.util.*;

public class Main{
	static List<Integer> sequence;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		sequence = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(sequence.size()==0 || num>sequence.get(sequence.size()-1)) sequence.add(num);
			else {
				int idx = Collections.binarySearch(sequence, num);
				if(idx<0) sequence.set(-idx-1, num);
			}
		}
		
		br.close();
		
		bw.write(String.valueOf(sequence.size()));
		bw.flush();
		bw.close();
	}

}