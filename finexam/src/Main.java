import java.util.Scanner;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Main {
	public static Scanner sc;

	public static void main(String[] args) {
		System.out.println("***Q3***");
		Scanner sc = new Scanner(System.in);
		System.out.print("입력> ");
		String T = sc.next(); // 입력받은 괄호 저장
		
		boolean result = CorrectArray.CorrectArray(T);
		if(result == true) { // 배열이 비어있다면
			System.out.println("arrayStack -> YES");
		}
		else { System.out.println("arrayStack -> NO"); }
		
	}	
}