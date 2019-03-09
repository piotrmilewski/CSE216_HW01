import java.util.LinkedList;

public class Laptop implements Computer {

    private String name;
    private String brand;
    private String hostname;
    private int screenSize;
    private int ram;
    private int processorSpeeed;
    private State state;

    LinkedList<Game> games = new LinkedList<Game>();

    Laptop(){
        screenSize = 0;
        ram = 0;
        processorSpeeed = 0;
        state = State.OFF;
    }

    Laptop(String newName, String newBrand, int newScreenSize, int newRam, int newprocessorSpeeed){
        brand = newBrand;
        hostname = newName + "'s " + brand + " laptop";
        screenSize = newScreenSize;
        ram = newRam;
        processorSpeeed = newprocessorSpeeed;
        state = State.ON;
    }

    public String getBrand(){
        return brand;
    }

    public String getHostname(){
        return hostname;
    }

    public int getScreenSize(){
        return screenSize;
    }

    public int getRAM(){
        return ram;
    }

    public int getProcessorSpeeed(){
        return processorSpeeed;
    }

    public State getState(){
        return state;
    }

    public void setState(String to){
        if (to.equals("on") || to.equals("ON") || to.equals("off") || to.equals("OFF"))
            throw new IllegalArgumentException("state must be off/OFF/on/ON.");
        else{
            if (to.equals("on") || to.equals("ON"))
                state = State.ON;
            else
                state = State.OFF;
        }
    }

    public void installGame(String gameName){
        if (state == State.ON){
            Game newGame = new Game(gameName);
            if (hasGame(gameName) == false)
                games.add(newGame);
        }
        else{
            System.out.println("SmartPhone is currently off");
        }
    }

    public boolean hasGame(String gameName){
        if (state == State.ON){
            Game newGame = new Game(gameName);
            for (int i = 0; i < games.size(); i++){
                if (games.get(i).equals(newGame))
                    return true;
            }
            return false;
        }
        else{
            System.out.println("SmartPhone is currently off");
        }
    }

    public void playGame(String gameName){
        if (state == State.ON){
            if (hasGame(gameName)){
                System.out.println(getOwner() + " is playing " + gameName);
            }
        }
        else{
            System.out.println("SmartPhone is currently off");
        }
    }

}