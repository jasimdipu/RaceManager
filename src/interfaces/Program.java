package interfaces;

import objectclasses.Athlete;
import objectclasses.Biker;
import objectclasses.Runner;
import objectclasses.Swimmer;
import java.util.Scanner;

public class Program {

    public static final int MENUSTARTS = 100;
    private static InfiniteSkillsRacers _isr;
    private static Scanner _input;

    public static void main(String []args){

        _input = new Scanner(System.in);
        printWelcome();
        boolean completeEntries = false;
        while(!completeEntries){
            int choice = printMenu();

            switch(choice){
                //create race
                case 1 :
                    _isr = new InfiniteSkillsRacers();
                    System.out.println("Created a new Race");
                    break;
                    //add racer
                case 2:
                    if(checkRaceCreated()){
                        System.out.println("What is the racer name?");
                        String name = _input.nextLine();

                        System.out.println("What is the racer age?");
                        int age = Integer.parseInt(_input.nextLine());

                        System.out.println("What type of racer is this?(B, R, S)");
                        String type = _input.nextLine();

                        Athlete aRacer = null;
                        if(type.equalsIgnoreCase("b")) {
                            System.out.println("Does this biker use clips[y/n]");
                            String uci = _input.nextLine();

                            boolean uc = false;
                            if (uci.charAt(0) == 'y' || uci.charAt(0) == 'Y') {
                                uc = true;
                            }
                            aRacer = new Biker(name, age, 0, uc);
                        }else if(type.equalsIgnoreCase("s")){
                            aRacer = new Swimmer(name, age, 0);
                        }else{
                            System.out.println("What brand of shoes does this runner use?");
                            String shoes = _input.nextLine();
                            aRacer = new Runner(name, age, 0, shoes);
                        }

                        if(aRacer != null){
                            boolean addRacer = _isr.addRacer(aRacer);
                            if(addRacer){
                                printRacer("Successfully added raer : ", aRacer);
                            }else{
                                System.out.println("could not add racer!!");
                            }
                        }
                    }
                    else {
                        System.out.println("You must create the race first.");
                    }
                    break;
                    //rermove racer
                case 3 :
                    if(checkRaceCreated()){
                        System.out.println("What is the racer name to remove?");
                        String name = _input.nextLine();
                        boolean remove = _isr.removeRacer(name);
                        if(remove){
                            System.out.println("Successfully removed Athlete "+name);
                        }else{
                            System.out.println("Could not remove Athlete "+name);
                        }
                    }else{
                        System.out.println("You must create the race first.");
                    }
                    break;
                    //find a racer
                case 4 :
                    if(checkRaceCreated()){
                        System.out.println("What is the name of the racer to find?");
                        String name = _input.nextLine();
                        Athlete findAthlete = _isr.getAthlete(name);
                        if(findAthlete != null) {
                            printRacer("Racer details : ", findAthlete);
                        }else{
                            System.out.println("Could not find Athlete by name");
                        }
                    }else{
                        System.out.println("You must create the race first.");
                    }
                    break;
                    //get race winner
                case 5 :
                    if(checkRaceCreated()){
                        Athlete athlete = _isr.getWinner();
                        if(athlete != null){
                            printRacer("the winner is ", athlete);
                        }
                    }else{
                        System.out.println("You must crate the race first.");
                    }
                    break;
                    //list the racers
                case 6 :
                    if(checkRaceCreated()){
                        Athlete[] athletes = _isr.getRacers();
                        if(athletes != null && athletes.length > 0){
                            for (Athlete a : athletes){
                                printRacer("Next Racer : ", a);
                            }
                        }else{
                            System.out.println("Please add some racer first.");
                        }
                    }else{
                        System.out.println("You have to create the race first.");
                    }
                    break;
                    //quit
                case 7 :
                    default:
                        completeEntries = true;
                        break;
            }
        }
        printCompleted();
    }

    private static void printCompleted() {
    }

    private static void printRacer(String s, Athlete aRacer) {
        dases(MENUSTARTS);
        String outputDetails = "%s] Name : %s ||| Age : %d ||| Racer Id : %d ||| Activity : %s %s";
        String title = null;
        String extra = null;
        if(aRacer instanceof Runner){
            title = "Runner";
            Runner r = (Runner) aRacer;
            extra = "Shoes : "+r.get_shoeBrands();
        }else if(aRacer instanceof Biker){
            title = "Biker";
            Biker b = (Biker) aRacer;
            extra = "Using clips : "+b.isUSINGCLIPS();
        }else if(aRacer instanceof Swimmer){
            title = "Swimmer";
            extra = "";
        }
        System.out.println(String.format(outputDetails, title,
                aRacer.getName(),
                aRacer.getAge(),
                aRacer.getRaceId(),
                aRacer.sportsPerformence(),
                extra));
        dases(MENUSTARTS);
    }

    private static void dases(int menustarts) {
        for(int i=0; i<menustarts; i++){
            System.out.print("#");
        }
        System.out.println();
    }

    private static boolean checkRaceCreated() {
        return _isr != null;
    }

    private static int printMenu() {
        stars(MENUSTARTS);
        System.out.println("Enter 1 to create a new race");
        System.out.println("Enter 2 to add a new racer");
        System.out.println("Enter 3 to remove a new racer");
        System.out.println("Enter 4 to find a new racer");
        System.out.println("Enter 5 to get the winner");
        System.out.println("Enter 6 to list the racers");
        System.out.println("Enter 7 to quit");
        stars(MENUSTARTS);
        return Integer.parseInt(_input.nextLine());
    }

    private static void stars(int menustarts) {
        for(int i=0; i<menustarts; i++){
            System.out.print("*");
        }
        System.out.println("\n");
    }

    private static void printWelcome() {
        stars(MENUSTARTS);
        System.out.println("Welcome to infinite Skills race manager");
        stars(MENUSTARTS);
    }
}
