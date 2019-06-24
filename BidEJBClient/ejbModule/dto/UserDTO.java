package dto;

import java.util.List;

public class UserDTO {
	private int idUser;

	private String firstName;

	private String lastName;

	private String password;

	private String role;

	private String userName;

	private List<AuctionDTO> auctions;

	private List<BiddingDTO> biddings;

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<AuctionDTO> getAuctions() {
		return this.auctions;
	}

	public void setAuctions(List<AuctionDTO> auctions) {
		this.auctions = auctions;
	}

	public List<BiddingDTO> getBiddings() {
		return this.biddings;
	}

	public void setBiddings(List<BiddingDTO> biddings) {
		this.biddings = biddings;
	}

}
