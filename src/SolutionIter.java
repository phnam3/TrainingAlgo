import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SolutionIter implements Iterable<Integer>{
    private LinkedList<Integer> integerLinkedList;

    public LinkedList<Integer> getIntegerLinkedList() {
        return integerLinkedList;
    }

    public void setIntegerLinkedList(LinkedList<Integer> integerLinkedList) {
        this.integerLinkedList = integerLinkedList;
    }

    public SolutionIter(Reader inp) {
        LinkedList<Integer> tempList = new LinkedList<>();
        try {
            String line;
            BufferedReader bf = new BufferedReader(inp);
            while ((line = bf.readLine()) != null) {
                line = line.trim();
                if(line.charAt(0) == '+' || line.charAt(0) == '-'){
                    if(isNumber(line.substring(1))){
                        tempList.add(Integer.parseInt(line));
                    }
                } else if(isNumber(line)){
                    tempList.add(Integer.parseInt(line));
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }
        integerLinkedList = tempList;
    }

    public boolean isNumber(String s){
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        return integerLinkedList.iterator();
    }
}
