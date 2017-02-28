package genericsAndCollections;

/**
 * Created by anonymous.vn1985 on 2/27/2017.
 */
class DVDInfo {
    String title;
    String genre;
    String leadActor;
    public DVDInfo(String title, String genre, String leadActor){
        this.title = title;
        this.genre = genre;
        this.leadActor = leadActor;
    }
    public String toString(){
        return "Title: " + this.title + "-----Genre: " + this.genre + "----LeadActor: " + this.leadActor + " \n";
    }
}
