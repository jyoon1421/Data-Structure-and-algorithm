import java.util.EmptyStackException;

public class stack{
	private char s[]; 		// 스택 구현 위한 배열 생성
	private int top; 	// 스택의 top 배열 원소 인덱스
	public stack() { 	// 스택 생성자
		s = new char [100]; 	// 크기 100인 배열 생성
		top = -1; 	// 맨 처음 하나 앞을 가리키게끔
	}
	//size 함수
	public int size() { return top+1;} 	// 스택의 항목 개수 리턴
										
	//empty 함수
	public boolean empty() { return (top == -1);} // top이 -1이면 empty이므로 true 리턴
	
	//top 함수
	public char top() { 	// 스택 맨 위 item 리턴
		if (empty()) throw new EmptyStackException(); // empty면 에러
		return s[top]; 
	}
	
	//push 함수
	public void push(char newItem) {
		if(size() == s.length) // 사이즈 함수에 넣어 스택의 항목 개수를 리턴 받았더니 배열 크기와 같으면(100) 오류메시지 
			System.out.println("스택이 다 찼습니다");
		s[++top] = newItem; // 새로운항목 넣기
	}
	
	//pop 함수
	public void pop() {
		if(empty()) throw new EmptyStackException(); // 비어있으면 pop할게 없으므로 오류
		else {
			char item = s[top--]; // top에 있는 항목을 item에 저장하고 top은 -1해서 아래 항목을 가리키게 함
		}
	}

}