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
	
	// ������ ��ȯ �Լ�
	public int size() { return size;}
	
	// Isempty �Լ�
	public boolean Isempty() { return size==0;} // size�� 0�̸� true ��ȯ
	
	
	// add �Լ� (�����͸� �� ���� ����)
	public void add(E value) {
		Node<E> newNode = new Node<E>(value);
		
		if(Isempty()) { head = newNode; tail = head;} // ��������� head�� tail�� newNode�� ����
		else {
			tail.next = newNode; // tail�� ������ new
			newNode.prev = tail; // new�� ������ tail
			tail = newNode; // tail�� newNode�� ����
		}
		size++;
	}
	
	// remove �Լ� (������ ���� �� ��ȯ)
	public E remove() {
		Node<E> target = head;
		if(size() == 1) { // ����� 1�̸� 
			head = null; // head ��带 ����
			size--;
			return target.data;
		}
		else { // ����� 1�� �ƴϸ� remove ����
			target = head;
			head= target.next; // ��带 ���� ���� �ű��
			head.prev = null; // head�� prev�� null�� ���� ���� ����
			target.next = null; // Ÿ���� next�� null�� ���� ���� ����
			size--;
			return target.data;
		}
	}

	// search �Լ� (index�� ���� ��ġ�� ��� ��ȯ �Լ�)
	public Node<E> search(int index) { 
		Node<E> x = head;
		if(index == 0) { return x;} //index�� 0 �̸� �ٷ� x ��ȯ
		else {
			for(int i=1; i<index; i++) { // head���� �ش� index ���� ���鼭 x�� next �׸��� ���� (�������� index���� �ش��ϴ� ���)
				x = x.next;
			}
			return x;
		}
	}
	

}
