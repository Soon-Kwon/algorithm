package stacks;
import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E s[];	// 스택을 위한 배열
	private int top;	// 스택의 top 항목의 배열 원소 인덱스
	
	public ArrayStack() {
		s = (E[]) new Object[1];	// 초기에 크기가 1인 배열 생성
		top = -1;
	}
	
	public int size() {return top + 1;}		// 스택에 있는 항목의 수를 반환
	public boolean isEmpty() {return top == -1;}	// 스택이 empth이면 true 반환
	
	// 스택 top 항목의 내용만을 리턴
	public E peek() {
		if (isEmpty()) throw new EmptyStackException();
		return s[top];
	}
	
	// 스택에 push
	public void push(E newItem) {
		if(size() == s.length)
			resize(2*s.length);
		s[++top] = newItem;
	}
	
	// 스택에서 pop
	public E pop() {
		if(isEmpty()) throw new EmptyStackException();
		E item = s[top];
		s[top--] = null;	// s[top] = null과 top--를 한번에 처리
		if(size() > 0 && size() == s.length/4)
			resize(s.length/2);
		return item;
	}
	
	// 배열 사이즈 조절
	public void resize(int newSize) {
		Object[] t = new Object[newSize];
		for(int i = 0; i < size(); i++)
			t[i] = s[i];
		s = (E[]) t;
	}
}


class Main{
	public static void main(String[] args) {
		ArrayStack<String> stack = new ArrayStack<>();
		stack.push("apple");
		System.out.println(stack.peek());
		stack.push("banana");
		stack.push("cherry");
		stack.push("melon");
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		System.out.println(stack.peek());
	}
}
