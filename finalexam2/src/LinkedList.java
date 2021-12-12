
public class LinkedList <E> {
	private Node<E> head, tail; // head�� tail ��� ����
	private int size;  // ������ ����
	private int maxsize = 100; // �ִ� ������
	
	public static class Node<E> {
		private Node<E> next,prev; // ����� �������� next�� prev, data ����
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
		this.size = 0; // ��� null�� �ʱ�ȭ 
	}
	
	// ������ ��ȯ �Լ�
	public int size() { return size;} 
	// empty �Լ�, ��������� true ��ȯ
	public boolean Isempty() { return size() == 0;} 
	

	// search �Լ�
	// index�� ���� ��ġ�� ��� ��ȯ �Լ�
	public Node<E> search(int index) { 
		Node<E> x = head;
		if( index == 0) { return x;} //index�� 0 �̸� �ٷ� x ��ȯ
		else {
			for(int i=0; i<index; i++) { // head���� �ش� index ���� ���鼭 x�� next �׸��� ���� (�������� index���� �ش��ϴ� ���)
				x = x.next;
			}
		return x; // x ��ȯ
		}
	}
	
	// add �Լ� ( ��ġ�� ������ �Ķ���ͷ� �ʿ�)
	public void add(int index, E value) {
		Node<E> newNode = new Node<E>(value); // �� ��� ����
		
		if(Isempty()) { head = newNode; tail = head; size++;} // ��������� head�� tail�� newNode�� ����
		else if(index == 0) { //  �� �տ� �ִ� �ٸ� 
			newNode.next = head; // newNode�� next�� head�� �ٲٰ� 
			head.prev = newNode; // head�� prev�� newNode��
			head = newNode; // head�� �ٽ� newNode�� �ٲ���
			size++;
		}
		else if(index == size) { //�� �ڿ� �ִ´ٸ�
			newNode.prev = tail; // newNode�� prev�� tail�� ����
			tail.next = newNode; // tail�� next�� newNode�� �ٲ��ְ�
			tail = newNode; // tail�� newNode�� �ٲ��ش�
			size++;
		}
		else { // �߰��� �ִ´ٸ�
			Node<E> prevn = search(index-1); // ������ ��ġ �ϳ� ���� ���� prevn
			prevn.next.prev = newNode; // ������ ��ġ ���� ����� prev�� newNode�� ����
			newNode.next = prevn.next; // ������ ����� next�� ������ ��ġ ���� ���� ����
			prevn.next = newNode; // ������ ��ġ ���� ����� next�� newNode�� ����
			newNode.prev = prevn; // ������ ����� prev�� ������ ��ġ ���� ���� ����
			size++;
		}
	}
	
	// remove �Լ� ( ������ ��ġ �Ķ���ͷ� �޾ƿ�)
	public E remove(int index) { 
		Node<E> target; // Ÿ�� ��� ����
		if(index ==0 ) { // ù ��带 �����Ѵٸ�
			target = head;
			head= target.next; // ��带 ���� ���� �ű��
			head.prev = null; // head�� prev�� null�� ���� ���� ����
			target.next = null; // Ÿ���� next�� null�� ���� ���� ����
		}
		else if(index == size -1) { // ������ ��� ����
			target = tail;
			tail = tail.prev; // tail�� �������� �ű�
			tail.next = null; // ���� ������ next�� null�� ���� ���� ����
			target.prev = null; // Ÿ���� prev�� null�� ���� ���� ����
		}
		else { // �߰� ��� ����
			target = search(index); // ������ ��ġ�� ��� ã��
			target.prev.next = target.next; // ������ ��� �ϳ� �� ����� next�� ������ ��� �ϳ� �� ���� ����
			target.next.prev = target.prev; // ������ ��� �ϳ� �� ����� prev�� ������ ��� �ϳ� �� ���� ����
			target.prev = null;	// ������ ����� prev�� null�� ���� ������ ����
			target.next = null; // ������ ����� next�� null�� ���� ������ ����
		}
		size--;
		return target.data; // Ÿ���� ������ ��ȯ( ���� ����� ������)
	}
	
	// get �Լ� ( �Ķ���ͷ� ���� index��ġ�� ������ ��ȯ�ϴ� �Լ�)
	public int get(int index) { // �ش� index ���� ������ ��ȯ�ϴ� �Լ�
		return (int) search(index).data; //search�� �ش� �ε��� ã�ư��� ������ ��ȯ
	}
	
