
public class Main {

	public static <K, V> void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***Q3 �ؽ����̺� - ü�̴� ���***");
		
		HashTable table = new HashTable(); // ũ�Ⱑ 5�� �ؽ����̺� ����
		
		// �����Ͱ� �� ������ Ȯ���ϱ� ���� �� ������ show�Լ��� ��� �����͸� ����غ��Ҵ�.
		// �ߺ��� ���� �Ͼ����(�浹) �������� 0���� ���� 5,10,15�� �ְ� -> 0�� �ڸ��� 5, 10, 15 ��� ������
		// 1�� �ڸ��� ������ 6�� 11�� �־�Ҵ�. -> 1�� �ڸ��� 6, 11 ��
		// ũ�� 5�̹Ƿ� ������ �̻��� �������� 7���� �־�ôµ� ��� �� ���� Ȯ���� �� �ִ�.
		
		table.put(5); // 0�� �ڸ� ��
		table.show();
		table.put(10); // 0�� �ڸ� ��
		table.show();
		table.put(15); // 0�� �ڸ� ��
		table.show();
		table.put(6); // 1�� �ڸ� ��
		table.show();
		table.put(11); // 1�� �ڸ� ��
		table.show();
		table.put(9); // 4�� �ڸ� ��
		table.show();
		table.put(8); // 3�� �ڸ� ��
		table.show();
		
	}

}
