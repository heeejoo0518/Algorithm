# Collection

* 자바에서 제공하는 자료구조를 담당하는 프레임워크

## List

- 순서를 유지하고 저장함. 중복 저장 가능.

- 종류 : ArrayList, Vector, LinkedList

| 이름       | 설명                                                         |
| ---------- | ------------------------------------------------------------ |
| Vector     | * 동기화 보장 - 공유자원/복수의 사용자가 존재할 때 안전하게 프로그램 작성 가능<br />* 하나의 스레드가 하나의 자원을 이용하는 경우에 성능의 저하 발생<br />* 공간이 모자랄 때 모자른 공간x2만큼의 공간을 새로 확보하기 때문에 메모리를 많이 잡아먹음 |
| ArrayList  | * 인덱스를 가지고 있어서 검색에 용이<br />* 삽입/삭제 시 중간에 빠진 곳을 전부 한칸씩 땡기거나 뒤로 밀어야하기때문에 삽입/삭제가 빈번한 데이터인 경우 부적합<br />* 동기화 보장x, 공간이 모자를 때는 모자른 공간만큼만 공간을 확보 |
| LinkedList | * 노드가 줄줄이 연결된 리스트<br />* 맨 마지막에 있는 요소를 검색할때 O(n)이 걸려서 검색에 부적합<br />* 삽입/삭제 시 중간에 해당 노드의 주소지만 바꿔주면 되기 때문에 삽입/삭제가 빈번한 데이터에 적합 |

```java
ArrayList<String> list = new ArrayList<>(); //객체 생성
list.add(data); //데이터 삽입
list.add(index,data); //데이터 삽입
list.set(index,data); //데이터 수정

list.get(index); //리스트 내 객체 사용
list.indexOf(data); //특정 데이터 인덱스 값 확인. 없으면 -1 반환
list.contains(data); //데이터 존재여부 검사. 존재하면 true

list.remove(index); //특정 데이터 삭제
list.remove(data); //특정 데이터 삭제
list.clear(); //모든 데이터 삭제

list.size(); //데이터 개수 확인
System.out.println(list); //전체 데이터 출력
```



## Set

- 순서를 유지하지 않고 저장함. 중복 저장 불가능. (null도 하나만 저장 가능)
- 내부구현에 Map 사용
- 인덱스가 없기 때문에 .get() 사용 불가 --> for-each, Iterator 사용
- 같은 인스턴스가 아니더라도 동일 객체를 구분해 중복저장을 막을 수 있음(hashCode, equals 사용)
  - 객체를 저장하기 전 hashCode() 호출-> 해시코드 얻음 -> 동일한 해시코드가 있다면 equals() 호출 -> 두 객체를 비교해 true가 나오면 동일한 객체로 판단 -> 저장하지 않음
- 종류 : HashSet, TreeSet, LinkedHashSet 

| 이름          | 설명                                                         |
| ------------- | ------------------------------------------------------------ |
| HashSet       | * Hashing을 이용해 구현 <br />* 정렬하지 않음<br />* 시간복잡도 O(1) |
| TreeSet       | * 이진탐색트리(Red Black Tree)형태로 데이터 저장<br />* 데이터 추가/삭제에 시간이 더 걸리지만 검색/정렬이 더 뛰어남<br />* 오름차순으로 자동정렬<br />* 시간복잡도 O(log n) |
| LinkedHashSet | * HashSet클래스를 상속받은 LinkedList<br />* 입력된 순서대로 데이터 관리<br />* 시간복잡도 O(1) - HashSet보다 조금 더 느림 |

```java
HashSet<String> set = new HashSet<>(); //객체 생성. 
set.add(data); //데이터 삽입
set.remove(data); //데이터 삭제
set.clear(); //데이터 초기화
set.size(); //데이터 개수 확인
System.out.println(set); //전체 데이터 출력

//Iterator 예시
Iterator <String> it = set.iterator();
while(is.hasNext()) System.out.println(it.next());
```



## Map

- key와 value의 쌍으로 저장됨. key는 중복 불가능
- key : Set방식 / value : List 방식으로 저장됨
- Map<K,V> : K는 key에 대한 타입, V는 value에 대한 타입
- 제네릭은 객체타입만 가능 -> 기본 자료형을 사용할 경우 Wrapper클래스를 사용해야 함
- key로 사용할 객체는 hashCode()와 equals() 메소드를 재정의해서 동등객체가 될 조건을 정해야 함
- 종류 : HashMap, Hashtable, TreeMap, Properties

| 이름       | 설명                                                         |
| ---------- | ------------------------------------------------------------ |
| HashMap    | * Hashing 사용 -> 많은 양의 데이터를 검색하는 데 성능이 뛰어남 |
| HashTable  | * HashMap과 동일한 내부구조<br />* 동기화 메소드로 구성되어있음 -> 멀티 스레드가 동시에 이 메소드를 실행할 수 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드에서 사용 가능 -> 멀티 스레드에서 안전하게 객체 추가/삭제 가능(thread safe) |
| TreeMap    | * 이진트리 기반<br />* 객체를 저장하면 자동으로 정렬됨. 키값을 비교해 낮은 건 왼쪽, 높은 건 오른쪽 자식 노드.<br />* 범위 검색과 정렬에 적합(대부분의 경우에서 HashMap 검색이 더 빠름) |
| Properties | * HashTable의 하위 클래스<br />* key, value 타입은 String타입으로 제한<br />* .properties 파일을 읽을 때 주로 사용 |

```java
HashMap<Integer,String> map = new HashMap<>(); 
map.put(key,value); // 데이터 추가

map.remove(key); //데이터 삭제
map.clear(); //전체 데이터 초기화

map.get(key); //value 값 반환
map.containsKey(key); //key contains 확인
map.containsValue(value); //value contains 확인

map.keySet(); //전체 key를 set 형태로 반환
map.values(); //전체 value를 Collections 형태로 변환

map.size(); //데이터 개수 확인
System.out.println(map); //전체 데이터 출력
```

