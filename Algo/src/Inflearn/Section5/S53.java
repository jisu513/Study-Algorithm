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

		for (int pos : moves) {// moves의 배열값에 해당하는 board의 index로 이동!
			for (int i = 0; i < board.length; i++) {// board의 행 길이! 열 길이는 board[0].length!
				if (board[i][pos - 1] != 0) {// board의 index는 0부터 시작하므로 -1 해줘야함!
					int doll = board[i][pos - 1];
					board[i][pos - 1] = 0;
					if (!sk.isEmpty() && sk.peek() == doll) { //stack이 비어있지 않을 때 비교
						//peek(): stack의 제일 상단에 있는 값만 확인!(pop()은 stack에서 꺼내서 리턴받음!)
						answer += 2;
						sk.pop();
					} else {
						sk.push(doll);

					}
					break; //if가 참일 때 하나만 수행! break 안해주면 for문 계속 돌게 되므로 오답!
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
