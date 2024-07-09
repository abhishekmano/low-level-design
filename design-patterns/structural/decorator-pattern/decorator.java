public class decorator {
    public static void main(String[] args){
        BasePizza cheeseThinPizza = new ExtraCheese(new ThinCrustPizza());
        BasePizza chickenThickPizza = new ExtraChicken(new ThickCrustPizza());
        System.out.println("Cheese Thin Pizza cost :" + cheeseThinPizza.cost() );
        System.out.println("Chicken Thick Pizza cost :" + chickenThickPizza.cost() );
    }
}
abstract class BasePizza{
    public abstract int cost();
}

abstract class ToppingDecorator extends BasePizza{

}
class ThinCrustPizza extends BasePizza{

    @Override
    public int cost() {
        return 200;
    }
    
}
class ThickCrustPizza extends BasePizza{

    @Override
    public int  cost() {
        return 150;
    }
    
}


class ExtraCheese extends ToppingDecorator{
    BasePizza basePizza;
    public ExtraCheese(BasePizza pizza){
        basePizza = pizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 40;
    }
    
}
class ExtraChicken extends ToppingDecorator{
    BasePizza basePizza;
    public ExtraChicken(BasePizza pizza){
        basePizza = pizza;
    }
    @Override
    public int cost() {
        return basePizza.cost() + 60;
    }
    
}


