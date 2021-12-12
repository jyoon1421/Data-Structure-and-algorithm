
public class LinkedList <E> {
	private Node<E> head, tail; // head와 tail 노드 생성
	private int size;  // 사이즈 변수
	private int maxsize = 100; // 최대 사이즈
	
	public static class Node<E> {
		private Node<E> next,prev; // 노드의 구성으로 next와 prev, data 지정
		private int size;
		private E data = null; 
		
		public Node(E data) { 
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0; // 모두 null로 초기화 
	}
	
	// 사이즈 반환 함수
	public int size() { return size;} 
	// empty 함수, 비어있으면 true 반환
	public boolean Isempty() { return size() == 0;} 
	

	// search 함수
	// index로 받은 위치의 노드 반환 함수
	public Node<E> search(int index) { 
		Node<E> x = head;
		if( index == 0) { return x;} //index가 0 이면 바로 x 반환
		else {
			for(int i=0; i<index; i++) { // head부터 해당 index 까지 돌면서 x에 next 항목을 넣음 (마지막은 index값에 해당하는 노드)
				x = x.next;
			}
		return x; // x 반환
		}
	}
	
	// add 함수 ( 위치와 데이터 파라미터로 필요)
	public void add(int index, E value) {
		Node<E> newNode = new Node<E>(value); // 새 노드 생성
		
		if(Isempty()) { head = newNode; tail = head; size++;} // 비어있으면 head와 tail을 newNode로 설정
		else if(index == 0) { //  맨 앞에 넣는 다면 
			newNode.next = head; // newNode의 next를 head로 바꾸고 
			head.prev = newNode; // head의 prev는 newNode로
			head = newNode; // head는 다시 newNode로 바꿔줌
			size++;
		}
		else if(index == size) { //맨 뒤에 넣는다면
			newNode.prev = tail; // newNode의 prev를 tail로 설정
			tail.next = newNode; // tail의 next를 newNode로 바꿔주고
			tail = newNode; // tail은 newNode로 바꿔준다
			size++;
		}
		else { // 중간에 넣는다면
			Node<E> prevn = search(index-1); // 삽입할 위치 하나 전의 노드는 prevn
			prevn.next.prev = newNode; // 삽입할 위치 다음 노드의 prev를 newNode로 설정
			newNode.next = prevn.next; // 삽입할 노드의 next를 삽입할 위치 다음 노드로 설정
			prevn.next = newNode; // 삽입할 위치 이전 노드의 next를 newNode로 설정
			newNode.prev = prevn; // 삽입할 노드의 prev를 삽입할 위치 이전 노드로 설정
			size++;
		}
	}
	
	// remove 함수 ( 삭제할 위치 파라미터로 받아옴)
	public E remove(int index) { 
		Node<E> target; // 타겟 노드 생성
		if(index ==0 ) { // 첫 노드를 삭제한다면
			target = head;
			head= target.next; // 헤드를 다음 노드로 옮긴다
			head.prev = null; // head의 prev를 null로 설정 연결 끊기
			target.next = null; // 타겟의 next를 null로 설정 연결 끊기
		}
		else if(index == size -1) { // 마지막 노드 삭제
			target = tail;
			tail = tail.prev; // tail을 이전노드로 옮김
			tail.next = null; // 현재 테일의 next를 null로 설정 연결 끊기
			target.prev = null; // 타겟의 prev를 null로 설정 연결 끊기
		}
		else { // 중간 노드 삭제
			target = search(index); // 삭제할 위치의 노드 찾기
			target.prev.next = target.next; // 삭제할 노드 하나 전 노드의 next를 삭제할 노드 하나 후 노드로 변경
			target.next.prev = target.prev; // 삭제할 노드 하나 후 노드의 prev를 삭제할 노드 하나 전 노드로 변경
			target.prev = null;	// 삭제할 노드의 prev를 null로 설정 연결을 끊기
			target.next = null; // 삭제할 노드의 next를 null로 설정 연결을 끊기
		}
		size--;
		return target.data; // 타겟의 데이터 반환( 삭제 노드의 데이터)
	}
	
	// get 함수 ( 파라미터로 받은 index위치의 데이터 반환하는 함수)
	public int get(int index) { // 해당 index 값의 데이터 반환하는 함수
		return (int) search(index).data; //search로 해당 인덱스 찾아가서 데이터 반환
	}
	
