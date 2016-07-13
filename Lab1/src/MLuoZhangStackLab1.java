class MLuoZhangStackLab1
{
   /* StackLab1 initializes a Stack data structure using a linked list of nodes.
    * A node contains the value stored in data and a pointer to the next node
    * in next. StackLab1 is only accessible via its top node, which contains 
    * the data and next information of the node on top of the stack. StackLab1
    * is initialized with a top node, and information is populated with
    * the push method, and removed with the pop method. The top node can be 
    * viewed without altering the stack with the peek method. There are also
    * methods to clear the stack and determine if the stack is empty. 
    */
   private Node top; //the node to access the data of the top of the stack

   private class Node {
      /* Defines class Node for StackLab1 that stores the character of the
       * input string in the data field and a pointer to the next node in 
       * the stack in the next field.
       */
      private char data; 
      private Node next; 
   }
   
   MLuoZhangStackLab1() { 
      /* Constructor method of class StackLab1; initializes top node to null.
       */
      top = null;  
   }
   
   public void push (char c) { 
      /* Push method adds a new node to the top of the stack. A new node is 
       * created, with its data field set to the char being pushed, and its
       * next field to the current top node. The top node is then assigned to 
       * the new node to complete the addition of the new node to the stack.
       */
      Node temp = new Node(); 
      temp.data = c; 
      temp.next = top; 
      top = temp; 
   }
   
   //removes the top node from the stack
   public char pop() { 
      /* Pop method removes the top node from the stack. It first checks if 
       * the stack is empty; if not, the current top node is copied to a 
       * temporary node, its data field stored in a local variable, then 
       * disconnected from the stack, and the top node pointer is reassigned 
       * to the next node underneath. The data field of the removed node 
       * is returned.
       */
      char c;
      char blank = '0';
      if (isEmpty()) { 
         return blank; 
      } else {
         Node temp = top; 
         c = top.data; 
         top = top.next; 
         temp.next = null; 
         temp.data = blank; 
         return c; 
      }
   }
   
   public char peek() { 
      /* Peek method returns the data field of the top node without altering
       * the list.
       */
      return top.data; 
   }
   
   public boolean isEmpty() { 
      /* isEmpty method checks if the stack is empty; returns true if it is,
       * returns false otherwise.
       */
      return (top == null);
   }

   public void clearAll() { 
      /* clearAll method disconnects all nodes from each other and reassigns
       * the top node to null.
       */
      top = null;
   }
}
