import java.util.Scanner;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Main {
	public static Scanner sc;

	public static void main(String[] args) {
		System.out.println("***Q1-2***");
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է�> ");
		String T = sc.next(); // �Է¹��� ��ȣ ����

		boolean result = Correct.Correct(T);
		if(result == true) { // �迭�� ����ִٸ�
			System.out.println("linkedListStack -> YES");
		}
		else { System.out.println("linkedListStack -> NO"); }
		
	}	
}
