import java.util.EmptyStackException;

public class linkedListStack {
	private static class Node{ // ��� Ŭ���� ����
		private char item;
		private Node next;
		
		public Node(char item) { // ������
			this.item  = item;
			this.next = null;
		}
	}
	
	private int size = 0;
	private Node topnode;
	
	public int size() {return size;}
	// empty �Լ�
	public boolean empty() {return size == 0;}
	
	// pop �Լ�
	public void pop() {
		if(topnode == null) { throw new EmptyStackException();} // ��������� ����
		char newItem = topnode.item; // topnode�� item�� newItem�� ����
		topnode = topnode.next; // topnode�� ���� �׸� ��, �ٷ� �Ʒ� �׸����� ����
		size--;
	}
	
	// push �Լ�
	public void push(char newItem) {
		Node newNode = new Node(newItem); 
		newNode.next = topnode; // �� ����� ������ top���� ����
		topnode = newNode; // topnode�� newnode�� �ٲ���
		size++;
	}
	
	// top �Լ�
	public char top() {
		if(empty()) throw new EmptyStackException(); // ��������� ����
		return topnode.item; // topnode�� item ��ȯ
	}
				
}
