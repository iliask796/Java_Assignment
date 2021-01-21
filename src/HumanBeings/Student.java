package HumanBeings;

public abstract class Student extends Human{
    String location;
    int fatigue_level;

    Student(String nam, int floor_no, int class_no){
        super(nam, floor_no, class_no);
        location = "out_of_school";
        fatigue_level = 0;
        System.out.println("A New Student has been created! (name:"+super.getName()+",floor:"+super.getFloorNumber()+",class:"+super.getClassNumber()+")");
    }

    String getLocation(){
        return location;
    }

    public void updateLocation(String direction){
        if (direction.equals("in")){
            location = "in_class";
        }
        else if (direction.equals("out")){
            location = "out_of_class";
        }
    }

    void updateFatigue(int new_fatigue){
        fatigue_level = new_fatigue;
    }

    public void print(){
        System.out.println("Student "+super.getName()+" has fatigue level equal to "+fatigue_level+".");
    }

    public void attend(int hours) {
    }
}
