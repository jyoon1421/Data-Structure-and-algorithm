import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***Q2-2***");
		Scanner sc = new Scanner(System.in);
		System.out.print("10개의 숫자를 입력(1~99) > "); 
		
	    insertsort <Integer> input = new insertsort<>();
		
		for (int i=0; i<10; i++) { // 숫자 10개 입력받는 반복문
			int t = sc.nextInt(); // 데이터는 space로 구분하여 10개 입력
			input.add(i, t); // 입력받은 숫자 add저장
		}	
		// 삽입 정렬 방식으로 정렬
	    for(int i = 0 ; i < input.size() ; i++) {
	        for(int j = i ; j < input.size() ; j++) {
	            if(input.get(i) > input.get(j)) {
	                Integer temp = input.remove(j);
	                input.add(i, temp);
	            }
	        }
	    }
		// 정렬된 배열 출력
		for(int i=0; i<10; i++) {
			System.out.print(input.get(i)+ " ");
		}
		
		
	}
}
