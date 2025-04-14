package selfMadePackage;

import java.util.ArrayList;
import java.util.List;
	

public class HR extends Person{

		private String position;
		private String department;

		public static List<HR> hrs = new ArrayList<>();
		
		private HR(String firstName, String lastName, String position, String department, int yearsOfService,  int salary, boolean teamLead) {
		super(firstName, lastName, yearsOfService, salary, teamLead);
			this.position = position;
			this.department = department;
			
		}
		
		
		//WATCH NAME CASING!!!!!
		public static HR createhrs(String firstName, String lastName, String position, String department, int yearsOfService,  int salary, boolean teamLead) {
	        HR hr = new HR(firstName, lastName, department, position, salary, yearsOfService, teamLead);
	        hrs.add(hr);        
	        return hr;
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


		public static List<HR> getHr() {
			return hrs;
		}


		public static void setHr(List<HR> hr) {
			HR.hrs = hr;
		}

				@Override
			    public String toString() {
			        return super.toString() + " | Department: " + department + "| Position: " + position + " | Salary: $" + salary + " | Years of Service: " + yearsOfService + " | Team Lead: " + teamLead;
			    }
				public static int countTeamLeads() {
					return (int) hrs.stream().filter(e -> e.teamLead).count(); //keep parenthesis for (int) have to cast
				}

				public static String lowestPaid() {  
					Person lowest = hrs.get(0);
					for (Person p: hrs) {
						if (p.getSalary() < lowest.getSalary()) {
							lowest = p;
						}
						}
					return "Name: " + lowest.getFirstName() + " " + lowest.getLastName() + "\nSalary: $" + lowest.getSalary();
					}


				@Override
				public double averageSalaryByDepartment() {
					// TODO Auto-generated method stub
					return 0;
				}


}


		


	

