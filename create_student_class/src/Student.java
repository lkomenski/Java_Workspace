import java.util.Objects;

public class Student {

    private String name;
    private int id;
    private double gpa;
    private String major;

    public Student(String name, int id, double gpa, String major) {
        this.name = formatName(name);
        this.id = id;
        this.gpa = capGpa(gpa);
        this.major = defaultMajor(major);
    }

    // Getter example
    public String getName() {
        return name;
    }

    // Setter example
    public void setGpa(double gpa) {
        this.gpa = capGpa(gpa);
    }

    // Helper methods for validation and formatting
    // Formats the name to ensure it is at least 2 characters long, else defaults to "Unknown"
    private String formatName(String name) {
        if (name == null) {
            return "Unknown";
        }
        String cleaned = name.trim();
        if (cleaned.length() < 2) {
            return "Unknown";
        }
        return cleaned;
    }
    // Caps the GPA between 0.0 and 4.0
    private double capGpa(double gpa) {
        if (gpa < 0.0) {
            return 0.0;
        }
        if (gpa > 4.0) {
            return 4.0;
        }
        return gpa;
    }
    // Defaults the major to "Undeclared" if null or empty
    private String defaultMajor(String major) {
        if (major == null) {
            return "Undeclared";
        }
        String cleaned = major.trim();
        if (cleaned.isEmpty()) {
            return "Undeclared";
        }
        return cleaned;
    }

    // toString method for easy representation
    @Override
    public String toString() {
        return "Student[name=" + name + ", id=" + id + ", gpa=" + gpa + ", major=" + major + "]";
    }

    // Equals and hashCode based on id
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Student)) {
            return false;
        }
        Student other = (Student) obj;

        return this.id == other.id &&
            this.name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name.toLowerCase());
    }
}
