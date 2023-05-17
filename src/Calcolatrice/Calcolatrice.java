/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Calcolatrice;

/**
 *
 * @author valentino.landrini
 */
import static java.lang.Math.pow;
import persona8.Persona8;
import persona8.Studente2;

public class Calcolatrice {

    public Calcolatrice() {

    }

    public static <T> T somma(T n1, T n2) throws Exception {
        if(n1 instanceof Persona8A || n1 instanceof Studente3) {
            throw new Exception("Bro è una calcolatrice");
        }
        else if(n1 instanceof String && n2 instanceof String) {
            try {
                Double num1 = Double.parseDouble((String) n1);
                Double num2 = Double.parseDouble((String) n2);
                Double ris = num1 + num2;
                return (T) ris.toString();
            }
            catch(NumberFormatException ex) {
                throw new Exception("Parse error");
            }
        }
        else if(n1 instanceof Integer && n2 instanceof Integer) {
            Integer ris = (Integer) n1 + (Integer) n2;
            return (T) ris;
        }
        else if(n1 instanceof Double && n2 instanceof Double) {
            Double ris = (Double) n1 + (Double) n2;
            return (T) ris;
        }
        else if(n1 instanceof Float && n2 instanceof Float) {
            Float ris = (Float) n1 + (Float) n2;
            return (T) ris;
        }
        else
            throw new Exception("Types must be the same");

    }
    
        public static <T> T sottrazione(T n1, T n2) throws Exception {
        Double ris;
        if (n1 instanceof Persona8 || n1 instanceof Studente2) {

            throw new Exception("Devi inserire un numero");
        } else if (n1 instanceof String) {
            try {
                System.out.println("STRINGA");
                Double num1 = Double.parseDouble((String) n1);
                Double num2 = Double.parseDouble((String) n2);
                ris = num1 - num2;
                return (T) ris.toString();

            } catch (NumberFormatException ex) {
                throw new Exception("Errore di tipo");

            }
        } else {
            ris = (Double) n1 - (Double) n2;

        }
        return (T) ris;
    }
        
          public static <T> T moltiplicazione(T n1, T n2) throws Exception {
        Double ris;
        if (n1 instanceof Persona8 || n1 instanceof Studente2) {

            throw new Exception("Devi inserire un numero");
        } else if (n1 instanceof String) {
            try {
                System.out.println("STRINGA");
                Double num1 = Double.parseDouble((String) n1);
                Double num2 = Double.parseDouble((String) n2);
                ris = num1 * num2;
                return (T) ris.toString();

            } catch (NumberFormatException ex) {
                throw new Exception("Errore di tipo");

            }
        } else {
            ris = (Double) n1 * (Double) n2;

        }
        return (T) ris;

    }
          
          
            public static <T> T divisione(T n1, T n2) throws Exception {
        Double ris;
        if (n1 instanceof Persona8 || n1 instanceof Studente2) {

            throw new Exception("Devi inserire un numero");
        } else if (n1 instanceof String) {
            try {
                System.out.println("STRINGA");
                Double num1 = Double.parseDouble((String) n1);
                Double num2 = Double.parseDouble((String) n2);
                ris = num1 / num2;
                return (T) ris.toString();

            } catch (NumberFormatException ex) {
                throw new Exception("Errore di tipo");

            }
        } else {
            ris = (Double) n1 / (Double) n2;

        }
        return (T) ris;

    }
            
       public static <T> T potenza (T n1, T n2) throws Exception {
        Double ris;
        if (n1 instanceof Persona8 || n1 instanceof Studente2) {

            throw new Exception("Devi inserire un numero");
        } else if (n1 instanceof String) {
            try {
                System.out.println("STRINGA");
                Double num1 = Double.parseDouble((String) n1);
                Double num2 = Double.parseDouble((String) n2);
                ris = pow (num1,num2);
                return (T) ris.toString();

            } catch (NumberFormatException ex) {
                throw new Exception("Errore di tipo");

            }
        } else {
            ris = pow((Double) n1,(Double) n2);

        }
        return (T) ris;

    }
        
        

}
