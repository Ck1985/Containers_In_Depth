package genericsAndCollections;
import java.util.*;

/**
 * Created by anonymous on 3/1/2017.
 */
public class GenreSort implements Comparator<DVDInfo>{
    public int compare(DVDInfo dvd1, DVDInfo dvd2){
        return dvd1.getGenre().compareTo(dvd2.getGenre());
    }
}
