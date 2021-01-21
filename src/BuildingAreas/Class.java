package BuildingAreas;

import HumanBeings.Student;
import HumanBeings.Teacher;

public class Class extends Area{
    int class_number;
    int count;
    Teacher t;

    Class(int no, int c){
        super(c);
        class_number = no;
        count = 0;
        t = null;
        System.out.println("A New Class has been created.");
    }

    int getNumber(){
        return class_number;
    }

    void print() {
        System.out.println("People in class " + class_number + " are:");
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                s[i].print();
            }
        }
        if (t!=null){
            t.print();
        }
    }

    boolean isFull(){
        return (count == capacity);
    }

    boolean isEmpty(){return (count == 0);}

    void studentEnter(Student s1){
            System.out.println(s1.getName()+" enters classroom!");
            s[count++]=s1;
            s1.updateLocation("in");
    }

    Student studentExit(){
        if (!isEmpty()){
            Student s1;
            s1 = s[--count];
            System.out.println("Student "+s1.getName()+" starts exiting!");
            System.out.println(s1.getName()+" exits class!");
            s[count].updateLocation("out");
            s[count] = null;
            return s1;
        }
        return null;
    }

    void teacherEnter(Teacher t1){
        t = t1;
        t.putInClass();
    }

    void teacherExit(){
        if (t!=null){
            System.out.println("Teacher "+t.getName()+" of class "+class_number+" is out!");
            t.takeOutOfClass();
            t = null;
        }
    }

    void operate(int hours) {
        if (count != 0) {
            for (int i = 0; i < count; i++) {
                {
                    s[i].attend(hours);
                }
            }
        }
        if (t!=null){
            t.teach(hours);
        }
    }
}