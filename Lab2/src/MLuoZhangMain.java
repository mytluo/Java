import java.io.*;

public class MLuoZhangMain
{ 
   
   static int determinant(MLuoZhangMatrix m) {
      /* Calculates and returns the determinant of matrix m.
       */
      int det = 0;
      if (m.len == 1) { //base case
         det += m.data[0][0]; 
      } else {
         for (int j = 0; j < m.len; j++) { 
            //sum up determinants of all minor matrices of elements in the first row
            det += ((int)Math.pow(-1, j) * m.data[0][j] * determinant(m.MinorMatrix(0, j)));  
         }
      }
      return det;
   }
   
   public static void main(String[] args) throws IOException
   {
      String inFile = args[0]; //first arg in command line is input filepath
      String outFile = args[1];//second arg is output filepath
      BufferedReader reader = new BufferedReader(new FileReader(inFile));
      PrintWriter output = new PrintWriter(outFile);
      int cols = 0; 
      int rows = 0;
      int counter = 1; //counter for matrix in input file
      String line;   
      outer: while (true) {
         line = reader.readLine();    
         boolean error = false; 
         boolean done = false;
         int[] matrix = null;
         if (line != null) {
            String[] row1 = line.trim().split("\\s+"); //trim and split line into array
            cols = row1.length; //columns equal number of ints in the row1 array (first row of matrix)
            rows = cols; 
            matrix = new int[cols*rows]; //create new array of appropriate size to be passed to constructor
            int matrixIndex = 0; //tracks the index position of the matrix array
            for (int i = 0; i < row1.length; i++) {
               int e = Integer.parseInt(row1[i]); //convert the elements in the row back to int form
               matrix[matrixIndex++] = e; //populate matrix array with the first row's elements
            }
            if (rows == 1) { //a 1x1 matrix
               done = true;
            } else { //not a 1x1 matrix
               rows--; //already entered the first row
               inner: while (line != null && rows > 0) {
                  line = reader.readLine(); 
                  String[] nextRow = line.trim().split("\\s+"); //trim and split next row in matrix
                  if (nextRow.length == cols) { // able to form a valid nxn matrix
                     for (int i = 0; i < cols; i++) {
                        int e = Integer.parseInt(nextRow[i]);
                        matrix[matrixIndex++] = e;   
                     } 
                     rows--;
                  } else { //next row does not have same number of columns as previous row
                        error = true; 
                        break inner;
                  }   
               }
            }
            if (!error) { //if exited inner while loop without error, completed nxn matrix
               done = true;
            }           
            if (done && !error) { 
               MLuoZhangMatrix m = new MLuoZhangMatrix(matrix);
               output.println(String.format("Matrix %d: \n%s \ndeterminant: %d\n", counter, m, determinant(m)));
            } else {
               output.println(String.format("Matrix %d: Not a valid matrix.\n", counter));
            }
            counter++;
         }
              
         if (line == null) { //if EOF, exit outer while loop
            break outer;
         }
      }
      
      reader.close();
      output.close();
   }  
}
