import java.util.ArrayList;
import java.util.Collections;

public class Test{

    public static void main(String[] args){

        //Test Phone methods
        //-------------------------------------------------------------------------------------------------------------------------
        
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
        
        OldLandline oldLandlineLL = new Landline("oldLandline", 8389291938L);
        Phone phoneLL = new Landline("phoneLL", 3839247581L);
        Phone phoneOLL = new OldLandline("phoneOLL", 3839247581L);
        Phone phoneSP = new SmartPhone("phoneSP", 3839247581L, 10, 5, 10);
        OldLandline oldLandlineSP = new SmartPhone("oldLandlineSP", 6699247581L, 17, 6, 9); //still works since it extends oldLandLine

        phoneLL.call(phoneOLL);
        phoneLL.call(phoneOLL);
        phoneOLL.call(phoneSP);
        phoneSP.call(oldLandlineLL);
        phoneLL.end();
        phoneLL.call(oldLandlineLL); //phoneLL is able to leave a message since the oldLaneline is internally still a Landline
        oldLandlineSP.call(phoneLL);
        //oldLandlineSP.installGame("Overwatch"); //Won't work since it's restricted to methods of type oldLandline
        phoneLL.end();
        phoneOLL.end();
        phoneSP.end();
        oldLandlineSP.end();
        phoneLL.call(phoneLL);
        phoneLL.end();
        
        //Test Orderings
        //-------------------------------------------------------------------------------------------------------------------------

        SmartPhone sp1 = new SmartPhone("sp1", 4444444444L, 1, 10, 1);
        SmartPhone sp2 = new SmartPhone("sp2", 5555555555L, 2, 20, 2);
        SmartPhone sp3 = new SmartPhone("sp3", 3333333333L, 3, 9, 1);
        SmartPhone sp4 = new SmartPhone("sp4", 1111111111L, 4, 1, 2);
        SmartPhone sp5 = new SmartPhone("sp5", 2222222222L, 5, 100, 3);

        ArrayList<SmartPhone> smartPhoneAL= new ArrayList<SmartPhone>();
        smartPhoneAL.add(sp1);
        smartPhoneAL.add(sp2);
        smartPhoneAL.add(sp3);
        smartPhoneAL.add(sp4);
        smartPhoneAL.add(sp5);

        System.out.println("\nTesting sorting smartphones:");
        System.out.println("Unsorted:");
        for (int i = 0; i < smartPhoneAL.size(); i++)
            System.out.println(smartPhoneAL.get(i).getOwner());

        Collections.sort(smartPhoneAL, new Orderings.phoneOwnerNameComparator());

        System.out.println("\nSorted by phone owner's name:");
        for (int i = 0; i < smartPhoneAL.size(); i++)
            System.out.println(smartPhoneAL.get(i).getOwner());

        Collections.sort(smartPhoneAL, new Orderings.phoneNumberComparator());

        System.out.println("\nSorted by phone number:");
        for (int i = 0; i < smartPhoneAL.size(); i++)
            System.out.println(smartPhoneAL.get(i).getOwner());

        Collections.sort(smartPhoneAL, new Orderings.computerRAMComparator());

        System.out.println("\nSorted by RAM:");
        for (int i = 0; i < smartPhoneAL.size(); i++)
            System.out.println(smartPhoneAL.get(i).getOwner());

        //leaves the collection alone since it's only ordering smartphones which don't have a brand
        Collections.sort(smartPhoneAL, new Orderings.computerBrandComparator());

        System.out.println("\nSorted by Brand:");
        for (int i = 0; i < smartPhoneAL.size(); i++)
            System.out.println(smartPhoneAL.get(i).getOwner());

        Collections.sort(smartPhoneAL, new Orderings.computerScreenComparator());

        System.out.println("\nSorted by Screen Size:");
        for (int i = 0; i < smartPhoneAL.size(); i++)
            System.out.println(smartPhoneAL.get(i).getOwner());

        //Testing sorting different kinds of phones    
        OldLandline oll = new OldLandline("oll", 3333333333L);
        Landline ll = new Landline("ll", 1111111111L);
        SmartPhone sp = new SmartPhone("sp", 2222222222L, 5, 100, 3);
        Phone oll2 = new OldLandline("oll2", 6666666666L);
        Phone ll2 = new Landline("ll2", 6666666661L);
        OldLandline sp6 = new SmartPhone("sp6", 1000000000L, 1, 10, 5);

        ArrayList<Phone> phoneAL= new ArrayList<Phone>();
        phoneAL.add(oll);
        phoneAL.add(ll);
        phoneAL.add(sp);
        phoneAL.add(oll2);
        phoneAL.add(ll2);
        phoneAL.add(sp6);

        System.out.println("\nUnsorted:");
        for (int i = 0; i < phoneAL.size(); i++)
            System.out.println(phoneAL.get(i).getOwner());

        Collections.sort(phoneAL, new Orderings.phoneOwnerNameComparator());

        System.out.println("\nSorted by phone owner's name:");
        for (int i = 0; i < phoneAL.size(); i++)
            System.out.println(phoneAL.get(i).getOwner());

        Collections.sort(phoneAL, new Orderings.phoneNumberComparator());

        System.out.println("\nSorted by phone number:");
        for (int i = 0; i < phoneAL.size(); i++)
            System.out.println(phoneAL.get(i).getOwner());
        
        //Testing sorting different kinds of phones    
        Laptop laptop1 = new Laptop("laptop1", "Mac", 1, 1, 1);
        Laptop laptop2 = new Laptop("laptop2", "Mac", 2, 14, 7);
        Laptop laptop3 = new Laptop("laptop3", "Acer", 3, 5, 7);
        Laptop laptop4 = new Laptop("laptop4", "HP", 4, 61, 12);
        SmartPhone smartPhone5 = new SmartPhone("smartPhone5", 2224445454L, 5, 26, 2);
        SmartPhone smartPhone6 = new SmartPhone("smartPhone6", 5324445454L, 6, 32, 1);

        ArrayList<Computer> computerAL= new ArrayList<Computer>();
        computerAL.add(laptop1);
        computerAL.add(laptop2);
        computerAL.add(laptop3);
        computerAL.add(laptop4);
        computerAL.add(smartPhone5);
        computerAL.add(smartPhone6);

        System.out.println("\nTesting sorting computers:");
        System.out.println("Unsorted:");
        for (int i = 0; i < computerAL.size(); i++)
            System.out.println(computerAL.get(i).getScreenSize());

        Collections.sort(computerAL, new Orderings.computerRAMComparator());

        System.out.println("\nSorted by RAM:");
        for (int i = 0; i < computerAL.size(); i++)
            System.out.println(computerAL.get(i).getScreenSize());

        Collections.sort(computerAL, new Orderings.computerBrandComparator());

        System.out.println("\nSorted by Brand:");
        for (int i = 0; i < computerAL.size(); i++)
            System.out.println(computerAL.get(i).getScreenSize());

        Collections.sort(computerAL, new Orderings.computerScreenComparator());

        System.out.println("\nSorted by Screen Size:");
        for (int i = 0; i < computerAL.size(); i++)
            System.out.println(computerAL.get(i).getScreenSize());
        
        //Test Games
        //-------------------------------------------------------------------------------------------------------------------------

        Computer lt = new Laptop("Jordan", "Acer", 5, 12, 7);
        Computer smartP = new SmartPhone("NotJordan", 9991119292L, 2, 53, 8);
        
        lt.installGame("game1");
        lt.installGame("game2");
        lt.installGame("game3");
        lt.installGame("game4");
        lt.installGame("game5");
        lt.installGame("game6");

        smartP.installGame("game1");
        smartP.installGame("game2");
        smartP.installGame("game3");
        smartP.installGame("game4");
        smartP.installGame("game5");
        smartP.installGame("game6");

        lt.hasGame("game6");
        lt.hasGame("game7");

        smartP.hasGame("game5");
        smartP.hasGame("game6");

        lt.playGame("game5");
        lt.playGame("game7");

        smartP.playGame("game5");
        smartP.playGame("game7");

        System.out.println("");

        Laptop lt2 = new Laptop("Eric", "Acer", 5, 12, 7);
        SmartPhone smartP2 = new SmartPhone("NotEric", 9991119292L, 2, 53, 8);
        
        lt2.installGame("game1");
        lt2.installGame("game2");
        lt2.installGame("game3");
        lt2.installGame("game4");
        lt2.installGame("game5");
        lt2.installGame("game6");

        smartP2.installGame("game1");
        smartP2.installGame("game2");
        smartP2.installGame("game3");
        smartP2.installGame("game4");
        smartP2.installGame("game5");
        smartP2.installGame("game6");

        lt2.hasGame("game6");
        lt2.hasGame("game7");

        smartP2.hasGame("game5");
        smartP2.hasGame("game6");

        lt2.playGame("game5");
        lt2.playGame("game7");

        smartP2.playGame("game5");
        smartP2.playGame("game7");
    }

}