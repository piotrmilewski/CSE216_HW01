import java.util.Comparator;

public class Orderings{

    public static class phoneNumberComparator implements Comparator<Phone>{

        @Override
        public int compare(Phone p1, Phone p2){
            if (p1.number().phoneNumber > p2.number().phoneNumber)
                return 1;
            else if (p1.number().phoneNumber < p2.number().phoneNumber)
                return -1;
            else
                return 0;
        }
    
    }

    public static class phoneOwnerNameComparator implements Comparator<Phone>{

        @Override
        public int compare(Phone p1, Phone p2){
            if (p1.getOwner().compareToIgnoreCase(p2.getOwner()) > 0)
                return 1;
            else if (p1.getOwner().compareToIgnoreCase(p2.getOwner()) < 0)
                return -1;
            else
                return 0;
        }
    
    }

    public static class computerScreenComparator implements Comparator<Computer>{

        @Override
        public int compare(Computer c1, Computer c2){
            if (c1.getScreenSize() > c2.getScreenSize())
                return 1;
            else if (c1.getScreenSize() < c2.getScreenSize())
                return -1;
            else
                return 0;
        }
    
    }

    public static class computerBrandComparator implements Comparator<Computer>{

        @Override
        public int compare(Computer c1, Computer c2){

            if (c1 instanceof SmartPhone && c2 instanceof SmartPhone)
                return 0;
            else if (c1 instanceof Laptop && c2 instanceof SmartPhone)
                return -1;
            else if (c1 instanceof SmartPhone && c2 instanceof Laptop)
                return 1;
            else{
                String cBrand1 = ((Laptop)c1).getBrand();
                String cBrand2 = ((Laptop)c2).getBrand();
                if (cBrand1.compareToIgnoreCase(cBrand2) > 0)
                    return 1;
                else if (cBrand1.compareToIgnoreCase(cBrand2) < 0)
                    return -1;
                else
                    return 0;
            }
        }
    
    }

    public static class computerRAMComparator implements Comparator<Computer>{

        @Override
        public int compare(Computer c1, Computer c2){
            if (c1.getRAM() > c2.getRAM())
                return 1;
            else if (c1.getRAM() < c2.getRAM())
                return -1;
            else
                return 0;
        }
    
    }

}