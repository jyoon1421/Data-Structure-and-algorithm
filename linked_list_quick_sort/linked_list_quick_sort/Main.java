package linked_lilst_quick_sort;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("10개의 숫자를 입력(1~99) > "); 
		
		LinkedList<Integer> input = new LinkedList<>();
		
		for (int i=0; i<10; i++) { // 숫자 10개 입력받는 반복문
			int t = sc.nextInt(); // 데이터는 space로 구분하여 10개 입력
			input.add(i, t); // 입력받은 숫자 add저장
		}	
		
		// 퀵 정렬 방식으로 정렬
		// int L = 0;
	    // int R = 9;
		// input.sort(L, R);
		input.quickSort();
		
		// 정렬된 링크드 리스트 출력
		for(int i=0; i<10; i++) {
			System.out.print(input.get(i)+ " ");
		}

		sc.close();
	}
}
