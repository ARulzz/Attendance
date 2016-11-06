import android.app.Application;

/**
 * Created by Aarya R Shankar on 11/5/2016.
 */

public class Global extends Application {
    /*public*/ private static int yr=0;  //to store the year
    public static String br=null, sub=null;  //to store the branch, and subject
    // public static int[] myarray1=new int[10];
    public static int getYear() {return yr;}
    public static void setYear(int yr) {Global.yr = yr;}

    public static String getBranch() {return br;}
    public static void setBranch(String br) {Global.br = br;}



    //Global global=new Global();

}
