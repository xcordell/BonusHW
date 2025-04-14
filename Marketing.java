package selfMadePackage;

import java.util.ArrayList;
import java.util.List;
	

public class Marketing extends Person{

			private String position;
			private String department;

			public static List<Marketing> marketings = new ArrayList<>();
			
			private Marketing(String firstName, String lastName, String position, String department, int yearsOfService,  int salary, boolean teamLead) {
			super(firstName, lastName, yearsOfService, salary, teamLead);
				this.position = position;
				this.department = department;
				
			}
			
			
			//WATCH NAME CASING!!!!!
			public static Marketing createmarketings(String firstName, String lastName, String position, String department, int yearsOfService,  int salary, boolean teamLead) {
		        Marketing marketing = new Marketing(firstName, lastName, position, department, salary, yearsOfService, teamLead);
		        marketings.add(marketing);        
		        return marketing;
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


			public static List<Marketing> getMarketing() {
				return marketings;
			}


			public static void setMarketing(List<Marketing> marketings) {
				Marketing.marketings = marketings;
			}

			@Override
		    public String toString() {
		        return super.toString() + " | Department: " + department + "| Position: " + position + " | Salary: $" + salary + " | Years of Service: " + yearsOfService + " | Team Lead: " + teamLead;
		    }
			
			public static int countTeamLeads() {
				return (int) marketings.stream().filter(e -> e.teamLead).count(); //keep parenthesis for (int) have to cast
			}


			public static String lowestPaid() {   
				Person lowest = marketings.get(0);
				for (Person p: marketings) {
					if (p.getSalary() < lowest.getSalary()) {
						lowest = p;
					}
					}
				return "Name: " + lowest.getFirstName() + " " + lowest.getLastName() + "\nSalary: $" + lowest.getSalary();
				}
			
			@Override
			public double averageSalaryByDepartment() {
				if (marketings.isEmpty()) return 0.0; //Failsafe if no marketing
				
				int marketingAverage = 0;
				for (Marketing m : marketings) {
					marketingAverage += m.getSalary();
				}
				return (double) marketingAverage / marketings.size();
			}
			
			
			
		
}
		



