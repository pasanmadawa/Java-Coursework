package Theatre;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Theatre {

    public static  int total_price = 0;
    public static int price = 0;
    static int[] row1 = new int[12];

    static int[] row2 = new int[16];
    static int[] row3 = new int[20];

    private static final ArrayList<Ticket> ticket = new ArrayList<>();


    public static void main(String[] args) {
        Arrays.fill(row1, 0);
        Arrays.fill(row2, 0);
        Arrays.fill(row3, 0);


        //int opinion = 1 ;

        while (true) {

            System.out.println("Welcome to the New Theatre!");
            System.out.println("-------------------------------------------------");
            System.out.println("Please select an option:");
            System.out.println("1) Buy a ticket ");
            System.out.println("2) Print seating area ");
            System.out.println("3) Cancel ticket ");
            System.out.println("4) List available seats");
            System.out.println("5) Save to file");
            System.out.println("6) Load from file ");
            System.out.println("7) Print ticket information and total price ");
            System.out.println("8) Sort tickets by price ");
            System.out.println("   0) Quit ");
            System.out.println("-------------------------------------------------");


            int option = 1;
            //int option = 0;

            Scanner input = new Scanner(System.in);
            boolean optionChecker = false;
            while (!optionChecker) {


                System.out.print("Enter option: ");
                //int option;
                try {
                    option = input.nextInt();

                    if(option > 8 || option < 0 ){
                        System.out.println("Invalid input,Try again.");
                        continue;
                    }

                    optionChecker = true;
                } catch (InputMismatchException ex) {
                    System.out.println("Invalid input,Try again.");
                    input.nextLine();
                }
            }
            if (option == 0) {
                System.out.println("  Thank You,Come Again  ");
                break;
            }

            switch (option) {
                case 1:
                    buy_ticket();
                    break;
                case 2:
                    print_seating_area();
                    break;
                case 3:
                    cancel_ticket();
                    break;

                case 4:
                    show_available();
                    break;

                case 5:
                    save();
                    break;
                case 6:
                    load();
                    break;

                case 7:
                    show_tickets_info();
                    break;

                case 8:
                    sort_tickets();
                    break;


            }

        }

    }

    public static void buy_ticket() {

        Scanner input = new Scanner(System.in);
        boolean variableChecker = false;
        int row_no = 0;
        while (!variableChecker) {
            System.out.print("Enter row number: ");

            try {
                row_no = input.nextInt();
                if (row_no > 3 || row_no < 1) {
                    System.out.println("Invalid input,Try again1.");
                    continue;
                }
                variableChecker = true;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input,Try again2.");
                input.nextLine();
            }
        }

        int seat_no = 0;
        Scanner input1 = new Scanner(System.in);
        boolean variableChecker1 = false;

        while (!variableChecker1) {
            System.out.print("Enter seat number: ");

            try {
                seat_no = input1.nextInt();
                if ((seat_no < 1) || row_no == 1 && seat_no > 12 || row_no == 2 && seat_no > 16 || row_no == 3 && seat_no > 20) {
                    System.out.println("Invalid input,Try again3.");
                    continue;
                }
                variableChecker1 = true;

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input,Try again4.");
                input1.nextLine();
            }
        }
        switch (row_no) {

            case 1:
                if (row1[seat_no - 1] == 0) {
                    System.out.println("Seat is available");

                    row1[seat_no - 1] = 1;

                } else
                    System.out.println("Seat is not available");
                break;


            case 2:
                if (row2[seat_no - 1] == 0) {
                    System.out.println("Seat is available");
                    row2[seat_no - 1] = 1;
                } else
                    System.out.println("Seat is not available");
                break;

            case 3:
                if (row3[seat_no - 1] == 0) {
                    System.out.println("Seat is available");
                    row3[seat_no - 1] = 1;
                } else
                    System.out.println("Seat is not available");
                break;
        }

        Scanner input3 = new Scanner(System.in);
        boolean variableChecker3 = false;
        while (!variableChecker3) {
            System.out.print("Enter ticket price in LKR: ");


            try {
                price = input3.nextInt();
                if (price < 0){
                    System.out.println("Invalid input,Try again.");
                    continue;
                }
                variableChecker3 = true;
            }
            catch (InputMismatchException ex) {

                System.out.println("Invalid input,Try again.");
                input3.nextLine();
            }
        }


        Scanner input2 = new Scanner(System.in);
        System.out.print("Enter the name: ");
        String name = input2.nextLine();

        System.out.print("Enter the surname: ");
        String surname = input2.nextLine();

        System.out.print("Enter the mail: ");
        String mail = input2.nextLine();

        Person obj = new Person(name, surname, mail);

        Ticket obj1 = new Ticket(obj, row_no, seat_no, price);

        ticket.add(obj1);

        total_price = price + total_price;

        System.out.println(" ");

    }

    public static void print_seating_area() {


        System.out.println("    ***********");

        System.out.println("    *  STAGE  *");

        System.out.println("    ***********");

        System.out.print("    ");

        for (int i = 0; i < row1.length; i++) {
            if (i == 6) {
                System.out.print(" ");
            }
            if (row1[i] == 0) {
                System.out.print("O");
            }
            if (row1[i] == 1) {
                System.out.print("X");
            }


        }

        System.out.println(" ");
        System.out.print("  ");          // to use print row2 pattern
        for (int i = 0; i < row2.length; i++) {
            if (i == 8) {
                System.out.print(" ");
            }
            if (row2[i] == 0) {
                System.out.print("O");
            }
            if (row2[i] == 1) {
                System.out.print("X");
            }

        }

        System.out.println("  ");       // to print row3 pattern
        for (int i = 0; i < row3.length; i++) {
            if (i == 10) {
                System.out.print(" ");
            }
            if (row3[i] == 0) {
                System.out.print("O");
            }
            if (row3[i] == 1) {
                System.out.print("X");
            }
        }

        System.out.println(" ");
        System.out.println(" ");


    }

    public static void cancel_ticket() {
        Scanner input4 = new Scanner(System.in);
        boolean variableChecker = false;
        int row_no1 = 0;
        while (!variableChecker) {
            System.out.print("Enter row number: ");

            try {
                row_no1 = input4.nextInt();
                if (row_no1 > 4 || row_no1 < 1) {
                    System.out.println("Invalid input,Try again1.");
                    continue;
                }
                variableChecker = true;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input,Try again2.");
                input4.nextLine();
            }
        }

        int seat_no1 = 0;
        Scanner input1 = new Scanner(System.in);
        boolean variableChecker1 = false;

        while (!variableChecker1) {
            System.out.print("Enter seat number: ");

            try {
                seat_no1 = input1.nextInt();
                if ((seat_no1 < 1) || (row_no1 == 1 && seat_no1 > 12) || (row_no1 == 2 && seat_no1 > 16) || (row_no1 == 3 && seat_no1 > 20)) {
                    System.out.println("Invalid input,Try again3.");
                    continue;
                }
                variableChecker1 = true;

            } catch (InputMismatchException ex) {
                System.out.println("Invalid input,Try again4.");
                input1.nextLine();
            }
        }


        switch (row_no1) {

            case 1:
                if (row1[seat_no1 - 1] == 1) {
                    System.out.println("Seat is available");
                    row1[seat_no1 - 1] = 0;
                } else
                    System.out.println("Seat is not booked");
                break;


            case 2:
                if (row2[seat_no1 - 1] == 1) {
                    System.out.println("Seat is available");
                    row2[seat_no1 - 1] = 0;
                } else
                    System.out.println("Seat is not booked");
                break;

            case 3:
                if (row3[seat_no1 - 1] == 1) {
                    System.out.println("Seat is available");
                    row3[seat_no1 - 1] = 0;
                } else
                    System.out.println("Seat is not booked");
                break;

        }
        for (Ticket ticket1:ticket){
            if (ticket1.getRow()==row_no1 && ticket1.getSeat()==seat_no1){
                ticket.remove(ticket1);
            }
        }

    }

    public static void show_available() {

        System.out.print("Seats available in row 1: ");
        for (int i = 0; i < row1.length; i++) {
            if (row1[i] == 0) {
                if (i == row1.length - 1) {
                    System.out.print(i + 1 + ".");
                } else {
                    System.out.print(i + 1 + ",");
                }

            }
            if (row1[i] == 1) {
                System.out.print("");
            }
        }
        System.out.println(" ");
        System.out.print("Seats available in row 2: ");
        for (int i = 0; i < row2.length; i++) {
            if (row2[i] == 0) {
                if (i == row2.length - 1) {
                    System.out.print(i + 1 + ".");
                } else {
                    System.out.print(i + 1 + ",");
                }

            }
            if (row2[i] == 1) {
                System.out.print("");
            }
        }
        System.out.println(" ");
        System.out.print("Seats available in row 3: ");
        for (int i = 0; i < row3.length; i++) {
            if (row3[i] == 0) {
                if (i == row3.length - 1) {
                    System.out.print(i + 1 + ".");
                } else {
                    System.out.print(i + 1 + ",");
                }

            }
            if (row3[i] == 1) {
                System.out.print("");
            }
        }
        System.out.println(" ");
        System.out.println(" ");

    }

    public static void save() {

        try {
            FileWriter saveWriter = new FileWriter("textSave.txt");

            saveWriter.write(Arrays.toString(row1) + "\n");
            saveWriter.write(Arrays.toString(row2) + "\n");
            saveWriter.write(Arrays.toString(row3) + "\n");


            saveWriter.close();
            System.out.println("Successfully wrote to the file");

        } catch (IOException ex) {
            System.out.println("Error while creating file");
            ex.printStackTrace();
        }


    }

    public static void load() {
        try {
            File readFile = new File("textSave.txt");
            Scanner file_reader = new Scanner(readFile);
            while (file_reader.hasNextLine()) {
                String text = file_reader.nextLine();
                System.out.println(text);
            }
        } catch (IOException ex) {
            System.out.println("Error while reading a file");
            ex.printStackTrace();
        }
        System.out.println(" ");
        System.out.println(" ");
    }

    public static void show_tickets_info() {


        for (Ticket obj4 : ticket) {
            obj4.print();

        }
        System.out.println("Total tickets price: " + total_price + ".00"+" LKR");
        System.out.println(" ");
    }
    public static void sort_tickets () {
        int bottom = ticket.size() - 2;
        Ticket temp;
        boolean exchanged = true;
        while (exchanged) {
            exchanged = false;
            for (int i = 0; i <= bottom; i++) {
                if (ticket.get(i).getPrice() > ticket.get(i+1).getPrice() ) {
                    temp = ticket.get(i);
                    ticket.set(i,ticket.get(i+1));
                    ticket.set(i+1,temp);
                    exchanged = true;
                }
            }
            bottom--;
        }
    }

}