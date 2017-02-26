package genericsAndCollections;

/**
 * Created by anonymous on 2/26/2017.
 */
class Bob{
    int shoeSize;
    String nickName;
    public Bob(int shoeSize, String nickName){
        this.shoeSize = shoeSize;
        this.nickName = nickName;
    }
    public String toString(){
        return "My name is Bob, but you can call me is: " +
                this.nickName + " , my shoe size is: " + this.shoeSize;
    }
}
public class BobTest {
    public static void main(String[] args){
        Bob bob = new Bob(19,"anonymous");
        System.out.println(bob);
    }
}
