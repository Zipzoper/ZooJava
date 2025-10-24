Classe InputUtil:
 
import java.util.Scanner;
 
public class InputUtils {
    private static final Scanner sc = new Scanner(System.in);
 
    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        return sc.nextInt();
    }
 
    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return sc.next();
    }
}
