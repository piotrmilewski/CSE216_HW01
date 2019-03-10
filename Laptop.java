import java.util.LinkedList;

public class Laptop implements Computer {

    private String name;
    private String brand;
    private String hostname;
    private int screenSize;
    private int ram;
    private int processorSpeeed;
    private State state;

    LinkedList<SmartPhone.Game> games = new LinkedList<SmartPhone.Game>();

    Laptop(){
        name = "";
        brand = "";
        hostname = "";
        screenSize = 0;
        ram = 0;
        processorSpeeed = 0;
        state = State.OFF;
    }

    Laptop(String newName, String newBrand, int newScreenSize, int newRam, int newprocessorSpeeed){
        name = newName;
        brand = newBrand;
        hostname = newName + "'s " + brand + " laptop";
        screenSize = newScreenSize;
        ram = newRam;
        processorSpeeed = newprocessorSpeeed;
        state = State.ON;
    }

    public String getOwner(){
        return name;
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
            SmartPhone.Game newGame = new SmartPhone.Game(gameName);
            if (hasGame(gameName) == false){
                games.add(newGame);
                System.out.println("Installing " + gameName + " on " + getOwner() + " laptop.");
            }
            else{
                System.out.println("Can't install " + gameName + " on " + getOwner() + "'s laptop.");
            }
        }
        else{
            System.out.println("SmartPhone is currently off.");
        }
    }

    public boolean hasGame(String gameName){
        if (state == State.ON){
            SmartPhone.Game newGame = new SmartPhone.Game(gameName);
            for (int i = 0; i < games.size(); i++){
                if (games.get(i).equals(newGame)){
                    System.out.println(getOwner() + " has " + gameName + " installed.");
                    return true;
                }
            }
            System.out.println(getOwner() + " doesn't have " + gameName + " installed.");
            return false;
        }
        else{
            System.out.println("SmartPhone is currently off.");
            return true; // it won't install the game in installGame()
        }
    }

    public void playGame(String gameName){
        if (state == State.ON){
            if (hasGame(gameName)){
                System.out.println(getOwner() + " is playing " + gameName + ".");
            }
            else{
                System.out.println("Cannot play " + gameName + " on " + getOwner() + "'s laptop.");
            }
        }
        else{
            System.out.println("SmartPhone is currently off.");
        }
    }

}