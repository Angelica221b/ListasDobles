package nodo;

public class node <T> implements Comparable{
	private T value=null;
	private node<T> next=null;
	private node<T> back=null;
	private long index=0;
	
	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index;
	}

	public node(){
		this.setValue(null);
	}
	
	public node(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public node<T> getNext() {
		return next;
	}
	public void setNext(node<T> next) {
		this.next = next;
	}
	public node<T> getBack() {
		return back;
	}
	public void setBack(node<T> back) {
		this.back = back;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
