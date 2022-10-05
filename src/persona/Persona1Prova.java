package persona;

/**
 *
 * @author valentino.landrini
 */
public class Persona1Prova {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Persona1 p1 = new Persona1();
        Persona1 p2 = new Persona1(1.80, "landrini", "19/08/2004", "valentino", 55f);
        
        String info = p2.info();
        
        System.out.println("informazioni\n"+ info);
        
    }
    
}
