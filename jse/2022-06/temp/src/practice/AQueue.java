package practice;

public abstract class AQueue<T> {
	abstract void offer(T data);
	abstract T poll();
	abstract T peek();
	abstract int size();
	abstract void clear();
	abstract boolean isEmpty();
} //end class
