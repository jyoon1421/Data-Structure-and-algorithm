public class CorrectArray { //�´��� Ȯ���ϴ� Ŭ���� ����
	public static boolean CorrectArray(String T) {
		stack as = new stack(); //���� ��ü �ϳ� ����
		char[] input = T.toCharArray(); // 
		boolean corrector = false; // Ȯ�ο� ���� ����

		for(int i =0; i<input.length; i++) {
			switch(input[i]) {
			// ���� ��ȣ�� ���ÿ� ����
				case '(': 
				case '{':
				case '[':
					as.push(input[i]);
					break;
			// ���� ��ȣ�� ���ÿ��� top�� ¦���̸� ������ ����
			// ����ְų� top�� ¦ �´� ��ȣ �ƴϸ� x�� push
				case ')':
					if((as.empty()) || (as.top() != '(') ){as.push('x');}
					else {as.pop();}
					break;
				case '}':
					if((as.empty()) || (as.top() != '{') ){as.push('x');}
					else {as.pop();}
					break;
				case ']':
					if((as.empty()) || (as.top() != '[') ){as.push('x');}
					else {as.pop();}
					break;
			} 
		}
		if(as.empty()) {return true;} // ��������� true, �ƴϸ� false ��ȯ
		else {return false;}
		
	}
}
