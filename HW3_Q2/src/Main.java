import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***Q2***");
		
		Scanner sc = new Scanner(System.in);
		
		
		// list �̸����� ���߿��ḵũ�帮��Ʈ ����
		DoubleLinkedList list = new DoubleLinkedList(); 
		
		// N�� K�� �Է¹���
		System.out.print("�Է�(N K)> ");
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		// 1���� N���� ���ʴ�� list�� ����
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		int tmp=0;
		
		System.out.print("< ");
		
		// list size�� 1�� �ƴѵ��� �ݺ�
		while(list.size() != 1) {
			for (int i=0; i<K-1; i++) {
				tmp = (int) list.remove() ; // K-1��° �����ͱ��� ���� �� �� ���� �߰�
				list.add(tmp);
			} 
			System.out.print(list.remove() + ", "); // K��° �����ʹ� ���� �� ���
		}
		System.out.print(list.remove()+ " "); // size�� 1�̸� �ݺ��� Ż�� �� ������ ���
		System.out.print(">");
		
	}

}
