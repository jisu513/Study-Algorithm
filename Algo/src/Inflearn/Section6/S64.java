package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S64 {// Least Recently Used
	public int[] solution(int s, int n, int[] arr) {
		int[] answer = new int[s];

		for(int x : arr) {
			int pos = -1; // pos�� hit �� �� �ش� answer[]�� index�̹Ƿ� answer[] index�� �ش����� �ʴ� -1 (0 ~ s-1�� �ƴ�)�� ����!
			for(int i = 0; i<s; i++) { // hit���� ���� Ȯ��
				if(x == arr[i]) { // hit�� ��
					pos = i; // pos�� hit�� �Ͼ �ε����� ����
				}
			}
			
			// answer[] �ڸ� �ű��
			if(pos == -1) { // miss�� �� �ڸ� �� ĭ �� �ڷ� �̵�
				for(int i = s-1; i>=1; i--) {
					answer[i] = answer[i-1];
				}
			}else {//hit�� �� �ڸ� �̵�(pos���� ����)
				for(int i = pos; i>=1; i--) {
					answer[i] = answer[i-1];
				}			
			}
			answer[0] = x; //miss�� ���� hit �϶��� ���ο� input�� answer[0]�� ���;� ��!
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
