package javaproject;

/**
*
* @author Jay Dobson
*/

import java.util.LinkedList;

public class JavaProject {

	public static void main(String[] args) {
		
		String mem;
		
		//mm object calls fh respectively
		MembershipManagement mm = new MembershipManagement();
		FileHandler fh = new FileHandler();
		
		//members obj uses fh object to call reeadFile method in FileHandler class
		//reads from the members.csv file and converts the information into a LinkedList of Member objects
		//LinkedList is then returned to the caller, then assigns this LinkedList to local variable members
		LinkedList<Member> members = fh.readFile();
		
		////mm object calls getChoice method in MembershipManagment class which displays a list of options to the user
		//to choose and returns the user's choice to the caller
		int choice = mm.getChoice();
		
		//repeatedly prompts user to enter a choice after each task is completed
		//as long as the the user does not enter -1, the while statement will continue to run
		while (choice != -1) {
			switch (choice) {
			
			//addMembers method in MembershipManagement to adds member to LinkedList
			//addMembers will prompt the user for info about nw member and update LinkdList
			//returns string and assigns it to mem
			//appendFile method in FileHandler class adds the mmber to members.csv file
			case 1:
				mem = mm.addMembers(members);
				fh.appendFile(mem);
				break;
				
			//removeMember method removes the member and use the overWrite method to update csv file
			case 2:
				mm.removeMember(members);
				fh.overwriteFile(members);
				break;
				
			//printMember method displays the info of member
			case 3:
				mm.printMemberInfo(members);
				break;
				
			//displays the user has selected an invalid option
			default:
				System.out.println("You have selected an invalid option\n\n");
				break;
			}
			
			//prompts user to select new option
			choice = mm.getChoice();
		}
		
		System.out.println("Good Bye!");
	}

}
