package flyweightpattern;

/**
 * Created by anonymous on 2/7/2017.
 */
public class JavaPlatform implements Platform {
    public JavaPlatform(){
        System.out.println("JavaPlatform Object is created");
    }
    public void excutive(Code code){
        System.out.println("Compiling and excuting by java platform");
    }
}
