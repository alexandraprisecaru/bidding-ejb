package dto;

import java.util.Date;
import java.util.List;

public class AuctionDTO {

	private int idAuction;

	private double currentPrice;

	private Date endingDate;

	private byte isFinished;

	private Date startingDate;

	private UserDTO user;

	private List<BiddingDTO> biddings;

	public int getIdAuction() {
		return idAuction;
	}

	public void setIdAuction(int idAuction) {
		this.idAuction = idAuction;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public byte getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(byte isFinished) {
		this.isFinished = isFinished;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<BiddingDTO> getBiddings() {
		return biddings;
	}

	public void setBiddings(List<BiddingDTO> biddings) {
		this.biddings = biddings;
	}

}
