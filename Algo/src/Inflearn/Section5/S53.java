package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S53 {// 인형 뽑기
	public int solution(int n, int[][] board, int k, int[] moves) {
		int answer = 0;

		Stack<Integer> sk = new Stack<>();

		for (int pos : moves) {
			for (int j = 1; j < board.length; j++) { // board의 행 길이! 열 길이는 board[0].length!
				if (board[j][pos] != 0) {//1번
					int doll = board[j][pos];
					board[j][pos] = 0;
					if (!sk.isEmpty() && doll == sk.peek()) {
						//stack이 비어있지 않을 때 비교
						//peek(): stack의 제일 상단에 있는 값만 확인!(pop()은 stack에서 꺼내서 리턴받음!)
						answer += 2;
						sk.pop();
					} else {
						sk.push(doll);
					}
					break; //**중요! 1번의 if문이 참이면 for문 한 번 수행 후 멈추기! 그 다음까지 넘어가면 안됨!
				}

			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S53 S = new S53();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());
		int[][] board = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int k = Integer.parseInt(br.readLine());
		int[] moves = new int[k];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			moves[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(S.solution(n, board, k, moves));

	}

}
