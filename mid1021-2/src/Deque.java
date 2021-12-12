
public class Deque {
	private char[] array; 
	private int size;
	
	private int front; //���� �ε��� ����Ŵ
	private int rear; // ������ �ε��� ����Ŵ
	
	public Deque() { //������
		this.array = new char[100];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	//empty �Լ�
	public boolean empty() { return (front == rear);} // front�� rear�� ������ empty�̹Ƿ� true ����
		
	//add front�Լ�
	public boolean addFront(char item) {
		array[front] = item; // front �ڸ��� item ����
		if(empty() == false) {
			rear = (rear +1); // ��� ���� ������ rear �� �ϳ� �ڷ� , ��������� rear �̵� ����
		}
		size++;
		return true;
	}
	
	//add rear�Լ�
	public boolean addRear(char item) {
		array[rear] = item; // rear�� item �߰�
		if(empty() == false) {
			rear = (rear + 1); // ������� ������ rear�� �ϳ� �ڷ�, ��������� �̵�����
		}
		size++;
		return true;
	}
	
	//delete first �Լ�
	public void deleteFirst() {
		char item = (char) array[front]; // item ������ front�� �ִ� �� ����
		array[front] = ' '; // front�ڸ��� �������� �ʱ�ȭ
		front = front +1; // front�� �ϳ� �ڷ�
		size--;
	}
	
	//delete rear �Լ�
	public void deleteRear() {
		char item = (char) array[rear]; // item ������ rear�� �ִ� �� ����
		array[rear] = ' '; // rear �ڸ� �������� �ʱ�ȭ
		rear = rear -1; // rear�� �ϳ� ������
		size--;
	}
	
	//getfront�Լ�
	public char getFront() {
		char item = (char) array[front]; // item ������ front�� �ִ� �� ����
		return item; // item ��ȯ
	}
	
	//getrear �Լ�
	public char getRear() {
		char item = (char) array[rear]; // item ������ rear�� �ִ� �� ����
		return item; //item ��ȯ
	}
	
}
