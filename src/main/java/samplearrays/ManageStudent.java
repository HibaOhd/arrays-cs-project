package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = new Student(0,"");
        for(Student std: students){
            if(std.getAge()>oldest.getAge()){
                oldest = std;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int numAdults=0;
        for(Student std:students){
            if(std.isAdult()){
                numAdults += 1;
            }
        }
        return numAdults;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if(students.length==0){
            return Double.NaN;
        }else{
            double average=0;
            for(Student std:students){
                average+= std.getGrade();
            }
            average /= students.length;
            return average;
        }
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for(Student std:students){
            if(std.getName().equalsIgnoreCase(name)){
                return std;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Arrays.sort(students, Comparator.comparing(Student::getGrade).reversed());
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(Student std: students){
            if(std.getGrade()>=15){
                System.out.println(std.getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(Student std:students){
            if(std.getId()==id){
                std.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        String[] visitedNames = new String[students.length];
        int index=0;
        for(Student std:students){
            for(String name:visitedNames){
                if(std.getName().equals(name)){
                    System.out.println("Duplicates found");
                    return true;
                }
            }
            visitedNames[index]=std.getName();
            index+=1;
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] updatedStudents = new Student[students.length +1];
        System.arraycopy(students,0,updatedStudents,0,students.length);
        updatedStudents[students.length]= newStudent;
        students = updatedStudents;
        return students;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student student1= new Student(1,"amal");
        Student student2= new Student(2,"omar",16);
        Student student3= new Student(3,"youness",19,20);
        Student student4= new Student(4,"mohamed");
        Student student5= new Student(5,"noura",18);
        Student[] arr = {student1,student2,student3,student4,student5};

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("Oldest Student: "+findOldest(arr));

        // 3) Count adults
        System.out.println("Adults count: "+countAdults(arr));

        // 4) Average grade
        System.out.println("Average grade: "+averageGrade(arr));

        // 5) Find by name
        System.out.println("Search by name: "+findStudentByName(arr,"Noura"));

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        boolean updated = updateGrade(arr,4,18);
        // function
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println(hasDuplicateNames(arr));

        // 10) Append new student
        arr=appendStudent(arr,new Student(6,"dina"));
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);

        // 11) School 2D array
        Student[][] school = {
                {new Student(1,"student1",18,19),new Student(2,"student2",18,15),new Student(3,"student3",19,14)},
                {new Student(4,"student4",13,11),new Student(5,"student5",14,17),new Student(6,"student6",13,14)}
        };
        //printing all students
        System.out.println("== All Students ==");
        for(int i=0;i<school.length;i++){
            System.out.println("Students of class "+(i+1)+" :");
            for(Student std:school[i]){
                System.out.println(std);
            }
        }
        // Top student in each class
        for(int i=0;i<school.length;i++){
            System.out.println("Top Student of class "+(i+1)+" :");
            Student topStud = new Student(0,"");
            for(Student std:school[i]){
                if(std.getGrade()>topStud.getGrade()){
                    topStud = std;
                }
            }
            System.out.println(topStud);
        }
    }
}

