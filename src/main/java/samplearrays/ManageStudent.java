package samplearrays;



import static java.lang.Double.NaN;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        Student oldest = students[0];
        for(Student student : students){
            if(student.getAge()>oldest.getAge()){
                oldest = student;
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int count = 0;
        for(Student student: students){
            if(student.isAdult()){
                count ++;
            }
        }
        return count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        if(students.length==0){
            return NaN;
        }
        double  sum = 0;
        for(Student student: students){
            sum +=  student.getGrade();
        }
        return sum/Student.getNumStudent();
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student student: students) {
            if (student.getName().equals(name)) {
                return student;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        for(int i=0;i<students.length;i++){
            for(int j=i+1;j<students.length;j++){
                if(students[i].getGrade()>students[j].getGrade()){
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }

            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for(Student student: students){
            if(student.getGrade()>=15){
                System.out.println(student.getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for(Student student: students){
            if(student.getId()==id){
                student.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        for(Student student: students){
            for(Student student2: students){
                if(student.getId()!=student2.getId()){
                    if(student.getName().equals(student2.getName())){
                        return true;
                    }
                }

            }
        }
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] newStudents = new Student[students.length+1];
        System.arraycopy(students, 0, newStudents, 0, students.length);
        newStudents[students.length] = newStudent;
        return newStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = new Student[5];

        arr[0] = new Student(1, "Alice", 20, 15);
        arr[1] = new Student(2, "Bob", 21, 19);
        arr[2] = new Student(3, "Charlie", 19, 12);
        arr[3] = new Student(4, "Diana", 16, 8);
        arr[4] = new Student(5, "Ethan", 17, 14);

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("Oldest: " + findOldest(arr));

        // 3) Count adults
        System.out.println("Adults count: " + countAdults(arr));

        // 4) Average grade
        System.out.println("Average grade: " + averageGrade(arr));

        // 5) Find by name
        System.out.println(findStudentByName(arr, "Alice"));

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        // sort function
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        boolean updated = updateGrade(arr, 4, 90);
        // function
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("Is there duplicate names? : " + hasDuplicateNames(arr));


        // 10) Append new student
        Student[] newStudents = appendStudent(arr, new Student(5, "Dina", 20, 80));
        System.out.println("== All Students ==");
        for (Student s : newStudents) System.out.println(s);

        // 11) 2D Classroom/Student Array
        //[
        // [student 1, student 2, student 3],
        // [student 1, student 2, student 3],
        // [student 1, student 2, student 3],
        // [student 1, student 2, student 3],
        // [student 1, student 2, student 3]
        // ]

        Student[][] classrooms = new Student[2][3];

        classrooms[0][0] = new Student(1, "Alice", 20, 15);
        classrooms[1][0] = new Student(2, "Bob", 21, 19);
        classrooms[0][1] = new Student(4, "Diana", 16, 8);
        classrooms[1][1] = new Student(5, "Ethan", 17, 14);
        classrooms[0][2] = new Student(7, "Chris", 13, 19);
        classrooms[1][2] = new Student(8, "Rex", 16, 15);
        // print all students in each class
        System.out.println("== All Students ==");
        for (int i = 0; i < classrooms.length; i++) {
            System.out.println("Classroom " + (i+1));
            for (Student student : classrooms[i]){
                System.out.println(student.getName());
            }
        }
        // Prints the Top Student in each class
        for (int j = 0; j < classrooms.length; j++) {
            sortByGradeDesc(classrooms[j]);
            System.out.println("Top student in classroom " + (j+1) + " is: ");
            System.out.println((classrooms[j][2]));

        }

    }
}

