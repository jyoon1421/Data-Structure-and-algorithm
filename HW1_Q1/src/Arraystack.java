import java.util.EmptyStackException;

public class Arraystack{
	private char s[]; 		// ���� ���� ���� �迭 ����
	private int top; 	// ������ top �迭 ���� �ε���
	public Arraystack() { 	// ���� ������
		s = new char [100]; 	// ũ�� 1�� �迭 ����
		top = -1; 	// �� ó�� �ϳ� ���� ����Ű�Բ�
	}
	public int size() { return top+1;} 	// ������ �׸� ���� ����
	
	//empty �Լ�
	public boolean empty() { return (top == -1);}
	
	//top �Լ�
	public char top() { 	// ���� �� �� item ����
		if (empty()) throw new EmptyStackException(); // empty�� ����
		return s[top];
	}
	
	//push �Լ�
	public void push(char newItem) {
		if(size() == s.length)
			System.out.println("������ �� á���ϴ�");
		s[++top] = newItem; // ���ο� �׸� �ֱ�
	}
	
	//pop �Լ�
	public void pop() {
		if(empty()) throw new EmptyStackException();
		else {
			char item = s[top--]; // top�� item ������ �����ϰ� -1�Ѵ�.
		}
	}

}
