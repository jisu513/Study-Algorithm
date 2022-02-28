package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S69 { // 뮤직비디오 (결정알고리즘) -> dvd 최소용량 구하기
	public int count(int[] arr, int capacity) { //몇 장의 dvd를 사용하는지
		int cnt = 1, sum = 0;
		
		for(int x : arr) {
			if(sum + x > capacity) { // sum+x가 용량보다 크면 dvd 개수를 하나 늘리고 x부터 다시 더하기
				cnt++;
				sum = x;
			}else {
				sum += x;
			}
		}
		
		return cnt;
	}
	

	public int solution(int n, int m, int[] arr) {
		int answer = 0;

		/* 결정 알고리즘 : 이분검색을 이용하는 알고리즘 
		 * Stream : 배열 또는 컬렉션을 인스턴스에 함수 여러 개를 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있음
		 *           --> 배열과 컬렉션을 함수형으로 처리 가능 (람다를 이용해서 코드를 간결하게 표현하는 것도 가능)
		 *    배열 스트림) Arrays.stream() 메소드 사용
		 *    https://wakestand.tistory.com/419 참고해서 공부!
		 */
		
		int lt = Arrays.stream(arr).max().getAsInt();
		int rt = Arrays.stream(arr).sum();
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			if(count(arr, mid) <= m) { // count()가 m보다 작거나 같으면 mid 이상의 용량은 무조건 가능하다는 의미 --> rt를 mid-1로 이동해서 더 낮은 용량으로도 가능한지 구하기
				answer = mid;
				rt = mid-1;
			}else { // mid이하의 용량은 불가능하다는 의미 --> lt를 mid+1로 이동해서 더 큰 용량에서 다시 구하기
				lt = mid+1;
			}
			
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S69 S = new S69();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(S.solution(n, m, arr));

	}

}
