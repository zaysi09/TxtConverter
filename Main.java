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
        int count = 1;
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("Done")) {
                //flag = false;
                break;
            }
            adder.codes.add("// Task " + count++);
            adder.addCodes(input);
            count++;
        }
        
        System.out.print("Enter your file name (e.g. Text.txt): ");
        String fileName = sc.nextLine();
        TxtConverter.convertAddedCodes(fileName, adder.getAddedCodes());
        sc.close();
    }
}