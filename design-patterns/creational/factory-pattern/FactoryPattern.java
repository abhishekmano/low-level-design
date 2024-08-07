public class FactoryPattern {
    public static void main(String[] args){
        PizzaFactory factory = new PizzaFactory();
        Pizza p = factory.CreatePizza(pizzaTypes.Ham);
        p.prepare();
        p = factory.CreatePizza(pizzaTypes.Pepperoni);
        p.prepare();
        p = factory.CreatePizza(pizzaTypes.Default);
        p.prepare();
    }
}
class PizzaFactory{
    Pizza pizza = null;
    public Pizza CreatePizza(pizzaTypes type){
        switch (type) {
            case pizzaTypes.Ham:
                return new HamPizza();
            case pizzaTypes.Pepperoni:
                return new PepperoniPizza();
            case pizzaTypes.Cheese:
                return new CheesePizza();
            default:
                return new BasePizza();
        }
    }
}

abstract class Pizza {
    abstract void prepare();
}
class BasePizza extends Pizza{
    @Override
    public void prepare(){
        System.out.println("Preparing  Pizza");
    }
}
class HamPizza extends Pizza{
    @Override
    public void prepare(){
        System.out.println("Preparing Ham Pizza");
    }
}
class PepperoniPizza extends Pizza{
    @Override
    public void prepare(){
        System.out.println("Preparing Pepperoni Pizza");
    }
}
class CheesePizza extends Pizza{
    @Override
    public void prepare(){
        System.out.println("Preparing Cheese Pizza");
    }
}
enum pizzaTypes {
    Ham , Pepperoni , Cheese , Default;
}