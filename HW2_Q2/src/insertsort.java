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

	public int size() { return size;} // ������ ��ȯ �Լ�
	public boolean Isempty() { return size() == 0;} // empty �Լ�, ��������� true ��ȯ
	

	// search �Լ�
	public Node search(int index) { // index�� ���� ��ġ�� ��� ��ȯ �Լ�
		Node<E> x = head;
		for(int i=0; i<index; i++) {
			x = x.next;
		}
		return x;
	}
	
	// add �Լ�
	public void add(int index, E value) {
		Node<E> newNode = new Node<E>(value);
		if(Isempty()) { head = newNode; tail = head; size++;} // ��������� head�� tail�� newnode�� ����
		else if(index == 0) { //  �� �տ� �ִ� �ٸ� 
			newNode.next = head; // newNode�� next�� head�� �ٲٰ� 
			head = newNode; // head�� �ٽ� newNode�� �ٲ���
			size++;
			if(head.next == null) { tail = head;} // head.next�� ���� ��� tail�� head�� ���� ������ش�.
		}
		else if(index == size) { //�� �ڿ� �ִ´ٸ�
			tail.next = newNode; // tail�� next�� newNode�� �ٲ��ְ�
			tail = newNode; // tail�� newNode�� �ٲ��ش�
			size++;
		}
		else { // �߰��� ����
			Node<E> prevn = search(index-1); // ������ ��ġ �ϳ� ���� ���� prevn��
			Node<E> nextn = prevn.next; // ������ ��ġ �ϳ� ������ ���� nextn��
			prevn.next = null; // ���� ����� ������ null�� �ٲ���
			prevn.next = newNode; // ���� ����� ������ ������ ���� �ٲ���
			newNode.next = nextn; // �� ����� ������ nextn���� �ٲ���
			size++;
		}
	}
	
	// remove �Լ�
	public E remove(int index) {
		Node<E> x = head;
		if(index ==0 ) { // ù ��带 �����Ѵٸ�
			Node<E> nextn = head.next; // ����� ���� ��带 nextn���� ����
			E rmx = nextn.data; // rmx �� ������ ������
			head.data = null; // head�� ������ ����
			head.next = null; // head�� next ����
			head = nextn; // head�� ���� ��� ����Ű���� ����
			size--;
		}
		Node<E> prevn = search(index-1); // ������ ��ġ �ϳ� ���� ���� prevn����
		Node<E> rmvn = prevn.next; // ������ ���� prevn�� ����
		Node<E> nextn = rmvn.next; // ������ ���� ���� ���� rmvn�� ����
		E rmx = rmvn.data; // rmx �� ������ ������
		prevn.next = nextn; // ���� ����� ������ nextn�� �ٲ���
		rmvn.next = null; // ������ ����� next ����
		rmvn.data = null; // ������ ����� data ����
		size--;
		return rmx;
	}
	
	// get �Լ�
	public E get(int index) { // �ش� index ���� ������ ��ȯ�ϴ� �Լ�
		return (E) search(index).data; //search�� �ش� �ε��� ã�ư��� ������ ��ȯ
	}
	
	
}
