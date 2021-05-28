
public class Sorting {
	public static void main(String[] args) {
		int[] arr = {10,64,6,9,44,5,1,86,94,56,57,2};
		//int[] arr = {2,3,4,5,1};
		printArr("기본 배열", arr);		
		printArr("삽입 정렬", insertionSort(arr.clone()));		
		printArr("선택 정렬", selectionSort(arr.clone()));	
		printArr("합병 정렬", mergeSort(arr.clone(),0,arr.length-1));
		printArr("힙 정렬", heapSort(arr.clone()));
		printArr("퀵 정렬", quickSort(arr.clone(),0,arr.length-1));
		printArr("버블 정렬", bubbleSort(arr.clone()));
	}
	
	//배열 프린트 함수
	public static void printArr(String sortType, int[] arr) {
		StringBuilder sb = new StringBuilder(sortType+" : ");
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb.toString());
	}
	
	//교환
	public static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	//삽입정렬
	public static int[] insertionSort(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int tmp = arr[i];
			int idx = i-1;
			
			while(idx>=0&&arr[idx]>tmp) {
				arr[idx+1] = arr[idx];
				idx--;
			}
			
			arr[idx+1] = tmp;
		}
		return arr;
	}
	
	//선택정렬
	public static int[] selectionSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int minIdx = i;
			
			for(int j=i+1;j<arr.length;j++) {
				if(arr[minIdx]>arr[j]) {
					minIdx=j;
				}
			}
			
			int tmp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = tmp;
		}
		return arr;
	}

	//병합정렬
	public static int[] mergeSort(int[] arr, int low, int high) {
		if(low>=high) return arr;
		
		int mid = (low+high)/2;
		
		arr = mergeSort(arr,low,mid); //분할1 배열
		arr = mergeSort(arr,mid+1,high); //분할2 배열
		
		int[] newArr = arr.clone();
		
		int idxA=low;//분할1 배열 시작idx
		int idxB=mid+1;//분할2 배열 시작idx
		for(int k=low;k<=high;k++) {
			if(idxB>high)  //분할2 배열을 다 쓴 경우
				newArr[k] = arr[idxA++];			
			else if(idxA>mid) //분할1 배열을 다 쓴 경우
				newArr[k] = arr[idxB++];
			else if(arr[idxA]<=arr[idxB]) //분할1 배열 요소가 분할2 배열 요소보다 작은 경우
				newArr[k] = arr[idxA++];			
			else //분할2 배열 요소가 분할1 배열 요소보다 작은 경우
				newArr[k] = arr[idxB++];
		}
		
		return newArr;
	}

	//힙정렬
	public static int[] heapSort(int[] arr) {
		Heap heap = new Heap(arr.length);
		for(int i=0;i<arr.length;i++) {
			heap.add(arr[i]);
		}
		return heap.allPopArr();
	}

	//퀵정렬
	public static int[] quickSort(int[] arr, int start, int end) {
		if(start>=end) return arr;
		
		//피벗, 양 끝 인덱스 설정
		int pivot = arr[start];
		int i=start;
		int j=end;
		
		//양 끝 인덱스가 교차하기 전까지 반복
		while(i<j) {
			//왼쪽에서부터 pivot보다 작은 요소 찾을때까지 반복
			while(pivot<arr[j]) j--;
			//오른쪽에서부터 pivot보다 큰 요소 찾을때까지 반복
			while(i<j && pivot>= arr[i]) i++;
			//서로 교환
			swap(arr,i,j);
		}
		//pivot과 인덱스 교환
		swap(arr,start,i);

		arr = quickSort(arr,start,i-1);
		arr = quickSort(arr,i+1,end);
		
		return arr;
	}

	//버블정렬
	public static int[] bubbleSort(int[] arr) {
		int tmp;
		for(int i = 0; i < arr.length - 1; i++) {
			for(int j = 1 ; j < arr.length - i; j++) {
				if(arr[j]<arr[j-1]) {
					tmp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}
}

