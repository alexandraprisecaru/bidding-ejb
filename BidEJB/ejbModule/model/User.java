package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int idUser;

	@Column(length=45)
	private String firstName;

	@Column(length=45)
	private String lastName;

	@Column(nullable=false, length=45)
	private String password;

	@Column(length=10)
	private String role;

	@Column(nullable=false, length=45)
	private String userName;

	//bi-directional many-to-one association to Auction
	@OneToMany(mappedBy="user")
	private List<Auction> auctions;

	//bi-directional many-to-one association to Bidding
	@OneToMany(mappedBy="user")
	private List<Bidding> biddings;

	public User() {
	}

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

	public List<Auction> getAuctions() {
		return this.auctions;
	}

	public void setAuctions(List<Auction> auctions) {
		this.auctions = auctions;
	}

	public Auction addAuction(Auction auction) {
		getAuctions().add(auction);
		auction.setUser(this);

		return auction;
	}

	public Auction removeAuction(Auction auction) {
		getAuctions().remove(auction);
		auction.setUser(null);

		return auction;
	}

	public List<Bidding> getBiddings() {
		return this.biddings;
	}

	public void setBiddings(List<Bidding> biddings) {
		this.biddings = biddings;
	}

	public Bidding addBidding(Bidding bidding) {
		getBiddings().add(bidding);
		bidding.setUser(this);

		return bidding;
	}

	public Bidding removeBidding(Bidding bidding) {
		getBiddings().remove(bidding);
		bidding.setUser(null);

		return bidding;
	}

}