package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class S45 {//k��° ū ��
	public int solution(int n, int k, int[] arr) {
		int answer = -1;
		
		//TreeSet ���! (�ߺ� ���ſ� ����)
		/* TreeSet: Set �������̽��� ������ Ŭ����! ��ü�� �ߺ��ؼ� ���� �� �� ���� ���� ������ �������� ���� (Set�� ����)
		         -> ���� Ž�� Ʈ�� ������ �̷���� (�˻��ɷ��� �� ����Ų ����-�� Ʈ��)
		  */
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); //�������� ���� (����Ʈ�� �������� ����)
		
		// �������� 3���� ���� ���϶� �����Ƿ� 3�� for�� ���!
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				for(int l = j+1; l<n; l++) {
					Tset.add(arr[i]+arr[j]+arr[l]); 
					//3�徿 ���� īƮ ���� ��� ����� �� Tset�� ū �� ���� ���ĵǾ� ����!
				}
			}
		}
		int cnt=0;
		for(int x : Tset) {
			cnt++;
			if(cnt==k) {
				return x; //k��° ���� ������ x return
			}
		}
		return answer;//k��° ���� ������ 1 return
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
