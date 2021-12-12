import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***Q1***");
		
		Scanner sc = new Scanner(System.in);
		LinkedListQueue list = new LinkedListQueue(); // 원형큐 list 이름으로 생성
		
		while(true) {
			System.out.print("입력> ");
			int t = sc.nextInt(); // 입력받은 값을 t로 저장
			
			// t가 0이면
			if(t == 0) {
				list.remove(); // 데이터 삭제
				list.display(); // 데이터 출력
			}
			// t가 0이하면
			else if( t <= 0 ) {
				System.out.println("양수만 입력하십시오."); // 오류메시지 출력
			}
			// t가 양수면
			else {
				list.add(t); // t를 큐에 저장
				list.display(); // 데이터 출력
			}
			
			// list가 비워지면 종료
			if(list.Isempty()) {
				break;
			}
		}
		System.out.println("큐가 비워졌습니다.");
	}
}
