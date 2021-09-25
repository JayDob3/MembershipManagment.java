package javaproject;

/**
*
* @author Jay Dobson
*/

public class MultiClubMember extends Member {

	private int membershipPoints;

	public MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoints) {
		super(pMemberType, pMemberID, pName, pFees);
		setMembershipPoints(pMembershipPoints);

	}

	/**
	 * @param membershipPoints the membershipPoints to set
	 */
	public void setMembershipPoints(int pMembershipPoints) {
		this.membershipPoints = pMembershipPoints;
	}

	/**
	 * @return the membershipPoints
	 */
	public int getMembershipPoints() {
		return membershipPoints;
	}

	@Override
	public String toString() {
		return super.toString() + ", " + membershipPoints;
	}

}
