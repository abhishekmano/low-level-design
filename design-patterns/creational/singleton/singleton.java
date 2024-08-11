public class singleton {
    public static void main(String[] args){
        System.err.println("Single class Instance: ");
        MyClass instance1 = MyClass.getInstance();
        instance1.GetCount();
        MyClass instance2 = MyClass.getInstance();      
        instance2.GetCount();

        System.err.println("Non Single class Instance: ");
        NonSingle instance3 = new NonSingle();
        instance3.GetCount();

        NonSingle instance4 = new NonSingle();      
        instance4.GetCount();

    }
}

class MyClass{
    private static MyClass singleInstance ;
    public static int  count = 0;
    //make the constructor private
    private MyClass(){
        count++;
    }
    public static  MyClass getInstance(){
        if(singleInstance == null){
            singleInstance = new MyClass();
        }
        return singleInstance;
    }
    public void GetCount(){
        System.out.println("count : " + count);
    }
}
class NonSingle {
    public static int count = 0;
    public NonSingle(){
        count++;
    }
    public void GetCount(){
        System.out.println("count : " + count);
    }

}
