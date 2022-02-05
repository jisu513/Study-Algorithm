package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S56 {// 공주 구하기
	public int solution(int n, int k) {
		int answer = 0;

		/*
		 * Queue(First In First Out) : 먼저 들어오 데이터가 먼저 나감! offer(): Queue에 데이터를 집어 넣는 함수
		 * poll() : Queue에서 데이터를 빼내는 함수 size() : Queue의 크기 구하는 함수 contanins(*) : *값이
		 * Queue에 있는지의 유무를 T/F로 리턴하는 함수
		 */

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {// q에 1~n까지 숫자 삽입
			q.offer(i + 1);
		}
		while (!q.isEmpty()) {
			for (int i = 1; i < k; i++) {// 특정 숫자 k전까지의 데이터 빼내서 다시 q에 집어 넣기!
				q.offer(q.poll());
			}
			q.poll(); // k 번째 데이터 poll()
			if (q.size() == 1) {// q안에 데이터가 하나 남아있을 때 값이 answer!
				answer = q.poll();
			}
		}

		return answer;
	}

	public static void main(String[] args) throws IOException {
		S56 S = new S56();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		System.out.println(S.solution(n, k));

	}

}
