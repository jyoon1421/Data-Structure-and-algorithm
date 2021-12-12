package linked_lilst_quick_sort;

public class LinkedList<E extends Number> {
	private Node<E> head, tail;
	private int size;
	private int maxsize = 100;

	public static class Node<E> {
		private Node<E> next, prev;
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
		this.size = 0;
	}

	 // 사이즈 반환
	public int size() {
		return size;
	}

	 // empty 함수, 비어있으면 true 반환
	public boolean isEmpty() {
		return size == 0;
	}

	// search 함수
	// index로 받은 위치의 노드 반환
	public Node<E> search(int index) {
		// 예외처리: 노드 개수 넘어가는 인덱스 위치 요구
		if (index < 0 || index >= size) return null;
		
		// index번째 노드 찾기
		Node<E> x = head;
		for (int i = 0; i < index; i++) // head부터 해당 index 까지 돌면서 x에 next 항목을 넣음 (마지막은 index값에 해당하는 노드)
			x = x.next;

		// index번째 노드 반환
		return x;
	}

	// add 함수
	public void add(int index, E value) {
		Node<E> newNode = new Node<E>(value);

		if (isEmpty()) {
			// 비어있으면 head와 tail을 newnode로 설정
			head = newNode;
			tail = newNode;
		} else if (index == 0) {
			// 맨 앞에 넣는다면
			newNode.next = head; // newNode의 next를 head로 설정
			head.prev = newNode; // 기존 head의 prev를 newNode로 설정

			head = newNode; // 헤드를 newNode로 변경
		} else if (index == size) {
			// 맨 뒤에 넣는다면
			newNode.prev = tail; // newNode의 prev를 tail로 설정
			tail.next = newNode; // 기존 tail의 next를 newNode로 설정

			tail = newNode; // 테일을 newNode로 변경
		} else {
			// 중간에 삽입
			Node<E> prevn = search(index - 1); // 삽입할 위치 하나 전의 노드를 찾는다.
			
			prevn.next.prev = newNode; // 삽입할 위치 다음 노드의 prev를 newNode로 설정
			newNode.next = prevn.next; // 삽입할 노드의 next를 삽입할 위치 다음 노드로 설정

			prevn.next = newNode; // 삽입할 위치 이전 노드의 next를 newNode로 설정
			newNode.prev = prevn; // 삽입할 노드의 prev를 삽입할 위치 이전 노드로 설정
		}

		size++;
	}

	// remove 함수
	public E remove(int index) {
		// 예외처리: 범위를 넘어가는 경우
		if (index < 0 || index >= size) return null;

		Node<E> target;
		
		if (index == 0) {
			// 첫 노드 삭제
			target = head;

			head = target.next; // 헤드를 다음 노드로 옮긴다.
			head.prev = null; // 현재 헤드의 prev를 null로 설정해 연결을 끊는다.
			target.next = null; // 타겟의 next를 null로 설정해 연결을 끊는다.
		} else if (index == size - 1) {
			// 마지막 노드 삭제
			target = tail;

			tail = tail.prev; // 테일을 이전 노드로 옮긴다.
			tail.next = null; // 현재 테일의 next를 null로 설정해 연결을 끊는다.
			target.prev = null; // 타겟의 prev를 null로 설정해 연결을 끊는다.
		} else {
			// 중간 노드 삭제
			target = search(index); // 삭제할 위치의 노드를 찾는다.

			target.prev.next = target.next; // 삭제할 노드 하나 전 노드의 next를 삭제할 노드 하나 후 노드로 변경한다.
			target.next.prev = target.prev; // 삭제할 노드 하나 후 노드의 prev를 삭제할 노드 하나 전 노드로 변경한다.

			target.prev = null;	// 삭제할 노드의 prev를 null로 설정해 연결을 끊는다.
			target.next = null; // 삭제할 노드의 next를 null로 설정해 연결을 끊는다.
		}

		size--;

		return target.data;
	}

	// get 함수
	public int get(int index) { // 해당 index 값의 데이터 반환하는 함수
		return (int) search(index).data; // search로 해당 인덱스 찾아가서 데이터 반환
	}

	// change 함수 (두 값의 자리 교환)
	public void change(Node a, Node b) {
		int temp = (int) a.data; // temp에 a의 데이터 넣어두고
		a.data = b.data; // a의 데이터는 b의 데이터로 바꿈
		b.data = temp; // b의 데이터에는 temp에 넣어둔 a 데이터로 바꿈
	}

