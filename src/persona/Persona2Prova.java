package persona;

/**
 *
 * @author valentino.landrini
 */
public class Persona2Prova {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Persona1 p1 = new Persona1();
        Persona2 p2 = new Persona2(1.80, "landrini", "19/8/2004", "valentino", 55f);

        String info = p2.info();

        System.out.println("informazioni\n" + info);

        System.out.println("eta': " + p2.calcoloEta());   

    }

}
