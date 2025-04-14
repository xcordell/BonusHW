package selfMadePackage;

import java.util.ArrayList;
import java.util.List;
	

public class Engineering extends Person{

			private String position;
			private String department;

			public static List<Engineering> engineers = new ArrayList<>();
			
			private Engineering(String firstName, String lastName, String position, String department, int yearsOfService,  int salary, boolean teamLead) {
			super(firstName, lastName, yearsOfService, salary, teamLead);
				this.position = position;
				this.department = department;
				
			}
			
			
			//WATCH NAME CASING!!!!!
			public static Engineering createengineers(String firstName, String lastName, String position, String department,int yearsOfService, int salary, boolean teamLead) {
		        Engineering engineer = new Engineering(firstName, lastName, department, position, salary, yearsOfService, teamLead);
		        engineers.add(engineer);        
		        return engineer;
		    }
				
			
			public String getPosition() {
				return position;
			}


			public void setPosition(String position) {
				this.position = position;
			}


			public String getDepartment() {
				return department;
			}


			public void setDepartment(String department) {
				this.department = department;
			}


			public static List<Engineering> getEngineering() {
				return engineers;
			}


			public static void setEngineering(List<Engineering> engineerings) {
				Engineering.engineers = engineerings;
			}

			@Override
		    public String toString() {
		        return super.toString() + " | Department: " + department + "| Position: " + position + " | Salary: $" + salary + " | Years of Service: " + yearsOfService + " | Team Lead: " + teamLead;
		    }
			
			public static int countTeamLeads() {
				return (int) engineers.stream().filter(e -> e.teamLead).count(); //keep parenthesis for (int) have to cast
			}


			public static String lowestPaid() {   
				Person lowest = engineers.get(0);
				for (Person p: engineers) {
					if (p.getSalary() < lowest.getSalary()) {
						lowest = p;
					}
					}
				return "Name: " + lowest.getFirstName() + " " + lowest.getLastName() + "\nSalary: $" + lowest.getSalary();
				}


			@Override
			public double averageSalaryByDepartment() {
				if (engineers.isEmpty()) return 0.0; //Failsafe if no marketing
				
				int EngineeringAverage = 0;
				for (Engineering m : engineers) {
					EngineeringAverage += m.getSalary();
				}
				return (double) EngineeringAverage / engineers.size();
			}
			
}
			
			
			

			
		

