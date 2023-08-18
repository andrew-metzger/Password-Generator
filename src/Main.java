import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*Currently this program creates generates a password based on user input asking for details on numbers, upper and lowercase letters etc.
* this program could be improved by simply asking the user how long of a password they want and what strength level they want
* based on strength level for password enables specific character libraries. Strong activates 3/4. Super strong activate all, and so on.   */
public class Main {

    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%&*()_+{}[]-=[]|,./?<>";
    private static boolean containsUppercase;
    private static boolean containsLowercase;
    private static boolean containsNumbers;
    private static boolean containsSymbols;
    private static int length;

    public static String generatePassword(boolean containsUpperCase, boolean containsLowerCase, boolean containsNumbers, boolean containsSymbols, int length) {
        StringBuilder password = new StringBuilder(length);
        Random random = new Random(System.nanoTime());
        List<String> passwordCharacterBank = new ArrayList<>();
        if(containsUpperCase){
            passwordCharacterBank.add(UPPER);
        }
        if (containsLowerCase){
            passwordCharacterBank.add(LOWER);
        }
        if (containsNumbers) {
            passwordCharacterBank.add(NUMBERS);
        }
        if (containsSymbols) {
            passwordCharacterBank.add(SYMBOLS);
        }
        for (int i = 0; i < length; i++) {
            String pass = passwordCharacterBank.get(random.nextInt(passwordCharacterBank.size()));
            int position = random.nextInt(pass.length());
            password.append(pass.charAt(position));
        }
        return new String(password);
    }

    public void checkPasswordStrength() {

    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);

        System.out.println("Do you want to generate a password?");      //Asks user
        String genPassResponse = myObj.nextLine().trim();                      //User input

        if(genPassResponse.toUpperCase().equals("YES")) {
            System.out.println("Do you want your password to contain uppercase letters? Enter 'Yes' or 'No'.");
            String uppercaseResponse = myObj.nextLine().trim();

            if (uppercaseResponse.toUpperCase().equals("YES")) {
                containsUppercase = true;
            } else {
                containsUppercase = false;
            }

            System.out.println("Do you want your password to contain lowercase letters? Enter 'Yes' or 'No'.");
            String lowercaseResponse = myObj.nextLine().trim();
            if (lowercaseResponse.toUpperCase().equals("YES")) {
                containsLowercase = true;
            } else {
                containsLowercase = false;
            }

            System.out.println("Do you want your password to contain numbers? Enter 'Yes' or 'No'.");
            String numbersResponse = myObj.nextLine().trim();
            if (numbersResponse.toUpperCase().equals("YES")) {
                containsNumbers = true;
            } else {
                containsNumbers = false;
            }

            System.out.println("Do you want your password to contain symbols? Enter 'Yes' or 'No'.");
            String symbolsResponse = myObj.nextLine().trim();
            if (symbolsResponse.toUpperCase().equals("YES")) {
                containsSymbols = true;
            } else {
                containsSymbols = false;
            }

            System.out.println("How long do you want your password to be? Input a numerical value. Max length = 16. Min length = 8.");
             int lengthResponse = myObj.nextInt();
             if(lengthResponse < 16 && lengthResponse > 8){
                 length = lengthResponse;
             } else {
                 System.out.println("Please enter a number between 8 and 16.");
             }
            String generatedPassword = generatePassword(containsUppercase, containsLowercase, containsNumbers, containsSymbols, length);
            System.out.println(generatedPassword);


        } else{
            System.exit(0);
        }
    }
}