	// sort 함수 (정렬)
	public void sort(int L, int R) {
		int l = L; // L과 R의 초기값을 각 소문자로 저장해둠
		int r = R;
		int pivot = R;
		Node<E> Lnode = search(L); // L위치의 노드를 Lnode로 생성
		Node<E> Rnode = search(R); // R위치의 노드를 Rnode로 생성
		Node<E> Pnode = search(pivot); // 피봇 위치의 노드를 Pnode로 생성
		if (R <= 0)
			return; // R이 0보다 작거나 같아지면 == 정렬할 게 1개일 경우 함수 종료

		while (true) { // 종료조건 만나기 전까지 반복
			while ((int) get(L) < (int) get(pivot)) { // L자리 값이 pivot자리 값보다 작은동안 반복
				Lnode = Lnode.next; // Lnode는 다음노드로 바꿔주고
				L++; // L값은 +1
			}
			while ((int) get(R) >= (int) get(pivot)) { // R자리 값이 pivot자리 값보다 크거나 같은 동안 반복
				if (((int) get(R) == 1) || (Rnode.prev == null))
					break; // R자리 값이 1이거나 R의 prev가 null이면 반복 종료
				Rnode = Rnode.prev; // Rnode는 전 노드로 바꿔주고
				R--; // R값은 -1
			}

			if (L >= R)
				break; // L이 R보다 크거나 같아지면 반복 종료

			change(Lnode, Rnode); // 위 경우에 해당 안하고, (L값이 pivot보다 크거나 같고, R 값이 pivot 보다 작을 때)
									// Lnode와 Rnode의 자리 바꿈

			Lnode = Lnode.next; // Lnode는 다음 노드로 바꿔주고
			L++; // L값은 +1
			Rnode = Rnode.prev; // Rnode는 이전 노드로 바꿔주고
			R--; // R값은 -1
		}

		change(Pnode, Lnode); // 위 반복문에서 나오면 피봇노드랑 Lnode랑 자리 바꿔줌

		// pivot 값 기준 왼쪽 정렬
		if ((Lnode.prev != null) && (L - 1 > 0)) { // Lnode의 prev가 null이 아니고(왼쪽집합존재), L-1이 0보다 크면
			if ((Lnode.next != Lnode) && (Lnode.prev != Lnode)) { // Lnode의 prev와 next가 모두 Lnode가 아니면
				sort(l, L - 1);
			}
		}
		// pivot 값 기준 오른쪽 정렬
		if ((Lnode.next != null) && (L < size())) { // Lnode이 next가 null이 아니고(오른쪽집합존재), L이 전체 사이즈보다 작으면
			if ((Lnode.prev != Rnode) && (Rnode.next != Lnode)) {
				sort(L + 1, r);
			}
		}

	}


	//---------------------------------------
	// 여기부터 추가
	//
	public int indexOf(Node<E> target) {
		int index = -1;
		
		Node<E> node = head;
		while(node != null) {
			index++;
			if (node == target) return index;
			node = node.next;
		}

		return -1;
	}

	public void quickSort() {
		quickSortRecursive(head, tail);
	}

	private void quickSortRecursive(Node<E> head, Node<E> tail) {
		// 종료 조건: 정렬할게 1개뿐
		if (head == null || tail == null || head == tail) return;
		
		// 항상 tail을 pivot으로 사용하자.
		int pivot = (int)tail.data;

		// 위치 기억
		int orgLeftNodeIndex = indexOf(head);
		int orgRightNodeIndex = indexOf(tail);

		// 피봇 제외한 가장 오른쪽, 왼쪽 노드 저장
		Node<E> orgLeftNode = head;
		Node<E> orgRightNode = tail.prev;

		// 정렬을 위한 변수들
		Node<E> leftNode = head;
		Node<E> rightNode = tail.prev;

		while(true) {
			// leftNode가 pivot보다 큰 원소를 가리킬 때까지 전진!
			while(leftNode != orgRightNode && (int)leftNode.data < pivot) leftNode = leftNode.next;
			// rightNode가 pivot보다 작은 원소를 가리킬 때가지 후진!
			while(rightNode != orgLeftNode && (int)rightNode.data > pivot) rightNode = rightNode.prev;

			// 크로스 되었는지 확인
			int leftIndex = indexOf(leftNode);
			int rightIndex = indexOf(rightNode);

			// 아직 크로스 안 되었음 - change
			if (leftIndex < rightIndex) {
				change(leftNode, rightNode);
				continue;
			} else {
				// 크로스 되었음
				// 일단 tail(pivot) 자리 찾고 pivot을 리스트에서 제거한다.
				int pivotIndex = indexOf(tail);
				remove(pivotIndex);

				if (leftIndex == rightIndex && rightIndex == pivotIndex - 1) {
					// 같은 자리에서 크로스 중 pivot 바로 앞에서 크로스된 경우 (즉, 비교할 리스트 크기가 2였던 경우)
					// 크로스된 위치(rigntIndex)의 값과 pivot값을 다시금 비교.
					// pivot이 그 위치의 값보다 크면 그 자리에 다시 넣고, 작으면 크로스된 위치(정확히 말하면 크로스된 노드의 앞)에 pivot을 삽입한다.
					if ((int)rightNode.data > pivot) pivotIndex = rightIndex;
				} else if (leftIndex == rightIndex) {
					// 같은 자리에서 크로스 - 크로스된 위치에 pivot을 삽입한다.
					pivotIndex = rightIndex;
				} else {
					// 크로스로 지나친 경우 - rightIndex + 1 자리 (정확히 말하면 크로스된 노드 중 왼쪽 노드의 뒤)에 pivot을 삽입한다.
					pivotIndex = rightIndex + 1;
				}

				// 제거한 pivot을 다시 삽입한다.
				add(pivotIndex, tail.data);
				
				// pivot 기준으로 왼쪽과 오른쪽의 리스트를 정렬한다.
				if (orgLeftNodeIndex < pivotIndex - 1) {
					quickSortRecursive(search(orgLeftNodeIndex), search(pivotIndex - 1));
				}
				if (orgRightNodeIndex > pivotIndex + 1) {
					quickSortRecursive(search(pivotIndex + 1), search(orgRightNodeIndex));
				}
				break;
			}
		}
	}
}