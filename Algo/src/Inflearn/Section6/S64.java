package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S64 {// Least Recently Used
	public int[] solution(int s, int n, int[] arr) {
		int[] answer = new int[s];

		for(int x : arr) {
			int pos = -1; // pos는 hit 일 때 해당 answer[]의 index이므로 answer[] index에 해당하지 않는 -1 (0 ~ s-1가 아닌)로 설정!
			for(int i = 0; i<s; i++) { // hit인지 여부 확인
				if(x == arr[i]) { // hit일 때
					pos = i; // pos를 hit이 일어난 인덱스로 변경
				}
			}
			
			// answer[] 자리 옮기기
			if(pos == -1) { // miss일 때 자리 한 칸 씩 뒤로 이동
				for(int i = s-1; i>=1; i--) {
					answer[i] = answer[i-1];
				}
			}else {//hit일 때 자리 이동(pos부터 변경)
				for(int i = pos; i>=1; i--) {
					answer[i] = answer[i-1];
				}			
			}
			answer[0] = x; //miss일 때나 hit 일때나 새로운 input은 answer[0]에 들어와야 함!
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S64 S = new S64();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int x : S.solution(s, n, arr)) {
			System.out.print(x + " ");
		}
	}

}
