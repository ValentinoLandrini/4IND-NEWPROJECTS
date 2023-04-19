package persona8;

/**
 *
 * @author valentino.landrini
 */
public class Prova {

    public static void main(String[] args) throws Exception {
        //Persona8 p8 = new Persona8(181.1, "Landrini", "Valentino", 56f, "19/08/2004", "Valentino1", "valentinolandrini@gmail.com");
        
        Float[] voti = {5f,7f,5f,5f,8f,9f};
        
        
        Studente2 s2 = new Studente2(4, false, voti, 180.0, "Landrini", "Valentino", 55f, "19/08/2004", "Valentino1", "valentinolandrini@gmail.com");
        
        String info = s2.info();
        
        
        System.out.println("informazioni\n" + info);
                
                
    }
}
