package Utility;

public class FatigueLevels {
    static int junior=0;
    static int senior=0;
    static int teacher=0;

    public FatigueLevels(int Lj, int Ls, int Lt){
        junior = Lj;
        senior = Ls;
        teacher = Lt;
        System.out.println("Fatigue Levels to be created!");
    }

    public static int getLevel(String type){
        if ((type.equals("junior"))){
            return junior;
        }
        else if (type.equals("senior")){
            return senior;
        }
        else{
            return teacher;
        }
    }
}
