import java.util.EmptyStackException;

public class linkedListStack {
	private static class Node{ // 노드 클래스 생성
		private char item;
		private Node next;
		
		public Node(char item) { // 생성자
			this.item  = item;
			this.next = null;
		}
	}
	
	private int size = 0;
	private Node topnode;
	
	public int size() {return size;}
	// empty 함수
	public boolean empty() {return size == 0;}
	
	// pop 함수
	public void pop() {
		if(topnode == null) { throw new EmptyStackException();} // 비어있으면 오류
		char newItem = topnode.item; // topnode의 item을 newItem에 저장
		topnode = topnode.next; // topnode를 다음 항목 즉, 바로 아래 항목으로 설정
		size--;
	}
	
	// push 함수
	public void push(char newItem) {
		Node newNode = new Node(newItem); 
		newNode.next = topnode; // 새 노드의 다음을 top노드로 설정
		topnode = newNode; // topnode를 newnode로 바꿔줌
		size++;
	}
	
	// top 함수
	public char top() {
		if(empty()) throw new EmptyStackException(); // 비어있으면 오류
		return topnode.item; // topnode의 item 반환
	}
				
}
