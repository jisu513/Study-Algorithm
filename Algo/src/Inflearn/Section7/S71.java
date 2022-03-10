package Inflearn.Section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S71 { //재귀함수 --> 자기 자신을 호출하는 함수
	public void DFS(int n) {
		if(n == 0) {
			return;
		}else {
			//System.out.print(n + " "); --> 내림차순 출력
			DFS(n-1);
			System.out.print(n + " "); // 오름차순 출력 --> 아이패드 확인
		}
	}

	public static void main(String[] args) throws IOException {
		S71 S = new S71();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		S.DFS(n);

	}

}
