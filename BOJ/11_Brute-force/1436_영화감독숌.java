import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//값 입력받기
		int n = Integer.parseInt(br.readLine());		
		br.close();
		
//    완전탐색 방법
//		int count = 1;
//		int number = 666;
//		while(count!=n) {
//			number++;
//			if(String.valueOf(number).contains("666"))count++;
//		}
//		System.out.println(number);
		
		
		//패턴으로 찾는 방법
		int cnt = 0;
		String num="";
		for(int start=0;start<n;start++) {
			String str_start = start!=0?String.valueOf(start):"";
			String str_end = "666";
			if(str_start.matches("(.*)666")) {
				if(n-cnt > 1000) cnt += 1000;
				else {
					str_end=String.format("%03d",n-cnt-1);
					cnt = n;
				}
			}
			else if(str_start.matches("(.*)66")) {
				if(n-cnt > 100) cnt += 100;
				else {
					str_end="6"+String.format("%02d",n-cnt-1);
					cnt = n;
				}
			}
			else if(str_start.matches("(.*)6")) {
				if(n-cnt > 10) cnt += 10;
				else {
					str_end="66"+String.valueOf(n-cnt-1);
					cnt = n;
				}
			}else {
				cnt ++;
			}
			
			if(cnt==n) {
				num = str_start+str_end;
				break;
			}
		}
		
		//출력
		System.out.println(num);

	}
	
}
