class MLuoZhangL3
{
   static boolean L3(MLuoZhangStackLab1 s) {
      /* L3 is a word in the form of AnB2n, for some n >= 0.
       * Like L2, there is an AStack to store A's and BStack to store B's, as
       * well as a boolean to track the switch from B's to A's in input stack s.
       * A is pushed twice to match the double amount of B's required. During 
       * the simultaneous popping of AStack and BStack, if both are empty at 
       * the same time, then there is twice as many B's as A's, which is the 
       * valid form of L3 and the method returns true. Otherwise it is false. 
       */
      MLuoZhangStackLab1 AStack = new MLuoZhangStackLab1();
      MLuoZhangStackLab1 BStack = new MLuoZhangStackLab1();
      boolean b = true; //top of input stack s should be B
      
      if (s.isEmpty()) {
         return true; //empty string is valid form of L3
      }
      
      while (!s.isEmpty()) {
         if (s.peek() == 'B' && b) { //no A's have appeared yet
            BStack.push(s.pop()); //add B to stack BStack
         } else if (s.peek() == 'B' && !b) { 
            return false; //B has appeared after an A; invalid form of L3
         } else if (BStack.isEmpty() && s.peek() == 'A') {
            return false; //A on top of input stack means word ends with A
                         //invalid form of L3 
         } else if (s.peek() == 'A') {
            b = false; //first A in input stack reached, BStack is full
            AStack.push(s.pop()); //add A to AStack
            AStack.push('A'); //push additional A to match number of B's 
                              //needed to confirm L3 validity
         } else { 
            return false; //any other char in string violates L3
         }
      }
      
      while (!AStack.isEmpty() && !BStack.isEmpty()) {
         AStack.pop();
         BStack.pop(); //pop both stacks simultaneously until one is empty
      }
      
      if (AStack.isEmpty() && BStack.isEmpty()) {
         return true; 
      } else {
         return false;   
      }
   }
}
