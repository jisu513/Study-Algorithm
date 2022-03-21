package Inflearn.Section7;

import java.util.LinkedList;
import java.util.Queue;

class Nnnode {
	int data;
	Nnnode lt, rt;

	public Nnnode(int val) {
		data = val;
		lt = rt = null;
	}
}

public class S710 { // Tree 말단 노드까지의 최단 거리(BFS)
	Nnnode root;

	public int BFS(Nnnode root) {
		Queue<Nnnode> Q = new LinkedList<>();
		Q.offer(root);
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				Nnnode cur = Q.poll();
				if (cur.lt == null && cur.rt == null) {
					return L;
				}
				if (cur.lt != null) {
					Q.offer(cur.lt);
				}
				if (cur.rt != null) {
					Q.offer(cur.rt);
				}
			}
			L++;
		}

		return 0;

	}

	public static void main(String[] args) {
		S710 tree = new S710();

		tree.root = new Nnnode(1);
		tree.root.lt = new Nnnode(2);
		tree.root.rt = new Nnnode(3);
		tree.root.lt.lt = new Nnnode(4);
		tree.root.lt.rt = new Nnnode(5);

		System.out.println(tree.BFS(tree.root));

	}

}
