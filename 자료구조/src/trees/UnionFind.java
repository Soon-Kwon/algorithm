package trees;

public class UnionFind {
	
	static class Node{
		int parent;
		int rank;
		
		public Node(int newParent, int newRank){
			parent = newParent;
			rank = newRank;
		} 

		public int getParent() {
			return parent;
		}

		public void setParent(int parent) {
			this.parent = parent;
		}

		public int getRank() {
			return rank;
		}

		public void setRank(int rank) {
			this.rank = rank;
		}
	}
	
	protected Node[] a;
	
	public UnionFind() {}
	
	public UnionFind(Node[] iarray) {
		a = iarray;
	}
	
	// i가 속한 집합의 루트를 재귀적으로 찾고 경로상의 각 원소의 부모를 루트로 만든다.
	protected int find(int i) {
		// 경로 압축
		if(i != a[i].getParent()) {
			a[i].setParent(find(a[i].getParent()));
		}
		return a[i].getParent();
	}
	
	public void union(int i, int j) {
		int iroot = find(i);
		int jroot = find(j);
		if(iroot == jroot) {
			return;	// 루트노드가 동일하면 더 이상의 수행없이 그대로 리턴
		}
		// rank가 높은 루트노드가 승자가 된다.
		if(a[iroot].getRank() > a[jroot].getRank()) {
			a[jroot].setParent(iroot);
		} else if(a[iroot].getRank() < a[jroot].getRank()) {
			a[iroot].setParent(jroot);
		} else {
			a[jroot].setParent(iroot); // 임의로 승자 정하기
			int t = a[iroot].getRank() + 1;
			a[iroot].setRank(t);
		}
	}
}
