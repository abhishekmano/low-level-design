// This is and Example of Strategy Design Pattern
public class duckStrategy {
    public static void main(String[] args){
        Duck redDuck = new RedHeadDeck();
        redDuck.display();
        redDuck.performFly();
        redDuck.performQuack();
        redDuck.setFlyBehavior(new FlyWithRocket());
        redDuck.setQuackBehavior(new Squeak());
        redDuck.display();
        redDuck.performFly();
        redDuck.performQuack();

    }
}

abstract class Duck{
    protected IFlyBehavior flyBehavior;
    protected IQuackBehavior quackBehavior;
    public abstract void display();
    public  void setFlyBehavior(IFlyBehavior fb){
        flyBehavior = fb;
    }
    public  void setQuackBehavior(IQuackBehavior qb){
        quackBehavior = qb;
    }
    public void performFly(){
        flyBehavior.fly();
    }
    public void performQuack(){
        quackBehavior.quack();
    }

}
class RedHeadDeck extends Duck{
    public RedHeadDeck(){
        super.flyBehavior = new FlyNoWay();
        super.quackBehavior = new QuackMute();
    }
    @Override
    public void display() {
        System.out.println("Im a read head deck");
    }
}
interface IFlyBehavior{
    public void fly();
}
interface IQuackBehavior{
    public void quack();
}
class FlyWithWings implements IFlyBehavior {
    @Override
    public void fly(){
        System.out.println("Flying With Wings");
    }
}
class FlyNoWay implements IFlyBehavior {
    @Override
    public void fly(){
        System.out.println("Cant Fly ");
    }
}
class FlyWithRocket implements IFlyBehavior {
    @Override
    public void fly(){
        System.out.println("Flying With Rocket");
    }
}
class QuackMute implements IQuackBehavior{

    @Override
    public void quack() {
        System.out.println("Cant Quack ");
    }
    
}
class Squeak implements IQuackBehavior{

    @Override
    public void quack() {
        System.out.println("Squeak Squeak ");
    }
    
}
class Quack implements IQuackBehavior{

    @Override
    public void quack() {
        System.out.println("Quack Quack ");
    }
    
}