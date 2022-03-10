package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S72 {// 재귀함수를 이용한 이진 출력
	public void DFS(int n) {
		if (n == 0) {
			return;
		} else {
			DFS(n / 2);
			System.out.print(n % 2);
			// System.out.print() 위치 중요! DFS() 앞에 쓰느냐ㅑ 뒤에 쓰느냐에 따라 값이 달라짐 --> 아이패드 정리
		}

	}

	public static void main(String[] args) throws IOException {
		S72 S = new S72();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		S.DFS(n);

	}

}
