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

		for (int pos : moves) {// moves의 값이 크레인의 위치!
			for (int i = 0; i < board.length; i++) {// board.length는 행의 길이! board[0].length는 열의 길이
				if (board[i][pos - 1] != 0) {// board의 index는 0부터 시작하므로 moves값(=pos)에서 -1 해줘야함!
					// 인형 뽑기
					int doll = board[i][pos - 1];
					board[i][pos - 1] = 0;

					// 뽑은 인형이 스택 상단에 있는 것과 같을 경우
					if (!sk.isEmpty() && sk.peek() == doll) { // peek(): 스택 상단에 있는 값 확인!(꺼내지 않음!)
						answer += 2;
						sk.pop();
					} else {// 다른 경우에 스택에 push!
						sk.push(doll);
					}
					break; // 첫번째 if문이 참일 때 한 번 수행! break 안해주면 i-for문 계속 수행하게 되므로 오답!
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
		int[][] board = new int[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
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
