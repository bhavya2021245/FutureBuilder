package A1;

import java.util.ArrayList;
import java.util.Scanner;

public class Company{
    private String name;
    private String role;
    private float offeredpackage;

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", offeredpackage=" + offeredpackage +
                ", cgpacriteria=" + cgpacriteria +
                '}';
    }

    public static int companycounter;
    private float cgpacriteria;
    ArrayList<Student> strofferedstudents=new ArrayList<>();
    ArrayList<Student>strselectedstudents=new ArrayList<>();
    Company(String name,String role,float ctc,float cgpa){
        this.name=name;
        this.role=role;
        this.offeredpackage=ctc;
        this.cgpacriteria=cgpa;
    }
    public String getName() {
        return this.name;
    }
    public String getRole() {
        return this.role;
    }
    public float getOfferedpackage() {
        return this.offeredpackage;
    }
    public float getCgpacriteria() {
        return this.cgpacriteria;
    }
    public void setRole(String role) {
        this.role=role;
    }
    public void setOfferedpackage(float offeredpackage) {
        this.offeredpackage=offeredpackage;
    }
    public void setCgpacriteria(float cgpacriteria) {
        this.cgpacriteria=cgpacriteria;
    }

    public void Register_to_Institute_Drive() {

        companycounter++;
    }
    public void Get_Offered_Students(Company cp){
        for(int i=0;i<Institue_Placement_cell.std.size();i++) {
            Student st=Institue_Placement_cell.std.get(i);
            if(st.getCgpa()>=cp.getCgpacriteria() && (st.getStatus().equals("unplaced"))){
                cp.strofferedstudents.add(st);
                st.strofferedcompany.add(cp);
            }
        }
    }
    public void Get_Selected_students() {
        for(int i=0;i<this.strofferedstudents.size();i++) {
            Student st=this.strofferedstudents.get(i);
            if(st.getStatus().equals("unplaced") && st.getOffer().equals("accept")) {
                System.out.println("Name: "+st.getName());
                System.out.println("Rollno: "+st.getRollno());
                System.out.println("CGPA: "+st.getCgpa());
                System.out.println("Branch: "+st.getBranch());
                this.strselectedstudents.add(st);
            }
        }
    }
    public void update_role_package_cgpa_criteria() {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the updated role");
        String role=sc.nextLine();
        float offeredpackage=sc.nextFloat();
        float cgpacriteria =sc.nextFloat();
        setRole(role);
        setOfferedpackage(offeredpackage);
        setCgpacriteria(cgpacriteria);
    }}