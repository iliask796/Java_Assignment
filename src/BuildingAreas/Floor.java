package BuildingAreas;

import HumanBeings.Student;
import HumanBeings.Teacher;

public class Floor {
    int floor_no;
    Corridor co;
    Class[] cl;

    Floor(int no, int c_class){
        floor_no = no;
        System.out.println("A New Floor has been created!");
        co = new Corridor();
        cl = new Class[6];
        for(int i=0;i<6;i++)
        {
            cl[i] = new Class(6*(floor_no-1)+i+1,c_class);
        }
    }

    int getFloor_no() {
        return floor_no;
    }

    void print(){
        System.out.println("Floor number "+floor_no+" cointains:");
        for (int i=0;i<6;i++){cl[i].print();}
    }

    void teacherPlace(Teacher t1){
        for (int i=0;i<6;i++)
        {
            if (t1.getClassNumber() == cl[i].getNumber())
            {
                cl[i].teacherEnter(t1);
                return;
            }
        }
    }

    void studentEnter(Student s1){
        System.out.println(s1.getName()+" enters floor!");
        co.studentEnter(s1);
    }

    void studentGetInClass(Student s1){
        for (int i=0;i<6;i++)
        {
            if (s1.getClassNumber() == cl[i].getNumber())
            {
                if (!cl[i].isFull())
                {
                    co.studentExit(s1);
                    cl[i].studentEnter(s1);
                    return;
                }
            }
        }
    }

    Student empty(){
        for (int i=0;i<6;i++)
        {
            Student s1 = cl[i].studentExit();
            if (s1 != null) {
                co.studentEnter(s1);
                co.studentExit(s1);
                System.out.println(s1.getName()+" exits floor!");
                return s1;
            }
        }
        return null;
    }

    void teachersExit(){
        for (int i=0;i<6;i++)
        {
            cl[i].teacherExit();
        }
    }

    void operate(int hours){
        for (int i=0;i<6;i++){cl[i].operate(hours);}
    }
}
