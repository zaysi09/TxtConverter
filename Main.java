import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Adder adder = new Adder();

        /*ask for input
         * send over the file to a class to make one big array
         * send the array to a new method to make a big txt file with headers
         */
        
        System.out.println("Enter your files here below. Write \"Done\" when finished");
        int count = 0;
        boolean taskHeaderAdded = false;  // Track if a task header has been added

        while (true) {
            String input = sc.nextLine();

            // Break the loop when user inputs "Done"
            if (input.equalsIgnoreCase("Done")) {
                break;
            }

            // Trim input for checking
            String trimmedInput = input.trim();

            // Detect imports and class declarations
            if (trimmedInput.startsWith("import") || trimmedInput.startsWith("public class")) {
                // Add a task header only if it hasn't been added yet
                if (!taskHeaderAdded) {
                    if (count == 0) {
                        adder.codes.add("// Task " + count + "\n");
                    } else {
                        adder.codes.add("\n// Task " + count + "\n");
                    }
                    count++;
                    taskHeaderAdded = true;  // Task header has been added
                }
            } else if (!input.isEmpty() &&
                       !trimmedInput.startsWith("//") &&
                       !trimmedInput.startsWith("/*") &&
                       !trimmedInput.startsWith("*") &&
                       !trimmedInput.startsWith("*/")) {
                // If it's not an import or class declaration and not a comment, reset taskHeaderAdded
                taskHeaderAdded = false;
            }

            // Add the input line as is (no trimming) to preserve it for future use
            adder.addCodes(input);
        }

        
        System.out.print("Enter your file name (e.g. Text.txt): ");
        String fileName = sc.nextLine();
        TxtConverter.convertAddedCodes(fileName, adder.getAddedCodes());
        sc.close();
    }
}
