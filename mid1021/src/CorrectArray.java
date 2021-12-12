public class CorrectArray { //맞는지 확인하는 클래스 생성
	public static boolean CorrectArray(String T) {
		stack as = new stack(); //스택 객체 하나 생성
		char[] input = T.toCharArray(); // 
		boolean corrector = false; // 확인용 변수 생성

		for(int i =0; i<input.length; i++) {
			switch(input[i]) {
			// 열린 괄호면 스택에 저장
				case '(': 
				case '{':
				case '[':
					as.push(input[i]);
					break;
			// 닫힌 괄호면 스택에서 top이 짝꿍이면 꺼내서 삭제
			// 비어있거나 top이 짝 맞는 괄호 아니면 x를 push
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
		if(as.empty()) {return true;} // 비어있으면 true, 아니면 false 반환
		else {return false;}
		
	}
}
