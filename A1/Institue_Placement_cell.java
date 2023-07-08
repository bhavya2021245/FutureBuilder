package A1;

import java.util.ArrayList;
import java.util.Scanner;

public class Institue_Placement_cell{
    static ArrayList<Student>std=new ArrayList<>();
    static ArrayList<Company> cpy=new ArrayList<>();
    Student st;
    public void upcgpa(Student student,float cgpa) {

        student.setCgpa(cgpa);
    }

    public void Open_Student_Registrations() {
        System.out.println("Fill in the details:-");
        System.out.println("1) Set the Opening time for Student registrations");
        System.out.println("2) Set the Closing time for Student registrations");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String str1=sc.nextLine();
        System.out.println(str);
        System.out.println(str1);
    }
    public void Open_Company_Registrations() {
        System.out.println("Fill in the details:-");
        System.out.println("1) Set the Opening time for company registrations");
        System.out.println("2) Set the Closing time for company registrations");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        String str1=sc.nextLine();
        System.out.println(str);
        System.out.println(str1);

    }
    public void Get_No_Of_Student_Registrations() {
        System.out.println(Student.studentcounter);
    }
    public void Get_No_of_Company_Regaistrations() {
        System.out.println(Company.companycounter);
    }
    public void Get_Number_of_Placed_UnPlaced_Blocked_Students() {
        System.out.println("no of placed students"+Student.no_of_placed_students);
        System.out.println("no of blocked students"+Student.no_of_blocked_students);
        int no_of_unplaced_students=Student.studentcounter-(Student.no_of_blocked_students+Student.no_of_placed_students);
        System.out.println("no of unplaced students"+no_of_unplaced_students);
    }
    public void Get_Student_Details(String name ,int rollno) {

        for(int i=0;i<Institue_Placement_cell.std.size();i++) {
            Student st=Institue_Placement_cell.std.get(i);
            if(st.getName().equals(name) && st.getRollno()==rollno) {
                st.getStatus();
                for(int j=0;j<st.strappliedcompany.size();j++) {
                    System.out.println("Applied comapnies"+st.strappliedcompany.get(j));
                }
                for(int k=0;k<st.strnotappliedcompany.size();k++) {
                    System.out.println(st.strnotappliedcompany.get(k));
                }
                for(int m=0;m<st.strofferedcompany.size();m++) {
                    System.out.println(st.strofferedcompany.get(m));
                }
            }
        }
    }
    public void Get_Company_Details(String name) {
        for(int i=0;i<Institue_Placement_cell.cpy.size();i++) {
            Company cp=Institue_Placement_cell.cpy.get(i);
            if(cp.getName().equals(name)) {
                System.out.println(cp.getCgpacriteria());
                System.out.println(cp.getRole());
                System.out.println(cp.getOfferedpackage());
                System.out.println(cp.getName());
                for(int j=0;j<cp.strselectedstudents.size();j++) {
                    Student st=cp.strselectedstudents.get(i);
                    System.out.println("Name of student selected"+st.getName());
                    System.out.println("roll no of student selected"+st.getRollno());
                }
            }
        }

    }
    public void Get_Average_Package() {
        float sum=0;
        int m=0;
        for(int i=0;i<cpy.size();i++) {
            Company cp=cpy.get(i);
            for(int j=0;j<cp.strselectedstudents.size();j++) {
                m=m+cp.strselectedstudents.size();
                Student st=cp.strselectedstudents.get(j);
                for(int k=0;k<st.strplacedcompany.size();k++) {
                    Company c=st.strplacedcompany.get(k);
                    sum=sum+c.getOfferedpackage();
                }
            }
        }
        float avg=sum/m;
        System.out.println("the average package offered to the students of the institute"+avg);
    }
    public void Get_Company_Process_Results(String name) {
        for(int i=0;i<cpy.size();i++) {
            Company cp=cpy.get(i);
            if(cp.getName().equals(name)) {
                cp.Get_Selected_students();
            }
        }
    }
}