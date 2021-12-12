import java.util.EmptyStackException;

public class Arraystack {
	private int s[]; 		// 스택 구현 위한 배열 생성
	private int top; 	// 스택의 top 배열 원소 인덱스
	public Arraystack() { 	// 스택 생성자
		s = new int [100]; 	// 배열 생성
		top = -1; 	// 맨 처음 하나 앞을 가리키게끔
	}
	public int size() { return top+1;} 	// 스택의 항목 개수 리턴
	
	//empty 함수
	public boolean empty() { return (top == -1);}
	
	//top 함수
	public int top() { 	// 스택 맨 위 item 리턴
		if (empty()) throw new EmptyStackException(); // empty면 에러
		return s[top]; // top 항목 반환
	}
	
	//push 함수
	public void push(int newItem) {
		if(size() == s.length) { // 꽉 차면 오류메시지 
			System.out.println("스택이 다 찼습니다");
		}
		s[++top] = newItem; // top +1한 뒤 그 자리에새로운 항목 넣기
	}
	
	//pop 함수
	public void pop() {
		if(empty()) throw new EmptyStackException(); // 비어있으면 오류
		else {
			s[top--] = ' '; // top을 공백으로 초기화 하고 -1
		}
	}

}
