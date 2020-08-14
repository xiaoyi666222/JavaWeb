import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate)
                context.getBean("studentJDBCTemplate");
        //增
//        System.out.println("------Records Creation--------" );
//        studentJDBCTemplate.create("Chen", 16);
//        studentJDBCTemplate.create("Nuha", 2);
//        studentJDBCTemplate.create("Ayan", 15);
//
//        for(int i=0;i<5;i++){
//            studentJDBCTemplate.create("Chen", 16);
//        }



//        //删
//        System.out.println("----Delete Record with ID = 2 -----" );
//        studentJDBCTemplate.delete(2);
//
//        System.out.println("------Listing Multiple Records--------" );
//        List<Student> students = studentJDBCTemplate.listStudents();
//
//        for (Student record : students) {
//            System.out.print("ID : " + record.getId() );
//            System.out.print(", Name : " + record.getName() );
//            System.out.println(", Age : " + record.getAge());
//        }



        //改
//        System.out.println("----Updating Record with ID = 2 -----" );
//        studentJDBCTemplate.update(2, 20);
//
//        //查，根据id查询。
//        System.out.println("----Listing Record with ID = 2 -----" );
//        Student student = studentJDBCTemplate.getStudent(2);
//        System.out.print("ID : " + student.getId() );
//        System.out.print(", Name : " + student.getName() );
//        System.out.println(", Age : " + student.getAge());





        //查
        System.out.println("------Listing Multiple Records--------" );
        List<Student> students = studentJDBCTemplate.listStudents();

        for (Student record : students) {
            System.out.print("ID : " + record.getId() );
            System.out.print(", Name : " + record.getName() );
            System.out.println(", Age : " + record.getAge());
        }
    }
}