	//change 함수 (두 값의 자리 교환, 교환할 노드 두개 파라미터로 받아옴)
	public void change(Node a, Node b) {
		int temp = (int) a.data; // temp에 a의 데이터 넣어두고 
		a.data = b.data; // a의 데이터는 b의 데이터로 바꿈
		b.data = temp; // b의 데이터에는 temp에 넣어둔 a 데이터로 바꿈
	} 
	
	// 인덱스 찾는 함수 ( 타겟이 될 노드 받아옴)
	public int indexOf(Node<E> target) {
		int index = -1; 
		Node<E> node = head; // 노드에 head 대입
		while(node != null) { // 노드를 head부터 하나씩 이동하며 보다가 
			index++;
			if (node == target) return index; // target과 같아지면 index 반환
			node = node.next; // 아니면 노드는 다음으로 넘김
		}
		return -1;
	} 

	// 퀵정렬 함수
	public void quickSort() {
		quickSortRecursive(head, tail);
	}
	// 퀵정렬 재귀함수 ( 어디부터 어디까지 정렬할건지 노드 두개 파라미터로 받아옴)
	private void quickSortRecursive(Node<E> head, Node<E> tail) {
		
		if (head == null || tail == null || head == tail) return; // 종료 조건은 정렬할게 1개뿐일때로
		
		int pivot = (int)tail.data; // tail의 data pivot으로 사용

		int orgLeftNodeIndex = indexOf(head);
		int orgRightNodeIndex = indexOf(tail); // 제일 왼쪽 오른쪽 노드의 위치 인덱스 기억해둠

		Node<E> orgLeftNode = head; // 가장 왼쪽 노드 저장해둠
		Node<E> orgRightNode = tail.prev; // 피봇 제외 가장 오른쪽 노드 저장해둠

		Node<E> leftNode = head; // leftNode 생성해서 head 대입
		Node<E> rightNode = tail.prev; 	// rightNode 생성해서 피봇바로 전 노드 대입, 정렬을 위해 변수 저장함

		while(true) { // true 인 동안 반복
			
			// leftNode가 pivot보다 큰 원소를 가리킬 때까지 이동
			while(leftNode != orgRightNode && (int)leftNode.data < pivot) leftNode = leftNode.next;
			// rightNode가 pivot보다 작은 원소를 가리킬 때가지 이동
			while(rightNode != orgLeftNode && (int)rightNode.data > pivot) rightNode = rightNode.prev;
			
			int leftIndex = indexOf(leftNode); // leftIndex에 leftNode의 인덱스 저장
			int rightIndex = indexOf(rightNode); // rightIndex에 rightNode의 인덱스 저장

			if (leftIndex < rightIndex) {  // rightIndex가 left보다 크면 그냥 change
				change(leftNode, rightNode);
				continue; 
			} 
			else { // leftIndex가 rightIndex랑 같거나 커지면 leftIndex 자리에다가 tail==pivot을 삽입
				int pivotIndex = indexOf(tail); // tail의 인덱스를 pivotIndex에 저장해둠
				remove(pivotIndex); // pivotIndex위치 삭제
				
				if(leftIndex == rightIndex && rightIndex == pivotIndex-1) { 
					// left,right 인덱스 같고, right인덱스가 피봇 바로 전 인 경우
					// 비교할 리스트가 두개였던 경우
					if((int)rightNode.data > pivot) {pivotIndex = rightIndex;} // 피봇이 그 위치 값보다 작으면 바뀐 위치 앞에 pivot 삽입
				}
				else if(leftIndex == rightIndex) { // 두 인덱스가 같으면
					pivotIndex = rightIndex; // 바뀐 위치에 pivot 삽입
				}
				else { // rightIndex + 1 자리(바뀐 노드 중 왼쪽 노드 뒤)에 pivot 삽입
					pivotIndex = rightIndex+1;
				}
				// 제거한 pivot 다시 삽입
				add(pivotIndex, tail.data);
				
				if (orgLeftNodeIndex < pivotIndex - 1) { // pivot 기준으로 왼쪽 재정렬
					quickSortRecursive(search(orgLeftNodeIndex), search(pivotIndex-1)); // 저장해둔 초기 맨 왼쪽노드 인덱스부터 
				}
				if (orgRightNodeIndex > pivotIndex + 1) { // pivot 기준으로 오른쪽 재정렬
					quickSortRecursive(search(pivotIndex+1), search(orgRightNodeIndex)); // pivot 하나 뒤부터 끝까지
				}
				break;
			}	
		}
	}
}
	

