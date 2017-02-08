package example;
import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985 on 2/8/2017.
 */
public class Example_4 {
    public static Collection<String> collectFromText(String fileName){
        String[] resultText = TextFile.read(fileName).split(" ");
        return new ArrayList<String>(Arrays.asList(resultText));
    }
    public static Collection<String> collectFromText2(String fileName){
        return new TreeSet<String>(new TextFile(fileName, "\\W+"));
    }
    public static void main(String[] args){
        String resultReadFile = TextFile.read("C:\\Users\\Dell Vostro 5459\\IdeaProjects\\Containers_In_Depth\\src\\example\\TestFile.txt");
        System.out.println(resultReadFile);
        System.out.println(collectFromText("C:\\Users\\Dell Vostro 5459\\IdeaProjects\\Containers_In_Depth\\src\\example\\TestFile.txt"));
        System.out.println(collectFromText2("C:\\Users\\Dell Vostro 5459\\IdeaProjects\\Containers_In_Depth\\src\\example\\TestFile.txt"));
    }
}
