package stacks;
import java.util.NoSuchElementException;

public class ArrayQueue<E> {
	private E[] q;	// 큐를 위한 배열
	private int front, rear, size;
	
	public ArrayQueue() {
		q = (E[]) new Object[2];	// 초기에 크기가 2인 배열 생성
		front = rear = size = 0;
	}
	
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	
	// 큐 삽입 연산
	public void add(E newItem) {
		if((rear+1) % q.length == front)	// 비어있는 원소가 1개뿐인 경우(즉, 큐가 full인 경우)
			resize(2*q.length);
		rear = (rear+1) % q.length;
		q[rear] = newItem;
		size++;
	}
	
	// 큐 삭제 연산
	public E remove() {
		if(isEmpty()) throw new NoSuchElementException();
		front = (front+1) % q.length;
		E item = q[front];
		q[front] = null;
		size--;
		if(size > 0 && size == q.length/4)
			resize(q.length/2);
		return item;
	}
	
	// 큐의 배열 크기 조절
	private void resize(int newSize) {
		Object[] t = new Object[newSize];
		for(int i = 1, j = front+1; i < size+1; i++, j++) {
			t[i] = q[j%q.length];
		}
		front = 0;
		rear = size;
		q = (E[]) t;
	}
}
