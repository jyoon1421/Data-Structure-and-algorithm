import java.util.Scanner;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Main {
	public static Scanner sc;

	public static void main(String[] args) {
		System.out.println("***7***");
		Scanner sc = new Scanner(System.in);
		System.out.print("입력> "); // 괄호 입력 받기
		String T = sc.next(); // 입력받은 괄호 저장
		
		boolean resultdq = CorrectDeque.CorrectDeque(T); //데크에 넣었을때결과
		if(resultdq == true) { // 배열이 비어있다면
			System.out.println("dq -> YES");
		}
		else { System.out.println("dq -> NO"); }
		
	}
}