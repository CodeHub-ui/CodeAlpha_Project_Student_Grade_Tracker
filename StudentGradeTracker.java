import java.util.*; // Importing the utility package for Scanner and ArrayList

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Scanner for user input
        ArrayList<Integer> grades = new ArrayList<>(); // List to store grades
        String choice; // Variable to store user's choice for continuing input

        System.out.println("Welcome to the Student Grade Tracker!"); // Greeting message

        // Input grades
        do {
            System.out.print("Enter a student's grade (0-100): ");
            int grade = sc.nextInt(); // Reading the grade input

            // Validating the grade and adding it to the list if valid
            if (grade >= 0 && grade <= 100) {
                grades.add(grade);
            } else {
                System.out.println("Invalid grade! Please enter a number between 0 and 100.");
            }

            // Asking the user if they want to input another grade
            System.out.print("Do you want to enter another grade? (yes/no): ");
            choice = sc.next().toLowerCase(); // Converting the input to lowercase for uniform comparison
        } while (choice.equals("yes")); // Loop continues while the user inputs "yes"

        // Checking if any grades were entered
        if (grades.isEmpty()) {
            System.out.println("No grades entered."); // Message if no grades were added
        } else {
            // Calculate and display statistics if grades are available
            int highest = findHighest(grades); // Finding the highest grade
            int lowest = findLowest(grades); // Finding the lowest grade
            double average = calculateAverage(grades); // Calculating the average grade

            // Displaying the results
            System.out.println("\nGrade Statistics:");
            System.out.println("Total grades entered: " + grades.size());
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
            System.out.printf("Average grade: %.2f%n", average); // Formatting the average to two decimal places
        }
    }

    /**
     * Method to find the highest grade
     * @param grades - List of grades
     * @return highest grade in the list
     */
    public static int findHighest(ArrayList<Integer> grades) {
        int highest = grades.get(0); // Initialize with the first grade
        for (int grade : grades) {
            if (grade > highest) { // Update highest if a larger grade is found
                highest = grade;
            }
        }
        return highest;
    }

    /**
     * Method to find the lowest grade
     * @param grades - List of grades
     * @return lowest grade in the list
     */
    public static int findLowest(ArrayList<Integer> grades) {
        int lowest = grades.get(0); // Initialize with the first grade
        for (int grade : grades) {
            if (grade < lowest) { // Update lowest if a smaller grade is found
                lowest = grade;
            }
        }
        return lowest;
    }

    /**
     * Method to calculate the average grade
     * @param grades - List of grades
     * @return average of the grades
     */
    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0; // Variable to store the sum of grades
        for (int grade : grades) {
            sum += grade; // Adding each grade to the sum
        }
        return (double) sum / grades.size(); // Calculating and returning the average
    }
}
