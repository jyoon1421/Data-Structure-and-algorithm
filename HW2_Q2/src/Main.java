import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***Q2-2***");
		Scanner sc = new Scanner(System.in);
		System.out.print("10���� ���ڸ� �Է�(1~99) > "); 
		
	    insertsort <Integer> input = new insertsort<>();
		
		for (int i=0; i<10; i++) { // ���� 10�� �Է¹޴� �ݺ���
			int t = sc.nextInt(); // �����ʹ� space�� �����Ͽ� 10�� �Է�
			input.add(i, t); // �Է¹��� ���� add����
		}	
		// ���� ���� ������� ����
	    for(int i = 0 ; i < input.size() ; i++) {
	        for(int j = i ; j < input.size() ; j++) {
	            if(input.get(i) > input.get(j)) {
	                Integer temp = input.remove(j);
	                input.add(i, temp);
	            }
	        }
	    }
		// ���ĵ� �迭 ���
		for(int i=0; i<10; i++) {
			System.out.print(input.get(i)+ " ");
		}
		
		
	}
}
