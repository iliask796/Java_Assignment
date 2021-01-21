import BuildingAreas.School;
import HumanBeings.Student;
import HumanBeings.JuniorStudent;
import HumanBeings.SeniorStudent;
import HumanBeings.Teacher;
import Utility.FatigueLevels;
import Utility.ReadFile;

import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Random;

@SuppressWarnings({"InstantiationOfUtilityClass"})
class School_Simulation {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int i;
            Random rand = new SecureRandom();
            int M = args.length;
            int[] iArgs = new int[M];
            for (i=0; i<M; i++) {
                iArgs[i] = Integer.parseInt(args[i]);
            }
            int c_class = iArgs[0];
            School sch = new School(c_class);
            int Lj = iArgs[1];
            int Ls = iArgs[2];
            int Lt = iArgs[3];
            new FatigueLevels(Lj,Ls,Lt);
            int N = iArgs[4];
            int count = ReadFile.getNamesCount("in/students.txt");
            String[] s_names = ReadFile.getNames("in/students.txt",count);
            String[] t_names = ReadFile.getNames("in/teachers.txt",18);
            Student[] s_data = new Student[count];
            Teacher[] t_data = new Teacher[18];
            Student s1;
            Teacher t1;
            int floor_no;
            for (i=0;i<count;i++)
            {
                floor_no = rand.nextInt(3)+1;
                int class_type = rand.nextInt(5)+1;
                if (class_type <= 3)
                {
                    s1 = new JuniorStudent(s_names[i],floor_no,6*(floor_no-1)+class_type);
                    s_data[i] = s1;
                }
                else
                {
                    s1 = new SeniorStudent(s_names[i],floor_no,6*(floor_no-1)+class_type);
                    s_data[i] = s1;
                }
            }
            for (i=0;i<18;i++)
            {
                t1 = new Teacher(t_names[i],(i/6)+1,i+1);
                t_data[i] = t1;
            }
            int first_wave = rand.nextInt(count)+1;
            for (i=0;i<first_wave;i++)
            {
                sch.studentEnter(s_data[i]);
                sch.studentGetInStairs(s_data[i]);
                sch.studentGetInFloor(s_data[i]);
                sch.studentGetInClass(s_data[i]);
            }
            int class_no;
            for (i=0;i<10;i++)
            {
                class_no = rand.nextInt(18)+1;
                sch.teacherPlace(t_data[class_no-1]);
            }
            for (i=first_wave;i<count;i++)
            {
                sch.studentEnter(s_data[i]);
                sch.studentGetInStairs(s_data[i]);
                sch.studentGetInFloor(s_data[i]);
                sch.studentGetInClass(s_data[i]);
            }
            sch.operate(N);
            sch.print();
            sch.empty();
            sch.teachersExit();
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Please input exactly 5 values. (1.Class Capacity, 2-4.Fatigue Levels, 5.Hours)");
        }
    }
}