package persona;

/**
 *
 * @author valentino.landrini
 */
public class ProvaPersona {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Persona p1 = new Persona();
        Persona p2 = new Persona(1.80, "landrini", "19/08/2004", "valentino", 55f);
        
        String info = p2.info();
        
        System.out.println("informazioni\n"+ info);
        
    }
    
}
