import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        System.out.print("""
                 █ █  █   █ █     █████ █ ████  █     █  ███    █   █████ █  ███  █   █
                █ █ █ █   █ █       █   █ █   █ █     █ █   █  █ █    █   █ █   █ ██  █
                █   █ █   █ █       █   █ ████  █     █ █     █   █   █   █ █   █ █ █ █
                █   █ █   █ █       █   █ █     █     █ █   █ █████   █   █ █   █ █  ██
                █   █  ███  █████   █   █ █     █████ █  ███  █   █   █   █  ███  █   █
                
                █████ █████  ████ █████                                               \s
                  █   █     █       █                                                 \s
                  █   █████  ███    █                                                 \s
                  █   █         █   █                                                 \s
                  █   █████ ████    █                                                 \s
                """);
        boolean test = true;
        Scanner scanner = new Scanner(System.in);
        while(test){
            int correct=0;
            for(int i=1; i<=10; i++){
                int x = (int)(Math.random()*10);
                int y = (int)(Math.random()*10);
                System.out.print(x + " * " + y + " = ");
                int ans = Integer.parseInt(scanner.nextLine());
                if (ans==x*y){
                    correct++;
                }
                else{
                    System.out.println("Wrong answer");
                }
            }
            if (correct==10){
                System.out.println("You answered all questions correctly!!");
                test = false;
            }
            else {
                System.out.println("You answered "+correct+" out of 10 questions correctly, try again.");
            }
        }
    }
}
