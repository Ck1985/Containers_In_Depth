package flyweightpattern;

/**
 * Created by anonymous on 2/7/2017.
 */
public class RubyPlatform implements Platform {
    public RubyPlatform(){
        System.out.println("RubyPlatform is created");
    }
    public void excutive(Code code){
        System.out.println("Compiling and excuting on RubyPlatform");
    }
}
