package HumanBeings;

public abstract class Human {
    String name;
    int floor_number;
    int class_number;

    Human(String nam, int floor_no, int class_no){
        //System.out.println("A New Human has been created!");
        name = nam;
        floor_number = floor_no;
        class_number = class_no;
    }

    public String getName(){
        return name;
    }

    public int getClassNumber(){
        return class_number;
    }

    public int getFloorNumber(){
        return floor_number;
    }
}
