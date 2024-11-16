import java.util.Hashtable;

/* This is a stub for the Library class */
public class Library extends Building{
    private Hashtable<String, Boolean> collection;

    /**
     * constructor
     * @param name
     * @param address
     * @param nFloors
     */
    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable<>();
        System.out.println("You have built a library: 📖");
    }

    /**
     * adds a book to the library
     * @param title
     */
    public void addTitle(String title) {
        if(!containsTitle(title)){
            collection.put(title, true);
            System.out.println(title + " has been added.");
        }else {
            System.out.println(title + " was already in the library.");
        }
    }

    /**
     * removes a book from the library
     * @param title
     * @return the removed title
     */
    public String removeTitle(String title){
        if(!containsTitle(title)){
            System.out.println(title + " does not exist in this library.");
            return null;
        }else {
            collection.remove(title, false);
            System.out.println(title + " has been removed.");
            return title;
        }
    }

    /**
     * updates book status when the book is checked out
     * @param title
     */
    public void checkOut(String title) {
        if(containsTitle(title)&&isAvailable(title)) {
            collection.put(title, false);
            System.out.println(title + " has been checked out.");
        }else {
            System.out.println(title + " is not in this library. (either checked out or doesn't belong in this library)");
        }
    }

    /**
     * updates book status when the book is returned
     */
    public void returnBook(String title) {
        if(containsTitle(title)&&!isAvailable(title)) {
            collection.put(title, true);
            System.out.println(title + " has been returned.");
        }else{
            System.out.println(title + " either doesn't belong in this library or was never checked out.");
        }
    }

    /**
     * checks if the library has the title
     * @param title
     * @return true if the title appears as a key in the Library's collection, false otherwise
     */
    public boolean containsTitle(String title) {
        return collection.containsKey(title);
    }

    /**
     * checks if the book is in the library, available for borrowing
     * @param title
     * @return true if the title is currently available, false otherwise
     */
    public boolean isAvailable(String title){
        if(collection.get(title) == true){
            System.out.println(title + " is available");
            return collection.get(title);
        }
        return false;
    }

    /**
     * prints out the entire collection in an easy-to-read way (including checkout status)
     *
     */
    public void printCollection(){
        System.out.println(collection.toString());
    }

    /**
     * is entrypoint for the Library class and allows creation of a Library object
     * @param args
     */
    public static void main(String[] args) {
      Library n=new Library("Neilson", "Central Campus", 3);
      n.addTitle("Think Java by Allen B. Downey");
      n.addTitle("Think Data Structures by Allen B. Downey");
      n.printCollection();
    }
  }