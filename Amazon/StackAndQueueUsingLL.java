package com.satty.amazon;

public class StackAndQueueUsingLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Stack Implementation");
		MyLinkedList stackll = new MyLinkedList();
		stackll.insertAtFirst(20);
		stackll.insertAtFirst(28);
		stackll.insertAtFirst(45);
		stackll.printMiddle();
		System.out.println("deleted: "+stackll.deleteAtFirst().data);
		stackll.insertAtFirst(35);
		stackll.insertAtFirst(28);
		System.out.println("deleted: "+stackll.deleteAtFirst().data);
		stackll.displayLinklist();
		System.out.println("\nSize of stack: "+stackll.size());
		
		System.out.println("\nQueue Implementation");
		MyLinkedList queuell = new MyLinkedList();
		queuell.insertAtLast(20);
		queuell.insertAtLast(28);
		queuell.insertAtLast(45);
		System.out.println("deleted: "+queuell.deleteAtFirst().data);
		queuell.insertAtLast(35);
		System.out.println("deleted: "+queuell.deleteAtFirst().data);
		queuell.displayLinklist();
		System.out.println("\nSize of stack: "+queuell.size());
	}

}
