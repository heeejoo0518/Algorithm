import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		
		br.close();
		
		bw.write(String.valueOf(findNum(n,k)));
		bw.flush();
		bw.close();
	}
	
	public static long findNum(int n, int k) {
		long low = 1;
		long high = k; //범위를 벗어나지 않도록 k로 설정
		long mid, cnt;
		long result = 0;
		
		while(low<=high) {
			mid = (low+high)/2;
			cnt = 0;
			
			for(int i=1;i<=n;i++) {
				cnt += Math.min(mid/i, n);
			}
			
			if(cnt<k) {
				//숫자 늘려야 함
				low = mid+1;
			}else {
				//숫자 저장하고 줄여야 함
				high = mid-1;
				result = mid;
			}
		}
		
		return result;
	}
}