import java.util.Scanner;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Main {
	public static Scanner sc;

	public static void main(String[] args) {
		System.out.println("***5***");
		Scanner sc = new Scanner(System.in);
		System.out.print("입력> ");
		String T = sc.next(); // 입력받은 괄호 저장
		
		boolean resultst = CorrectArray.CorrectArray(T); // 스택에 넣었을 때 결과
		if(resultst == true) { // 배열이 비어있다면
			System.out.println("as -> YES");
		}
		else { System.out.println("as -> NO"); }
		
	}	
}