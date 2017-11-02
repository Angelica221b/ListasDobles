package app;

import java.util.Iterator;
import java.util.ListIterator;

import doubleLinkedlist.doubleLinkedlist;
import nodo.node;

public class App {
	
	public static void main(String[] args) {
		doubleLinkedlist<String> names = new doubleLinkedlist<String>();
		//Agregar valores a la lista
		//Metodos agregar
		names.addStart("Alejandro");
		names.addStart("Roxx");
		names.addEnd("Angela");
		names.addStart("Ricardo");
		names.addStart("Jalil");
		names.addEnd("Ang");
		names.addStart("Jose");
		
		
		names.addAfter("Jalil", "Andrea");
		names.addBefore("Jose", "Laura");
		
		
		//Impirmir lista
				System.out.println("Imprimir hacia adelante:");
				System.out.println();
				names.pronter();
				System.out.println("----------");
				//Imprimir lista por el final
				System.out.println("Imprimir hacia atras:");
				System.out.println();
				names.print();
		
			
		
		
		
		
		
		
		
		names.removeAfter("Angela");
		names.removeBefore("Jalil");
		names.removeLast();
		names.removeFirst();
		System.out.println();
		System.out.println("Tamaño original de la lista");
		names.size();
		
		System.out.println();
		System.out.println("Lista con valores eliminados:");
		//names.pronter();
		
		Iterator<String> iterator =names.iterator();
		
		
		for(Iterator<String> it=iterator; it.hasNext(); ) {
			System.out.println(iterator.next());
		}
		
		System.out.println();
		System.out.println("Remplazar Ricardo por Emmanuel:");
		names.replace("Ricardo", "Emmanuel");
		names.pronter();
		
		
		System.out.println();
		System.out.println("Tamaño de la lista:");
		names.size();
		System.out.println();
		System.out.println("Indice de Roxx: ");
		names.indexOf("Roxx");
		
		names.Clear();
		System.out.println("Tamaño de la lista luego de usar Clear");
		names.pronter();
		names.size();
		
		
		
	}

}
