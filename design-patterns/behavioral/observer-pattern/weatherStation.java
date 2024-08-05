import java.util.HashSet;

public class weatherStation {
    public static void main(String[] args){
        IObservable broadcast = new WeatherObservable();
        IObserver a = new WeatherObserver(0, broadcast);
        IObserver b = new WeatherObserver(1, broadcast);
        IObserver c = new WeatherObserver(2 ,broadcast);
        
        broadcast.setData("10 degrees");
        broadcast.register(a);
        broadcast.setData("20 degrees");
        broadcast.register(b);
        broadcast.register(c);
        broadcast.setData("40 degrees");
        broadcast.remove(a);
        broadcast.setData("0 degrees");

    }
}
interface IObservable{
    public void register(IObserver observer);
    public void remove(IObserver observer);
    public void sendNotify();
    public String getData();
    public void setData(String data);

}
interface IObserver{
    public void Update();
}
class WeatherObserver implements IObserver{
    private int id;
    private IObservable observable;
    public WeatherObserver(int id, IObservable observable){
        this.id = id;
        this.observable = observable;
    }
    @Override
    public void Update() {
        System.out.println("New data received by : "  + id + ": "  + observable.getData());
    }
    
}
class  WeatherObservable  implements IObservable{
    HashSet<IObserver> set ;
    public String temp = "";
    public WeatherObservable(){
        set = new HashSet<IObserver>();
    }
    @Override
    public void register(IObserver observer) {
        set.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        if(set.contains(observer)){
            set.remove(observer);
        }
    }

    @Override
    public void sendNotify() {
       for(IObserver ob : set){
        ob.Update();
       }
    }
    @Override
    public String getData() {
        return temp;
        
    }
    @Override
    public void setData(String data) {
        temp = data;
        sendNotify();
    }
    
}
