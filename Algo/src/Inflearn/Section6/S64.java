package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S64 {// Least Recently Used
	public int[] solution(int s, int n, int[] arr) {
		int[] answer = new int[s];

		for (int x : arr) {
			int pos = -1; // pos는 hit 일 때 해당 answer[]의 index이므로 arr[] index에 해당하지 않는 -1 (0 ~ s-1 제외)로 설정!
			
			// hit인지 아닌지 확인 --> pos의 값이 변하지 않으면 miss / 변하면 hit
			for (int i = 0; i < s; i++) {
				if (x == answer[i]) { // hit일 때
					pos = i; // 해당 index값을 pos 넣어줌
				}
			}
			
			if (pos == -1) { // miss인 경우
				for (int i = s - 1; i >= 1; i--) { // 맨 마지막 index에서 감소하면서 자리옮기기! (첫번째 index [0]는 새로운 input!)
					answer[i] = answer[i - 1]; // ex) answer[3]에 answer[2] 값 들어옴 --> 한 칸 씩 옆으로 이동!
					// answer[0] = x;
				}
			} else { // hit인 경우
				for (int i = pos; i >= 1; i--) { // hit난 자리의 index(pos)부터 감소하면서 자리옮기기!
					answer[i] = answer[i - 1];
					// answer[0] = x;
				}
			}
			answer[0] = x; //miss일 때나 hit 일때나 새로운 input은 answer[0]에 들어와야 하므로 밖으로 빼도 됨!
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
