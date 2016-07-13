class MLuoZhangL4
{
   static boolean L4(MLuoZhangStackLab1 s) {
      /* L4 is a word in the form of (AnBm)p, for some m, n, p >= 0. 
       * Any number of A's, followed by any number of B's form a pattern which
       * is then repeated p number of times. The stack p holds the base pattern
       * from the input stack, which is some number of B's, then some number of
       * A's until a B is encountered again. The p stack now holds the pattern 
       * in the "right" order, but since our stacks are LIFO, it needs to be 
       * "reversed" to check against the remaining chars in the input stack. 
       * Thus, p is popped and pushed into revP. revP is then used to check 
       * against the remaining input stack. If the top matches, revP is popped
       * and pushed back onto p, and s is popped. This is repeated until the
       * input stack is empty. If revP is also empty, then the input stack 
       * consisted of the repeating pattern of AnBm, and the method returns 
       * true. Any other char in the word is invalid, and if the pattern does 
       * not hold true (the tops of the stacks do not match, or revP is not 
       * empty), it is also invalid and the method will return false. 
       */
      MLuoZhangStackLab1 p = new MLuoZhangStackLab1(); 
      //holds initial pattern from input stack
      MLuoZhangStackLab1 revP = new MLuoZhangStackLab1(); 
      //reverses "back" for matching 

      if (s.isEmpty()) {
         return true; //empty string is valid form of L4
      }
      
      //for word of all A's (n=1, m=0, p=word.length)
      if (s.peek() == 'A') {
         while (!s.isEmpty() && s.peek() == 'A') {
            s.pop();
         }
         if (s.isEmpty()) {
            return true;
         } else {
            return false;
         }
            
      } else if (s.peek() != 'B') {
         return false; //invalid chars in word
         
      } else { //for strings of all B's, or A's and B's
         // get the set of B's (Bm) in base pattern
         while (!s.isEmpty() && s.peek() == 'B') {
            p.push(s.pop());
         }
         // get the set of A's (An) in base pattern
         while (!s.isEmpty() && s.peek() == 'A') {
            p.push(s.pop());
         }  
      }
      
      if (s.isEmpty()) {
         return true; // for the case of a string of all B's, or p=1
         
      } else {
         while (!s.isEmpty()) { // traverse through remainder of input stack
            while (!p.isEmpty()) { 
               revP.push(p.pop()); //store pattern back in reverse stack order
            } while (!s.isEmpty() && !revP.isEmpty()) { 
               //compare top.data of input stack to revP stack pattern
               if (s.peek() == revP.peek()) { 
                  p.push(revP.pop()); 
                  s.pop();
               } else {
                  return false; //L4 pattern does not hold true
               }
            }
         }
         if (revP.isEmpty() && s.isEmpty()) {
            return true;
         } else {
            return false;
         }
      }
   }
}
