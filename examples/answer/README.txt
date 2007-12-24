A simple demonstration on how to assemble some code in java,
write out the generated instructions and load the instructions
from a c driver (Be warned driver.c is probably Linux specific).

Steps to see it working are as follows;

$ javac jasm/examples/answer/Main.java      # Compile the java file
$ java -classpath .:/path/to/jasm.jar jasm.examples.answer.Main output.dat
                                            # Assemble instructions
$ gcc -o myDriver driver.c                  # Compile the c file
$ ./myDriver output.dat                     # Run the generated file
