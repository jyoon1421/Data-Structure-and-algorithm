import java.util.EmptyStackException;


public class LinkedListQueue <E> {
	private Node<E> head, tail;
	private int front, rear;
	private int size;
	private int maxsize = 5;
	
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
	
	public LinkedListQueue() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	// 사이즈 반환 함수
	public int size() { return size;}
	
	// Isempty 함수
	public boolean Isempty() { return size==0;} // size가 0이면 true 반환
	
	// Isfull 함수
	public boolean Isfull() {
		if(Isempty()) {return false;} // 비어있으면 false 반환
		if( (rear+1) % maxsize == front ) { // 비어있지 않고, rear와 front가 한칸 차이면
			return true;
		}
		return false;
	}
	
	// add 함수
	public void add(E value) {
		Node<E> newNode = new Node<E>(value);
		
		if (Isfull()) { throw new EmptyStackException(); } // 꽉 차있으면 오류 출력
		if (Isempty()) { // 비어있으면 head와 tail을 newNode로 설정
			head = newNode; 
			tail = head;
			size++;
		} 
		else {
			tail.next = newNode; // tail의 다음은 new
			head.prev = newNode; // head의 이전은 new
			newNode.next = head; // new의 다음은 head
			newNode.prev = tail; // new의 이전은 tail
			tail = newNode; // tail을 newNode로 설정
			size++;
			rear = (++rear) % maxsize; // 원형큐이므로 rear 순환
		}
	}
	
	// remove 함수
	public void remove() {
		head.prev.next = head.next; // 헤드 이전 노드의 다음을 헤드의 다음으로
		head.next.prev = head.prev; // 헤드 다음 노드의 이전을 헤드의 이전으로
		head = head.next; // 헤드는 다음노드로 설정
		size--;
		front = (++front) % maxsize; // 원형큐이므로 front 순환
	}
	
	// search 함수
	// index로 받은 위치의 노드 데이터 반환 함수
	public E search(int index) { 
		Node<E> x = head;
		if(index == 0) { return x.data;} //index가 0 이면 바로 x 반환
		else {
			for(int i=0; i<index; i++) { // head부터 해당 index 까지 돌면서 x에 next 항목을 넣음 (마지막은 index값에 해당하는 노드)
				x = x.next;
			}
			return x.data;
		}
	}
	
	// display 함수 (큐의 데이터 출력하는 함수)
	public void display() {
		System.out.print("Data: "); 
		
		Node<E> x = head; // x를 head로 지정
		for(int i=0; i<size(); i++) { // i가 0~크기만큼 반복
			System.out.print(x.data + " "); // 데이터 출력
			x = x.next; // x는 다음 노드로 지정
		}
		System.out.println("");
	}

}
