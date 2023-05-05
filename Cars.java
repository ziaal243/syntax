
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

    public static void main(String[] args) {
        
        ArrayList<Cars> Lager1 = new ArrayList<Cars>();
    
        Lager1.add(new Cars("Volvo", "V90", 2020, engine.Diesel));
        Lager1.add(new Cars("MB", "CLA", 2020, engine.Hybrid));
        Lager1.add(new Cars("Volvo", "XC60", 2018, engine.Diesel));
        Lager1.add(new Cars("MB", "GLB", 2020, engine.Hybrid));
        Lager1.add(new Cars("Volvo", "XC90", 2019, engine.Petrol));
        Lager1.add(new Cars("MB", "E220", 2022, engine.Hybrid));
        Lager1.add(new Cars("Volvo", "C40", 2023, engine.Electric));      

        for (Cars cars : Lager1) {
            System.out.print((Lager1.indexOf(cars)+1) + " " +cars.Out());
        }

        if (Lager1.size() > 0){
            try {
                OutputStream out = new FileOutputStream("Lager3.txt");
                for (Cars cars : Lager1){
                    out.write(cars.Out().getBytes());   
                }    
                out.close();
            }
            catch (Exception e) {
                e.getStackTrace();
            }
            
            
        }        
    }
    
}
