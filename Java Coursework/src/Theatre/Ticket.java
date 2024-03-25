package Theatre;

public class Ticket {

    private  int   row,seat,price;
    private  Person person;




    public Ticket(Person person,int row,int seat,int price ){
        this.person = person;
        this.row = row;
        this.seat = seat;
        this.price = price;

    }

    public int getRow() {

        return row;
    }

    public int getSeat() {

        return seat;
    }

    public int getPrice() {

        return price;
    }
    public Person getPerson(){

        return person;
    }

    public  void print(){
        System.out.println(" ");
        System.out.println("Name: "+person.getName());
        System.out.println("Surname: "+person.getSurname() );
        System.out.println("Mail: "+ person.getMail());
        System.out.println("Row: " + row);
        System.out.println("Seat: "+ seat);
        System.out.println("Price: "+ price);
        System.out.println(" ");
    }


}

