public class PizzaAbstract {
    public static void main(String[] args){
        PizzaStore store = new NYPizzaStore();
        Pizza pizza = store.createPizza("cheese");
        pizza.prepare();
        store = new Chicago();
        pizza = store.createPizza("cheese");
        pizza.prepare();
    }
}

abstract class PizzaStore{
    abstract Pizza createPizza(String item);
}
class NYPizzaStore extends PizzaStore {
     Pizza createPizza(String item) {
        Pizza pizza = null;
        IngredientFactory ingredientFactory =
        new NYIngredientFactory();
        if (item.equals("cheese")) {
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        } else if (item.equals("onion")) {
            pizza = new OnionPizza(ingredientFactory);
            pizza.setName("New York Style Veggie Pizza");
        } 
        return pizza;
    }
}
class Chicago extends PizzaStore {
    Pizza createPizza(String item) {
       Pizza pizza = null;
       IngredientFactory ingredientFactory =
       new ChicagoIngredientFactory();
       if (item.equals("cheese")) {
           pizza = new CheesePizza(ingredientFactory);
           pizza.setName("Chicago Style Cheese Pizza");
       } else if (item.equals("onion")) {
           pizza = new OnionPizza(ingredientFactory);
           pizza.setName("Chicago Style Veggie Pizza");
       } 
       return pizza;
   }
}
interface  IngredientFactory{
   Dough createDough();
   Sauce createSauce();
   Cheese createCheese();
}
class NYIngredientFactory implements IngredientFactory{

    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new GoatCheese();
    }

}
class ChicagoIngredientFactory implements IngredientFactory{

    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new TomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new Mozzarella();
    }

}
abstract class Pizza {
    String name;
    Dough dough;
    Sauce sauce;
    Cheese cheese;
    abstract void prepare();
    void bake() {
        System.out.println("Bake for 25 minutes at 350");
    }
    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }
    void box() {
        System.out.println("Place pizza in official PizzaStore box");
    }
    void setName(String name) {
        this.name = name;
    }
    String getName() {
        return name;
    }
}
class CheesePizza extends Pizza {
    IngredientFactory ingredientFactory;
    public CheesePizza(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
class OnionPizza extends Pizza {
    IngredientFactory ingredientFactory;
    public OnionPizza(IngredientFactory ingredientFactory) {
        this.ingredientFactory = ingredientFactory;
    }
    void prepare() {
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
    }
}
interface Dough {

}
class ThinCrustDough implements Dough{

}
class ThickCrustDough implements Dough{

}
interface Sauce{

}
class MarinaraSauce implements Sauce{

}
class TomatoSauce implements Sauce{

}
interface Cheese{

}
class Mozzarella implements Cheese{

}
class GoatCheese implements Cheese{

}

