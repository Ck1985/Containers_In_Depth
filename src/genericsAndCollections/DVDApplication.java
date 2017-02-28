package genericsAndCollections;
import java.lang.reflect.Array;
import java.util.*;
import net.mindview.util.*;

/**
 * Created by anonymous.vn1985 on 2/27/2017.
 */
public class DVDApplication {
    private static ArrayList<DVDInfo> dvdList = new ArrayList<>();
    private static DVDInfo dvdInfo = null;
    static ArrayList<DVDInfo> populateData(){
        String title = null;
        String genre = null;
        String leadActor = null;
        String extraData = TextFile.read("C:\\Users\\Dell Vostro 5459\\IdeaProjects\\Containers_In_Depth\\src\\genericsAndCollections\\dvdinfo.txt");
        String[] arrayData = extraData.split("\n");
        String[] arrayKind;
        for (String string : arrayData){
            arrayKind = string.split("/");
            for (int i = 0; i < arrayKind.length; i++) {
                 if (i == 0){
                     title = arrayKind[i];
                 }else if (i == 1){
                     genre = arrayKind[i];
                 }else {
                     leadActor = arrayKind[i];
                 }
            }
            dvdInfo = new DVDInfo(title,genre,leadActor);
            dvdList.add(dvdInfo);
        }
        return dvdList;
    }
    static void showDVDList(){
        populateData();
        System.out.println(dvdList);
    }
    public static void main(String[] args){
        showDVDList();
        Collections.sort(dvdList);
    }
}
