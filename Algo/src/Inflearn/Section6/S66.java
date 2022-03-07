package Inflearn.Section6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S66 { // �峭�ٷ���
	public ArrayList<Integer> solution(int n, int[] arr) {
		ArrayList<Integer> answer = new ArrayList<>();
		
		/* �ڹٿ��� ��ü�� �����ϴ� �������� ���� ����� ���� ���簡 ����
		 * ���� ����: ��ü�� �������� ���ο� ��ü�� ���� -> �޸� ���鿡�� ��ȿ������ �� ����
		 * ���� ����: �ܼ��� ��ü�� �ּ� ������ ���� -> ���� �ּҸ� �����ϱ� ������ �ϳ��� ���� �����ϸ� �ٸ� ��� �ڵ����� ����� 
		 */
		
		// arr ���� �� ������ �迭�� ���� --> �� �迭 �� �� �迭 ���� �ٸ� �ε��� ���
		int[] tmp = arr.clone(); // clone()�޼��� ����ؼ� ���� ������ �� ����! (���� ����)
		/*int[] tmp = new int[n]; 
		for (int i = 0; i < n; i++) {
			tmp[i] = arr[i];
		}*/
		
		Arrays.sort(tmp);
		
		for(int i = 0; i<n; i++) {
			if(arr[i] != tmp[i])
				answer.add(i+1); // �л� ��ȣ�� 1�� ���� �ο��ϹǷ� +1 �������!
		}
			
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S66 S = new S66();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int x : S.solution(n, arr)) {
			System.out.print(x + " ");
		}

	}

}
