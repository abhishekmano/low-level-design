import java.util.ArrayList;
import java.util.List;
public class commandPattern {
    public static void main(String[] args){
        RemoteControl remote = new RemoteControl();
        Light light = new Light();
        remote.setCommand(new LightOnCommand(light));
        remote.PressButton();
        remote.setCommand(new LightOffCommand(light));
        remote.PressButton();
        System.out.println("Pressing Back Button");
        remote.PressBackButton();
    }
}
class RemoteControl{
    List<Command> history;
    Command current ;
    public RemoteControl(){
        history = new ArrayList<>();
    }
    public void setCommand(Command command){
        current = command;
    }
    public void PressButton(){
        current.execute();
        history.add(current);
    }
    public void PressBackButton(){
        if(history.size() == 0){
            //Do Nothing
        }
        else{
            Command last = history.removeLast();
            last.undo();
        }
    }

}
interface Command {
    public void execute();
    public void undo();
}
class Light{
    private boolean isOn;
    public Light(){
        isOn = false;
    }
    public void on(){
        isOn = true;
        System.out.println("Lights On");
    }
    public void off(){
        isOn = false;
        System.out.println("Lights Off");
    }
    public boolean IsOn(){
        return isOn;
    }
}
class LightOnCommand implements Command{
    Light light;
    public LightOnCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.on();
    }
    public void undo(){
        light.off();
    }
}
class LightOffCommand implements Command{
    Light light;
    public LightOffCommand(Light light){
        this.light = light;
    }
    public void execute(){
        light.off();
    }
    @Override
    public void undo() {
       light.on();
    }
}
