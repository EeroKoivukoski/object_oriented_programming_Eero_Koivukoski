import java.util.Locale;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Generate name? Y/N");
        String x=input.nextLine().toLowerCase(Locale.getDefault());

        if (x.equals("n")) System.exit(1);

        do{
            String[] fnames= {"Eero","Lucas","Juhani","Jarkko","Jaakko","Kari","Jyri","Jari","Sampo","Aapo","Salainen"};
            String[] lnames= {"Koivukoski","Mattinen","Mäntykoski","Jokilainen","Kantolainen","Kärkkäinen","Harjulainen","Froidilainen","Salainen"};
            System.out.println( fnames[(int)(Math.random()*11)]+ " " + lnames[(int)(Math.random()*9)]);
            System.out.println("Generate name? Y/N");
            x=input.nextLine().toLowerCase(Locale.getDefault());
        }while(!x.equals("n"));
}}
