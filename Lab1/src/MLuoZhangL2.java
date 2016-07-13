class MLuoZhangL2
{
   static boolean L2(MLuoZhangStackLab1 s) {
      /* L2 is a word in the form of AnBn for some n >= 0. Like L1, two stacks
       * are created to store A's and B's. There is an extra boolean variable
       * that tracks when the stack has switched to A's. If a B reappears after
       * an A, the word is not a valid form of L2 and returns false. If any 
       * other char appears, it is also false. If all the B's are popped first, 
       * then all A's are popped, and they are present in equal quantities, 
       * then the method returns true. Otherwise, it returns false.
       */
      MLuoZhangStackLab1 AStack = new MLuoZhangStackLab1();
      MLuoZhangStackLab1 BStack = new MLuoZhangStackLab1();
      boolean b = true; //top of input stack s should be B (word ends with B)
      
      if (s.isEmpty()) {
         return true; //empty string is a valid form of L2
      }
      
      while (!s.isEmpty()) {
         if (s.peek() == 'B' && b) { //top is B and no A's have appeared yet
            BStack.push(s.pop());  //add B to stack BStack
            
         } else if (s.peek() == 'B' && !b) {  //B appears after A's 
            return false; //invalid form of L2
            
         } else if (BStack.isEmpty() && s.peek() == 'A') { 
            return false; //A on top of stack s means word ends with A
                           //invalid form of L2
            
         } else if (s.peek() == 'A') { 
            b = false; //change boolean to indicate BStack should be full
            AStack.push(s.pop()); //add A to stack AStack
            
         } else { 
            return false; //any other char in string violates L2
         }
      }
      
      while (!AStack.isEmpty() && !BStack.isEmpty()) {
         AStack.pop();
         BStack.pop(); //pop both stacks simultaneously until one is empty
      }
      
      if (AStack.isEmpty() && BStack.isEmpty()) {
         return true; //equal amount of A's and B's in correct order
      } else {
         return false; //unequal amount of A's and B's
      }
   }
}
