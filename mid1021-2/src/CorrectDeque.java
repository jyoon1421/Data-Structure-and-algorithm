
public class CorrectDeque {
	public static boolean CorrectDeque(String T) {
		Deque as = new Deque(); //스택 객체 하나 생성
		char[] input = T.toCharArray(); // 
		boolean corrector = false; // 맞는지 확인할 boolean 변수 생성

		for(int i =0; i<input.length; i++) {
			switch(input[i]) {
		// 열린 괄호면 front에 저장
				case '(': 
				case '{':
				case '[':
					as.addFront(input[i]);
					break;
		// 닫힌 괄호면 데크에서 getRear가 짝꿍이면 꺼내서 삭제
				case ')':
					if((as.empty()) || (as.getRear() != '(') ) { as.addFront('x');} 
					//근데 비어있거나 맨 끝이 짝 맞는 괄호가 아니면 앞에다 x를 넣음 -> empty가 아니면 false 이므로
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
		if(as.empty()) {return true;} // 비어있으면 true 반환
		else {return false;} // 안비어있으면 false 반환
	
	
	
	}	
}
