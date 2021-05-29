public class Heap {
	private int[] element; //element[0] contains length
	private static final int ROOTLOC = 1;
	private static final int DEFAULT = 10;
	
	public Heap(int size) {
		if(size>DEFAULT) element = new int[size+1];
		else element = new int[DEFAULT+1];
		element[0] = 0;
	}
	
	public void add(int newnum) {
		//새 노드 추가
		if(element[0]+1>=element.length) {
			int[] tmpElem = new int[element[0]*2];
			for(int i=0;i<element[0];i++) {
				tmpElem[i] = element[i];
			}
			element = tmpElem;
		}
		
		element[++element[0]] = newnum;
		upheap();
	}
	
	public int pop() {
		//root 노드 리턴하고 삭제
		//맨 끝 노드를 루트자리에 넣고 다시 정렬
		int root = element[1];
		element[1] = element[element[0]--];
		downheap();
		return root;
	}
	
	public void upheap() {
		//아래에서 위로 정렬
		int markIdx = element[0];
		
		//부모(markIdx/2)-자식(markIdx) 노드 비교
		//부모노드가 자식노드보다 크면 교환
		while(markIdx>1 && element[markIdx/2]>element[markIdx]) {
			swap(markIdx/2,markIdx);
			markIdx /= 2;
		}
	}
	
	public void downheap() {
		//위에서 아래로 정렬
		int markIdx = 1;
		int size = element[0];
		//자식 노드 중 왼쪽, 오른쪽 비교해서 더 작은 쪽 선택
		int smallIdx;
		while(markIdx*2 <= size) {
			if(markIdx*2+1<=size) {
				smallIdx = element[markIdx*2]<element[markIdx*2+1]? markIdx*2:(markIdx*2+1);
			} else {
				smallIdx = markIdx*2;
			}
			//부모노드가 자식노드보다 크면 swap
			if(element[markIdx]>element[smallIdx]) {
				swap(markIdx,smallIdx);
			}
			markIdx = smallIdx;
		}
	}
	
	public void swap(int a, int b) {
		int tmp = element[a];
		element[a] = element[b];
		element[b] = tmp;
	}
	
	public int[] allPopArr() {
		int[] arr = new int[element[0]];
		for(int i=0;i<arr.length;i++) {
			arr[i] = pop();
		}
		return arr;
	}
}
