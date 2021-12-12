import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("***Q2***");
		int[] arr = new int[20]; // 크기 20인 배열 생성
		
		// 배열에 2^0 ~ 2^19 까지 채움
		for (int i=0; i<20; i++) {
			arr[i] = (int)(Math.pow(2, i));
		}
		
		// 사용자로부터 값 입력받기
		Scanner sc = new Scanner(System.in);
		System.out.print("입력> ");
		int target = sc.nextInt(); // 값 입력받아 target 변수에 저장
	
		// 이진탐색함수에 입력받은 target과 arr 인수로 이진탐색 진행
		int result = searchBinary(target, arr);
		
		// 탈출 실패인 경우 실패 메시지 출력
		if(result == 0) { System.out.println("더 이상 남은 항목이 없으므로 탐색 실패"); }
		
	}	
	
	// 이진 탐색 함수
	public static int searchBinary(int target, int arr[]) {
		int middle; // middle 변수 생성
		int low = 0; 
		int high = arr.length - 1 ; // low와 high 지정
		
		// high가 low보다 크거나 같은 동안 반복
		while(high >= low) {
			middle = (low+high) / 2; // middle은 중간값으로
			
			// target이 중간값과 같으면, 탐색성공 메시지 띄우기
			if(target == arr[middle]) { 
				System.out.println(target +  " == " + arr[middle] + " 이므로 탐색 성공");
				return middle;
			}
			
			// target이 중간값보다 작으면, 
			if(target < arr[middle]) {
				System.out.println(target + " < "+ arr[middle] + "이므로 앞부분 다시 탐색");
				high = middle - 1; // 0~(중간-1) 값을 탐색해하므로 high를 mid-1로
			}
			
			// target이 중간값보다 크면, 
			if(target > arr[middle]) {
				System.out.println(target + " > "+ arr[middle] + "이므로 뒷부분 다시 탐색");
				low = middle + 1; // (중간+1)~high 값을 탐색해하므로 low를 mid+1로
			}
		}
		
		return 0; // while문을 탈출했으면 탐색 실패
	}
}





