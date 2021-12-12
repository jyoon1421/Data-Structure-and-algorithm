import java.util.EmptyStackException;

public class insertsort <E> {
	private Node<E> head, tail;
	private int size;
	private int maxsize = 100;
	
	public static class Node<E> {
		private Node<E> next,prev;
		private int size;
		private E data = null;
		
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public insertsort() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() { return size;} // 사이즈 반환 함수
	public boolean Isempty() { return size() == 0;} // empty 함수, 비어있으면 true 반환
	

	// search 함수
	public Node search(int index) { // index로 받은 위치의 노드 반환 함수
		Node<E> x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	
	// add 함수
	public void add(int index, E value) {
		Node<E> newNode = new Node<E>(value);
		if(Isempty()) { head = newNode; tail = head; size++;} // 비어있으면 head와 tail을 newnode로 설정
		else if(index == 0) { //  맨 앞에 넣는 다면 
			newNode.next = head; // newNode의 next를 head로 바꾸고 
			head = newNode; // head는 다시 newNode로 바꿔줌
			size++;
			if(head.next == null) { tail = head;} // head.next가 없는 경우 tail도 head와 같게 만들어준다.
		}
		else if(index == size) { //맨 뒤에 넣는다면
			tail.next = newNode; // tail의 next를 newNode로 바꿔주고
			tail = newNode; // tail은 newNode로 바꿔준다
			size++;
		}
		else { // 중간에 삽입
			Node<E> prevn = search(index-1); // 삽입할 위치 하나 전의 노드는 prevn로
			Node<E> nextn = prevn.next; // 삽입할 위치 하나 다음의 노드는 nextn로
			prevn.next = null; // 이전 노드의 다음을 null로 바꿔줌
			prevn.next = newNode; // 이전 노드의 다음을 삽입할 노드로 바꿔줌
			newNode.next = nextn; // 새 노드의 다음을 nextn으로 바꿔줌
			size++;
		}
	}
	
	// remove 함수
	public E remove(int index) {
		Node<E> x = head;
		if(index ==0 ) { // 첫 노드를 삭제한다면
			Node<E> nextn = head.next; // 헤드의 다음 노드를 nextn으로 지정
			E rmx = nextn.data; // rmx 는 삭제될 데이터
			head.data = null; // head의 데이터 삭제
			head.next = null; // head의 next 삭제
			head = nextn; // head가 다음 노드 가리키도록 지정
			size--;
		}
		Node<E> prevn = search(index-1); // 삭제할 위치 하나 전의 노드는 prevn으로
		Node<E> rmvn = prevn.next; // 삭제할 노드는 prevn의 다음
		Node<E> nextn = rmvn.next; // 삭제할 거의 다음 노드는 rmvn의 다음
		E rmx = rmvn.data; // rmx 는 삭제될 데이터
		prevn.next = nextn; // 이전 노드의 다음은 nextn로 바꿔줌
		rmvn.next = null; // 삭제할 노드의 next 삭제
		rmvn.data = null; // 삭제할 노드의 data 삭제
		size--;
		return rmx;
	}
	
	// get 함수
	public E get(int index) { // 해당 index 값의 데이터 반환하는 함수
		return (E) search(index).data; //search로 해당 인덱스 찾아가서 데이터 반환
	}
	
	
}
