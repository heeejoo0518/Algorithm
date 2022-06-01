import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_1291_구구단 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		StringBuilder sb= new StringBuilder();

		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		while(s<2 || s>9 || e<2 || e>9){
			sb.append("INPUT ERROR!\n");
			st = new StringTokenizer(in.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
		}

		for(int i=1;i<10;i++){
			int dan = s;
			while((s>=e && dan>=e) || (s<e && dan<=e)){
				sb.append(dan).append(" * ").append(i).append(" = ");
				if((dan*i)<10) sb.append(" ");
				sb.append(dan*i).append("   ");
				if(s>=e) dan--;
				else dan++;
			}
			sb.append("\n");
		}

		System.out.print(sb);
	}
}
