package Inflearn.Section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S25 {// 소수 갯수 구하기 (에라토스테네스 체) --> 소수가 되는 수의 배수를 지우면 남은건 소수
	public int solution(int n) {
		int answer = 0;

		// 배열 생성
		int[] num = new int[n + 1]; // 숫자와 index번호를 같기 하기 위해서 n+1까지 생성 --> num[1] 은 숫자 1, num[2]는 숫자 2 ...
		
		for (int i = 2; i < n + 1; i++) { // 숫자 1은 제외
			if (num[i] == 0) {
				answer++;
			}
			for (int j = i; j < n + 1; j += i) { // **KeyPoint! -> i배수의 인덱스를 가진 배열의 값을 1로 변경
				                                 // --> 해당 배열은 나눠지는 값이 있다는 의미이므로 소수가 아님!
				num[j] = 1;
			}

		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S25 S = new S25();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println(S.solution(n));

	}

}
