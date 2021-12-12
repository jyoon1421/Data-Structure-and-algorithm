import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Q2 후위 연산 프로그램
		System.out.println("***Q1-2***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력> ");
		String T = sc.next();
		char[] input = T.toCharArray();
		
		Arraystack result = new Arraystack();
	
		for(int i=0; i<input.length; i++) {
			int temp1=0, temp2=0, temp3=0;
			switch(input[i]) {
			// 연산자(기호)면 result에서 두번 pop해서 계산 후 push
				case '*':
					temp1 = result.top();
					result.pop();
					temp2 = result.top();
					result.pop();
					temp3 = temp2 * temp1;
					result.push(temp3);
					break;
				case '/':
					temp1 = result.top();
					result.pop();
					temp2 = result.top();
					result.pop();
					temp3 = temp2 / temp1;
					result.push(temp3);
					break;
				case '+':
					temp1 = result.top();
					result.pop();
					temp2 = result.top();
					result.pop();
					temp3 = temp2 + temp1;
					result.push(temp3);
					break;
				case '-':
					temp1 = result.top();
					result.pop();
					temp2 = result.top();
					result.pop();
					temp3 = temp2 - temp1;
					result.push(temp3);
					break;
				// 피연산자(숫자)면 결과스택에 push
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					temp1 =Character.getNumericValue(input[i]);
					result.push(temp1);
					break;
			}
		}
			System.out.print(result.top());
		
	}
}
