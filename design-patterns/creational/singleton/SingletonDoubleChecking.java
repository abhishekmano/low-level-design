public class SingletonDoubleChecking {
    public static void main(String[] args){
        Singleton instance1 = Singleton.getInstance();
        instance1.getCount();
        Singleton instance2 = Singleton.getInstance();
        instance2.getCount();
        System.out.println("is First equal second " + (instance1 == instance2));
    }
}
class Singleton{
    private static int count = 0;
    private static Singleton uniqueInstance = null;
    private Singleton(){
        count++;
    }
    public static synchronized Singleton getInstance(){
        if(uniqueInstance == null){
            synchronized(Singleton.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
    public void getCount(){
        System.out.println("total count of initialization is :" + count);
    }

}
