import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***Q2***");
		int[] arr = new int[20]; // ũ�� 20�� �迭 ����
		
		// �迭�� 2^0 ~ 2^19 ���� ä��
		for (int i=0; i<20; i++) {
			arr[i] = (int)(Math.pow(2, i));
		}
		
		// ����ڷκ��� �� �Է¹ޱ�
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է�> ");
		int target = sc.nextInt(); // �� �Է¹޾� target ������ ����
	
		// ����Ž���Լ��� �Է¹��� target�� arr �μ��� ����Ž�� ����
		int result = searchBinary(target, arr);
		
		// Ż�� ������ ��� ���� �޽��� ���
		if(result == 0) { System.out.println("�� �̻� ���� �׸��� �����Ƿ� Ž�� ����"); }
		
	}	
	
	// ���� Ž�� �Լ�
	public static int searchBinary(int target, int arr[]) {
		int middle; // middle ���� ����
		int low = 0; 
		int high = arr.length - 1 ; // low�� high ����
		
		// high�� low���� ũ�ų� ���� ���� �ݺ�
		while(high >= low) {
			middle = (low+high) / 2; // middle�� �߰�������
			
			// target�� �߰����� ������, Ž������ �޽��� ����
			if(target == arr[middle]) { 
				System.out.println(target +  " == " + arr[middle] + " �̹Ƿ� Ž�� ����");
				return middle;
			}
			
			// target�� �߰������� ������, 
			if(target < arr[middle]) {
				System.out.println(target + " < "+ arr[middle] + "�̹Ƿ� �պκ� �ٽ� Ž��");
				high = middle - 1; // 0~(�߰�-1) ���� Ž�����ϹǷ� high�� mid-1��
			}
			
			// target�� �߰������� ũ��, 
			if(target > arr[middle]) {
				System.out.println(target + " > "+ arr[middle] + "�̹Ƿ� �޺κ� �ٽ� Ž��");
				low = middle + 1; // (�߰�+1)~high ���� Ž�����ϹǷ� low�� mid+1��
			}
		}
		
		return 0; // while���� Ż�������� Ž�� ����
	}
}





