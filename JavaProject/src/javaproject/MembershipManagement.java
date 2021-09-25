package javaproject;

/**
*
* @author Jay Dobson
*/

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {

	// Scanner object to read user input
	// reader is final because we will not be assigning any new references
	// private because on this class will use it
	final private Scanner reader = new Scanner(System.in);

	private int getIntInput() {

		int choice = 0;

		// repeatedly prompts user to enter int as long as try block fails
		while (choice == 0) {

			try {

				// tried reading in an int from user and assigns it to choice
				choice = reader.nextInt();

				// throws exception if users enters 0 so while loop doesn't keep looping
				if (choice == 0)
					throw new InputMismatchException();
				
				reader.nextLine();
			}

			// prompts user to enter valid int
			catch (InputMismatchException e) {

				// reads any input that has not been consumed yet
				reader.nextLine();

				// error message to prompt user to try aagin
				System.out.println("ERROR: INVALID INPUT. PLeas try again: ");
			}
		}

		return choice;

	}

	// prints club options
	private void printClubOptions() {
		System.out.println("\n1) Club Mercury");
		System.out.println("2) Club Neptune");
		System.out.println("3) Club Jupiter");
		System.out.println("4) Multi Clubs");

	}

	// prints selected choice from menu
	public int getChoice() {
		int choice;

		System.out.println("\nWELCOME TO OZONE FITNESS CENTER");
		System.out.println("================================");
		System.out.println("1) Add Member");
		System.out.println("2) Remove Member");
		System.out.println("3) Display member Information");

		System.out.print("\nPlease select an option (or Enter -1 to quit): ");

		// reads the user's input and assigns it to choice
		choice = getIntInput();

		// returns option
		return choice;

	}

	// method adds members to LinkedList Members object
	public String addMembers(LinkedList<Member> m) {
		String name;
		int club;
		String mem;
		double fees;
		int memberID;
		Member mbr;
		Calculator<Integer> cal;

		// prompts user to enter name and assigns it to name
		System.out.print("\nEnter the member's name: ");
		name = reader.nextLine();

		// calls print club option
		printClubOptions();

		// prompts user to enter member's club ID and assigns it to club
		System.out.print("\nEnter member's club ID: ");
		club = getIntInput();

		// repeatedly prompts user to enter club ID if invalid
		while (club < 1 || club > 4) {
			System.out.println("Invaild Club ID, please try again: ");
			club = getIntInput();

		}
		// calculates and auto increments member ID to each new member
		// first check if LinkedList is empty, if not use last element in LinkedList
		// use getMemberID method to get the memberID field of that element
		// increments memberID and assigns it to memberID of new member
		if (m.size() > 0) {
			memberID = m.getLast().getMemberID() + 1;
		} else {
			memberID = 1;
		}

		// adding single club member to the LinkedList
		if (club != 4) {

			// lambda expression because method has no parameter
			cal = (n) -> {
				switch (n) {

				// club Mercury fees
				case 1:
					return 900;

				// club Neptune fees
				case 2:
					return 950;

				// club Jupiter fees
				case 3:
					return 1000;

				default:
					return -1;
				}
			};

			// calculates the membership fes of the single club member and assigns it to
			// fees
			fees = cal.calculatorFees(club);

			// instantiate new SingleClubMember object
			mbr = new SingleClubMember('S', memberID, name, fees, club);

			// adds mbr to LinkedList m
			m.add(mbr);

			// generate string representation of new member and assigns it to mem
			mem = mbr.toString();

			// informs user new member has been successfully added
			System.out.println("\nSTATUS: Single Club Member added\n");

		} else {

			// lambda expression to calculate fees of multi-club member
			cal = (n) -> {

				// returns multi-club fee if n is 4
				if (n == 4)
					return 1200;
				else
					return -1;
			};

			// calculates the membership fees of multi-club member and assign it to fees
			fees = cal.calculatorFees(club);

			// instantiate new MultiClubMember object
			mbr = new MultiClubMember('M', memberID, name, fees, 100);

			// adds mbr to LinkedList m
			m.add(mbr);

			// generate string representation of new member and assigns it to mem
			mem = mbr.toString();

			// informs user new member has been successfully added
			System.out.println("\nSTATUS: Mutli Club Member added\n");
		}
		
		//returns mem
		return mem;
	}
	 
	//method to remove member from LinkedList
	public void removeMember(LinkedList<Member> m) {
		
		int memberID;
		
		//prompts user to enter member ID they wish to remove
		System.out.println("\nEnter the Member ID you want to remove: ");
		
		//reads input and assigns it to memberID
		memberID = getIntInput();
		
		//loops through LinkedList for memberID
		for (int i = 0; i < m.size(); i++) {
			
			//compares memberID to each element with the memberID user entered
			if (m.get(i).getMemberID() == memberID) {
				
				//removes element at index i from LinkedList
				m.remove(i);
				
				//informs the user the member has been successfully been removed
				System.out.println("\nSTATUS: Member has been sucessfully removed.\n");
				
				return;
			}
		}
		
		//prompts user if member ID was not found
		System.out.println("\nMember ID not found\n");
		
	}
	
	//method for printing Member Info
	public void printMemberInfo(LinkedList<Member> m) {
		
		int memberID;
		
		//prompts user to enter member ID they wish to remove
		System.out.print("\nEnter Member ID to display information: ");
		
		//reads input and assigns it to memberID
		memberID = getIntInput();
		
		//loops through LinkedList for memberID
		for (int i = 0; i < m.size(); i++) {
			
			//compares memberID to each element with the memberID user entered
			if (m.get(i).getMemberID() == memberID) {
				
				//array to assign .toString() to local string memberInfo
 				String[] memberInfo = m.get(i).toString().split(", ");
				
 				//displays info of the member requested
				System.out.println("\n\nMember Type = " + memberInfo[0]);
				System.out.println("Member ID = " + memberInfo[1]);
				System.out.println("Member Name = " + memberInfo[2]);
				System.out.println("Membership Fees = " + memberInfo[3]);
				
				//tests whether or not member is a Single Club or Multi Club Member
				if (memberInfo [0].equals("S")) {
					System.out.println("Club ID = " + memberInfo[4]);
				} else {
					System.out.println("Membership Points = " + memberInfo[4]);
				}
				
				return;
			}
		}
		
		//prompts user if member ID is not found
		System.out.println("\nMember ID not found");
	}

}
