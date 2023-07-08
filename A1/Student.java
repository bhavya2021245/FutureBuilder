package A1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

        private String name;
        private int rollno;
        private float cgpa;
        private String branch;
        public static int studentcounter;
        private String status="unplaced";
        private String offer="reject";
        private String application="not applied";
        ArrayList<Company> stravailablecompany=new ArrayList<>();
        ArrayList<Company>strappliedcompany=new ArrayList<>();
        ArrayList<Company>strplacedcompany=new ArrayList<>();
        ArrayList<Company>strofferedcompany=new ArrayList<>();
        ArrayList<Company>strnotappliedcompany=new ArrayList<>();
        float ctc=0;
        public static int no_of_placed_students=0;
        public static int no_of_blocked_students=0;
        Student(String name,int rollno,float cgpa,String branch){
            this.name=name;
            this.rollno=rollno;
            this.cgpa=cgpa;
            this.branch=branch;
        }
        public String getApplication() {
            return this.application;
        }
        public void setApplication(String application ) {
            this.application=application;
        }
        public String getName() {
            return this.name;
        }

        public String getOffer() {
            return this.offer;
        }
        public void setOffer(String offer) {
            this.offer=offer;
        }
        public String getStatus() {
            return this.status;
        }
        public void setStatus(String status) {
            this.status=status;
        }
        public int getRollno() {
            return this.rollno;
        }
        public float getCgpa() {
            return this.cgpa;
        }
        public void setCgpa(float cgpa) {
            this.cgpa=cgpa;
        }

        public String getBranch() {
            return this.branch;
        }
        public void Register_For_Placement_Drive() {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));
            studentcounter++;
        }

        public void Register_For_Company(Company cp) {
            if(this.cgpa>=cp.getCgpacriteria() && cp.getOfferedpackage()>=3*this.ctc) {
                System.out.println("Successfully Registered at"+cp);
                this.setApplication("applied");
                this.strappliedcompany.add(cp);

            }
        }
        public void blocked_students() {
            int flag=0;
            for(int i=0;i<Institue_Placement_cell.std.size();i++) {
                A1.Student std=Institue_Placement_cell.std.get(i);
                if(std.getStatus().equals("unplaced")) {
                    for(int j=0;j<std.stravailablecompany.size();j++) {
                        if(std.accept_reject_offer(stravailablecompany.get(i)).equals("accept")) {
                            flag=1;
                        }
                    }
                    if(flag==0) {
                        std.setStatus("blocked");
                        no_of_blocked_students++;
                    }
                }
            }
        }

        public void Get_All_Available_Companies() {

            if(this.getStatus().equals("blocked") || this.getOffer().equals("accept")) {
                System.out.println("unavailable");
            }
            else {
                for(int i=0;i<Institue_Placement_cell.cpy.size();i++) {
                    Company cmpy=Institue_Placement_cell.cpy.get(i);
                    if(this.getCgpa()>=cmpy.getCgpacriteria() && 3*cmpy.getOfferedpackage()>=this.ctc) {

                        this.stravailablecompany.add(cmpy);
                    }
                }
                if(this.stravailablecompany.size()!=0) {
                    System.out.println("List of all available companies");
                    for(int i=0;i<this.stravailablecompany.size();i++) {
                        Company cmpy=Institue_Placement_cell.cpy.get(i);
                        System.out.println("company name"+cmpy.getName());
                        System.out.println("company role offering"+cmpy.getRole());
                        System.out.println("company package"+cmpy.getOfferedpackage());
                        System.out.println("company cgpa criteria"+cmpy.getCgpacriteria());
                    }
                }
            }
        }

        public void Get_Current_Status() {
            System.out.print(getStatus());
            if(this.getStatus().equals("placed")) {
                for(int i=0;i<this.strplacedcompany.size();i++) {
                    Company cp=strplacedcompany.get(i);
                    System.out.print("Name of the company"+cp.getName());
                    System.out.println("ctc offered by the company"+cp.getOfferedpackage());
                    System.out.println("role of the student"+cp.getRole());
                    System.out.println("cgpa criteria of the company"+cp.getCgpacriteria());
                }
            }
        }
        public void Update_Cpga(Institue_Placement_cell plc) {
            plc.upcgpa(this,this.cgpa);
        }
        public String accept_reject_offer(Company cp) {
            System.out.println("do you want to accept the offer at "+cp.getName());
            Scanner sc=new Scanner(System.in);
            String offer=sc.next();
            if(offer.equals("accept")) {
                setStatus("Placed");
                no_of_placed_students++;
                setOffer("accept");
                strplacedcompany.add(cp);
                String st="accept";
                ctc=cp.getOfferedpackage();
                return st;

            }
            setOffer("reject");
            setStatus("unplaced");
            return "reject";
        }
        public void appliedcompanies(A1.Student st) {
            for(int k=0;k<st.stravailablecompany.size();k++) {
                Company cpy=stravailablecompany.get(k);
                if(st.apply_offer(cpy).equals("apply")) {
                    st.strappliedcompany.add(cpy);
                }
                else {
                    st.strnotappliedcompany.add(cpy);
                }
            }
        }
        public String apply_offer(Company cp) {
            System.out.println("do you want to apply to this company(apply/not to apply)");
            Scanner sc=new Scanner(System.in);
            String apply=sc.next();
            if(apply.equals("apply")) {
                return "apply";
            }
            return "not to apply";
        }

    }

