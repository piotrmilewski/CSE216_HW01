public class Test{

    public static void main(String[] args){

        Landline jack = new Landline("Jack", 6312028899L);
        Landline john = new Landline("John", 3028113434L);
        OldLandline julie = new OldLandline("Julie", 9018772324L);
        SmartPhone paul = new SmartPhone("Paul", 2024449019L, 10, 5, 10);

        jack.call(john);
        julie.call(john);
        john.end();
        julie.call(john);
        john.call(jack);
        julie.end();
        paul.installGame("fortnite");
        paul.installGame("angry birds");
        paul.installGame("fortnite");
        paul.playGame("minecraft");
        paul.playGame("fortnite");

    }

}