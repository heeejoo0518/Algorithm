import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BOJ_2108_통계학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		Map<Integer, Integer> nums = new HashMap<>();

		int sum = 0;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(in.readLine());
			nums.put(num, nums.getOrDefault(num, 0) + 1);
			sum += num;
		}

		// 평균
		double avg = (double) sum / N;

		// entryset으로 만든 list
		List<Entry<Integer, Integer>> entrylst = new ArrayList<>(nums.entrySet());

		// key정렬:오름차순
		entrylst.sort(Entry.comparingByKey());

		// 중앙값
		int mid = 0;
		int count = 0;
		for(int i=0;i<entrylst.size();i++) {
			count+=entrylst.get(i).getValue();
			if(count>N/2) {
				mid = entrylst.get(i).getKey();
				break;
			}
		}
		
		//범위
		int range = entrylst.get(entrylst.size()-1).getKey() - entrylst.get(0).getKey();

		// value정렬:내림차순
		entrylst.sort(Entry.comparingByValue((o1, o2) -> o2.intValue() - o1.intValue()));

		// 최빈값 - entrylst.size() 1보다 크면 비교해서 두번째 값 넣기
		int mode = entrylst.get(0).getKey();
		if (entrylst.size() > 1 && entrylst.get(0).getValue() == entrylst.get(1).getValue()) {
			mode = entrylst.get(1).getKey();
		}

		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		out.write(String.format("%.0f\n%d\n%d\n%d\n", avg, mid, mode, range));

		out.flush();

	}
}
