import java.io.*;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReaderInfoBank {
    public int digits;

    public ReaderInfoBank(int digits){
        this.digits = digits;
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three first digits of bank account  ");
        int userInput = scanner.nextInt();
        ReaderInfoBank readerInfoBank = new ReaderInfoBank(userInput);

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("Bank_Account_Info/src/bank.txt"));
        FileWriter fw = new FileWriter("Bank_Account_Info/src/bank_after_search.txt"))
        {

            String line;
            while((line = bufferedReader.readLine()) != null){

                String [] words = line.split("\\s");
                String bank_number = words[0].trim();
                String num = words[0].trim().substring(0,3);
                String bank_name = "";
                for (int i = 2; i < words.length; i++) {
                    bank_name += words[i].trim() + " ";
                }
                String digitsAsString = String.valueOf(readerInfoBank.digits);
                if(digitsAsString.equals(num)){
                    System.out.println("Bank number: " + bank_number + " Bank name: " + bank_name);
                    fw.write( "Bank number:" + bank_number + "\s" + " Bank name:"+ bank_name + "\n");
                }
            }
            fw.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error IO");


    }
}
}



// This one done with straightly read from url link , not by file
//public class ReaderInfoBank {
//    public String digits;
//
//    public ReaderInfoBank(String digits){
//        this.digits = digits;
//    }
//
//    public static void main(String [] args){
//        try {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt").openStream()));
//
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Enter three first digits of bank account  ");
//            String userInput = scanner.nextLine();
//            ReaderInfoBank readerInfoBank = new ReaderInfoBank(userInput);
//
//            String line;
//            while((line = bufferedReader.readLine()) != null){
//
//                String [] words = line.split("\\s");
//                String bank_number = words[0].trim();
//                String bank_name = "";
//                for (int i = 2; i < words.length; i++) {
//                    bank_name += words[i].trim() + " ";
//                }
//                if(bank_number.startsWith(readerInfoBank.digits)){
//                    System.out.println("Bank number: " + bank_number + " Bank name: " + bank_name);
//                }
//            }
//        } catch (IOException e){
//            System.out.println("Error IO");
//        }
//
//    }
//}

