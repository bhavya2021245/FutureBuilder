package A1;
import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class Hello
{
    public static void main(String[] args) {


        while(true) {
            System.out.println("Welcome to FutureBuilder:");
            System.out.println("1) Enter the Application");
            System.out.println("2) Exit the Application");
            Scanner sc=new Scanner(System.in);

            int opt=sc.nextInt();
            if(opt==1) {
                while(true) {

                    System.out.println("Choose The mode you want to Enter in:-");
                    System.out.println("1) Enter as Student Mode");
                    System.out.println("2) Enter as Company Mode");
                    System.out.println("3) Enter as Placement Cell Mode");
                    System.out.println("4) Return To Main Application");
                    int opt1=sc.nextInt();
                    if(opt1==1) {
                        while(true){
                            System.out.println("Choose the Student Query to perform-");
                            System.out.println("1) Enter as a Student(Give Student Name, and Roll No.)");
                            System.out.println("2) Add students");
                            System.out.println("3) Back");
                            int opt2=sc.nextInt();
                            if(opt2==1) {
                                String studentname=sc.next();
                                int studentrollno=sc.nextInt();
                                while(true){
                                    System.out.println("welcome "+studentname);
                                    System.out.println("1) Register For Placement Drive");
                                    System.out.println("2) Register For Company");
                                    System.out.println("3) Get All available companies");
                                    System.out.println("4) Get Current Status");
                                    System.out.println("5) Update CGPA");
                                    System.out.println("6) Accept offer");
                                    System.out.println("7) Reject offer");
                                    System.out.println("8) Back");
                                    int opt21=sc.nextInt();
                                    if(opt21==1) {
                                        for(int i=0;i<Institue_Placement_cell.std.size();i++) {
                                            Student std=Institue_Placement_cell.std.get(i);
                                            if(std.getName().equals(studentname) && std.getRollno()==studentrollno) {
                                                std.Register_For_Placement_Drive();
                                                System.out.println(std.getName()+"Registered for the Placement Drive at IIITD!!!!");
                                                System.out.println("Your details are:");
                                                System.out.println("Name: "+std.getName());
                                                System.out.println("Rollno: "+std.getRollno());
                                                System.out.println("CGPA: "+std.getCgpa());
                                                System.out.println("Branch: "+std.getBranch());
                                            }
                                        }
                                    }
                                    else if(opt21==2) {

                                        for(int j=0;j<Institue_Placement_cell.std.size();j++) {
                                            Student std=Institue_Placement_cell.std.get(j);
                                            if(std.getName().equals(studentname) && std.getRollno()==studentrollno) {
                                                System.out.println("enter the company you want to apply to");
                                                String name=sc.next();
                                                for(int k=0;k<Institue_Placement_cell.cpy.size();k++) {
                                                    Company cp=Institue_Placement_cell.cpy.get(k);
                                                    if(cp.getName().equals(name)) {
                                                        std.Register_For_Company(cp);

                                                    }
                                                }

                                            }
                                        }
                                    }

                                    else if(opt21==3) {

                                        for(int i=0;i<Institue_Placement_cell.std.size();i++) {
                                            Student st=Institue_Placement_cell.std.get(i);
                                            if(st.getName().equals(studentname) && st.getRollno()==studentrollno) {
                                                st.Get_All_Available_Companies();
                                            }
                                        }
                                    }
                                    else if(opt21==4) {
                                        for(int i=0;i<Institue_Placement_cell.std.size();i++) {
                                            Student std=Institue_Placement_cell.std.get(i);
                                            if(std.getName().equals(studentname) && std.getRollno()==studentrollno) {
                                                std.Get_Current_Status();}
                                        }
                                    }
                                    else if(opt21==5) {
                                        for(int i=0;i<Institue_Placement_cell.std.size();i++) {
                                            Student std=Institue_Placement_cell.std.get(i);
                                            Institue_Placement_cell iiitd=new Institue_Placement_cell();
                                            if(std.getName().equals(studentname) && std.getRollno()==studentrollno) {
                                                std.Update_Cpga(iiitd);}
                                        }
                                    }
                                    else if(opt21==6) {
                                        for(int i=0;i<Institue_Placement_cell.std.size();i++) {
                                            Student std=Institue_Placement_cell.std.get(i);
                                            if(std.getName().equals(studentname) && std.getRollno()==studentrollno) {
                                                for(int j=0;j<std.stravailablecompany.size();j++) {
                                                    std.accept_reject_offer(std.stravailablecompany.get(j));

                                                }
                                            }
                                        }
                                    }
                                    else if(opt21==7) {
                                        for(int i=0;i<Institue_Placement_cell.std.size();i++) {
                                            Student std=Institue_Placement_cell.std.get(i);
                                            if(std.getName().equals(studentname) && std.getRollno()==studentrollno) {
                                                for(int j=0;j<std.stravailablecompany.size();j++) {
                                                    std.accept_reject_offer(std.stravailablecompany.get(j));

                                                }
                                            }
                                        }
                                    }
                                    else if(opt21==8) {
                                        break;
                                    }


                                }

                            }
                            else if(opt2==2) {
                                System.out.println("no of students to add");
                                int no_of_students=sc.nextInt();
                                System.out.println("Please add students Name, Roll No, CGPA, Branch(in order):");

                                for(int i=0;i<no_of_students;i++) {
                                    System.out.println("enter the name");
                                    String name=sc.next();
                                    System.out.println("enter the rollno");
                                    int rollno=sc.nextInt();
                                    System.out.println("Enter the cgpa");
                                    float cgpa=sc.nextFloat();
                                    System.out.println("enter the branch");
                                    String branch=sc.next();
                                    Student st=new Student(name,rollno,cgpa,branch);
                                    Institue_Placement_cell.std.add(st);
                                }
                            }
                            else if(opt2==3) {
                                break;
                            }
                        }
                    }
                    else if(opt1==2) {
                        while(true) {
                            System.out.println("Choose the Company Query to perform-");
                            System.out.println("1) Add Company and Details");
                            System.out.println("2) Choose Company");
                            System.out.println("3) Get Available Companies");
                            System.out.println("4) Back");
                            Scanner st=new Scanner(System.in);
                            int opt3=sc.nextInt();
                            if(opt3==1) {
                                System.out.println("enter the company name");
                                String companyname=sc.next();
                                System.out.println("enter the company role");
                                String companyrole=sc.next();
                                System.out.println("enter the company ctc");
                                float companyctc=st.nextFloat();
                                System.out.println("enter the company cgpa");
                                float companycgpa=st.nextFloat();
                                Company cmpy=new Company(companyname,companyrole,companyctc,companycgpa);
                                Institue_Placement_cell.cpy.add(cmpy);
                                System.out.println("Name: "+cmpy.getName());
                                System.out.println("Role offered: "+cmpy.getRole());
                                System.out.println("Offered package: "+cmpy.getOfferedpackage());
                                System.out.println("Cgpa Requirement: "+cmpy.getCgpacriteria());
                            }
                            else if(opt3==2) {
                                System.out.println("Choose To enter into mode of Available Companies:-");
                                String companyname=sc.next();

                                while(true) {
                                    System.out.println("welcome"+companyname);
                                    System.out.println("1) Update Role");
                                    System.out.println("2) Update Package");
                                    System.out.println("3) Update CGPA criteria");
                                    System.out.println("4) Register To Institute Drive");
                                    System.out.println("5) Back");
                                    int opt31=sc.nextInt();
                                    if(opt31==1) {
                                        System.out.println("Enter the updated role");
                                        String updatedrole=sc.next();
                                        for(int i=0;i<Institue_Placement_cell.cpy.size();i++) {
                                            Company cmpy=Institue_Placement_cell.cpy.get(i);
                                            if(cmpy.getRole().equals(updatedrole)) {
                                                cmpy.setRole(updatedrole);
                                            }
                                        }
                                    }
                                    else if(opt31==2) {
                                        System.out.println("Enter the updated package");
                                        float updatedpackage=sc.nextFloat();
                                        for(int i=0;i<Institue_Placement_cell.cpy.size();i++) {
                                            Company cmpy=Institue_Placement_cell.cpy.get(i);
                                            if(cmpy.getOfferedpackage()==updatedpackage) {
                                                cmpy.setOfferedpackage(updatedpackage);
                                            }
                                        }

                                    }
                                    else if(opt31==3) {
                                        System.out.println("Enter the updated cgpa criteria");
                                        float updatedcgpacriteria=sc.nextFloat();
                                        for(int i=0;i<Institue_Placement_cell.cpy.size();i++) {
                                            Company cmpy=Institue_Placement_cell.cpy.get(i);
                                            if(cmpy.getCgpacriteria()==updatedcgpacriteria) {
                                                cmpy.setCgpacriteria(updatedcgpacriteria);
                                            }
                                        }
                                    }
                                    else if(opt31==4) {
                                        for(int i=0;i<Institue_Placement_cell.cpy.size();i++) {
                                            Company cmpy=Institue_Placement_cell.cpy.get(i);
                                            if(cmpy.getName().equals(companyname)){
                                                cmpy.Register_to_Institute_Drive();
                                                System.out.println("REGISTERED");
                                            }}

                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                                        LocalDateTime now = LocalDateTime.now();
                                        System.out.println(dtf.format(now));
                                    }
                                    else {
                                        break;
                                    }

                                }

                            }
                            else if(opt3==3) {
                                for(int i=0;i<Institue_Placement_cell.cpy.size();i++) {
                                    Company cmpy=Institue_Placement_cell.cpy.get(i);
                                    System.out.println(cmpy);
                                }
                            }
                            else if(opt3==4) {
                                break;
                            }
                        }
                    }
                    else if(opt1==3) {
                        while(true){
                            System.out.println("Welcome to Placement Cell");
                            System.out.println("1) Open Student Registrations");
                            System.out.println("2) Open Company Registrations");
                            System.out.println("3) Get Number of Student Registrations");
                            System.out.println("4) Get Number of Company Registrations");
                            System.out.println("5) Get Number of Offered/Unoffered/Blocked Students");
                            System.out.println("6) Get Student Details");
                            System.out.println("7) Get Company Details");
                            System.out.println("8) Get Average Package");
                            System.out.println("9) Get Company Process Results");
                            System.out.println("10) Back");
                            Institue_Placement_cell iiitd=new Institue_Placement_cell();
                            int opt4=sc.nextInt();
                            if(opt4==1) {
                                iiitd.Open_Student_Registrations();
                            }
                            else if(opt4==2) {
                                iiitd.Open_Company_Registrations();
                            }
                            else if(opt4==3) {
                                iiitd.Get_No_Of_Student_Registrations();
                            }

                            else if(opt4==4) {
                                iiitd.Get_No_of_Company_Regaistrations();
                            }
                            else if(opt4==5) {
                                iiitd.Get_Number_of_Placed_UnPlaced_Blocked_Students();
                            }
                            else if(opt4==6) {
                                System.out.print("enter the name");
                                String name=sc.next();
                                System.out.println("enter the rollno");
                                int rollno=sc.nextInt();
                                iiitd.Get_Student_Details(name,rollno);
                            }
                            else if(opt4==7) {
                                System.out.println("enter the name");
                                String name=sc.next();
                                iiitd.Get_Company_Details(name);
                            }
                            else if(opt4==8) {
                                iiitd.Get_Average_Package();
                            }
                            else if(opt4==9) {
                                System.out.println("enter the company name to get its results");
                                String name=sc.next();
                                iiitd.Get_Company_Process_Results(name);
                            }
                            else {
                                break;
                            }
                        }
                    }

                    else if(opt1==4) {
                        break;
                    }
                }}
            else if(opt==2) {
                System.out.println("Thanks For Using FutureBuilder!!!!!!");
                break;
            }

        }
    }
}
