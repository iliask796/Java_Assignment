package HumanBeings;

import Utility.FatigueLevels;

public class Teacher extends Human{
    boolean is_in_class;
    int fatigue_level;

    public Teacher(String nam, int floor_no, int class_no){
        super(nam, floor_no, class_no);
        is_in_class = false;
        fatigue_level = 0;
        System.out.println("A New Teacher has been created! (name:"+super.getName()+",floor:"+super.getFloorNumber()+",class:"+super.getClassNumber()+")");
    }

    public void putInClass(){
        is_in_class = true;
    }

    public void takeOutOfClass() {is_in_class = false;}

    public void teach(int hours){
        if (is_in_class){
            int increment;
            increment = FatigueLevels.getLevel("teacher");
            fatigue_level += increment*hours;
        }
    }

    public void print(){
        System.out.println("The teacher is: "+super.getName()+" and has fatigue level equal to "+fatigue_level+".");
    }
}
