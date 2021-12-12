import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***Q2-1***");
		Scanner sc = new Scanner(System.in);
		System.out.print("원반의 개수 입력 > "); 
		 
		int n = sc.nextInt(); // 원반 개수 n 으로 저장
		hanoi(n, 'A', 'B', 'C'); // 원반 개수, 기둥 이름 세개, 하노이함수 호출
	}
	
	private static void hanoi(int n, char start, char mid, char des) { // 원반 개수, 첫번째 기둥, 두번째 기둥, 세번째 기둥
		// TODO Auto-generated method stub
		if(n==1) { // n이 제일 작은 원반(제일 위 원반) 일 때
			System.out.println("원판"+ n + "을 " +start + "에서 " +des+ "로 옮긴다.");
		}
		else {
			hanoi(n-1, start, des, mid); // n-1개의 원반을 두번째 기둥으로 옮긴다.
			System.out.println("원판"+ n +"을 " + start + "에서 " + des + "로 옮긴다.");
			hanoi(n-1, mid, start, des); // 두번째 기둥의 원반들을 세번째 기둥으로 옮긴다.
		}
	}
}

