import java.util.*;

class Student {
    private int id;
    private String name;
    private double cgpa;

    // Constructor
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {
        // Custom comparator for priority queue
        PriorityQueue<Student> pq = new PriorityQueue<>(
            (s1, s2) -> {
                // 1. Higher CGPA first
                if (Double.compare(s2.getCGPA(), s1.getCGPA())!= 0) {
                    return Double.compare(s2.getCGPA(), s1.getCGPA());
                }
                // 2. Name ascending
                int nameCompare = s1.getName().compareTo(s2.getName());
                if (nameCompare!= 0) {
                    return nameCompare;
                }
                // 3. ID ascending
                return Integer.compare(s1.getID(), s2.getID());
            }
        );

        // Process events
        for (String event : events) {
            String[] parts = event.split(" ");
            if (parts[0].equals("ENTER")) {
                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);
                pq.offer(new Student(id, name, cgpa));
            } else if (parts[0].equals("SERVED")) {
                if (!pq.isEmpty()) {
                    pq.poll(); // remove highest priority student
                }
            }
        }

        // Extract remaining students in priority order
        List<Student> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        return result;
    }
}

// This main is for local testing. HackerRank provides its own.
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- > 0) {
            events.add(scan.nextLine());
        }

        Priorities priorities = new Priorities();
        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
        scan.close();
    }
}
