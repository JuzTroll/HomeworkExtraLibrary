import java.util.Arrays;
import java.util.Scanner;

public class Library implements AgeRecommendation{
    private Scanner input = new Scanner(System.in);
    private Book[] auxBooks;
    private Book[] books = new Book[200];

    public Book[] getBooks() {
        return this.books;
    }

    private int counter=0;
    private int auxcounter;

    public String readFromKeyboard(Scanner input, String title){
        System.out.println(title);
        String value = input.nextLine();
        if (value.isEmpty()) {
            return null;
        }else return value;
    }

    public Book[] readBooks() {
        while(true) {
            String title = this.readFromKeyboard(input, "\nTitlu: ");
            if(title==null) break;
            String year = this.readFromKeyboard(input, "Year: ");
            if(year==null) break;
            String publisher = this.readFromKeyboard(input, "Publisher: ");
            if(publisher==null) break;
            String age = this.readFromKeyboard(input, "Recommended Age: ");
            if(age==null) break;
            String price = this.readFromKeyboard(input, "Price: ");
            if(price==null) break;

            Book b = new Book(title, Integer.parseInt(year), publisher, Integer.parseInt(age), Float.parseFloat(price));

            this.books[this.counter] = b;
            this.counter++;
        }
        return this.books;
        //citesc de la tastatura title,year,publisher,price,recommendedAge cu un Scanner
    }

    public String readUsers() {
        return input.nextLine();
    }

    public void addBook(Book book) {
        this.books[counter] = book;
        this.counter++;
    }

    @Override
    public Book[] sortBooks() {
        this.auxBooks = new Book[counter];
        for(int i=0;i<counter;i++){
            this.auxBooks[i] = this.books[i];
        }
        Arrays.sort(this.auxBooks);
        return this.auxBooks;
    }

    @Override
    public Book[] recommendBooksForUser(User user) {
        this.auxBooks = new Book[counter];
        this.auxcounter = this.counter;
        for(int i=0;i<this.auxcounter;i++){
            this.auxBooks[i] = this.books[i];
        }
        for(int i=0;i<this.auxcounter;i++) {
            if((this.auxBooks)[i].getRecommendedAge() > user.getAge()) {
                this.auxBooks[i] = this.books[i+1];
                this.auxcounter--;
            }
        }
        Arrays.sort(this.auxBooks);
        return this.auxBooks;
    }
}
