import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***Q1***");
		LinkedList list = new LinkedList(); // list ����
		
		// �������� �������� ���� ����
		// key���� ���� list �ִ�ũ���� 100���� �ϳ� ���� 99���� 
		int size = (int)(Math.random()*99)+1; 
		while ( size > list.size() ) { // ����Ʈũ��<�����Ͱ��� �̸� size �ٽ� ����
			size = (int)(Math.random()*99)+1; 
		}
		
		// ������ Ȯ��
		System.out.println("���� ������ ����Ʈ ũ��: " + list.size()); // ���� ����Ʈ ũ�� Ȯ�ο����� ���
		System.out.println("���� ������ ������ ����: " + size); // ���� ������ ���� Ȯ�ο����� ���
		
		// ������ ������ �����͸� list�� add
		for(int i=0; i<size; i++) {
			int rdata = (int)(Math.random()*100)+1 ; // �������� 1~100 ������ ���� ����
			if (i==0) { list.addFirst(rdata); } 
			else { list.add(rdata); } // �ļ��� ������ list�� add
		}
		
		// ����ڷκ��� �� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("ã�� ���� �� �Է�> ");
		int target = sc.nextInt(); // �� �Է¹޾� target ������ ����
		
		// ����ڿ��� �Է¹��� ���� ����Ʈ ���� Ž��Ű�� ����
		list.add(target);
		
		// ����Ʈ���� �ε��� 0~key�� ������ target�� ���� �� ã��
		for(int i=0; i<size+1; i++) {
			// i��° �׸��� target�� ������
			if(list.getItem(i) == target) {
				if(i == size) { // ������ �׸��̸� �Է¹޾� �߰��� key���̹Ƿ� ����
					System.out.println(i+1 + ". "+list.getItem(i) + " = " + target + " ������ ������ �׸�(key��)�̹Ƿ� Ž�� ����");
				}
				else { // ������ �׸��� �ƴϸ� ����Ʈ�� �ִ� ���̹Ƿ� ����
					System.out.println(i+1 + ". "+list.getItem(i) + " = " + target + " �̹Ƿ� Ž�� ����");
					break;
				}
			}
			// �ٸ��� �޽��� ��� �� �ݺ��� ���
			else { 
				System.out.println(i+1 + ". "+list.getItem(i) + " =/= " + target + " �̹Ƿ� Ž�� ���");
				continue; 
			}
		}
		
	}

}