	//change �Լ� (�� ���� �ڸ� ��ȯ, ��ȯ�� ��� �ΰ� �Ķ���ͷ� �޾ƿ�)
	public void change(Node a, Node b) {
		int temp = (int) a.data; // temp�� a�� ������ �־�ΰ� 
		a.data = b.data; // a�� �����ʹ� b�� �����ͷ� �ٲ�
		b.data = temp; // b�� �����Ϳ��� temp�� �־�� a �����ͷ� �ٲ�
	} 
	
	// �ε��� ã�� �Լ� ( Ÿ���� �� ��� �޾ƿ�)
	public int indexOf(Node<E> target) {
		int index = -1; 
		Node<E> node = head; // ��忡 head ����
		while(node != null) { // ��带 head���� �ϳ��� �̵��ϸ� ���ٰ� 
			index++;
			if (node == target) return index; // target�� �������� index ��ȯ
			node = node.next; // �ƴϸ� ���� �������� �ѱ�
		}
		return -1;
	} 

	// ������ �Լ�
	public void quickSort() {
		quickSortRecursive(head, tail);
	}
	// ������ ����Լ� ( ������ ������ �����Ұ��� ��� �ΰ� �Ķ���ͷ� �޾ƿ�)
	private void quickSortRecursive(Node<E> head, Node<E> tail) {
		
		if (head == null || tail == null || head == tail) return; // ���� ������ �����Ұ� 1�����϶���
		
		int pivot = (int)tail.data; // tail�� data pivot���� ���

		int orgLeftNodeIndex = indexOf(head);
		int orgRightNodeIndex = indexOf(tail); // ���� ���� ������ ����� ��ġ �ε��� ����ص�

		Node<E> orgLeftNode = head; // ���� ���� ��� �����ص�
		Node<E> orgRightNode = tail.prev; // �Ǻ� ���� ���� ������ ��� �����ص�

		Node<E> leftNode = head; // leftNode �����ؼ� head ����
		Node<E> rightNode = tail.prev; 	// rightNode �����ؼ� �Ǻ��ٷ� �� ��� ����, ������ ���� ���� ������

		while(true) { // true �� ���� �ݺ�
			
			// leftNode�� pivot���� ū ���Ҹ� ����ų ������ �̵�
			while(leftNode != orgRightNode && (int)leftNode.data < pivot) leftNode = leftNode.next;
			// rightNode�� pivot���� ���� ���Ҹ� ����ų ������ �̵�
			while(rightNode != orgLeftNode && (int)rightNode.data > pivot) rightNode = rightNode.prev;
			
			int leftIndex = indexOf(leftNode); // leftIndex�� leftNode�� �ε��� ����
			int rightIndex = indexOf(rightNode); // rightIndex�� rightNode�� �ε��� ����

			if (leftIndex < rightIndex) {  // rightIndex�� left���� ũ�� �׳� change
				change(leftNode, rightNode);
				continue; 
			} 
			else { // leftIndex�� rightIndex�� ���ų� Ŀ���� leftIndex �ڸ����ٰ� tail==pivot�� ����
				int pivotIndex = indexOf(tail); // tail�� �ε����� pivotIndex�� �����ص�
				remove(pivotIndex); // pivotIndex��ġ ����
				
				if(leftIndex == rightIndex && rightIndex == pivotIndex-1) { 
					// left,right �ε��� ����, right�ε����� �Ǻ� �ٷ� �� �� ���
					// ���� ����Ʈ�� �ΰ����� ���
					if((int)rightNode.data > pivot) {pivotIndex = rightIndex;} // �Ǻ��� �� ��ġ ������ ������ �ٲ� ��ġ �տ� pivot ����
				}
				else if(leftIndex == rightIndex) { // �� �ε����� ������
					pivotIndex = rightIndex; // �ٲ� ��ġ�� pivot ����
				}
				else { // rightIndex + 1 �ڸ�(�ٲ� ��� �� ���� ��� ��)�� pivot ����
					pivotIndex = rightIndex+1;
				}
				// ������ pivot �ٽ� ����
				add(pivotIndex, tail.data);
				
				if (orgLeftNodeIndex < pivotIndex - 1) { // pivot �������� ���� ������
					quickSortRecursive(search(orgLeftNodeIndex), search(pivotIndex-1)); // �����ص� �ʱ� �� ���ʳ�� �ε������� 
				}
				if (orgRightNodeIndex > pivotIndex + 1) { // pivot �������� ������ ������
					quickSortRecursive(search(pivotIndex+1), search(orgRightNodeIndex)); // pivot �ϳ� �ں��� ������
				}
				break;
			}	
		}
	}
}
	

