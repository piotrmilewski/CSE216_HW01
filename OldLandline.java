public class OldLandline implements Phone {

    String name;
    boolean isBusy;
    PhoneNumber myNumber;
    Phone caller;

    public OldLandline(){
        name = "noName";
        myNumber = new PhoneNumber(9999999999L);
        isBusy = false;
    }
    
    public OldLandline( String newName, Long newPhoneNumber){
        name = newName;
        myNumber = new PhoneNumber(newPhoneNumber);
        isBusy = false;
    }

    public String getOwner(){
        return name;
    }

    //if busy = print out correct error messages
    //if not busy, set caller for both people
    public void call(Phone phone){
        if (phone.isBusy() || isBusy()){
            if (phone.isBusy())
                System.out.println(getOwner() + " is unable to call " + phone.getOwner() + ". Line is currently busy.");
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

    public void end(){
        isBusy = false;
        caller = null;
        caller.receiveEndSignal(this);
    }

    public void receive(Phone from){
        /* redundant, only add if receive is used elsewhere
        if (isBusy() || from.isBusy()){
            if (from.isBusy())
                System.out.println(from.getOwner() + " is unable to call " + getOwner() + ". Line is currently busy.");
            else if (isBusy())
                System.out.println(getOwner() + " cannot take calls while he is in another call.");
            else
                System.out.println(getOwner() + " and " + from.getOwner() + " are both currently in a call");
        }
        */
        caller = from;
    }

    public boolean isBusy(){
        return isBusy;
    }

    public void receiveEndSignal(Phone from){
        isBusy = false;
        caller = null;
    }

    public PhoneNumber number(){
        return myNumber;
    }

}