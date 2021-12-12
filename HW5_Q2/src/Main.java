
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***Q2 해시테이블 - 오픈주소 방식***\n");
		
		HashTable<Integer> table = new HashTable(); // 크기 5인 해시테이블 생성
		
		// 데이터가 잘 들어갔는지 확인하기 위해 들어갈 때마다 show함수로 모든 데이터를 출력해보았다.
		// 중복이 많이 일어나도록 나머지가 0으로 같은 5,10,15를 넣고 
		// 선형조사가 잘 되는지 확인을 위해 1번 자리에 들어가야할 6도 넣어보았다.
		// 적재율 0.9 이상일때 배열 사이즈가 잘 늘어나는지 확인을 위해 데이터를 더 넣어보았다.
		
		table.put(5); 
		table.show();
		table.put(10);
		table.show();
		table.put(15);
		table.show();
		table.put(6);
		table.show();
		table.put(6);
		table.show();
		table.put(9);
		table.show();
		table.put(30);
		table.show();
		
	}

}


class HashTable<K>{
	int N = 5;
	int size = 0; // 테이블에 들어간 데이터개수
	K[] a = (K[]) new Object[N]; // 해시테이블
	
	
	// Hash값을 얻기 위한 함수
	int hash(K key) {
		return ((int)key % N); // 해시함수는 크기N으로 나눈 나머지
	}
	
	// key값을 저장하기 위한 함수
	void put(K key) {
		int initialpos = hash(key); // 초기 위치를 계산 
		
		if(ratio()>=0.9) { resize(2*N); } // 적재율이 0.9 이상이면 배열 사이즈 2배로
		
		// 초기 위치가 비어있으면 그대로 넣음
		if(a[initialpos]==null) {
			a[initialpos] = key; // key를 해시테이블에 저장
		}
		// 초기 위치에 이미 key가 존재하면 
		else {
			// 넣을 위치가 비어있을 때까지 +1
			while(a[initialpos]!=null) {
				initialpos++;
			}
			a[initialpos] = key; // key를 해시테이블에 저장
		}
		size++;
	}
	
	// key 값을 가진 항목 삭제
	void remove(K key) {
		// 해시테이블을 처음부터 돌면서 key값을 찾으면 null로 초기화
		for(int i=0; i<N; i++) {
			if(a[i] == key) { a[i] = null; }
		}
	}
	
	// 해당 key가 존재하는지 검사
	boolean contains(K key) {
		boolean temp = false;
		// 해시테이블을 처음부터 돌면서 key값을 찾으면 temp 변수를 true로
		for(int i=0; i<N; i++) {
			if(a[i] == key) { temp = true; }
		}
		return temp;
	}
	
	// 적재율 계산 함수
	float ratio() {
		float ratio = (size/N); // 사용중인 사이즈 나누기 전체 크기
		return ratio;
	}
	
	// 배열 크기 조절 함수
	void resize(int newSize) {
		int newsize = newSize;
		Object[] t = new Object[newSize]; // 새 크기의 배열 t생성
		for(int i=0; i<size; i++) {
			t[i] = a[i]; // 기존 배열 a를 배열 t로 복사
		}
		a = (K[]) t; // 배열 t를 원래 배열 a로 
	}
	
	// 배열 출력 함수
	void show() {
		int j = 0;
		for(K i:a) { 
			System.out.print(j+ ")" + i + " "); 
			j++;
			// 인덱스 0자리에 10, 1자리에 20있으면 
			// 0)10 1)20 이런식으로 출력되게끔 
		}
		System.out.println(" ");
	}
	
	
}