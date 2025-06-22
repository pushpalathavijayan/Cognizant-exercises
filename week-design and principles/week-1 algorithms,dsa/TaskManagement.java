class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return taskId + " - " + taskName + " - " + status;
    }
}

public class TaskManagement {
    static Task head = null;

    public static void addTask(Task t) {
        if (head == null) head = t;
        else {
            Task temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = t;
        }
    }

    public static Task search(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    public static void delete(int id) {
        if (head == null) return;
        if (head.taskId == id) {
            head = head.next;
            return;
        }
        Task temp = head;
        while (temp.next != null && temp.next.taskId != id) temp = temp.next;
        if (temp.next != null) temp.next = temp.next.next;
    }

    public static void traverse() {
        Task temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addTask(new Task(1, "Write Report", "Pending"));
        addTask(new Task(2, "Code Review", "Completed"));
        traverse();

        System.out.println("Search Result: " + search(1));
        delete(1);
        System.out.println("After Deletion:");
        traverse();
    }
}
