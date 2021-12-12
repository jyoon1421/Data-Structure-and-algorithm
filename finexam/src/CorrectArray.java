
public class CorrectArray {
	public static boolean CorrectArray(String T) {
		Arraystack as = new Arraystack();
		char[] input = T.toCharArray();

		for(int i =0; i<input.length; i++) {
			switch(input[i]) {
			// ���� ��ȣ�� ���ÿ� ����
				case '(': 
				case '{':
				case '[':
					as.push(input[i]);
					break;
			// ���� ��ȣ�� ���ÿ��� top�� ¦���̸� ������ ����
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
		if(as.empty()) {return true;}
		else {return false;}
		
	}
}
