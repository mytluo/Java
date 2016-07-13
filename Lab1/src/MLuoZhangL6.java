class MLuoZhangL6
{
   static boolean L6(MLuoZhangStackLab1 s) {
      /* L6 is a word in the form of a palindrome. This method takes advantage
       * of the fact that a palindrome is the same forwards and backwards. The
       * input stack is stored in "reversed" order (the original char order of
       * the input word) as well as in a temp stack. The temp stack is then 
       * popped and pushed back into the original stack to return to the same
       * order as the original input stack. The resulting original and reversed
       * stacks should be reversals of each other. If the input is a palindrome,
       * the stacks would be exactly the same and return true. If they are not,
       * then it is not a palindrome and would return false.
       */
      MLuoZhangStackLab1 reversed = new MLuoZhangStackLab1(); 
         /*to store the input stack in "reversed" order (i.e., original char 
          * order of the word) */
      MLuoZhangStackLab1 temp = new MLuoZhangStackLab1(); 
         /*to store the input stack temporarily so it may be restacked into 
          * original order of the input stack */
      char data; // to store the data of the top node

      if (s.isEmpty()) {
         return true; //empty string is a valid form of L6
      }
      
      //populate reversed and temp stacks
      while (!s.isEmpty()) { 
         data = s.pop();
         reversed.push(data); 
         temp.push(data);
      }
      
      //repopulate original input stack
      while (!temp.isEmpty()) {
         s.push(temp.pop()); //return copy of the original input stack
      }
      
      //compare original input stack and reversed stack
      while (!s.isEmpty() && !reversed.isEmpty()) {
         if (s.peek() == reversed.peek()) {
            s.pop();
            reversed.pop(); //simultaneously pop stacks if top nodes are same
         } else {
            return false; //if top nodes do not match, invalid form of L6
         }
      }
      
      if (s.isEmpty() && reversed.isEmpty()) {
         return true;
      } else {
         return false;
      }
   }
}
