package BuildingAreas;

import HumanBeings.Student;

public class Stairs extends Area {
    Stairs(){
        System.out.println("New Stairs have been created!");
    }

    void studentEnter(Student s1){
        for (int i=0;i<capacity;i++)
        {
            if (s[i] == null)
            {
                System.out.println(s1.getName()+" enters stairs!");
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
                System.out.println(s1.getName()+" exits stairs!");
                s[i] = null;
                return;
            }
        }
    }
}
