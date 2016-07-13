README for MLuoZhangLab1

The project consists of 9 java files and two text files, built with Java SE 8 [1.8.0_45] on Eclipse Neon 4.6.

All files are prefixed with the name MLuoZhang; I will refer to the main part of names of the files.

The text files include: Lab1Input.txt, the input file for the main.java file. The Lab1Output.txt is the result of a successful main run, and will be overwritten every time MLuoZhangMain.java successfully runs. 

L1.java...L6.java consists of the function to test validity of each language requirement. They do not have a main method and are only meant to be imported to be run by the main java file in the same package.

DeepCopyStack.java is a function to make a deep copy of the input stack being passed into the L1.java...L6.java functions. It does not consist of a main method and is only meant to be imported to be run by the main java file in the same package.

The main java file (MLuoZhangMain.java) consists of the main method to run the BufferedReader to read the input text file, PrintWriter to write results to the output text file, and actual runs of the L1...L6 language methods. The current path of the input and output text files in the main java file are only partial paths; please correct as needed after download for main to run properly.