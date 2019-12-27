public class LinkedHeadTailList<T extends Comparable<? super T>> implements HeadTailListInterface<T>, Comparable<LinkedHeadTailList<T>> {

	private Node head, tail;
   
   public LinkedHeadTailList() {
	   this.head = null;
	   this.tail = null;
   }
   
   public void addFront(T newEntry) {
	   if(isEmpty()) {
		   emptyListAddHelper(newEntry);
	   }
	   
	   else {
		   Node newNode = new Node(newEntry);
		   newNode.next = head;
		   head = newNode;   
	   }
   }
   
   public void addBack(T newEntry) {
	   if(isEmpty()) {
		   emptyListAddHelper(newEntry);
	   } else {
		   Node newNode = new Node(newEntry);
		   this.tail.next = newNode;
		   this.tail = newNode;
	   }   
   }
   
   private void emptyListAddHelper(T newEntry) {
	   head = new Node(newEntry);
	   this.tail = this.head;
   }

   public T removeFront() { 
	   if(!isEmpty()) {
		   T toRemove = this.head.data;
		   if(this.head.next == null) {		//singleton list
			   this.head = this.head.next;
			   this.tail = this.head;
			   
		   } else {
			   this.head = this.head.next;
		   }
		   return toRemove;
	   }
	   return null;
   }
   
   public T removeBack() {
	   if(!isEmpty()) {
		   T toRemove = this.tail.data;
		   Node tempNode = head;
		   if(this.head.next == null) {		//singleton list
			   this.head = this.head.next;
			   this.tail = this.head;
			   
		   } else {
			   while(tempNode.next != this.tail) {
				   tempNode = tempNode.next;
			   }
			   this.tail = tempNode;
			   this.tail.next = null;
		   }
		   return toRemove;
	   }
		   return null;
   }
   
   public void clear() {
	   this.head = null;
	   this.tail = null;
   }
   
   public boolean isEmpty() {
	   return this.head == null && this.tail == null;
   }
   
   public T getEntry(int givenPosition) {
	   if(isEmpty() || givenPosition < 0) {
		   return null;
	   } else {
		   if (givenPosition == 0) {
			   return this.head.data;
		   }
		   Node tempNode = this.head;
		   int currentPosition = 0;
		   
		   while(tempNode.next != null) {
			   tempNode = tempNode.next;
			   currentPosition++;
			   if(givenPosition == currentPosition) {
				   return tempNode.data;
			   }
		   }
		   return null;
	   }
   }
   
   public void display() {
	   
	   if(isEmpty()) {
		   System.out.println("[]");
	   } else {
		   Node tempNode = this.head;
		   System.out.print("[" + tempNode.data.toString());
		   while(tempNode.next != null) {
			   
			   tempNode = tempNode.next;
			   System.out.print(", " + tempNode.data.toString() );
		   }
		   System.out.print("]");
	   }
   }
   
   public int indexOf(T anEntry) {
	   if(isEmpty()) {
		   return -1;
	   } else {
		   Node tempNode = this.head;
		   if(tempNode.data.equals(anEntry)) {
			   return 0;
		   }
		   boolean found = false;
		   int position = 0;
		   while (tempNode.next != null && !found) {
			   tempNode = tempNode.next;
			   position++;
			   if(tempNode.data.equals(anEntry)) {
				  found = true;
				  return position;
			   }
		   }
		   return -1;
	   }
   }
   
   public int lastIndexOf(T anEntry) {
	   if(isEmpty()) {
		   return -1;
	   } else {
		   Node tempNode = this.head;
		   if (tempNode.next == null && tempNode.data.equals(anEntry)) {
			   return 0;
		   }
		   int currentIndex = 0;
		   int lastIndexFound = 0;
		   boolean found = false;
		   while (tempNode.next != null) {
			   tempNode = tempNode.next;
			   currentIndex++;
			   if(tempNode.data.equals(anEntry)) {
				   found = true;
				   lastIndexFound = currentIndex;
			   }
			  
		   }
		   if (found) {
			   return lastIndexFound;
		   } else {
			   return -1;
		   }
	   
	   }
   }
   
   public boolean contains(T anEntry) {
	   if(isEmpty()) {
		   return false;
	   } else {
		   Node tempNode = this.head;
		   if (tempNode.data.equals(anEntry)) {
			   return true;
		   }
		   
		   while (tempNode.next != null) {
			   tempNode = tempNode.next;
			   if (tempNode.data.equals(anEntry)) {
				   return true;
			   }
		   }
		   return false;
	   }
	   
   }
   
   public int size() {
	   if (isEmpty()) {
		   return 0;
	   } else {
		   int currentSize = 1;
		   Node tempNode = this.head;
		   
		   while (tempNode.next != null) {
			   tempNode = tempNode.next;
			   currentSize++;
		   }
		   return currentSize;
	   }
   }
   
   @Override
   public int compareTo (LinkedHeadTailList<T> otherList) {
	   Node tempNode1 = this.head;
	   Node tempNode2 = otherList.head;
	   if(tempNode1 == null && tempNode2 == null) {
		   return 0;
	   } else if (tempNode1 == null && tempNode2 != null) {
		   return -1;
	   } else if (tempNode1 != null && tempNode2 == null) {
		   return 1;
	   } else {
		   if(!tempNode1.data.equals(tempNode2.data)) {
			   return tempNode1.data.compareTo(tempNode2.data);
		   }
		   while(tempNode1.next != null && tempNode2.next != null) {
			   tempNode1 =  tempNode1.next;
			   tempNode2 = tempNode2.next;
			   if(!tempNode1.data.equals(tempNode2.data)) {
				   return tempNode1.data.compareTo(tempNode2.data);
			   }   
		   }
		   if(tempNode1.next == null && tempNode2.next == null) {
			   return 0;
		   }
		   else if(tempNode1.next == null) {
			   return -1;
		   }
		   else {
			   return 1;
		   }
	   }
   }
   
   

	private class Node {
		private T data; 
		private Node next; 

		private Node(T dataPortion) {
			data = dataPortion;
			next = null;
		}

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		}

		private T getData() {
			return data;
		}

		private void setData(T newData) {
			data = newData;
		}

		private Node getNextNode() {
			return next;
		}

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} 
	} 
}
