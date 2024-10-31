import java.util.ArrayList;

/* This is a stub for the House class */
public class House extends Building {
  private ArrayList<String> residents;
  private final boolean hasDiningRoom;

  /**
   * constructor
   * @param name
   * @param address
   * @param nFloors
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom) {
    super(name, address, nFloors);
    this.residents = new ArrayList<>();
    this.hasDiningRoom = hasDiningRoom;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * getter method
   * @return the list of residents
   */
  public ArrayList<String> getResidents() {
    return this.residents;
  }

  /**
   * getter method
   * @return true if house has a dining room, false otherwise
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * getter method
   * @return number of residents living in the house
   */
  public int getNResidents() {
    return this.residents.size();
  }

  /**
   *
   * @param student
   * @return true if a student lives in the house, false otherwise
   */
  public boolean isResident(String student){
    return residents.contains(student);
  }

  /**
   * checks if the student is already in the house
   * throws an exception if student is already in the house
   * otherwise adds the student to the house
   * @param name
   */
  public void moveIn(String name){
    if(isResident(name)){
      throw new RuntimeException(name+" already lives in this house.");
    }else{
      residents.add(name);
      System.out.println(name+" has moved in!");
    }
  }

  /**
   * checks if the student LIVES in the house
   * removes the student from the house
   * otherwise throws an exception if student is not in the house
   * @param name
   * @return name of the student who moved out
   */
  public String moveOut(String name){
    if(isResident(name)){
      residents.remove(name);
      return name;
    }else{
      throw new RuntimeException(name+" does not live in this house.");
    }
  }

  /**
   * is entrypoint for the House class and allows creation of a House object
   * @param args
   */
  public static void main(String[] args) {
    House h=new House("Hubbard", "Central Campus", 3, false);
    h.moveIn("Lorem Ipsum");
  }
}