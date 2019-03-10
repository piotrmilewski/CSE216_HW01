import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

public class Landline extends OldLandline {

    protected enum MSG_STATUS {

        READ, UNREAD;
    
    }

    protected class Message {

        private String message;
        private MSG_STATUS status;
        private Phone caller;
    
        Message(){
            caller = null;
            message = null;
            status = MSG_STATUS.UNREAD;
        }
    
        Message(Phone newCaller, String newMessage){
            caller = newCaller;
            message = newMessage;
            status = MSG_STATUS.UNREAD;
        }
    
        Phone getCaller(){
            return caller;
        }
    
        String getMessage(){
            return message;
        }
    
        MSG_STATUS getStatus(){
            return status;
        }
    
        void setStatus(MSG_STATUS newStatus){
            status = newStatus;
        }
    
    }

    LinkedList<Message> messages = new LinkedList<Message>();

    public Landline(){
        super();
    }
    
    public Landline( String newName, Long newPhoneNumber){
        super(newName, newPhoneNumber);
    }

    public void readMessages(){
        ListIterator<Message> litr = messages.listIterator();
        System.out.println("All messages: \n");
        while (litr.hasNext()){
            Message curr = litr.next();
            System.out.println(curr.getCaller().getOwner() + ": " + curr.getMessage() + "\n");
        }
    }

    public void readMessages(MSG_STATUS status){
        ListIterator<Message> litr = messages.listIterator();
        if (status == MSG_STATUS.UNREAD){
            System.out.println("Unread messages: \n");
        }
        else if (status == MSG_STATUS.READ)
            System.out.println("Read messages: \n");
        while (litr.hasNext()){
            Message curr = litr.next();
            if (curr.getStatus() == status){
                System.out.println(curr.getCaller().getOwner() + ": " + curr.getMessage() + "\n");
            }
        }
    }

    public void leaveMessage(Phone from) throws IOException{
        InputStreamReader inStream = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(inStream);

        //LOOP FOR ADDING A MESSAGE
        boolean run = true;
        while (run){
            System.out.print("Does " + from.getOwner() + " want to leave a message? [y/n] ");

            String input = stdin.readLine();
            String[] newInput = input.split(" ");
            if (newInput[0].equals("y") && newInput.length == 1){
                input = stdin.readLine();
                Message newMessage = new Message(this, input);
                messages.add(newMessage);
                run = false;
            }
            else if (newInput[0].equals("n") && newInput.length == 1){
                run = false;
            }
            else
                System.out.println("\nWrong input, please try again");
        }
    }
}