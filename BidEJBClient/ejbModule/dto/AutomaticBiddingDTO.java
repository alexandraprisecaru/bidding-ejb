package dto;

public class AutomaticBiddingDTO {

	private int idAutomaticBidding;

	private String automaticBiddingcol;

	private double maxPrice;

	private BiddingDTO bidding;

	public int getIdAutomaticBidding() {
		return idAutomaticBidding;
	}

	public void setIdAutomaticBidding(int idAutomaticBidding) {
		this.idAutomaticBidding = idAutomaticBidding;
	}

	public String getAutomaticBiddingcol() {
		return automaticBiddingcol;
	}

	public void setAutomaticBiddingcol(String automaticBiddingcol) {
		this.automaticBiddingcol = automaticBiddingcol;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public BiddingDTO getBidding() {
		return bidding;
	}

	public void setBidding(BiddingDTO bidding) {
		this.bidding = bidding;
	}

}
