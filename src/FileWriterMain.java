import java.io.*;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Scanner;

public class FileWriterMain {
    public void readFromFile() {
        try {
            File myFile = new File("balance.txt");
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNext()) {
                String dataInFile = myReader.nextLine();
                System.out.println(dataInFile);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        }
    }

    public void writeBalance(float previousBalance, float currentBalance, String transactionType) {
        try (FileWriter fileWriter = new FileWriter("balance.txt")) {
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();

            fileWriter.write(currentTime.toString() + "\n");
            fileWriter.write("Date: " + currentDate + "\n");
            fileWriter.write("Transaction Type: " + transactionType + "\n");
            fileWriter.write("Previous Balance: " + previousBalance + "\n");
            fileWriter.write("Current Balance: " + currentBalance + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
