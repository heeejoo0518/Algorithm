import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Member {
	int age;
	String name;
	
	Member(int age, String name){
		this.age = age;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return age+" "+name;
	}
}

public class Main{
	public static void main(String[] args) throws IOException {
		//입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());		
		List<Member> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			list.add(new Member(Integer.parseInt(st.nextToken()),st.nextToken()));
		}
		br.close();
		
		//정렬
		list.sort(new Comparator<Member>() {
			@Override
			public int compare(Member m1, Member m2) {
				return m1.age-m2.age;
			}
		});
		
		//출력
		StringBuilder sb = new StringBuilder();		
		for(Member mem:list) {
			sb.append(mem+"\n");
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
