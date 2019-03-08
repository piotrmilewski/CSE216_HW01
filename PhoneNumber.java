public class PhoneNumber{

    public final Long phoneNumber;

    public PhoneNumber(){
        phoneNumber = 0L;
    }

    public PhoneNumber(Long newPhoneNumber) throws IllegalArgumentException{
        if (newPhoneNumber <= 9999999999L && newPhoneNumber >= 1000000000L)
            phoneNumber = newPhoneNumber;
        else
            throw new IllegalArgumentException("Only 10-digit phone numbers are accepted");
    }
}