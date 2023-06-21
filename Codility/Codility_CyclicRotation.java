public class Codility_CyclicRotation {
	public int[] solution(int[] A, int K) {
		int len = A.length;
		int[] answer = new int[len];
		for(int i=0;i<len;i++){
			answer[(i+K)%len] = A[i];
		}

		return answer;
	}
}
