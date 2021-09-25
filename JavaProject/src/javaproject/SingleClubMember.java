package javaproject;

/**
*
* @author Jay Dobson
*/

public class SingleClubMember extends Member {

	// private variable
	private int club;

	// SingleClubMember constructor
	public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub) {
		super(pMemberType, pMemberID, pName, pFees); // super keywords calls parent constructor
		club = pClub;
	}

	// setter for club
	public void setClub(int pClub) {
		club = pClub;
	}

	// getter for club
	public int getClub() {
		return club;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + club; // super keyword calls parent toString() and concats club variable
	}

}
