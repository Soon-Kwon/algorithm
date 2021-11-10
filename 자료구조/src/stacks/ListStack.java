package stacks;

import lists.SNode;
import java.util.EmptyStackException;

public class ListStack<E> {
	private SNode<E> top;	// 스택 top 항목을 가진 Node를 가리키기 위해
	private int size;
	
	public ListStack() {
		top = null;
		size = 0;
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	
	// 스택 top 항목만을 리턴
	public E peek() {
		if(isEmpty()) throw new EmptyStackException();
		return top.getItem();
	}
	
	// 스택 push 연산
	public void push(E newItem) {
		SNode<E> newNode = new SNode(newItem, top);
		top = newNode;
		size++;
	}
	
	// 스택 pop 연산
	public E pop() {
		E topItem = top.getItem();
		top = top.getNext();
		size--;
		return topItem;
	}
}
