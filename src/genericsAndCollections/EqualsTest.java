package genericsAndCollections;

/**
 * Created by anonymous on 2/26/2017.
 */
class Moof{
    private int moofValue;
    public Moof(int moofValue){
        this.moofValue = moofValue;
    }
    public int getMoofValue(){
        return this.moofValue;
    }
    public boolean equals(Object object){
        return (object instanceof Moof) && (((Moof)object).getMoofValue() == this.getMoofValue()) ? true : false;
    }
}
public class EqualsTest {
    public static void main(String[] args){
        Moof one = new Moof(8);
        Moof two = new Moof(8);
        if(one.equals(two)){
            System.out.println("one equals two");
        }
    }
}
