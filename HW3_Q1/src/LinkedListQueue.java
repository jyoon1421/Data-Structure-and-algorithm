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
	
	// ������ ��ȯ �Լ�
	public int size() { return size;}
	
	// Isempty �Լ�
	public boolean Isempty() { return size==0;} // size�� 0�̸� true ��ȯ
	
	// Isfull �Լ�
	public boolean Isfull() {
		if(Isempty()) {return false;} // ��������� false ��ȯ
		if( (rear+1) % maxsize == front ) { // ������� �ʰ�, rear�� front�� ��ĭ ���̸�
			return true;
		}
		return false;
	}
	
	// add �Լ�
	public void add(E value) {
		Node<E> newNode = new Node<E>(value);
		
		if (Isfull()) { throw new EmptyStackException(); } // �� �������� ���� ���
		if (Isempty()) { // ��������� head�� tail�� newNode�� ����
			head = newNode; 
			tail = head;
			size++;
		} 
		else {
			tail.next = newNode; // tail�� ������ new
			head.prev = newNode; // head�� ������ new
			newNode.next = head; // new�� ������ head
			newNode.prev = tail; // new�� ������ tail
			tail = newNode; // tail�� newNode�� ����
			size++;
			rear = (++rear) % maxsize; // ����ť�̹Ƿ� rear ��ȯ
		}
	}
	
	// remove �Լ�
	public void remove() {
		head.prev.next = head.next; // ��� ���� ����� ������ ����� ��������
		head.next.prev = head.prev; // ��� ���� ����� ������ ����� ��������
		head = head.next; // ���� �������� ����
		size--;
		front = (++front) % maxsize; // ����ť�̹Ƿ� front ��ȯ
	}
	
	// search �Լ�
	// index�� ���� ��ġ�� ��� ������ ��ȯ �Լ�
	public E search(int index) { 
		Node<E> x = head;
		if(index == 0) { return x.data;} //index�� 0 �̸� �ٷ� x ��ȯ
		else {
			for(int i=0; i<index; i++) { // head���� �ش� index ���� ���鼭 x�� next �׸��� ���� (�������� index���� �ش��ϴ� ���)
				x = x.next;
			}
			return x.data;
		}
	}
	
	// display �Լ� (ť�� ������ ����ϴ� �Լ�)
	public void display() {
		System.out.print("Data: "); 
		
		Node<E> x = head; // x�� head�� ����
		for(int i=0; i<size(); i++) { // i�� 0~ũ�⸸ŭ �ݺ�
			System.out.print(x.data + " "); // ������ ���
			x = x.next; // x�� ���� ���� ����
		}
		System.out.println("");
	}

}
