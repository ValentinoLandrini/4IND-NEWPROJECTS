package calculator;

/**
 *
 * @author valen
 */

import java.util.Scanner;

public class Calculator {

    public void calc() {
                //creazione scanner e variabili
    	double num1, num2;
        Scanner sc = new Scanner (System.in);
        System.out.print("inserisci il primo numero:");

        num1 = sc.nextDouble();
        System.out.print("inserisci il secondo numero:");
        num2 = sc.nextDouble();

        System.out.print("inserisci un operaore: ");
        char operator = sc.next().charAt(0);

       
        double output;
                //switch
        switch(operator)
        {
            case '+':
            	output = num1 + num2;
                break;

            case '-':
            	output = num1 - num2;
                break;

            case '*':
            	output = num1 * num2;
                break;

            case '/':
            	output = num1 / num2;
                break;

          
            default:
                System.out.printf("hai inserito l'operatore sbagliato");
                return;
        }
            //Output
        System.out.println(num1+" "+operator+" "+num2+": "+output);
        
        
        
    }
}

