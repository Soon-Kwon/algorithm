package lists;

import java.util.NoSuchElementException;

public class CircularLinkedList<E> {
	private SNode last; // 리스트의 마지막 노드(항목)을 가리킨다.
	private int size;
	
	public CircularLinkedList() {
		last = null;
		size = 0;
	}
	
	// last가 가리키는 노드의 다음에 새노드 삽입
	public void insert(E newItem) {
		SNode newNode = new SNode(newItem, null);	// 새 노드 생성
		if(last == null) {
			newNode.setNext(newNode);	// 자기 자신을 가리킨다.
			last = newNode;
		} else {
			newNode.setNext(last.getNext());  // 원래 last가 가리켰던 노드를 이제 newNode가 가리키게 되므로
			last.setNext(newNode);	//last가 가리킬 새로운 노드, newNode 
		}
		size++;
	}
	
	// last가 가리키는 노드의 다음 노드를 제거
	public SNode delete() {
		if(isEmpty()) throw new NoSuchElementException();
		SNode x = last.getNext();
		if(x == null) last = null;	// 리스트에 1개의 노드만 있을 경우
		else {
			last.setItem(x.getNext());
			x.setNext(null);
		}
		size--;
		return x;
		
	}
	
	public boolean isEmpty() {
		return last == null;
	}
}
