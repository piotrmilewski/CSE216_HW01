import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;

enum MSG_STATUS {

    READ, UNREAD;

}

class Message {

    public String message;
    public MSG_STATUS status;
    public Phone caller;

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

public class Landline extends OldLandline {

    LinkedList<Message> messages = new LinkedList<Message>();

    public Landline(){
        super();
    }
    
    public Landline( String newName, Long newPhoneNumber){
        super(newName, newPhoneNumber);
    }

    public void readMessages(MSG_STATUS status){
        ListIterator<Message> litr = messages.listIterator();
        if (status == MSG_STATUS.UNREAD)
            System.out.println("Unread messages: \n");
        if (status == MSG_STATUS.READ)
            System.out.println("Read messages: \n");
        while (litr.hasNext()){
            Message curr = litr.next();
            if (curr.getStatus() == status){
                System.out.println(curr.getCaller().getOwner() + ": " + curr.getMessage() + "\n");
            }
        }
    }

    @Override
    public void call(Phone phone){
        if (phone.isBusy() || isBusy()){
            if (phone.isBusy()){
                Scanner stdin = new Scanner(System.in);

                System.out.println(getOwner() + " is unable to call " + phone.getOwner() + ". Line is currently busy.");

                //LOOP FOR ADDING A MESSAGE
                boolean run = true;
                while (run){
                    System.out.print("Does" + getOwner() + "want to leave a message? [y/n]");

                    String input = stdin.nextLine();
                    String[] newInput = input.split(" ");
                    if (newInput[0].equals("y") && newInput.length == 1){
                        System.out.print("\n");
                        input = stdin.nextLine();
                        Message newMessage = new Message(this, input);
                        messages.add(newMessage);
                        System.out.print("\n");
                        run = false;
                    }
                    else if (newInput[0].equals("n") && newInput.length == 1){
                        System.out.print("\n");
                        run = false;
                    }
                    else
                        System.out.println("\nWrong input, please try again");
                }
            }
            else if (isBusy())
                System.out.println(getOwner() + " cannot make calls while he/she is in another call.");
            else
                System.out.println(getOwner() + " and " + phone.getOwner() + " are both currently in a call");
        }
        else{
            caller = phone;
            System.out.println(getOwner() + " is on the phone with " + phone.getOwner());
            phone.receive(this);
        }  
    }
}