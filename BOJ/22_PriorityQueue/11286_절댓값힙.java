import java.io.*;
import java.util.*;

public class Main{
	static int[] heap;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		heap = new int[Math.min(n, 100)+1];
		//PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> {
        //	return (Math.abs(b)-Math.abs(a))==0 ? a-b: Math.abs(a)-Math.abs(b); });
		
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) add(num);
			else sb.append(pop()+"\n");
		}
		
		br.close();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void add(int num) {
		if(heap[0]+1 >= heap.length) {
			int[] nHeap = new int[heap.length*2];
			for(int i=0;i<heap.length;i++) {
				nHeap[i] = heap[i];
			}
			heap = nHeap;
		}
		heap[++heap[0]] = num;
		upheap();
	}
	
	private static void upheap() {
		int idx = heap[0];
		//idx가 부모보다 작으면 swap
		while(idx>1 && !check(idx,idx/2) ) {
			swap(idx,idx/2);
			idx /= 2;
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
			//자식노드 중 더 작은 쪽 선택
			int childIdx = idx*2;
			if(childIdx+1 <= size) childIdx = check(childIdx+1, childIdx)? childIdx:childIdx+1;
			
			if(check(idx,childIdx)) swap(idx,childIdx);
			idx = childIdx;
		}
	}
	
	private static void swap(int i, int j) {
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
	
	private static boolean check(int i, int j) {
		//heap[i]가 heap[j]보다 더 큰지 체크
		return Math.abs(heap[i])>Math.abs(heap[j]) || (Math.abs(heap[i])==Math.abs(heap[j]) && heap[i]>heap[j]);
	}
}