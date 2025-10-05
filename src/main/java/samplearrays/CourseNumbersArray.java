package samplearrays;

import java.util.Arrays;

public class CourseNumbersArray {
    public static int[] UpdateList(int[] oldList,int newCourse){
        int[] newList = new int[oldList.length+1];
        System.arraycopy(oldList, 0, newList, 0, oldList.length);
        newList[oldList.length] = newCourse;
        return newList;
    }
    public static void printList(int[] coursesList){
        for(int courseNum:coursesList){
            System.out.print(courseNum+"|");
        }
        System.out.println();
    }
    public static Boolean checkNumber(int[] coursesList,int num){
        for(int courseNum:coursesList){
            if(courseNum==num){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = UpdateList(registeredCourses,3000);
        printList(updatedCourses);
        System.out.println(checkNumber(updatedCourses,3000));
        System.out.println(checkNumber(updatedCourses,10));
    }
}
