
public class Deque {
	private char[] array; 
	private int size;
	
	private int front; //시작 인덱스 가리킴
	private int rear; // 마지막 인덱스 가리킴
	
	public Deque() { //생성자
		this.array = new char[100];
		this.size = 0;
		this.front = 0;
		this.rear = 0;
	}
	
	//empty 함수
	public boolean empty() { return (front == rear);} // front와 rear가 같으면 empty이므로 true 리턴
		
	//add front함수
	public boolean addFront(char item) {
		array[front] = item; // front 자리에 item 삽입
		if(empty() == false) {
			rear = (rear +1); // 비어 있지 않으면 rear 를 하나 뒤로 , 비어있으면 rear 이동 없음
		}
		size++;
		return true;
	}
	
	//add rear함수
	public boolean addRear(char item) {
		array[rear] = item; // rear에 item 추가
		if(empty() == false) {
			rear = (rear + 1); // 비어있지 않으면 rear를 하나 뒤로, 비어있으면 이동없음
		}
		size++;
		return true;
	}
	
	//delete first 함수
	public void deleteFirst() {
		char item = (char) array[front]; // item 변수에 front에 있는 애 저장
		array[front] = ' '; // front자리를 공백으로 초기화
		front = front +1; // front는 하나 뒤로
		size--;
	}
	
	//delete rear 함수
	public void deleteRear() {
		char item = (char) array[rear]; // item 변수에 rear에 있는 애 저장
		array[rear] = ' '; // rear 자리 공백으로 초기화
		rear = rear -1; // rear는 하나 앞으로
		size--;
	}
	
	//getfront함수
	public char getFront() {
		char item = (char) array[front]; // item 변수에 front에 있는 애 저장
		return item; // item 반환
	}
	
	//getrear 함수
	public char getRear() {
		char item = (char) array[rear]; // item 변수에 rear에 있는 애 저장
		return item; //item 반환
	}
	
}
