public class TapeEquilibrium {
	public int solution(int[] A) {
		int len = A.length;
		for(int i=1;i<len;i++) A[i] += A[i-1];

		int answer = 100_001;
		for(int i=0;i<len-1;i++){
			answer = Math.min(answer, Math.abs(2*A[i]-A[len-1]));
		}

		return answer;
	}
}
