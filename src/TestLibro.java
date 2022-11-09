package bridi;

/**
 *
 * @author 75verifica19
 */
public class TestLibro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] autori = new String[1];
        autori[0] = "Chris Kyle";
        Libro l = new Libro(autori, "ChrisKyle", 458, "American Sniper");
        
        System.out.println(l.getInfo());
    }
    
}
