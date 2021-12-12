import java.util.EmptyStackException;


public class LinkedList{
	
	private static class Node{ // 노드 클래스 생성
		private int item;
		private Node next;
		
		public Node(int item) {
			this.item  = item;
			this.next = null;
		}
	}
	
	private int size = (int)(Math.random()*100)+1; // 크기는 1~100 사이의 난수로 지정
	private Node head;
	private Node tail;
	
	public int size() {return size;}
	
	// search 함수 
	// index로 받은 위치의 노드 데이터 반환 함수
	public int search(int index) { 
		Node x = head;
		if(index == 0) { return x.item; } //index가 0 이면 바로 x 반환
		else {
			for(int i=0; i<index; i++) { // head부터 해당 index 까지 돌면서 x에 next 항목을 넣음 (마지막은 index값에 해당하는 노드)
				x = x.next;
			}
			return x.item;
		}
	}
	
	// addFirst -> 비어있을때 add하는 함수
	public void addFirst(int newItem) {
		Node newNode = new Node(newItem);  
			head = newNode; 
			tail = head; // head와 tail을 newNode로 설정
			size++;
		}
	// add 함수 - 맨 뒤에 다음 항목 추가 
	public void add(int newItem) {
		Node newNode = new Node(newItem); 
		tail.next = newNode;
		tail = newNode;
		size++;
	}
	
	
	// getItem 함수 - 원하는 item정보 가져오기
	public int getItem(int target) {
		int tmp = search(target); // target의 위치를 찾아가 item을 tmp에 저장
		return tmp; // tmp 반환
	}

	
	// delete 함수 - 맨 앞 항목 삭제
	public void delete() {
		if(head == null) { throw new EmptyStackException();} // 비어있으면 오류
		int newItem = head.item; // head의 item을 newItem에 저장
		head = head.next; // head를 다음 항목 즉, 바로 아래 항목으로 설정
		size--;
	}
	
}
