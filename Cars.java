
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.OutputStream;

enum engine{
    Diesel,
    Petrol,
    Electric,
    Hybrid,
    Gas,
    Hydrogin,
    Other
}

public class Cars {
        String Brand;
        String Model;
        int Year;
        engine Usedengine;

        public Cars(String brand, String model, int year, engine usedengine){
            this.Brand = brand;
            this.Model = model;
            this.Year = year;
            this.Usedengine = usedengine;
        }

        private String Out(){
             return (this.Brand + "\t" + this.Model + "\t" + this.Year + "\t" + this.Usedengine +  "\n");
        }

    public static void AddingCars(ArrayList<Cars> Lager){
        Lager.add(new Cars("Volvo", "V90", 2020, engine.Diesel));
        Lager.add(new Cars("MB", "CLA", 2020, engine.Hybrid));
        Lager.add(new Cars("Volvo", "XC60", 2018, engine.Diesel));
        Lager.add(new Cars("MB", "GLB", 2020, engine.Hybrid));
        Lager.add(new Cars("Volvo", "XC90", 2019, engine.Petrol));
        Lager.add(new Cars("MB", "E220", 2022, engine.Hybrid));
        Lager.add(new Cars("Volvo", "C40", 2023, engine.Electric));   
    }

    public static void OutStream(ArrayList<Cars> Lager, String LagerName){
        if (Lager.size() > 0){
            try {
                OutputStream out = new FileOutputStream(LagerName);
                for (Cars cars : Lager){
                    out.write(cars.Out().getBytes());   
                }    
                out.close();
            }
            catch (Exception e) {
                e.getStackTrace();
            }
        }  
    }

    public static int CountVolvo(ArrayList<Cars> Lager, String CartoCount){
        int counter = 0;
        for (Cars cars : Lager) {
            if (cars.Brand == CartoCount)
                counter ++;
        }
        return counter;
    }

    public static void PrintOutStream(ArrayList<Cars> Lager){
        for (Cars cars : Lager) {
            System.out.print((Lager.indexOf(cars)+1) + " " +cars.Out());
        }
    }

    public static void main(String[] args) {
        String FileName = "Lager3.txt";
        ArrayList<Cars> Lager1 = new ArrayList<Cars>();
        AddingCars(Lager1);
        PrintOutStream(Lager1);
        OutStream(Lager1, FileName); 
        String CartoCount = "Volvo";
        System.out.println("Total number of " + CartoCount + " Cars in the Lager is: " + CountVolvo(Lager1, CartoCount));     
    }
    
}
