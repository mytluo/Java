class MLuoZhangL5
{
   static boolean L5(MLuoZhangStackLab1 s){
      /* L5 is a word in the form of AnBn for some n >= 0, the reverse of L2. 
       * Two stacks are created to store A's and B's. There is an extra boolean 
       * variable that tracks when the stack has switched to B's. If an A 
       * reappears after a B, the word is not a valid form of L5 and returns 
       * false. If any other char appears, it is also false. If all the A's are 
       * popped first, then all B's are popped, and they are present in equal 
       * quantities, then the method returns true. Otherwise, it returns false.
       */
      MLuoZhangStackLab1 AStack = new MLuoZhangStackLab1();
      MLuoZhangStackLab1 BStack = new MLuoZhangStackLab1();
      boolean a = true; //top of input stack s should be A (word ends with A)

      if (s.isEmpty()) {
         return true; //empty string is a valid form of L2
      }
      
      while (!s.isEmpty()) {
         if (s.peek() == 'A' && a) { //top is A and no B's have appeared yet
            AStack.push(s.pop());  //add A to stack AStack
            
         } else if (s.peek() == 'A' && !a) {  //A appears after B's 
            return false; //invalid form of L5
            
         } else if (AStack.isEmpty() && s.peek() == 'B') { 
            return false; //B on top of stack s means word ends with B
                           //invalid form of L5
            
         } else if (s.peek() == 'B') { 
            a = false; //change boolean to indicate AStack should be full
            BStack.push(s.pop()); //add B to stack BStack
            
         } else { 
            return false; //any other char in string violates L5
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
