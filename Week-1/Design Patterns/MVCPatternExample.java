class Student
{
    String name;
    int id;
    char grade;

    public Student(String name, int id, char grade)
    {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setGrade(char grade)
    {
        this.grade = grade;
    }

    public char getGrade()
    {
        return grade;
    }
}

class StudentView
{
    public void displayStudentDetails(String name, int id, char grade)
    {
        System.out.println("Student");
        System.out.println("Name : "+name);
        System.out.println("ID : "+id);
        System.out.println("Grade : "+grade);
    }
}

class StudentController
{
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view)
    {
        this.model = model;
        this.view = view;
    }

    public String getStudentName()
    {
        return model.getName();
    }

    public void setStudentName(String name)
    {
        model.setName(name);
    }

    public int getStudentId()
    {
        return model.getId();
    }

    public void setStudentId(int id)
    {
        model.setId(id);
    }

    public char getStudentGrade()
    {
        return model.getGrade();
    }

    public void setStudentGrade(char ch)
    {
        model.setGrade(ch);
    }

    public void updateView()
    {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
public class MVCPatternExample
{
    public static void main(String[] args)
    {
        Student model = new Student("Dev",11,'O');
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model,view);

        controller.updateView();

        controller.setStudentName("Dinesh");
        controller.setStudentGrade('A');
        controller.updateView();

    }
}

