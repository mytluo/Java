class MLuoZhangMatrix
{
   /* This class creates a 2D array with the fields len and data. len is the number of rows (or columns) in the
    * 2D array that makes up the nxn matrix; there should be an equal number of rows and columns. data holds the
    * elements (in this case, integers) that make up the matrix. It is accessed via its row and column position.
    */
   
   int len;
   int[][] data;
   
   MLuoZhangMatrix(int... elements) {
      /* Constructor class to generate the 2D array matrix from a variable list of integers. It checks to verify
       * the number of integers given is sufficient to generate a nxn matrix, which requires that number (the 
       * length) to be a perfect square.
       */
      int n = (int) Math.sqrt(elements.length);
      if (n*n == elements.length) { //checks if length was a perfect square
         this.len = n;
         this.data = new int[n][n];
      } else { // cannot create nxn matrix
         this.len = 0;
      }  //populate matrix with list of integers
      for (int i = 0; i < this.len; i++) {
         for (int j = 0; j < this.len; j++) {
            this.data[i][j] = elements[i*n+j];
         }
      }
   }
   
   MLuoZhangMatrix MinorMatrix(int row, int col) {
      /* MinorMatrix creates and returns a submatrix of element x located at the row and column, 
       * the two parameters being passed to the method.
       */
      int mlen = this.len - 1; //minor matrix is 1 row and 1 col shorter
      int[] minorElements = new int[mlen*mlen]; // array to store elements that will populate minor 
      int index = 0; //counter for index of minorElements array
      for (int i = 0; i < this.len; i++) {
         for (int j = 0; j < this.len; j++) {
            if (i == row || j == col) {
               continue; //same row or col as element x of minor
            } else { 
               minorElements[index] = this.data[i][j];
               index++;
            }
         }
      }
      MLuoZhangMatrix minor = new MLuoZhangMatrix(minorElements);
      return minor;
   }
   
   @Override public String toString() {
      /* Overrides the default toString method to print out the matrix in proper format.
       */
      if (this.len == 0) {
         return "Not a valid matrix.";
      }
      StringBuilder matrixStr = new StringBuilder();
      if (this.len == 1) { //if matrix is a 1x1 matrix
         matrixStr.append(String.format("[%s]", this.data[0][0]));
      } else {
         for (int i = 0; i < this.len; i++) {
            for (int j = 0; j < this.len; j++) {
               if (j == this.len - 1) { //if element is the last in the row, newline instead of space
                  matrixStr.append(this.data[i][j] + "\n");
               } else {
                  matrixStr.append(this.data[i][j] + "  ");
               }
            }
         }
      }
      return matrixStr.toString();
   }
}
