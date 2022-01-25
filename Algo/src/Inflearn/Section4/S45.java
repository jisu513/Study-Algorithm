package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class S45 {//k��° ū ��
	public int solution(int n, int k, int[] arr) {
		int answer = -1;
		
		//TreeSet ���! (�ߺ����ſ� ����)
		/* TreeSet: Set �������̽��� ������ Ŭ����! ��ü�� �ߺ��ؼ� ���� �� �� ���� ���� ������ �������� ���� (Set�� ����)
		         -> ���� Ž�� Ʈ�� ������ �̷���� (�˻��ɷ��� �� ����Ų ����-�� Ʈ��)
		  */
		//Set<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); //�������� ���� (����Ʈ�� �������� ����)
		
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S45 S = new S45();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.print(S.solution(n, k, arr));

	}

}
