import java.io.*;
import java.util.PriorityQueue;

public class Main{
	static int[] heap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		//우선순위 큐 자료구조 활용 가능
		//PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		heap = new int[Math.min(n, 100)+1];
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) sb.append(pop()+"\n");
			else add(num);
		}
		
		br.close();
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}

	private static void add(int num) {
		if(heap[0]+1 >= heap.length) {
			int[] nHeap = new int[heap.length*2];
			for(int i=0;i<heap[0];i++) {
				nHeap[i] = heap[i];
			}
			heap = nHeap;
		}
		heap[++heap[0]] = num;
		upheap();
	}

	private static void upheap() {
		int idx = heap[0];
		
		//idx가 부모보다 크다면 swap
		while(idx>1 && heap[idx] > heap[idx/2]) {
			swap(idx,idx/2);
			idx = idx/2;
		}
	}

	private static int pop() {
		if(heap[0]==0) return 0;
		int num = heap[1];

		heap[1] = heap[heap[0]--];
		downheap();
		
		return num;
	}
	
	private static void downheap() {
		int idx = 1;
		int size = heap[0];
		while(idx*2<=size) {
			int childIdx = idx*2;
			
			//자식노드 중 더 큰 쪽 선택
			if(idx*2+1<=size) {
				childIdx = heap[childIdx]>heap[childIdx+1]? childIdx:childIdx+1;
			}
			
			//idx가 자식보다 작다면 swap
			if(heap[idx]<heap[childIdx]) swap(idx,childIdx);
			idx = childIdx;
		}
	}

	private static void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
}