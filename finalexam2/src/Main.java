import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***Q8***");
		Scanner sc = new Scanner(System.in);
		System.out.print("10���� ���ڸ� �Է�(1~99) > "); 
		
		LinkedList <Integer> input = new LinkedList<>(); // input �̸��� linked list ����
		
		for (int i=0; i<10; i++) { // ���� 10�� �Է¹޴� �ݺ���
			int t = sc.nextInt(); // �����ʹ� space�� �����Ͽ� 10�� �Է�
			input.add(i, t); // �Է¹��� ���� add����
		}	
		
		// �� ���� ������� ����
        input.quickSort();
		
		// ���ĵ� ��ũ�帮��Ʈ ���
		for(int i=0; i<10; i++) {
			System.out.print(input.get(i)+ " ");
		}
		
		sc.close();
	}
}
