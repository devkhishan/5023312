/*
Theory Questions :
Explain the different types of linked lists (Singly Linked List, Doubly Linked List).

Answer :
Singly Linked List - A linked list in which each node contains data and reference to the next Node.
Doubly Linked List - A linked list in which each node contains data and reference to both previous and next Node.
 */

class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId +
                "\nTask Name: " + taskName +
                "\nStatus: " + status;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskLinkedList {
    private Node head;

    public TaskLinkedList() {
        this.head = null;
    }

    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public Task searchTask(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(new Task(1, "Design Database", "Pending"));
        taskList.addTask(new Task(2, "Develop API", "In Progress"));
        taskList.addTask(new Task(3, "Test Application", "Pending"));

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task with ID 2:");
        Task task = taskList.searchTask(2);
        if (task != null) {
            System.out.println(task);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task with ID 2");
        taskList.deleteTask(2);

        System.out.println("\nAll Tasks after deletion:");
        taskList.traverseTasks();
    }
}