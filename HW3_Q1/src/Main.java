import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***Q1***");
		
		Scanner sc = new Scanner(System.in);
		LinkedListQueue list = new LinkedListQueue(); // ����ť list �̸����� ����
		
		while(true) {
			System.out.print("�Է�> ");
			int t = sc.nextInt(); // �Է¹��� ���� t�� ����
			
			// t�� 0�̸�
			if(t == 0) {
				list.remove(); // ������ ����
				list.display(); // ������ ���
			}
			// t�� 0���ϸ�
			else if( t <= 0 ) {
				System.out.println("����� �Է��Ͻʽÿ�."); // �����޽��� ���
			}
			// t�� �����
			else {
				list.add(t); // t�� ť�� ����
				list.display(); // ������ ���
			}
			
			// list�� ������� ����
			if(list.Isempty()) {
				break;
			}
		}
		System.out.println("ť�� ��������ϴ�.");
	}
}
