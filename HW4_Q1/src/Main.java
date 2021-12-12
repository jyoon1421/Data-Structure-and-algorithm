import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***Q1***");
		LinkedList list = new LinkedList(); // list 생성
		
		// 랜덤으로 데이터의 개수 설정
		// key값을 위해 list 최대크기인 100보다 하나 작은 99까지 
		int size = (int)(Math.random()*99)+1; 
		while ( size > list.size() ) { // 리스트크기<데이터개수 이면 size 다시 설정
			size = (int)(Math.random()*99)+1; 
		}
		
		// 랜덤값 확인
		System.out.println("랜덤 생성된 리스트 크기: " + list.size()); // 랜덤 리스트 크기 확인용으로 출력
		System.out.println("랜덤 생성된 데이터 개수: " + size); // 랜덤 데이터 개수 확인용으로 출력
		
		// 랜덤한 개수의 데이터를 list에 add
		for(int i=0; i<size; i++) {
			int rdata = (int)(Math.random()*100)+1 ; // 랜덤으로 1~100 사이의 난수 생성
			if (i==0) { list.addFirst(rdata); } 
			else { list.add(rdata); } // 셍성한 난수를 list에 add
		}
		
		// 사용자로부터 값 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("찾고 싶은 값 입력> ");
		int target = sc.nextInt(); // 값 입력받아 target 변수에 저장
		
		// 사용자에게 입력받은 값을 리스트 끝에 탐색키로 저장
		list.add(target);
		
		// 리스트에서 인덱스 0~key값 전까지 target과 같은 값 찾기
		for(int i=0; i<size+1; i++) {
			// i번째 항목이 target과 같으면
			if(list.getItem(i) == target) {
				if(i == size) { // 마지막 항목이면 입력받아 추가한 key값이므로 실패
					System.out.println(i+1 + ". "+list.getItem(i) + " = " + target + " 이지만 마지막 항목(key값)이므로 탐색 실패");
				}
				else { // 마지막 항목이 아니면 리스트에 있던 값이므로 성공
					System.out.println(i+1 + ". "+list.getItem(i) + " = " + target + " 이므로 탐색 성공");
					break;
				}
			}
			// 다르면 메시지 출력 후 반복문 계속
			else { 
				System.out.println(i+1 + ". "+list.getItem(i) + " =/= " + target + " 이므로 탐색 계속");
				continue; 
			}
		}
		
	}

}
