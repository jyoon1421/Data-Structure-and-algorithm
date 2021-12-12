
public class CorrectDeque {
	public static boolean CorrectDeque(String T) {
		Deque as = new Deque(); //���� ��ü �ϳ� ����
		char[] input = T.toCharArray(); // 
		boolean corrector = false; // �´��� Ȯ���� boolean ���� ����

		for(int i =0; i<input.length; i++) {
			switch(input[i]) {
		// ���� ��ȣ�� front�� ����
				case '(': 
				case '{':
				case '[':
					as.addFront(input[i]);
					break;
		// ���� ��ȣ�� ��ũ���� getRear�� ¦���̸� ������ ����
				case ')':
					if((as.empty()) || (as.getRear() != '(') ) { as.addFront('x');} 
					//�ٵ� ����ְų� �� ���� ¦ �´� ��ȣ�� �ƴϸ� �տ��� x�� ���� -> empty�� �ƴϸ� false �̹Ƿ�
					else {as.deleteRear();}
					break;
				case '}':
					if((as.empty()) || (as.getRear() != '{') ) { as.addFront('x');}
					else {as.deleteRear();}
					break;
				case ']':
					if((as.empty()) || (as.getRear() != '[') ) { as.addFront('x');}
					else {as.deleteRear();}
					break;
			} 
		}
		if(as.empty()) {return true;} // ��������� true ��ȯ
		else {return false;} // �Ⱥ�������� false ��ȯ
	
	
	
	}	
}
