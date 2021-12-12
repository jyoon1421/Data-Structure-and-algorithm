import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***Q2-1***");
		Scanner sc = new Scanner(System.in);
		System.out.print("������ ���� �Է� > "); 
		 
		int n = sc.nextInt(); // ���� ���� n ���� ����
		hanoi(n, 'A', 'B', 'C'); // ���� ����, ��� �̸� ����, �ϳ����Լ� ȣ��
	}
	
	private static void hanoi(int n, char start, char mid, char des) { // ���� ����, ù��° ���, �ι�° ���, ����° ���
		// TODO Auto-generated method stub
		if(n==1) { // n�� ���� ���� ����(���� �� ����) �� ��
			System.out.println("����"+ n + "�� " +start + "���� " +des+ "�� �ű��.");
		}
		else {
			hanoi(n-1, start, des, mid); // n-1���� ������ �ι�° ������� �ű��.
			System.out.println("����"+ n +"�� " + start + "���� " + des + "�� �ű��.");
			hanoi(n-1, mid, start, des); // �ι�° ����� ���ݵ��� ����° ������� �ű��.
		}
	}
}

