package BuildingAreas;

import HumanBeings.Student;

public abstract class Area {
    int capacity = 5;
    Student[] s;

    Area() {
        s = new Student[capacity];
        for (int i = 0; i < capacity; i++) {
            s[i] = null;
        }
    }

    Area(int cap){
        capacity = cap;
        s = new Student[capacity];
        for (int i = 0; i < capacity; i++) {
            s[i] = null;
        }
    }

    void studentEnter(Student s1){
    }

    void studentExit(Student s1){
    }

}
