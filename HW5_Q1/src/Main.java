
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***Q1 ������׷� ����***");
		
		int n = 8; // ���� ���� ���� ����
		int height[] = {3, 2, 3, 4, 2, 3, 4, 1}; // ������׷� ���̸� �迭�� �߰�
		
		
		// ���� ���� ���
		System.out.print("���� ����: "); 
		for(int i=0; i<n; i++) { System.out.print(height[i] + " "); };
		System.out.println(" ");
		
		long area = 0; // ���� ���� ����
		Arraystack stack = new Arraystack(); // stack ����
		
		stack.push(0);
		
		for(int i=1; i<n; i++) {
			
			// ������ ������� �ʰ�, ���� ���밡 �� ���뺸�� �۰ų� ���� ���
			// i��°���� ���� ������� pop�Ͽ� �ִ� ���̸� ���
			while(stack.empty()==false && height[stack.top()]>=height[i]) {
				
				// ���� ������ ���̸� prev ������ ����
				int prev = height[stack.top()];
				stack.pop();
				// �ʺ�� i
				int width = i;
				
				// ���� ���� ���밡 ���ٸ� �ʺ�� �״�� i
				// ���� stack�� ���� ���밡 �ִٸ� 
				if(stack.empty()==false) {
					// �ʺ�� �Ʒ��� ����
					width = i - stack.top() - 1 ;
				}
				
				// ���̴� �� �� �ִ밪���� ����
				area = Math.max(area, prev*width);
			}
			stack.push(i); // stack�� �����ִ� �ֵ��� i���� �۰ų� �����Ƿ� i�� �־���
		}
		
		// ������ ������� �ʴٸ� 
		while(stack.empty()==false) {
			// ���� ���� ���� 
			int prev = height[stack.top()];
			stack.pop();
			int width = 0; 
			
			if(stack.empty()==false) {
				width = n - stack.top() - 1 ;
			}
			// ���̴� �� �� �ִ밪���� ����
			area = Math.max(area, prev*width);
		}
		
		// �ִ� ���� ���
		System.out.println("�ִ� ����: "+ area);
	}

}
