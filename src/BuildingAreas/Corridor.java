package BuildingAreas;

import HumanBeings.Student;

public class Corridor extends Area{
    Corridor(){
        System.out.println("A New Corridor has been created.");
    }

    void studentEnter(Student s1){
        for (int i=0;i<capacity;i++)
        {
            if (s[i] == null)
            {
                System.out.println(s1.getName()+" enters corridor!");
                s[i] = s1;
                return;
            }
        }
    }

    void studentExit(Student s1){
        for (int i=0;i<capacity;i++)
        {
            if (s[i]!=null && s[i].getName().equals(s1.getName()))
            {
                System.out.println(s1.getName()+" exits corridor!");
                s[i] = null;
                return;
            }
        }
    }

}
