package flyweightpattern;

/**
 * Created by anonymous on 2/7/2017.
 */
public class WebsiteLanguage {
    public static void main(String[] args){
        Platform javaPlatform = new JavaPlatform();
        javaPlatform.excutive(new Code());
    }
}
