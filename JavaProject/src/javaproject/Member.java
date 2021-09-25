package javaproject;

/**
*
* @author Jay Dobson
*/

public class Member {

	// private variables
	private char memberType;
	private int memberID;
	private String name;
	private double fees;

	// Constructor
	public Member(char pMemberType, int pMemberID, String pName, double pFees) {
		memberType = pMemberType;
		memberID = pMemberID;
		name = pName;
		fees = pFees;
	}

	// setter for memberType
	public void setMemberType(char pMemberType) {
		memberType = pMemberType;
	}

	// getter for memberType
	public char getMemberType() {
		return memberType;
	}

	// setter for memberID
	public void setMemberID(int pMemberID) {
		memberID = pMemberID;
	}

	// getter for memberID
	public int getMemberID() {
		return memberID;
	}

	// setter for name
	public void setName(String pName) {
		name = pName;
	}

	// getter for name
	public String getName() {
		return name;
	}

	// setter for fees
	public void setFees(double pFees) {
		fees = pFees;
	}

	// getter for fees
	public double getFees() {
		return fees;
	}

	// Overriding the toSting() method as a function
	@Override
	public String toString() {
		return memberType + ", " + memberID + ", " + name + ", " + fees;
	}

}
