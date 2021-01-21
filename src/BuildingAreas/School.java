package BuildingAreas;

import HumanBeings.Student;
import HumanBeings.Teacher;

public class School {
    Yard yar;
    Stairs sta;
    Floor[] flo;

    public School(int c_class){
        System.out.println("A New School has been created!");
        yar = new Yard();
        sta = new Stairs();
        flo = new Floor[3];
        for(int i=0;i<3;i++)
        {
            flo[i] = new Floor(i+1,c_class);
        }
    }

    public void print(){
        System.out.println("School life consists of: ");
        for (int i=0;i<3;i++){flo[i].print();}
    }

    public void teacherPlace(Teacher t1){
        for (int i=0;i<3;i++)
        {
            if (t1.getFloorNumber() == flo[i].getFloor_no())
            {
                flo[i].teacherPlace(t1);
                return;
            }
        }
    }

    public void studentEnter(Student s1){
        System.out.println(s1.getName()+" enters school!");
        yar.studentEnter(s1);
    }

    public void studentGetInStairs(Student s1){
        yar.studentExit(s1);
        sta.studentEnter(s1);
    }

    public void studentGetInFloor(Student s1){
        for (int i=0;i<3;i++)
        {
            if (s1.getFloorNumber() == flo[i].getFloor_no())
            {
                sta.studentExit(s1);
                flo[i].studentEnter(s1);
                return;
            }
        }
    }

    public void studentGetInClass(Student s1){
        for (int i=0;i<3;i++)
        {
            if (s1.getFloorNumber() == flo[i].getFloor_no())
            {
                flo[i].studentGetInClass(s1);
                return;
            }
        }
    }

    public void operate(int hours){
        for (int i=0;i<3;i++){flo[i].operate(hours);}
    }

    public void empty(){
        for (int i=0;i<3;i++)
        {
            Student s1 = flo[i].empty();
            while(s1 != null){
                sta.studentEnter(s1);
                sta.studentExit(s1);
                yar.studentEnter(s1);
                yar.studentExit(s1);
                System.out.println(s1.getName()+" is out of school!");
                s1 = flo[i].empty();
            }
        }
    }

    public void teachersExit(){
        for (int i=0;i<3;i++){
            flo[i].teachersExit();
        }
    }
}
