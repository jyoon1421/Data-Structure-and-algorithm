public class HashTable<E>{
	int N = 5;
	int size; // ���̺� �� �����Ͱ���
	
	class Node<E>{
        int key;
        Node<E> next;

        public Node(int key, Node<E> next) {
            this.key = key;
            this.next = next;
        }
	}
	
	private Node<E>[] a = new Node[N]; // �ؽ����̺�
	private Node<E> head; // ����� ù �κ�
	
	public HashTable(){
		a = (Node<E>[]) new Node[N]; // ��� Ÿ�� �迭 ����
		size = 0;
		head = null;
	}
	
	// Hash���� ��� ���� �Լ�
	int hash(int key) {
		return ((int)key % N); // �ؽ��Լ��� ũ��N���� ���� ������
	}
	
	
	// key���� ���� value ���� �����ϱ� ���� �Լ�
	void put(int key) {
		int initialpos = hash(key); // �ʱ� ��ġ�� ��� 
		Node<E> newNode = new Node<E>(key, null); // �� ��� ����
		
		// �ʱ� ��ġ�� ��������� ��ũ�帮��Ʈ�� ù ���� ����
		if(a[initialpos]==null) {
			a[initialpos] = newNode;
			head = newNode;
		}
		
		// ������� ������ 
		else {
			Node<E> temp = a[initialpos]; // �ӽ� ��忡 �ʱ� ��ġ�� �ִ� �� ����
			Node<E> prevNode = null; // ���� ��� ����
			
			while(temp!=null) { // temp�� null�̸� ������尡 ���ٴ� �� == �� ĭ�� ������ ���
				prevNode = temp; // prevNode�� temp �����صΰ�
				temp = temp.next; // temp�� ���� ���� ������Ʈ 
			}
			prevNode.next = newNode; // ������ ����� ������ newNode ����
		} 
		size++;
	}
	
	
	// key ���� ���� �׸� ����
	void remove(int key) {
		int initialpos = hash(key); // key�� �ʱ� ��ġ ���
		Node<E> temp = a[initialpos]; // temp ��带 �����ؼ� ���� �� ������ ����
		Node<E> prev = null; // ������庯�� ����
		
		// �ؽ����̺��� key���� �ִ� ��ġ�� ���鼭
		while(temp != null) { // temp�� ������� �������� �ݺ�
			
			// key���� temp�� Ű���� ������
			if(key == temp.key) { 
				// �����Ϸ��� ��尡 ù ����̸�
				if(head.next == temp) {
					head.next = temp.next; // ����� ������带 temp�� �������� ����
				}
				// ù ��尡 �ƴϸ�
				else {
					prev.next = temp.next; // ��������� ������带 �����Ϸ��� temp�� �������� ����
				}
				temp = null;
				size--;
				break;
			} 
			
			// key���� temp�� Ű���� �ٸ���
			prev = temp; // temp�� �������� �ϰ�
			temp = temp.next; // temp�� ������� Ž���ϱ� ���� �Ѿ
		}
	}
	
	
	
	// �ش� key�� �����ϴ��� �˻�
	boolean contains(int key) {
		int initialpos = hash(key); // key�� �ʱ� ��ġ ���
		Node<E> temp = a[initialpos]; // temp ��带 �����ؼ� ���� �� ������ ����
		
		while(temp != null) { // temp�� ������� �������� �ݺ�
			if(key == temp.key) { return true; } // Ű ���̶� temp�� Ű ���� ������ true
			temp = temp.next; // ���� ������ ���� ��� Ž��
		}
		return false;
	}

	
	// �迭 ��� �Լ�
	void show() {
		for(int i=0; i<N; i++) { 
			System.out.print(i+ ")"); 
			Node<E> temp = a[i]; // temp ��带 �����ؼ� ���� �� ������ ����
			
			// a[i]�� ������� ������ 
			if(a[i] != null) {
				while(temp != null) {
					System.out.print(temp.key + " "); 
					temp = temp.next;
				}
			}
			// ��������� null ���
			else System.out.print("null "); 
		}
		System.out.println(" ");
		// �ε��� 0�ڸ��� 10,20 1�ڸ��� 1������ 
		// 0)10 20 1)1 �̷������� ��µǰԲ� 
	}
	
	
}