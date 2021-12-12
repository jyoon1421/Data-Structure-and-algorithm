import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***Q2***");
		
		Scanner sc = new Scanner(System.in);
		
		
		// list 이름으로 이중연결링크드리스트 생성
		DoubleLinkedList list = new DoubleLinkedList(); 
		
		// N과 K를 입력받음
		System.out.print("입력(N K)> ");
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 1부터 N까지 차례대로 list에 삽입
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		int tmp=0;
		
		System.out.print("< ");
		
		// list size가 1이 아닌동안 반복
		while(list.size() != 1) {
			for (int i=0; i<K-1; i++) {
				tmp = (int) list.remove() ; // K-1번째 데이터까지 삭제 후 맨 끝에 추가
				list.add(tmp);
			} 
			System.out.print(list.remove() + ", "); // K번째 데이터는 삭제 후 출력
		}
		System.out.print(list.remove()+ " "); // size가 1이면 반복문 탈출 후 데이터 출력
		System.out.print(">");
		
	}

}
