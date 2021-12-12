import java.util.EmptyStackException;

public class Arraystack {
	private int s[]; 		// ���� ���� ���� �迭 ����
	private int top; 	// ������ top �迭 ���� �ε���
	public Arraystack() { 	// ���� ������
		s = new int [100]; 	// �迭 ����
		top = -1; 	// �� ó�� �ϳ� ���� ����Ű�Բ�
	}
	public int size() { return top+1;} 	// ������ �׸� ���� ����
	
	//empty �Լ�
	public boolean empty() { return (top == -1);}
	
	//top �Լ�
	public int top() { 	// ���� �� �� item ����
		if (empty()) throw new EmptyStackException(); // empty�� ����
		return s[top]; // top �׸� ��ȯ
	}
	
	//push �Լ�
	public void push(int newItem) {
		if(size() == s.length) { // �� ���� �����޽��� 
			System.out.println("������ �� á���ϴ�");
		}
		s[++top] = newItem; // top +1�� �� �� �ڸ������ο� �׸� �ֱ�
	}
	
	//pop �Լ�
	public void pop() {
		if(empty()) throw new EmptyStackException(); // ��������� ����
		else {
			s[top--] = ' '; // top�� �������� �ʱ�ȭ �ϰ� -1
		}
	}

}
