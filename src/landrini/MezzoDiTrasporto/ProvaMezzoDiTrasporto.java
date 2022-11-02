package landrini.MezzoDiTrasporto;

/**
 *
 * @author Landrini Valentino 
 */
public class ProvaMezzoDiTrasporto{
    

public static void main(String[] args){
    
    MezzoDiTrasporto m2 = new MezzoDiTrasporto(-50, 100, "blu", "bravo", "fiat");
    
    String info = m2.stampa();
    Float KW = m2.CalcoloKW();
    System.out.println("KW = "+ KW);
    System.out.println(info);
    
    
   
    
    

}

   
}