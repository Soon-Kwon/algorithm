package lists;

import java.util.NoSuchElementException;

public class SinglyLinkedList<E> {
	
	protected SNode<E> head;	// 연결리스트의 첫 노드
	private int size;
	
	public SinglyLinkedList() {	// 단순연결리스트 생성자
		head = null;
		size = 0;
	}
	
	// target을 검색
	public int search(E target) {	
		SNode<E> p = head;
		for(int k = 0; k < size; k++) {
			if(target == p.getItem()) 
				return k;
			p = p.getNext();
		}
		
		return -1;	// 탐색에 실패한 경우 -1 리턴
	}
	
	// 연결리스트 맨 앞에 새 노드 삽입
	public void insertFront(E newItem) {	
		head = new SNode<E>(newItem, head);
		size++;
	}
	
	// 노드 p 바로 다음에 새 노드 삽입
	public void insertAfter(E newItem, SNode<E> p) {
		p.setNext(new SNode<E>(newItem, p.getNext()));
		size++;
	}
	
	// 리스트의 첫 노드 삭제
	public void deleteFront() {
		if(isEmpty()) throw new NoSuchElementException();
		head = head.getNext();
		size--;
	}
	
	// p가 가르키는 노드의 다음 노드를 삭제
	public void deleteAfter(SNode<E> p) {
		if(isEmpty()) throw new NoSuchElementException();
		SNode<E> t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}
	private boolean isEmpty() {
		if(size == 0) return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		SinglyLinkedList<String> list = new SinglyLinkedList<>();
		
		list.insertFront("apple");
		list.insertFront("tomato");
		list.insertFront("banana");
		
		int k = list.search("tomato");
		System.out.println(k);
	}
}
