import java.util.EmptyStackException;

public class Arraystack{
	private char s[]; 		// 스택 구현 위한 배열 생성
	private int top; 	// 스택의 top 배열 원소 인덱스
	public Arraystack() { 	// 스택 생성자
		s = new char [100]; 	// 크기 1인 배열 생성
		top = -1; 	// 맨 처음 하나 앞을 가리키게끔
	}
	public int size() { return top+1;} 	// 스택의 항목 개수 리턴
	
	//empty 함수
	public boolean empty() { return (top == -1);}
	
	//top 함수
	public char top() { 	// 스택 맨 위 item 리턴
		if (empty()) throw new EmptyStackException(); // empty면 에러
		return s[top];
	}
	
	//push 함수
	public void push(char newItem) {
		if(size() == s.length)
			System.out.println("스택이 다 찼습니다");
		s[++top] = newItem; // 새로운 항목 넣기
	}
	
	//pop 함수
	public void pop() {
		if(empty()) throw new EmptyStackException();
		else {
			char item = s[top--]; // top을 item 변수에 대입하고 -1한다.
		}
	}

}
