import java.util.LinkedList;

public class SmartPhone extends Landline implements Computer{

    protected class Game {

        String name;
    
        Game(){
            name = "";
        }
    
        Game(String newName){
            name = newName;
        }
    
        String getName(){
            return name;
        }
    
        @Override
        public boolean equals(Object game){
            if (name.equals(((Game)game).getName()))
                return true;
            return false;
        }
    }

    private int screenSize;
    private int ram;
    private int processorSpeeed;
    private State state;

    LinkedList<Game> games = new LinkedList<Game>();

    private final int MAX_SIZE = 5;

    public SmartPhone(){
        screenSize = 0;
        ram = 0;
        processorSpeeed = 0;
        state = State.OFF;
    }

    public SmartPhone(String newName, Long newPhoneNumber, int newScreenSize, int newRam, int newProcessorSpeeed, State newState){
        super(newName, newPhoneNumber);
        screenSize = newScreenSize;
        ram = newRam;
        processorSpeeed = newProcessorSpeeed;
        state = newState;
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
            if (hasGame(gameName) == false && games.size() < MAX_SIZE)
                games.add(newGame);
        }
        else{
            System.out.println("SmartPhone is currently off");
        }
    }

    public boolean hasGame(String gameName){
        if (state == State.ON){
            for (int i = 0; i < 5; i++){
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