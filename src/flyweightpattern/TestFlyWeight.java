package flyweightpattern;

/**
 * Created by anonymous on 2/7/2017.
 */
public class TestFlyWeight {
    public static void main(String[] args){
        Code code = new Code();
        code.setCode("C Code .....");
        Platform platform = PlatformFactory.getPlatformInstantiate("C");
        platform.excutive(code);
        System.out.println("--------------------");
        code = new Code();
        code.setCode("C Code2 .....");
        platform = PlatformFactory.getPlatformInstantiate("C");
        platform.excutive(code);
        System.out.println("----------------------");
        code = new Code();
        code.setCode("Java Code .....");
        platform = PlatformFactory.getPlatformInstantiate("JAVA");
        platform.excutive(code);
        System.out.println("-------------------");
        code = new Code();
        code.setCode("Ruby Code......");
        platform = PlatformFactory.getPlatformInstantiate("RUBY");
        platform.excutive(code);
        System.out.println("-------------");
        code = new Code();
        code.setCode("Ruby code2......");
        platform = PlatformFactory.getPlatformInstantiate("RUBY");
        platform.excutive(code);
    }
}
