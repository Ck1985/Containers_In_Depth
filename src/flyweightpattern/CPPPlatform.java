package flyweightpattern;

/**
 * Created by anonymous on 2/7/2017.
 */
public class CPPPlatform implements Platform{
    public CPPPlatform(){
        System.out.println("CPPPlatform object is created");
    }
    public void excutive(Code code){
        System.out.println("Compiling and executing on CPPplatform");
    }
}
