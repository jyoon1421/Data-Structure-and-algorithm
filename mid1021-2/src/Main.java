import java.util.Scanner;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Main {
	public static Scanner sc;

	public static void main(String[] args) {
		System.out.println("***7***");
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է�> "); // ��ȣ �Է� �ޱ�
		String T = sc.next(); // �Է¹��� ��ȣ ����
		
		boolean resultdq = CorrectDeque.CorrectDeque(T); //��ũ�� �־��������
		if(resultdq == true) { // �迭�� ����ִٸ�
			System.out.println("dq -> YES");
		}
		else { System.out.println("dq -> NO"); }
		
	}
}