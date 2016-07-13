class MLuoZhangDeepCopyStack
{
   static MLuoZhangStackLab1 deepCopy(MLuoZhangStackLab1 s) {
      /* This method creates a deep copy of the input stack s so that a copy
       * of s, rather than s itself, is passed to the language methods. Because
       * the language methods pop off and potentially empties the input stack,
       * if the original input stack s is used, the resultant stack s after a
       * language method call (i.e., L1(test)) will be empty, and all 
       * subsequent method calls with s will be an empty stack. This method
       * returns a replica of the input stack s. 
       */
      MLuoZhangStackLab1 temp = new MLuoZhangStackLab1(); 
      /*to store the input stack in "reversed" order (i.e., original char order 
       * of the word) temporarily */
      MLuoZhangStackLab1 copy = new MLuoZhangStackLab1(); 
      //to store a copy of the input stack 
      char data; // to store the data of the top node
      
      //remove whitespace
      while (!s.isEmpty() && Character.isWhitespace(s.peek())) {
         s.pop();
      }
      
      //populate temp stack
      while (!s.isEmpty()) {
         temp.push(s.pop());
      }
      
      //repopulate original input stack and create the copy with temp stack
      while (!temp.isEmpty()) {
         data = temp.pop();
         s.push(data); //return copy of the original input stack
         copy.push(data);
      }
      
      return copy; 
   }
}
