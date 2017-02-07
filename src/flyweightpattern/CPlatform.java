package flyweightpattern;

/**
 * Created by anonymous on 2/7/2017.
 */
public class CPlatform implements Platform{
    public CPlatform(){
        System.out.println("CPlatform object is created");
    }
    public void excutive(Code code){
        System.out.println("Compiling and executive on CPlatform");
    }
}
