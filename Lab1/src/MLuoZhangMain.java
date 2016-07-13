import java.io.*;
import java.util.ArrayList; //used only for output file clarity

public class MLuoZhangMain
{
   /* Main class to read input file, a character at a time until it hits a 
    * newline (end of the word). Each character is pushed onto a stack. When 
    * the file reader encounters a newline, it passes a deep copy of the stack 
    * as the argument to all the language methods to determine if the word is 
    * a valid form of that particular language, and writes the results to an 
    * output file. The stack is cleared, and the reader starts reading again 
    * from the next character on the next line in the input file until it 
    * reaches another newline, repeats, or the last character of the input file.
    */
   private static BufferedReader reader;

   public static void main(String[] args) throws IOException
   {
      /* This section uses java.util.ArrayList to store each line in an 
       * array so that it can be used to print to output file. It is only so
       * the original word can be written to the output file for clarity. 
       */
      FileInputStream file = new FileInputStream
            ("/MLuoZhangLab1/src/MLuoZhangLab1Input.txt");
      DataInputStream input = new DataInputStream(file);
      BufferedReader br = new BufferedReader(new InputStreamReader(input));
      String strLine;
      ArrayList<String> words = new ArrayList<String>();
      while ((strLine = br.readLine()) != null)   {
         words.add(strLine);
      }
      file.close();
      
      // The start of the reading and parsing of each word in the input file 
      reader = new BufferedReader(new FileReader
            ("/MLuoZhangLab1/src/MLuoZhangLab1Input.txt"));
      PrintWriter output = new PrintWriter
            ("/MLuoZhangLab1/src/MLuoZhangLab1Output.txt");
      
      int ch = reader.read(); //read input file one character at a time
      MLuoZhangStackLab1 test = new MLuoZhangStackLab1();
      //initialize new stack to store chars
      int wordCounter = 0; //to get index position for the words ArrayList
      
      while (ch != -1) {
         if ((char)ch != '\n') {
            test.push((char)ch); //add char to the stack if not a newline
            ch = reader.read(); //read next char
            
         } else {  /* if newline encountered, run language methods
                  and write results to output file */
            if (MLuoZhangL1.L1(MLuoZhangDeepCopyStack.deepCopy(test))) {
               output.println(words.get(wordCounter) + " is a valid L1 word.");
            } else {
               output.println(words.get(wordCounter) + 
                     " is not a valid L1 word.");
            }
            
            if (MLuoZhangL2.L2(MLuoZhangDeepCopyStack.deepCopy(test))) {
               output.println(words.get(wordCounter) + " is a valid L2 word.");
            } else {
               output.println(words.get(wordCounter) + 
                     " is not a valid L2 word.");
            }
            
            if (MLuoZhangL3.L3(MLuoZhangDeepCopyStack.deepCopy(test))) {
               output.println(words.get(wordCounter) + " is a valid L3 word.");
            } else {
               output.println(words.get(wordCounter) + 
                     " is not a valid L3 word.");
            }
            
            if (MLuoZhangL4.L4(MLuoZhangDeepCopyStack.deepCopy(test))) {
               output.println(words.get(wordCounter) + " is a valid L4 word.");
            } else {
               output.println(words.get(wordCounter) + 
                     " is not a valid L4 word.");
            }
            
            if (MLuoZhangL5.L5(MLuoZhangDeepCopyStack.deepCopy(test))) {
               output.println(words.get(wordCounter) + " is a valid L5 word.");
            } else {
               output.println(words.get(wordCounter) + 
                     " is not a valid L5 word.");
            }
            
            if (MLuoZhangL6.L6(MLuoZhangDeepCopyStack.deepCopy(test))) {
               output.println(words.get(wordCounter) + " is a valid L6 word.");
            } else {
               output.println(words.get(wordCounter) + 
                     " is not a valid L6 word.");
            }
            
            test.clearAll(); //clear stack to store next word to be tested
            wordCounter++;
            ch = reader.read(); //read next char
         }
      }
      
      //to test last line of input file
      if (MLuoZhangL1.L1(MLuoZhangDeepCopyStack.deepCopy(test))) {
         output.println(words.get(wordCounter) + " is a valid L1 word.");
      } else {
         output.println(words.get(wordCounter) + 
               " is not a valid L1 word.");
      }
      
      if (MLuoZhangL2.L2(MLuoZhangDeepCopyStack.deepCopy(test))) {
         output.println(words.get(wordCounter) + " is a valid L2 word.");
      } else {
         output.println(words.get(wordCounter) + 
               " is not a valid L2 word.");
      }
      
      if (MLuoZhangL3.L3(MLuoZhangDeepCopyStack.deepCopy(test))) {
         output.println(words.get(wordCounter) + " is a valid L3 word.");
      } else {
         output.println(words.get(wordCounter) + 
               " is not a valid L3 word.");
      }
      
      if (MLuoZhangL4.L4(MLuoZhangDeepCopyStack.deepCopy(test))) {
         output.println(words.get(wordCounter) + " is a valid L4 word.");
      } else {
         output.println(words.get(wordCounter) + 
               " is not a valid L4 word.");
      }
      
      if (MLuoZhangL5.L5(MLuoZhangDeepCopyStack.deepCopy(test))) {
         output.println(words.get(wordCounter) + " is a valid L5 word.");
      } else {
         output.println(words.get(wordCounter) + 
               " is not a valid L5 word.");
      }
      
      if (MLuoZhangL6.L6(MLuoZhangDeepCopyStack.deepCopy(test))) {
         output.println(words.get(wordCounter) + " is a valid L6 word.");
      } else {
         output.println(words.get(wordCounter) + 
               " is not a valid L6 word.");
      }
      
      reader.close();
      output.close();
      System.out.println("done");
   }
}
