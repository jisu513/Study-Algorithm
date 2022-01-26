package Inflearn.Section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;




public class S45 {//k번째 큰 수
	public int solution(int n, int k, int[] arr) {
		int answer = -1;
		
		//TreeSet 사용! (중복 제거와 정렬)
		/* TreeSet: Set 인터페이스를 구현한 클래스! 객체를 중복해서 저장 할 수 없고 저장 순서가 유지되지 않음 (Set의 성질)
		         -> 이진 탐색 트리 구조로 이루어짐 (검색능력을 더 향상시킨 레드-블랙 트리)
		  */
		TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder()); //내림차순 정렬 (디폴트는 오름차순 정렬)
		
		// 문제에서 3개의 합을 구하라 했으므로 3중 for문 사용!
		for(int i = 0; i<n; i++) {
			for(int j = i+1; j<n; j++) {
				for(int l = j+1; l<n; l++) {
					Tset.add(arr[i]+arr[j]+arr[l]); 
					//3장씩 뽑은 카트 합의 모든 경우의 수 Tset에 큰 수 부터 정렬되어 있음!
				}
			}
		}
		int cnt=0;
		for(int x : Tset) {
			cnt++;
			if(cnt==k) {
				return x; //k번째 값이 있으면 x return
			}
		}
		return answer;//k번째 값이 없으면 1 return
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
