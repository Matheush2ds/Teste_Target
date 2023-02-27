import java.util.Scanner;

public class InverteString {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String str = input.nextLine();
        String strInvertida = inverterString(str);
        System.out.println("String invertida: " + strInvertida);
    }

    public static String inverterString(String str) {
        char[] chars = str.toCharArray();
        int inicio = 0;
        int fim = chars.length - 1;

        while (inicio < fim) {
            char temp = chars[inicio];
            chars[inicio] = chars[fim];
            chars[fim] = temp;
            inicio++;
            fim--;
        }

        return new String(chars);
    }
}