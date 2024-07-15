import java.util.HashSet;

public class weatherStation {
    public static void main(String[] args){
        IObserver a = new WeatherObserver(0);
        IObserver b = new WeatherObserver(1);
        IObserver c = new WeatherObserver(2);
        IObservable broadcast = new WeatherObservable();
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
    public void Update(IObservable observable);
}
class WeatherObserver implements IObserver{
    private int id;
    public WeatherObserver(int id){
        this.id = id;
    }
    @Override
    public void Update(IObservable observable) {
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
        ob.Update(this);
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
