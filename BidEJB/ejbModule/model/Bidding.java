package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the bidding database table.
 * 
 */
@Entity
@Table(name="bidding")
@NamedQuery(name="Bidding.findAll", query="SELECT b FROM Bidding b")
public class Bidding implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idBidding;

	@Temporal(TemporalType.TIMESTAMP)
	private Date biddingDate;

	private double priceOffered;

	//bi-directional many-to-one association to Automaticbidding
	@OneToMany(mappedBy="bidding")
	private List<Automaticbidding> automaticbiddings;

	//bi-directional many-to-one association to Auction
	@ManyToOne
	@JoinColumn(name="idAuction")
	private Auction auction;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="idUserBidder")
	private User user;

	public Bidding() {
	}

	public int getIdBidding() {
		return this.idBidding;
	}

	public void setIdBidding(int idBidding) {
		this.idBidding = idBidding;
	}

	public Date getBiddingDate() {
		return this.biddingDate;
	}

	public void setBiddingDate(Date biddingDate) {
		this.biddingDate = biddingDate;
	}

	public double getPriceOffered() {
		return this.priceOffered;
	}

	public void setPriceOffered(double priceOffered) {
		this.priceOffered = priceOffered;
	}

	public List<Automaticbidding> getAutomaticbiddings() {
		return this.automaticbiddings;
	}

	public void setAutomaticbiddings(List<Automaticbidding> automaticbiddings) {
		this.automaticbiddings = automaticbiddings;
	}

	public Automaticbidding addAutomaticbidding(Automaticbidding automaticbidding) {
		getAutomaticbiddings().add(automaticbidding);
		automaticbidding.setBidding(this);

		return automaticbidding;
	}

	public Automaticbidding removeAutomaticbidding(Automaticbidding automaticbidding) {
		getAutomaticbiddings().remove(automaticbidding);
		automaticbidding.setBidding(null);

		return automaticbidding;
	}

	public Auction getAuction() {
		return this.auction;
	}

	public void setAuction(Auction auction) {
		this.auction = auction;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}