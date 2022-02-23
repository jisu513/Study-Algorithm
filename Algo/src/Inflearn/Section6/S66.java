package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S66 { // 장난꾸러기
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		/* 자바에서 객체를 복사하는 유형에는 깊은 복사와 얕은 복사가 있음
		 * 깊은 복사: 객체의 실제값을 새로운 객체로 복사 -> 메모리 측면에서 비효율적일 수 있음
		 * 얕은 복사: 단순히 객체의 주소 값만을 복사 -> 같은 주소를 참조하기 때문에 하나의 값을 변경하면 다른 대상도 자동으로 변경됨 
		 */

		//tmp[] 만들어서 arr[] 그대로 복사!
		int[] tmp = arr.clone(); // clone()메서드 사용해서 쉽게 복사할 수 있음! (깊은 복사)
		
		/*int[] tmp = new int[n]; 
		for (int i = 0; i < n; i++) {
			tmp[i] = arr[i];
		}*/
		
		Arrays.sort(tmp); // 오름차순으로 정렬

		for (int i = 0; i < n; i++) {
			if (arr[i] != tmp[i]) {
				answer.add(i + 1); // 학생 번호를 1번 부터 부여하므로 +1 해줘야힘!
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S66 S = new S66();

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
