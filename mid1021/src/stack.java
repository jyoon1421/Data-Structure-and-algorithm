import java.util.EmptyStackException;

public class stack{
	private char s[]; 		// ���� ���� ���� �迭 ����
	private int top; 	// ������ top �迭 ���� �ε���
	public stack() { 	// ���� ������
		s = new char [100]; 	// ũ�� 100�� �迭 ����
		top = -1; 	// �� ó�� �ϳ� ���� ����Ű�Բ�
	}
	//size �Լ�
	public int size() { return top+1;} 	// ������ �׸� ���� ����
										
	//empty �Լ�
	public boolean empty() { return (top == -1);} // top�� -1�̸� empty�̹Ƿ� true ����
	
	//top �Լ�
	public char top() { 	// ���� �� �� item ����
		if (empty()) throw new EmptyStackException(); // empty�� ����
		return s[top]; 
	}
	
	//push �Լ�
	public void push(char newItem) {
		if(size() == s.length) // ������ �Լ��� �־� ������ �׸� ������ ���� �޾Ҵ��� �迭 ũ��� ������(100) �����޽��� 
			System.out.println("������ �� á���ϴ�");
		s[++top] = newItem; // ���ο��׸� �ֱ�
	}
	
	//pop �Լ�
	public void pop() {
		if(empty()) throw new EmptyStackException(); // ��������� pop�Ұ� �����Ƿ� ����
		else {
			char item = s[top--]; // top�� �ִ� �׸��� item�� �����ϰ� top�� -1�ؼ� �Ʒ� �׸��� ����Ű�� ��
		}
	}

}