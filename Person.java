package selfMadePackage;

public abstract class Person {

		
	
	//KEEP TO PROTECTED 
				protected String firstName;
				protected String lastName;
				protected String department;
				protected String position;
				protected int salary;
				protected int yearsOfService;
				protected boolean teamLead;
				public String getPosition() {
					return position;
				}

				

				public Person(String firstName, String lastName, int salary, int yearsOfService, boolean teamLead) {

			    	this.firstName = firstName;
			    	this.lastName = lastName;
//			    	this.department = department;
//			    	this.position = position;
			    	this.salary = salary;
			    	this.yearsOfService = yearsOfService;
			    	this.teamLead = teamLead;
			    	
			    }
				
				
				public abstract double averageSalaryByDepartment();
				

				public void setPosition(String position) {
					this.position = position;
				}


				public int getSalary() {
					return salary;
				}


				public void setSalary(int salary) {
					this.salary = salary;
				}


				public int getYearsOfService() {
					return yearsOfService;
				}


				public void setYearsOfService(int yearsOfService) {
					this.yearsOfService = yearsOfService;
				}


				public boolean isTeamLead() {
					return teamLead;
				}


				public void setTeamLead(boolean teamLead) {
					this.teamLead = teamLead;
				}


			    
			    public String getDepartment() {
					return department;
				}


				public void setDepartment(String department) {
					this.department = department;
				}


				public String getFirstName() {
					return firstName;
				}


				public void setFirstName(String firstName) {
					this.firstName = firstName;
				}


				public String getLastName() {
					return lastName;
				}


				public void setLastName(String lastName) {
					this.lastName = lastName;
				}


				@Override
			    public String toString() {
			        return "Name: " + firstName + " " + lastName;
			    }



			
			}

