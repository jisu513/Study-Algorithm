package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S62 {//버블정렬
	public int[] solution(int n, int[] arr) {
		
		/*버블 정렬: 이웃한 두 요소의 대소관계를 비교하여 교환하며 정렬하는 알고리즘
		 시간복잡도 = O(N*N) 
		   --> 선택정렬, 삽입정렬과 같은 복잡도를 보이지만 연산 수가 가장 많아 상대적으로 가장 느리고 비효율적!*/
		
		for(int i = 0; i<n-1; i++) { 
			for(int j = 0; j<n-1-i; j++) { 
				// **j 범위 중요** 마지막 index는 정렬 되어 있으므로 n-1 까지! 그리고 i카 커질수록 비교횟수 적어지므로 (n-1)-i!
				if(arr[j] > arr[j+1]) { // 이웃한 두 요소 비교 --> j와 j+1 비교!
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}				
			} // for-j 한 번의 턴을 통해서 최댓값 마지막에 정렬!
		}
		return arr;
		
	}

	public static void main(String[] args) throws IOException {
		S62 S = new S62();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int x : S.solution(n, arr)) {
			System.out.print(x + " ");
		}

	}

}
