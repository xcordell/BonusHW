package selfMadePackage;

import java.util.ArrayList;
import java.util.List;
	

public class Finance extends Person{

			private String position;
			private String department;

			public static List<Finance> finances = new ArrayList<>();
			
			private Finance(String firstName, String lastName, String position, String department, int yearsOfService,  int salary, boolean teamLead) {
			super(firstName, lastName, yearsOfService, salary, teamLead);
				this.position = position;
				this.department = department;
				
			}
			
			
			//WATCH NAME CASING!!!!!
			public static Finance createfinances(String firstName, String lastName, String position, String department, int yearsOfService,  int salary, boolean teamLead) {
		        Finance finance = new Finance(firstName, lastName, department, position, salary, yearsOfService, teamLead);
		        finances.add(finance);        
		        return finance;
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


			public static List<Finance> getfinance() {
				return finances;
			}

			public static void setFinace(List<Finance> finances) {
				Finance.finances = finances;
			}

			@Override
		    public String toString() {
		        return super.toString() + " | Department: " + department + "| Position: " + position + " | Salary: $" + salary + " | Years of Service: " + yearsOfService + " | Team Lead: " + teamLead;
		    }
			
			public static int countTeamLeads() {
				return (int) finances.stream().filter(e -> e.teamLead).count(); //keep parenthesis for (int) have to cast
			}


			public static String lowestPaid() {   // KEEP TO STRING CANT GO TO PERSON
				Person lowest = finances.get(0);
				for (Person p: finances) {
					if (p.getSalary() < lowest.getSalary()) {
						lowest = p;
					}
					}
				return "Name: " + lowest.getFirstName() + " " + lowest.getLastName() + "\nSalary: $" + lowest.getSalary();
				}
			
			@Override
			public double averageSalaryByDepartment() {
				if (finances.isEmpty()) return 0.0; //Failsafe if no marketing
				
				int FinanceAverage = 0;
				for (Finance m : finances) {
					FinanceAverage += m.getSalary();
				}
				return (double) FinanceAverage / finances.size();
			}
			
			}
		



