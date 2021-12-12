import java.util.EmptyStackException;

public class DoubleLinkedList <E> {
	private Node<E> head, tail;
	private int size;
	
	public static class Node<E> {
		private Node<E> next, prev;
		private int size;
		private E data = null;
		
		public Node(E data) {
			this.data = data;
			this.prev = null;
			this.next = null;
		}
	}
	
	public DoubleLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	// 사이즈 반환 함수
	public int size() { return size;}
	
	// Isempty 함수
	public boolean Isempty() { return size==0;} // size가 0이면 true 반환
	
	
	// add 함수 (데이터를 맨 끝에 저장)
	public void add(E value) {
		Node<E> newNode = new Node<E>(value);
		
		if(Isempty()) { head = newNode; tail = head;} // 비어있으면 head와 tail을 newNode로 설정
		else {
			tail.next = newNode; // tail의 다음은 new
			newNode.prev = tail; // new의 이전은 tail
			tail = newNode; // tail을 newNode로 설정
		}
		size++;
	}
	
	// remove 함수 (데이터 삭제 후 반환)
	public E remove() {
		Node<E> target = head;
		if(size() == 1) { // 사이즈가 1이면 
			head = null; // head 노드를 삭제
			size--;
			return target.data;
		}
		else { // 사이즈가 1이 아니면 remove 수행
			target = head;
			head= target.next; // 헤드를 다음 노드로 옮긴다
			head.prev = null; // head의 prev를 null로 설정 연결 끊기
			target.next = null; // 타겟의 next를 null로 설정 연결 끊기
			size--;
			return target.data;
		}
	}

	// search 함수 (index로 받은 위치의 노드 반환 함수)
	public Node<E> search(int index) { 
		Node<E> x = head;
		if(index == 0) { return x;} //index가 0 이면 바로 x 반환
		else {
			for(int i=1; i<index; i++) { // head부터 해당 index 까지 돌면서 x에 next 항목을 넣음 (마지막은 index값에 해당하는 노드)
				x = x.next;
			}
			return x;
		}
	}
	

}
