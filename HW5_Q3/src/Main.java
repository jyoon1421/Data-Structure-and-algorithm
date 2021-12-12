
public class Main {

	public static <K, V> void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***Q3 해시테이블 - 체이닝 기법***");
		
		HashTable table = new HashTable(); // 크기가 5인 해시테이블 생성
		
		// 데이터가 잘 들어갔는지 확인하기 위해 들어갈 때마다 show함수로 모든 데이터를 출력해보았다.
		// 중복이 많이 일어나도록(충돌) 나머지가 0으로 같은 5,10,15를 넣고 -> 0번 자리에 5, 10, 15 모두 들어가야함
		// 1번 자리에 들어가야할 6과 11도 넣어보았다. -> 1번 자리에 6, 11 들어감
		// 크기 5이므로 적재율 이상의 데이터인 7개를 넣어봤는데 모두 잘 들어감을 확인할 수 있다.
		
		table.put(5); // 0번 자리 들어감
		table.show();
		table.put(10); // 0번 자리 들어감
		table.show();
		table.put(15); // 0번 자리 들어감
		table.show();
		table.put(6); // 1번 자리 들어감
		table.show();
		table.put(11); // 1번 자리 들어감
		table.show();
		table.put(9); // 4번 자리 들어감
		table.show();
		table.put(8); // 3번 자리 들어감
		table.show();
		
	}

}
