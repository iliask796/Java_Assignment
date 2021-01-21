package HumanBeings;

import Utility.FatigueLevels;

public class SeniorStudent extends Student{
    public SeniorStudent(String nam, int floor_no, int class_no){
        super(nam,floor_no,class_no);
    }

    public void attend(int hours){
        if (super.getLocation().equals("in_class")){
            int increment;
            increment = FatigueLevels.getLevel("senior");
            super.updateFatigue(increment*hours);
        }
    }
}
