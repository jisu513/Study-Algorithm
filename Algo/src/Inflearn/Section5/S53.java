package Inflearn.Section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S53 {// ���� �̱�
	public int solution(int n, int[][] board, int k, int[] moves) {
		int answer = 0;

		Stack<Integer> sk = new Stack<>();

		for (int pos : moves) { // moves�� ���� ũ������ ��ġ!
			for (int i = 0; i < board.length; i++) { // board.length�� ���� ���� (board[0].length�� ���� ����)
				if (board[i][pos - 1] != 0) { // board�� index�� 0���� �����ϹǷ� moves��(=pos)���� -1 �������!
					// ���� �̱�
					int doll = board[i][pos - 1];
					board[i][pos - 1] = 0;

					// ���� ������ ���� ��ܿ� �ִ� �Ͱ� ���� ���
					if (!sk.isEmpty() && sk.peek() == doll) {
						// peek(): ���� ��ܿ� �ִ� �� Ȯ��!(������ ����!)
						answer += 2;
						sk.pop();
					} else { // �ٸ� ��쿡 ���ÿ� push!
						sk.push(doll);
					}
					break; // ù��° if���� ���� �� �� �� ����! break �����ָ� i-for�� ��� �����ϰ� �ǹǷ� ����!
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
