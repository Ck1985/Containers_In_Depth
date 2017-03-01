package genericsAndCollections;

/**
 * Created by anonymous.vn1985 on 2/27/2017.
 */
class DVDInfo implements Comparable<DVDInfo>{
    private String title;
    private String genre;
    private String leadActor;
    public DVDInfo(String title, String genre, String leadActor){
        this.title = title;
        this.genre = genre;
        this.leadActor = leadActor;
    }
    public String getTitle(){
        return this.title;
    }
    public String getGenre(){
        return this.genre;
    }
    public String getLeadActor(){
        return this.leadActor;
    }
    public int compareTo(DVDInfo object){
        return this.title.compareTo(object.getTitle());
    }
    public String toString(){
        return "Title: " + this.title + "-----Genre: " + this.genre + "----LeadActor: " + this.leadActor + " \n";
    }
}
