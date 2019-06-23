package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the auction database table.
 * 
 */
@Entity
@NamedQuery(name="Auction.findAll", query="SELECT a FROM Auction a")
public class Auction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idAuction;

	private double currentPrice;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endingDate;

	private byte isFinished;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startingDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUserOfferer")
	private User user;

	//bi-directional many-to-one association to Bidding
	@OneToMany(mappedBy="auction")
	private List<Bidding> biddings;

	public Auction() {
	}

	public int getIdAuction() {
		return this.idAuction;
	}

	public void setIdAuction(int idAuction) {
		this.idAuction = idAuction;
	}

	public double getCurrentPrice() {
		return this.currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Date getEndingDate() {
		return this.endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public byte getIsFinished() {
		return this.isFinished;
	}

	public void setIsFinished(byte isFinished) {
		this.isFinished = isFinished;
	}

	public Date getStartingDate() {
		return this.startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Bidding> getBiddings() {
		return this.biddings;
	}

	public void setBiddings(List<Bidding> biddings) {
		this.biddings = biddings;
	}

	public Bidding addBidding(Bidding bidding) {
		getBiddings().add(bidding);
		bidding.setAuction(this);

		return bidding;
	}

	public Bidding removeBidding(Bidding bidding) {
		getBiddings().remove(bidding);
		bidding.setAuction(null);

		return bidding;
	}

}