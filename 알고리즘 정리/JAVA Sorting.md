# JAVA Sorting

## Arrays.sort()

* DualPivotQuicksort 사용 - 평균 O(n log(n)), 최악 O(n^2)
* primitive type에는 quick sort 사용, 객체에는 merge sort 사용
  * merge sort는 안정적이지만 quick sort는 안정적이지 않다.(순서가 달라짐) primitive type은 정렬이 안정적인지 여부가 상관 없다. 동일하지 않지만 동일한 정렬순서를 갖는 값이 없기 때문이다.
  * quick sort가 merge sort보다 배열 생성시간만큼 빠름

```java
Arrays.sort(data);
Arrays.sort(data, fromIdx, toIdx);
Arrays.sort(data, comparator);
Arrays.sort(data, startIdx, toIdx, comparator);
```



## Collections.sort()

* <s>merge sort 사용</s>
* Timsort() 사용 - 삽입정렬 + 합병정렬
  * 시간복잡도 평균 O(n log(n)) 최악도 동일
  * 참조지역성원리(CPU가 미래에 원하는 데이터를 예측하여 캐시에 담아놓는데 이때 예측률을 높이기 위해 사용하는 원리)

```java
Collections.sort(data);
Collections.sort(data, comparator);
```



## Arrays.binarySearch()

* 목록 호출 전 오름차순 정렬된 data 필수
* 동일한 요소가 여러 개 있을 경우 어떤 요소가 발견될 지 보장되지 않음
* return
  * 키가 있을 경우 **인덱스** > 0
  * 키가 없을 경우 **-삽입할 지점-1** < 0
  * 첫번째 요소가 키보다 큰 경우 **-1** < 0
  * 목록의 모든 요소가 지정된 키보다 작을 경우 **-list.size()** < 0

```java
Arrays.binarySearch(data, key);
Arrays.binarySearch(data, fromIdx, toIdx, key);
Arrays.binarySearch(data, key, comparator);
Arrays.binarySearch(data, fromIdx, toIdx, key, comparator);
```



## Collections.binarySearch()

* 목록 호출 전 오름차순 정렬된 data 필수
* 동일한 요소가 여러 개 있을 경우 어떤 요소가 발견될 지 보장되지 않음
* 랜덤 엑세스일 때: O(log n), 데이터 크고 랜덤액세스 사용 안할 때: O(n) + O(log n) (링크횡단+비교시간)
* return
  * 키가 있을 경우 **인덱스** > 0
  * 키가 없을 경우 **-삽입할 지점-1** < 0
  * 첫번째 요소가 키보다 큰 경우 **-1** < 0
  * 목록의 모든 요소가 지정된 키보다 작을 경우 **-list.size()** < 0

```java
Collections.binarySearch(data, key);
Collections.binarySearch(data, key, comparator);
```



## Comparable Interface

```java
class 객체이름 implements Comparable<객체이름> {
    int data1;
    int data2;
    
    @Override
    public int CompareTo(객체이름 other){
        //양수면 this가 큼, 0이면 동일함, 음수면 other가 큼
        return this.data1 - other.data1;
    }
}
```



## Comparator

```java
Comparator<객체이름> ___ = new Comparator<객체이름>(){
    public int compare(객체이름 obj1, 객체이름 obj2){
        //양수면 obj1가 큼, 0이면 동일함, 음수면 obj2가 큼
        return obj1.data1 - obj2.data1;
    }
}
```

