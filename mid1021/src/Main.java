import java.util.Scanner;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Main {
	public static Scanner sc;

	public static void main(String[] args) {
		System.out.println("***5***");
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է�> ");
		String T = sc.next(); // �Է¹��� ��ȣ ����
		
		boolean resultst = CorrectArray.CorrectArray(T); // ���ÿ� �־��� �� ���
		if(resultst == true) { // �迭�� ����ִٸ�
			System.out.println("as -> YES");
		}
		else { System.out.println("as -> NO"); }
		
	}	
}