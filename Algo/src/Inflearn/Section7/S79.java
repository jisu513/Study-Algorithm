package Inflearn.Section7;

class Nnode {
	int data;
	Nnode lt, rt;

	public Nnode(int val) {
		data = val;
		lt = rt = null;
	}
}

public class S79 { // Tree 말단 노드까지의 최단 거리 (DFS) -> BFS로 풀어야 하는 문제임!(최단거리)
	Nnode root;

	public int DFS(int L, Nnode root) {
		if(root.lt == null && root.rt == null) {
			return L;
		}else {
			return Math.min(DFS(L+1,  root.lt), DFS(L+1, root.rt));
		}

	}

	public static void main(String[] args) {
		S79 tree = new S79();

		tree.root = new Nnode(1);
		tree.root.lt = new Nnode(2);
		tree.root.rt = new Nnode(3);
		tree.root.lt.lt = new Nnode(4);
		tree.root.lt.rt = new Nnode(5);

		System.out.println(tree.DFS(0, tree.root));

	}

}
