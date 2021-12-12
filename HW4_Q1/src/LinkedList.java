import java.util.EmptyStackException;


public class LinkedList{
	
	private static class Node{ // ��� Ŭ���� ����
		private int item;
		private Node next;
		
		public Node(int item) {
			this.item  = item;
			this.next = null;
		}
	}
	
	private int size = (int)(Math.random()*100)+1; // ũ��� 1~100 ������ ������ ����
	private Node head;
	private Node tail;
	
	public int size() {return size;}
	
	// search �Լ� 
	// index�� ���� ��ġ�� ��� ������ ��ȯ �Լ�
	public int search(int index) { 
		Node x = head;
		if(index == 0) { return x.item; } //index�� 0 �̸� �ٷ� x ��ȯ
		else {
			for(int i=0; i<index; i++) { // head���� �ش� index ���� ���鼭 x�� next �׸��� ���� (�������� index���� �ش��ϴ� ���)
				x = x.next;
			}
			return x.item;
		}
	}
	
	// addFirst -> ��������� add�ϴ� �Լ�
	public void addFirst(int newItem) {
		Node newNode = new Node(newItem);  
			head = newNode; 
			tail = head; // head�� tail�� newNode�� ����
			size++;
		}
	// add �Լ� - �� �ڿ� ���� �׸� �߰� 
	public void add(int newItem) {
		Node newNode = new Node(newItem); 
		tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	
	// getItem �Լ� - ���ϴ� item���� ��������
	public int getItem(int target) {
		int tmp = search(target); // target�� ��ġ�� ã�ư� item�� tmp�� ����
		return tmp; // tmp ��ȯ
	}

	
	// delete �Լ� - �� �� �׸� ����
	public void delete() {
		if(head == null) { throw new EmptyStackException();} // ��������� ����
		int newItem = head.item; // head�� item�� newItem�� ����
		head = head.next; // head�� ���� �׸� ��, �ٷ� �Ʒ� �׸����� ����
		size--;
	}
	
}
