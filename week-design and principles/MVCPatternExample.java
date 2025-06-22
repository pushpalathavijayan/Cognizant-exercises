// MVCPatternExample.java

// Step 2: Model Class
class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}

// Step 3: View Class
class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("=== Student Details ===");
        System.out.println("Name  : " + name);
        System.out.println("ID    : " + id);
        System.out.println("Grade : " + grade);
        System.out.println("========================\n");
    }
}

// Step 4: Controller Class
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    // Setters (updating model)
    public void setStudentName(String name) {
        model.setName(name);
    }

    public void setStudentId(String id) {
        model.setId(id);
    }

    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }

    // Getters (reading model)
    public String getStudentName() {
        return model.getName();
    }

    public String getStudentId() {
        return model.getId();
    }

    public String getStudentGrade() {
        return model.getGrade();
    }

    // Update the view with model's data
    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}

// Step 5: Test the MVC Pattern
public class MVCPatternExample {
    public static void main(String[] args) {
        // Create Model and View
        Student student = new Student("Aarthi", "S102", "A");
        StudentView view = new StudentView();

        // Create Controller
        StudentController controller = new StudentController(student, view);

        // Display initial data
        controller.updateView();

        // Update model data via controller
        controller.setStudentName("Akii");
        controller.setStudentGrade("A+");

        // Display updated data
        controller.updateView();
    }
}
