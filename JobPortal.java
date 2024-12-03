import java.util.ArrayList;
import java.util.Scanner;

// Job class to store job details
class Job {
    private String title;
    private String description;
    private String company;
    private String location;

    public Job(String title, String description, String company, String location) {
        this.title = title;
        this.description = description;
        this.company = company;
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Job Title: " + title +
                "\nCompany: " + company +
                "\nLocation: " + location +
                "\nDescription: " + description + "\n";
    }
}

// JobPortal class
public class JobPortal {
    private ArrayList<Job> jobs = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    // Add a job to the portal
    public void addJob() {
        System.out.println("Enter Job Title: ");
        String title = scanner.nextLine();

        System.out.println("Enter Job Description: ");
        String description = scanner.nextLine();

        System.out.println("Enter Company Name: ");
        String company = scanner.nextLine();

        System.out.println("Enter Job Location: ");
        String location = scanner.nextLine();

        Job job = new Job(title, description, company, location);
        jobs.add(job);
        System.out.println("Job added successfully!");
    }

    // Search jobs by keyword
    public void searchJob() {
        System.out.println("Enter keyword to search jobs: ");
        String keyword = scanner.nextLine();

        System.out.println("Search Results:");
        for (Job job : jobs) {
            if (job.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    job.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(job);
            }
        }
    }

    // Apply for a job
    public void applyForJob() {
        System.out.println("Enter Job Title to apply: ");
        String title = scanner.nextLine();

        for (Job job : jobs) {
            if (job.getTitle().equalsIgnoreCase(title)) {
                System.out.println("You have successfully applied for the job: " + title);
                return;
            }
        }
        System.out.println("Job not found!");
    }

    // Display menu
    public void displayMenu() {
        int choice;
        do {
            System.out.println("\n=== Online Job Portal ===");
            System.out.println("1. Add Job");
            System.out.println("2. Search Job");
            System.out.println("3. Apply for Job");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addJob();
                    break;
                case 2:
                    searchJob();
                    break;
                case 3:
                    applyForJob();
                    break;
                case 4:
                    System.out.println("Exiting Job Portal...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        JobPortal portal = new JobPortal();
        portal.displayMenu();
    }
}
