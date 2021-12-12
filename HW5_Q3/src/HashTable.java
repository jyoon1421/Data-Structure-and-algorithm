public class HashTable<E>{
	int N = 5;
	int size; // 테이블에 들어간 데이터개수
	
	class Node<E>{
        int key;
        Node<E> next;

        public Node(int key, Node<E> next) {
            this.key = key;
            this.next = next;
        }
	}
	
	private Node<E>[] a = new Node[N]; // 해시테이블
	private Node<E> head; // 노드의 첫 부분
	
	public HashTable(){
		a = (Node<E>[]) new Node[N]; // 노드 타입 배열 생성
		size = 0;
		head = null;
	}
	
	// Hash값을 얻기 위한 함수
	int hash(int key) {
		return ((int)key % N); // 해시함수는 크기N으로 나눈 나머지
	}
	
	
	// key값을 가진 value 값을 저장하기 위한 함수
	void put(int key) {
		int initialpos = hash(key); // 초기 위치를 계산 
		Node<E> newNode = new Node<E>(key, null); // 새 노드 생성
		
		// 초기 위치가 비어있으면 링크드리스트의 첫 노드로 삽입
		if(a[initialpos]==null) {
			a[initialpos] = newNode;
			head = newNode;
		}
		
		// 비어있지 않으면 
		else {
			Node<E> temp = a[initialpos]; // 임시 노드에 초기 위치에 있는 값 저장
			Node<E> prevNode = null; // 이전 노드 생성
			
			while(temp!=null) { // temp가 null이면 다음노드가 없다는 뜻 == 그 칸의 마지막 노드
				prevNode = temp; // prevNode에 temp 저장해두고
				temp = temp.next; // temp는 다음 노드로 업데이트 
			}
			prevNode.next = newNode; // 마지막 노드의 다음에 newNode 대입
		} 
		size++;
	}
	
	
	// key 값을 가진 항목 삭제
	void remove(int key) {
		int initialpos = hash(key); // key의 초기 위치 계산
		Node<E> temp = a[initialpos]; // temp 노드를 생성해서 제일 앞 데이터 저장
		Node<E> prev = null; // 이전노드변수 생성
		
		// 해시테이블이 key값이 있는 위치를 돌면서
		while(temp != null) { // temp가 비어있지 않은동안 반복
			
			// key값과 temp의 키값이 같으면
			if(key == temp.key) { 
				// 삭제하려는 노드가 첫 노드이면
				if(head.next == temp) {
					head.next = temp.next; // 헤드의 다음노드를 temp의 다음노드로 저장
				}
				// 첫 노드가 아니면
				else {
					prev.next = temp.next; // 이전노드의 다음노드를 삭제하려는 temp의 다음으로 지정
				}
				temp = null;
				size--;
				break;
			} 
			
			// key값과 temp의 키값이 다르면
			prev = temp; // temp를 이전노드로 하고
			temp = temp.next; // temp는 다음노드 탐색하기 위해 넘어감
		}
	}
	
	
	
	// 해당 key가 존재하는지 검사
	boolean contains(int key) {
		int initialpos = hash(key); // key의 초기 위치 계산
		Node<E> temp = a[initialpos]; // temp 노드를 생성해서 제일 앞 데이터 저장
		
		while(temp != null) { // temp가 비어있지 않은동안 반복
			if(key == temp.key) { return true; } // 키 값이랑 temp의 키 값이 같으면 true
			temp = temp.next; // 같지 않으면 다음 노드 탐색
		}
		return false;
	}

	
	// 배열 출력 함수
	void show() {
		for(int i=0; i<N; i++) { 
			System.out.print(i+ ")"); 
			Node<E> temp = a[i]; // temp 노드를 생성해서 제일 앞 데이터 저장
			
			// a[i]가 비어있지 않으면 
			if(a[i] != null) {
				while(temp != null) {
					System.out.print(temp.key + " "); 
					temp = temp.next;
				}
			}
			// 비어있으면 null 출력
			else System.out.print("null "); 
		}
		System.out.println(" ");
		// 인덱스 0자리에 10,20 1자리에 1있으면 
		// 0)10 20 1)1 이런식으로 출력되게끔 
	}
	
	
}