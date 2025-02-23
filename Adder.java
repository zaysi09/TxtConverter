import java.util.ArrayList;

public class Adder {
    ArrayList<String> codes = new ArrayList<>();
    
    public void addCodes (String input){
        codes.add(input);
    }
    public ArrayList<String> getAddedCodes(){
        return codes;
    }
}