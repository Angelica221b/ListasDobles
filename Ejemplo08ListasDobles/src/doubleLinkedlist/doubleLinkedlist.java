package doubleLinkedlist;

import java.util.Iterator;

import nodo.node;

public class doubleLinkedlist <T> implements Iterable{
	private node<T> start=null, end=null;
	
	public doubleLinkedlist() {
		start = new node<T>();
		start.setIndex(-1);
				
		end = new node<T>();
		end.setIndex(-1);
	}
	
	public doubleLinkedlist(T value){
		this();
		/*node<T> nuevo=new node<T>(value);
		end.setBack(nuevo);
		start.setNext(nuevo);*/
		
		
		end.setBack(new node<T>(value));
		//end.getBack().setIndex(0); //Index del nuevo nodo
		
		start.setNext(end.getBack());
		start.getNext().setIndex(0); //Index del nuevo nodo
	}
	
	public void addStart(T value){ //Agregar al inicio 
		//El nuevo nodo se agrega en el next del start
		node<T> tmp=start.getNext();
		start.setNext(new node<T>(value));
		
		if(tmp==null) {
			
			end.setBack(start.getNext());
			start.getNext().setIndex(0);
		}else {
			start.getNext().setNext(tmp);
			tmp.setBack(start.getNext());
		}
		
	}
	
	
	public node<T>Search(T value){
		return Search(value, start, end);
	}
	
	private node<T> Search(T value, node<T> start, node<T> end){
		if(start.getNext()==null || end.getBack() == null ) {
			
			return null;
			
		}
		
		else if(start.getNext().getValue().equals(value)){
			return start.getNext();
		}else if(end.getBack().getValue().equals(value)) {
			return end.getBack();
		}
		else if((start.getNext().equals(end)) || (start.equals(end))){
			
			return null;
		}
		return Search(value,start.getNext(),end.getBack());
		
	}
	
	public boolean remove(T value){
		node<T> tmp = Search(value);
		
		if(tmp!=null) {
			if(tmp.getNext()!=null) {
				tmp.getNext().setBack(tmp.getBack());
			}else {
				end.setBack(tmp.getBack());
			}
			if(tmp.getBack()!=null) {
				tmp.getBack().setNext(tmp.getNext());
			}else {
				start.setNext(tmp.getNext());
			}
			reindex();
			return true;
		}
		return false;
	}
	
	public void reindex() {
		node<T> tmp=start;
		int cont=-1;
		while(tmp.getNext()!=null) {
			tmp=tmp.getNext();
			
			tmp.setIndex(++cont);
		}
	}
	
	
	public void pronter() {
		node<T> tmp=start;
		while(tmp.getNext()!=null) {
			tmp=tmp.getNext();
			System.out.println(tmp.getValue());
		}
	}
	
	
	
	
	public void print(){
		node<T> tmp=end;
		
		while(tmp.getBack()!=null) {
			tmp=tmp.getBack();
			System.out.println(tmp.getValue());
		}
	}
	
	///////////////Metodos faltantes/////////////////////////
	//Agregar alfinal
	public void addEnd(T value) {
		node<T> tmp=end.getBack();
		end.setBack(new node<T>(value));
		
		if(tmp==null) {
			
			start.setNext(end.getBack());
			//end.getBack().setIndex(0);
		}else {
			end.getBack().setBack(tmp);
			tmp.setNext(end.getBack());
		}
			
	}
	
	
	//Eliminar despues de un valor
	public boolean removeAfter(T value){
		node<T> finder = Search(value);
		
		if(finder!=null && finder.getNext()!=null){
			return remove(finder.getNext().getValue());
		}

			return false;
		
	}
	
	//Eliminar antes de un valor
	public boolean removeBefore(T value){
		node<T> finder = Search(value);
		
		if(finder!=null && finder.getBack()!=null){
			return remove(finder.getBack().getValue());
		}

			return false;
		
	}
	
	
	
	//Lista vacia
	public boolean isEmpty() {
		return (start.getNext() == null) ? true : false;
	}

	//Obtener ultimo nodo
	public node<T> getLast() {
		node<T> tmp = end.getBack();
		if (!isEmpty()) {
			return tmp;
		} 
		return null;
	}
	
	//Obtener primer nodo
	public node<T> getFirst() {
		node<T> tmp = start.getNext();
		if (!isEmpty()) {
			return tmp;
		} 
		return null;
	}
	
	//remover ultimo nodo
	public boolean removeLast(){
		//Utilizamos el metodo getLast para tomar el ultimo nodo y llamamos al metodo remove para eliminarlo
		if(!isEmpty()){
			return remove(getLast().getValue());
		}
			return false;
	}
	
	//remover primer nodo
	public boolean removeFirst(){
		//Utilizamos el metodo getFirst para tomar el primer nodo y llamamos al metodo remove para eliminarlo
		if(!isEmpty()){
			return remove(getFirst().getValue());
		}
			return false;
	}

	//tamaño de la lista
	public void size(){
		node<T> tmp = start;
		reindex();
		while(tmp.getNext()!=null){
			tmp=tmp.getNext();
			
		}
		
		System.out.println(tmp.getIndex());
		
	}
	
	//Indice del nodo
	public void indexOf(T value){
		node<T> finder = Search(value);
		reindex();
		if(finder!=null){
			System.out.println(finder.getIndex());
		}
	}
	
	//Agregar despues de un valor
	public Boolean addAfter(T value, T newvalue){
		node<T> finder = Search(value);
		
		if (finder!=null) {
			if(finder.getNext()!=null) {
				
				finder.getNext().setBack(new node<T>(newvalue));
				finder.getNext().getBack().setNext(finder.getNext());
				finder.setNext(finder.getNext().getBack());
				finder.getNext().setBack(finder);
				
			}else{
				addEnd(newvalue);
			}
		}
		return true;
		
	}
	
	//agregar antes de un valor
	public boolean addBefore(T value, T newvalue){
		node<T> finder = Search(value);
		
		if (finder!=null) {
			if(finder.getBack()!=null) {
				
				finder.getBack().setNext(new node<T>(newvalue));
				finder.getBack().getNext().setBack(finder.getBack());
				finder.setBack(finder.getBack().getNext());
				finder.getBack().setNext(finder);
				
			}else{
				addStart(newvalue);
			}
		}
		return true;
		
	}
	
	
	//remplazar
	public boolean replace(T value, T newvalue){
		node<T> finder = Search(value);
		
		if(finder==null){
			return false;
			
		}
			return addAfter(value, newvalue) && remove(value);
		
		
	}
	
	//vaciar lista
	public boolean Clear(){
		
		while(!isEmpty())
			removeFirst();
		
		return true;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			node<T> tmp = start;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				tmp = tmp.getNext();
				return (tmp != null)?true:false;
			}
			@Override
			public T next() {
				// TODO Auto-generated method stub
				return tmp.getValue();
			}
		};
	}
}
