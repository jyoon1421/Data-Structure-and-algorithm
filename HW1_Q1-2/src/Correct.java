
public class Correct {
	public static boolean Correct(String T) {
		linkedListStack lls = new linkedListStack();
		char[] input = T.toCharArray();

		for(int i =0; i<input.length; i++) {
			switch(input[i]) {
			// ¿­¸° °ýÈ£¸é ½ºÅÃ¿¡ ÀúÀå
				case '(': 
				case '{':
				case '[':
					lls.push(input[i]);
					break;
			// ´ÝÈù °ýÈ£¸é ½ºÅÃ¿¡¼­ topÀÌ Â¦²áÀÌ¸é ²¨³»¼­ »èÁ¦
				case ')':
					if((lls.empty()) || (lls.top() != '(') ){lls.push('x');}
					else {lls.pop();}
					break;
				case '}':
					if((lls.empty()) || (lls.top() != '{') ){lls.push('x');}
					else {lls.pop();}
					break;
				case ']':
					if((lls.empty()) || (lls.top() != '[') ){lls.push('x');}
					else {lls.pop();}
					break;
			} 
		}
		if(lls.empty()) {return true;}
		else {return false;}
		
	}
}
