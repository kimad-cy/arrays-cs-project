package samplearrays;

public class CourseNumbersArray {
    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        int[] updatedCourses = new int[registeredCourses.length];
        System.arraycopy(registeredCourses, 0, updatedCourses, 0, registeredCourses.length);
        int newCourse = 3010;
        updatedCourses[registeredCourses.length-1] = newCourse;
        for (int course: updatedCourses){
            System.out.println(course);
        }
        int courseToFind = 2080;
        for (int course: updatedCourses){
            if (course == courseToFind){
                System.out.println("Course "+courseToFind + " found");
            }
        }
    }
}
