package Inflearn.Section3;

import java.io.*;
import java.util.*;

public class S32 {//������� ���ϱ�(�������� ����)
	public ArrayList<Integer> solution(int n, int m, int[] A, int[] B){
		ArrayList<Integer> answer = new ArrayList<>();
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		//2�� for�� ��� -> ȿ�������� ����!(�ð����⵵ ����)
		/*for(int i = 0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				if(A[i] == B[j]) {
					answer.add(A[i]);
					break;
				}
			}
		}*/
		
		//two pointers ���! (�ð����⵵ ����!)
		int p1=0, p2=0;
		while(p1<n && p2<m) {
			if(A[p1] == B[p2]) {
				answer.add(A[p1]); //A, B�߿� ���� add �ص� ��� ����
				p1++;
				p2++;
			}else if(A[p1] > B[p2]) {
				p2++;
			}else {
				p1++;
			}
		}
		return answer;
	}

	public static void main(String[] args) throws IOException {
		S32 S = new S32();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		int[] A = new int[n];
		for(int i = 0; i<n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int m = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		int[] B = new int[m];
		for(int i = 0; i<m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int x : S.solution(n, m, A, B)) {
			System.out.print(x + " ");
		}
		
		

	}

}
