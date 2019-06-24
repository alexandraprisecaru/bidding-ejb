package dto;

import java.util.Date;
import java.util.List;

public class BiddingDTO {
	
	private int idBidding;

	private Date biddingDate;

	private double priceOffered;

	private List<AutomaticBiddingDTO> automaticbiddings;

	private AuctionDTO auction;

	/**
	 * @return the idBidding
	 */
	public int getIdBidding() {
		return idBidding;
	}

	/**
	 * @param idBidding the idBidding to set
	 */
	public void setIdBidding(int idBidding) {
		this.idBidding = idBidding;
	}

	/**
	 * @return the biddingDate
	 */
	public Date getBiddingDate() {
		return biddingDate;
	}

	/**
	 * @param biddingDate the biddingDate to set
	 */
	public void setBiddingDate(Date biddingDate) {
		this.biddingDate = biddingDate;
	}

	/**
	 * @return the priceOffered
	 */
	public double getPriceOffered() {
		return priceOffered;
	}

	/**
	 * @param priceOffered the priceOffered to set
	 */
	public void setPriceOffered(double priceOffered) {
		this.priceOffered = priceOffered;
	}

	/**
	 * @return the automatic biddings
	 */
	public List<AutomaticBiddingDTO> getAutomaticbiddings() {
		return automaticbiddings;
	}

	/**
	 * @param automaticbiddings the automatic biddings to set
	 */
	public void setAutomaticbiddings(List<AutomaticBiddingDTO> automaticbiddings) {
		this.automaticbiddings = automaticbiddings;
	}

	/**
	 * @return the auction
	 */
	public AuctionDTO getAuction() {
		return auction;
	}

	/**
	 * @param auction the auction to set
	 */
	public void setAuction(AuctionDTO auction) {
		this.auction = auction;
	}
}
