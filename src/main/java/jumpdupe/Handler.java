package main.java.jumpdupe;

import main.java.jumpdupe.option.ChooseDupeOption;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Handler {

    public static String output= "ERROR";
    public static String version = "1";

    private void createTextFiles() throws Exception{
        Files.createFile(Paths.get("output.txt"));
        Files.createFile(Paths.get("version.txt"));
    }

    private void readInfoFromTextFiles() throws Exception{
        output = Files.readString(Paths.get("output.txt"));
        version = Files.readString(Paths.get("version.txt")).trim();

        // Delete all contents from output.txt:

        new FileWriter("output.txt",false).close();
    }

    public void startDupe(){
        try {
            ChooseDupeOption chooseDupeOption = new ChooseDupeOption();
            //createTextFiles();
            readInfoFromTextFiles();
            Scanner input = new Scanner(System.in);
            System.out.println("Enter dupe option (s, a, m):");
            String option = input.next();

            System.out.println("Enter dupe multiplier:");
            int multiplier = input.nextInt();
            System.out.println("Duping " + multiplier + " times");

            switch (option){
                case "s" : {
                    System.out.println("Single");
                    chooseDupeOption.JumputiDupeSingle(multiplier);
                }break;
                case "a":{
                    System.out.println("All");
                    chooseDupeOption.JumputiDupeAll(multiplier);
                }break;
                case "m" :{
                    System.out.println("Mission");
                    chooseDupeOption.JumputiDupeMissions(multiplier);
                }break;
                default: System.out.println("Wrong option");
            }
        } catch (Exception e){
            System.out.println("Error : " + e.getMessage());
        }
    }
}
