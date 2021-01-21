package BuildingAreas;

import HumanBeings.Student;

public class Yard extends Area{
    Yard(){
        System.out.println("A New Yard has been created!");
    }

    void studentEnter(Student s1){
        for (int i=0;i<capacity;i++)
        {
            if (s[i] == null)
            {
                System.out.println(s1.getName()+" enters yard!");
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
                System.out.println(s1.getName()+" exits yard!");
                s[i] = null;
                return;
            }
        }
    }
}
