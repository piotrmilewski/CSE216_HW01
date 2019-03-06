public class OldLandline implements Phone {

    String name;
    boolean isBusy;
    PhoneNumber myNumber;
    PhoneNumber caller;

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

    public void call(Phone phone){
        if (phone.isBusy() || isBusy()){
            if (phone.isBusy())
                System.out.println(getOwner() + " is unable to call " + phone.getOwner() + ". Line is currently busy.");
            else if (isBusy())
                System.out.println(getOwner() + " cannot make calls while he is in another call.");
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

    }

    public void receive(Phone from){

    }

    public boolean isBusy(){
        return true;
    }

    public void receiveEndSignal(Phone from){

    }

    public PhoneNumber number(){
        return new PhoneNumber();
    }

}