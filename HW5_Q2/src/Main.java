
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***Q2 �ؽ����̺� - �����ּ� ���***\n");
		
		HashTable<Integer> table = new HashTable(); // ũ�� 5�� �ؽ����̺� ����
		
		// �����Ͱ� �� ������ Ȯ���ϱ� ���� �� ������ show�Լ��� ��� �����͸� ����غ��Ҵ�.
		// �ߺ��� ���� �Ͼ���� �������� 0���� ���� 5,10,15�� �ְ� 
		// �������簡 �� �Ǵ��� Ȯ���� ���� 1�� �ڸ��� ������ 6�� �־�Ҵ�.
		// ������ 0.9 �̻��϶� �迭 ����� �� �þ���� Ȯ���� ���� �����͸� �� �־�Ҵ�.
		
		table.put(5); 
		table.show();
		table.put(10);
		table.show();
		table.put(15);
		table.show();
		table.put(6);
		table.show();
		table.put(6);
		table.show();
		table.put(9);
		table.show();
		table.put(30);
		table.show();
		
	}

}


class HashTable<K>{
	int N = 5;
	int size = 0; // ���̺� �� �����Ͱ���
	K[] a = (K[]) new Object[N]; // �ؽ����̺�
	
	
	// Hash���� ��� ���� �Լ�
	int hash(K key) {
		return ((int)key % N); // �ؽ��Լ��� ũ��N���� ���� ������
	}
	
	// key���� �����ϱ� ���� �Լ�
	void put(K key) {
		int initialpos = hash(key); // �ʱ� ��ġ�� ��� 
		
		if(ratio()>=0.9) { resize(2*N); } // �������� 0.9 �̻��̸� �迭 ������ 2���
		
		// �ʱ� ��ġ�� ��������� �״�� ����
		if(a[initialpos]==null) {
			a[initialpos] = key; // key�� �ؽ����̺� ����
		}
		// �ʱ� ��ġ�� �̹� key�� �����ϸ� 
		else {
			// ���� ��ġ�� ������� ������ +1
			while(a[initialpos]!=null) {
				initialpos++;
			}
			a[initialpos] = key; // key�� �ؽ����̺� ����
		}
		size++;
	}
	
	// key ���� ���� �׸� ����
	void remove(K key) {
		// �ؽ����̺��� ó������ ���鼭 key���� ã���� null�� �ʱ�ȭ
		for(int i=0; i<N; i++) {
			if(a[i] == key) { a[i] = null; }
		}
	}
	
	// �ش� key�� �����ϴ��� �˻�
	boolean contains(K key) {
		boolean temp = false;
		// �ؽ����̺��� ó������ ���鼭 key���� ã���� temp ������ true��
		for(int i=0; i<N; i++) {
			if(a[i] == key) { temp = true; }
		}
		return temp;
	}
	
	// ������ ��� �Լ�
	float ratio() {
		float ratio = (size/N); // ������� ������ ������ ��ü ũ��
		return ratio;
	}
	
	// �迭 ũ�� ���� �Լ�
	void resize(int newSize) {
		int newsize = newSize;
		Object[] t = new Object[newSize]; // �� ũ���� �迭 t����
		for(int i=0; i<size; i++) {
			t[i] = a[i]; // ���� �迭 a�� �迭 t�� ����
		}
		a = (K[]) t; // �迭 t�� ���� �迭 a�� 
	}
	
	// �迭 ��� �Լ�
	void show() {
		int j = 0;
		for(K i:a) { 
			System.out.print(j+ ")" + i + " "); 
			j++;
			// �ε��� 0�ڸ��� 10, 1�ڸ��� 20������ 
			// 0)10 1)20 �̷������� ��µǰԲ� 
		}
		System.out.println(" ");
	}
	
	
}