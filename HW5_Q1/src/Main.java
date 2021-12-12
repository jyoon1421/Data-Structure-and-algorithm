
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***Q1 히스토그램 문제***");
		
		int n = 8; // 막대 개수 변수 설정
		int height[] = {3, 2, 3, 4, 2, 3, 4, 1}; // 히스토그램 높이를 배열에 추가
		
		
		// 막대 높이 출력
		System.out.print("막대 높이: "); 
		for(int i=0; i<n; i++) { System.out.print(height[i] + " "); };
		System.out.println(" ");
		
		long area = 0; // 넓이 변수 생성
		Arraystack stack = new Arraystack(); // stack 생성
		
		stack.push(0);
		
		for(int i=1; i<n; i++) {
			
			// 스택이 비어있지 않고, 현재 막대가 전 막대보다 작거나 같은 경우
			// i번째보다 작은 막대들을 pop하여 최대 넓이를 계산
			while(stack.empty()==false && height[stack.top()]>=height[i]) {
				
				// 이전 막대의 높이를 prev 변수에 저장
				int prev = height[stack.top()];
				stack.pop();
				// 너비는 i
				int width = i;
				
				// 만약 남은 막대가 없다면 너비는 그대로 i
				// 만약 stack에 남은 막대가 있다면 
				if(stack.empty()==false) {
					// 너비는 아래와 같음
					width = i - stack.top() - 1 ;
				}
				
				// 넓이는 둘 중 최대값으로 저장
				area = Math.max(area, prev*width);
			}
			stack.push(i); // stack에 남아있는 애들은 i보다 작거나 같으므로 i를 넣어줌
		}
		
		// 스택이 비어있지 않다면 
		while(stack.empty()==false) {
			// 이전 막대 높이 
			int prev = height[stack.top()];
			stack.pop();
			int width = 0; 
			
			if(stack.empty()==false) {
				width = n - stack.top() - 1 ;
			}
			// 넓이는 둘 중 최대값으로 저장
			area = Math.max(area, prev*width);
		}
		
		// 최대 넓이 출력
		System.out.println("최대 넓이: "+ area);
	}

}
