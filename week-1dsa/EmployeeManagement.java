class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return employeeId + " - " + name + " - " + position + " - ₹" + salary;
    }
}

public class EmployeeManagement {
    static Employee[] employees = new Employee[100];
    static int count = 0;

    public static void addEmployee(Employee e) {
        employees[count++] = e;
    }

    public static Employee search(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id)
                return employees[i];
        }
        return null;
    }

    public static void delete(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--count] = null;
                break;
            }
        }
    }

    public static void traverse() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        addEmployee(new Employee(1, "Arun", "Manager", 70000));
        addEmployee(new Employee(2, "Bhavya", "Developer", 50000));
        traverse();

        System.out.println("Search Result: " + search(1));
        delete(1);
        System.out.println("After Deletion:");
        traverse();
    }
}
