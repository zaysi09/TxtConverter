import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TxtConverter {

    public static void convertAddedCodes(String fileName, ArrayList<String> codes){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (String code : codes) {
                writer.write(code + "\n");
                //writer.write("//Task " + count++ + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}