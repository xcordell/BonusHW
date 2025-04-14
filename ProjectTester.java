package selfMadePackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProjectTester {    
	
		private static final Scanner scanner = new Scanner(System.in);
	    	public static ArrayList<Person> allEmployees = new ArrayList<>();

    public static void main(String[] args) {
    	
    
        loadDatabase();
        displayMenu();
        
    }
        
    private static void displayMenu() {
        while (true) {
        	System.out.println("\nPlease select one of the following options:");
        	System.out.println("0   -   Display all Personel");
        	System.out.println("1   -   Lowest Paid by Department");
        	System.out.println("2   -   Employees working < 4 years");
        	System.out.println("3   -   Average pay in Marketing Department");
        	System.out.println("4   -   Longest Tenure Employees");
        	System.out.println("5   -   Display Departments & Lead Count");
//        	System.out.println("3   -   Delete UAB Person from Database");
//        	System.out.println("4   -   Update Database");
//        	
        	System.out.print(" ");
        	int choice = scanner.nextInt();
        	scanner.nextLine();
        	
        	
        	
        	switch (choice) {
            case 0 -> displayAllPeople();
            case 1 -> lowestPaidEachDPT();
            case 2 -> employeeLessThanFourYears();
            case 3 -> averagePayInMarketing();
            case 4 -> longestTenure();
            case 5 -> displayDepartmentsAndLeads();
//            case 4 -> UpdateDataBase();
            default -> {
                System.out.println("Invalid choice. Please select a valid option.");
            }
        	}
        }

        }

        
    	//DATABASE TO READ & PROCESS .txt FILE
        private static void loadDatabase() {
            try (Scanner fileScanner = new Scanner(new File("employee_data.csv"))) {
                if (fileScanner.hasNextLine()) {
                	fileScanner.nextLine();
                	
                }

                while (fileScanner.hasNextLine()) {
                	String line = fileScanner.nextLine();
                	String[] data = line.split(",");
                

    				
    				if (data.length != 7) { //!= 7 for checking invalid data
                		System.out.println("Invalid Data");
                		continue;
                		
    				}

                    
                		
                		String firstName = data[0]; //first
                		String lastName = data[1]; //last
                		String department = data[2]; //dpt
                		String position = data[3]; //position
                		int salary1 = Integer.parseInt(data[4]); //salary
                		int years = Integer.parseInt(data[5]); //years
                		boolean lead = data[6].equalsIgnoreCase("Yes"); //team lead


                		Person person = switch (department.toLowerCase()) {
                		case "engineering" -> Engineering.createengineers(firstName, lastName, department, position, years, salary1, lead);
                		case "marketing" -> Marketing.createmarketings(firstName, lastName, department, position, years, salary1, lead);
                		case "hr" -> HR.createhrs(firstName, lastName, department, position, years, salary1, lead);
                		case "finance" -> Finance.createfinances(firstName, lastName, department, position, years, salary1, lead);                      
                		default -> {
                		System.out.println("invalid dpt" + department);
                		yield null;  //Basically a Catch case if anything that doesnt match is read (dont remove it works fine)
                		}
                		};
                		if (person != null) { //If not empty add to masterlist of employees.
                			allEmployees.add(person);
                		}
                		}
            }catch (FileNotFoundException e) {
            	System.out.println("Data Not Found"); 
            }
            
        }
        
        
        private static void displayDepartmentsAndLeads() {
            System.out.println("Finance \nTeam Leads: " + Finance.countTeamLeads() + "\n");
            System.out.println("Marketing \nTeam Leads: " + Marketing.countTeamLeads() + "\n");
            System.out.println("HR \nTeam Leads: " + HR.countTeamLeads() + "\n");
            System.out.println("Engineering \nTeam Leads: " + Engineering.countTeamLeads() + "\n");

        }

        
        // CASE #0 DISPLAYALLPEOPLES
        
        private static void displayAllPeople() {
            System.out.println("\n Finance: " + Finance.finances.size());
            Finance.finances.forEach(System.out::println);
            
            System.out.println("\n Marketing: " + Marketing.marketings.size());
            Marketing.marketings.forEach(System.out::println);

            System.out.println("\n HR: " + HR.hrs.size());
            HR.hrs.forEach(System.out::println);

            System.out.println("\n Engineering: " + Engineering.engineers.size());
            Engineering.engineers.forEach(System.out::println);

        }

        private static void lowestPaidEachDPT() {
        	System.out.println("Lowest Paid Engineering DPT: \n" + Engineering.lowestPaid() + "\n");
        	System.out.println("Lowest Paid Finance DPT: \n " + Finance.lowestPaid() + "\n");
        	System.out.println("Lowest Paid Marketing DPT: \n" + Marketing.lowestPaid()+ "\n");
        	System.out.println("Lowest Paid HR DPT: \n" + HR.lowestPaid()+"\n");

        	
        }

 
        
        private static void employeeLessThanFourYears() {
        	for (Person e : allEmployees) {
        		if (e.getYearsOfService() < 4) {
        			System.out.println("\n" + e.getFirstName() + " " + e.getLastName() + " | " + e.getDepartment() + " | "  + e.getPosition()  + " | $" + e.getSalary() + " | " + e.getYearsOfService() + " years of service | Team Lead: " + e.isTeamLead());                   		
        			
        		}
        	}
        }
        
        
        private static void averagePayInMarketing() {
        	for (Person p : allEmployees) {
        		if (p instanceof Marketing) {      //instanceof calls marketing dont touch the reccomended thingy keep it as it is
                	System.out.printf("Average Pay in Marketing: $%.2f\n", + p.averageSalaryByDepartment());
break;
        		}
        	}
        }



//        Write one function to get longest Years and the second one to display info of said person
        private static void longestTenure() {
        int tenureYears = 0;
        for (Person p : allEmployees) {
        	if (p.getYearsOfService() > tenureYears) {
        		tenureYears = p.getYearsOfService();
        	}
        	}
        for (Person p : allEmployees) {
        	if (p.getYearsOfService() == tenureYears) {
        		System.out.println(p.getFirstName() + " " + p.getLastName() + "  | " + p.getDepartment()  + "  | " + p.getPosition() + "  | $" + p.getSalary() + "  | " + p.getYearsOfService() + " years of service | Is Team Lead: "+ p.isTeamLead() + "\n\n\n8 years as a software engineer and only 102K??? Lowkey sad imo ʕ ͡° ʖ̯ ͡°ʔ \n\n");
        	}
        }
        }
        }
