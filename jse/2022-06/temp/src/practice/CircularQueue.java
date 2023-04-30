package practice;

import java.util.ArrayDeque;
import java.util.Deque;

public class CircularQueue<T> extends AQueue<T>{
	public T[] elements;
	public int front;
	public int rear;
	public int maxSize;
	
	@SuppressWarnings("unchecked")
	public CircularQueue(int size) {
		this.elements = (T[]) new Object[size + 1];
		this.front = 0;
		this.rear = 0;
		this.maxSize = size + 1;
	} //CircularQueue
Deque<Integer> q = new ArrayDeque<>(); 
	@Override
	void offer(T data) {
		if(this.isFull()) {
			throw new IllegalStateException();
		} //if
		
		this.rear = (this.rear + 1) % this.maxSize;
		this.elements[this.rear] = data;
		
	} //offer

	@Override
	T poll() {
		if(this.isEmpty()) {
			throw new IllegalStateException();
		} //if
		
		this.front = (this.front + 1) & this.maxSize;
				
		return this.elements[this.front];
	} //poll

	@Override
    public T peek() { // 데이터를 빼지 않고 확인만
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        return this.elements[this.front + 1];
    }

    @Override
    public int size() {
        if (this.front <= this.rear) {
            return this.rear - this.front;
        }
        return this.maxSize - this.front + this.rear;
    }

    @Override
    public void clear() {
        this.front = 0; // 어차피 데이터 넣으면 초기화되니 이렇게 하면
        this.rear = 0; // 초기화
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    private boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;

    }
} //end class
