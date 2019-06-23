package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the automaticbidding database table.
 * 
 */
@Entity
@Table(name="automaticbidding")
@NamedQuery(name="Automaticbidding.findAll", query="SELECT a FROM Automaticbidding a")
public class Automaticbidding implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idAutomaticBidding;

	@Column(length=45)
	private String automaticBiddingcol;

	private double maxPrice;

	//bi-directional many-to-one association to Bidding
	@ManyToOne
	@JoinColumn(name="idBidding")
	private Bidding bidding;

	public Automaticbidding() {
	}

	public int getIdAutomaticBidding() {
		return this.idAutomaticBidding;
	}

	public void setIdAutomaticBidding(int idAutomaticBidding) {
		this.idAutomaticBidding = idAutomaticBidding;
	}

	public String getAutomaticBiddingcol() {
		return this.automaticBiddingcol;
	}

	public void setAutomaticBiddingcol(String automaticBiddingcol) {
		this.automaticBiddingcol = automaticBiddingcol;
	}

	public double getMaxPrice() {
		return this.maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Bidding getBidding() {
		return this.bidding;
	}

	public void setBidding(Bidding bidding) {
		this.bidding = bidding;
	}

}