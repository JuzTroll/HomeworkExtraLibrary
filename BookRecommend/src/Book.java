public class Book implements Buyer, Comparable{
    private String title;
    private String[] authors;
    private String[] aux;
    private int year;
    private String publisher;
    private int recommendedAge;
    private float price;

    private int countAuthor;
    private int capacity;
    static private int countBooks=0;  // este acelasi pt toate obiectele, se aceseaza prin clasa : Book.countBooks

    public static int getCountBooks(){
        return countBooks;
    }

    public Book(String title, int year, String publisher, int recommendedAge, float price) {
        this.title = title;
        this.year = year;
        this.publisher = publisher;
        this.recommendedAge = recommendedAge;
        this.price = price;

        this.capacity = 2;

        this.authors = new String[capacity];
        this.countAuthor = 0;
        this.countBooks++;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getRecommendedAge() {
        return recommendedAge;
    }
    public void setRecommendedAge(int recommendedAge) {
        this.recommendedAge = recommendedAge;
    }

    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }


    public void addAuthor(String name){
        if(countAuthor >= authors.length) {
            this.aux = new String[capacity];
            this.aux = this.authors;
            capacity *= 2;
            this.authors = new String[capacity];
            this.authors = this.aux;
        }
        this.authors[countAuthor] = name;
        countAuthor++;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", publisher='" + publisher + '\'' +
                ", recommendedAge=" + recommendedAge +
                ", price=" + price +
                ", count=" + countAuthor +
                '}';
    }

    @Override
    public float buyBook(User user) {
        if(user instanceof Student) {
            return 5/100f * this.price;
        }
        else if(user instanceof Teacher) {
            return 10/100f * this.price;
        }
        else if(user instanceof Librarian) {
            return 20/100f * this.price;
        }
        else return this.price;
    }

    @Override
    public int compareTo(Object o) {
        Book b = ((Book)o);
        if (this.recommendedAge > b.recommendedAge) {
            return 1; // ceva pozitiv
        } else if (this.recommendedAge < b.recommendedAge) {
            return -1; // ceva negativ
        } else if (this.year > b.year){
            return 1;
        } else if (this.year < b.year) {
            return -1;
        } else return this.title.compareTo(b.title);
    }
}
