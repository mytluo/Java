class MLuoZhangL1
{
   static boolean L1(MLuoZhangStackLab1 s) {
      /* L1 is a word that contains equal numbers of A's and B's in any order
       * and no other characters. It takes the input stack and stores A's and 
       * B's into separate stacks. The two stacks are popped simultaneously 
       * until at least one stack is empty. If both are empty, the method 
       * returns true, as the input stack of the string is a valid form of L1. 
       * Otherwise, it returns false.
       */
      MLuoZhangStackLab1 AStack = new MLuoZhangStackLab1();
      MLuoZhangStackLab1 BStack = new MLuoZhangStackLab1();
      
      if (s.isEmpty()) {
         return true; //empty string is a valid form of L1
      }
      
      while (!s.isEmpty()) {         
         if (s.peek() == 'A') {
            AStack.push(s.pop()); //add A to stack AStack
         } else if (s.peek() == 'B'){
            BStack.push(s.pop());; //add B to stack BStack
         } else { //another char is present
            return false; //invalid form of L1
         }
      } 
      
      while (!AStack.isEmpty() && !BStack.isEmpty()) {
         AStack.pop(); // pop both stacks simultaneously
         BStack.pop(); // until at least one stack is empty
      }
      
      if (AStack.isEmpty() && BStack.isEmpty()) {
         return true; //there are equal number of A's and B's
      } else {
         return false; //there is not an equal number of A's and B's
      }
   }
}
