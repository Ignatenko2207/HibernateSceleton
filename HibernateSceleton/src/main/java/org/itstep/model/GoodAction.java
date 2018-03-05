package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "good_actions")
public class GoodAction {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "time_action")
	private Long timeAction;

	@Column(name = "action")
	private String action;

	@Column(name = "added_to_cart")
	private Boolean addedToCart;

	@ManyToOne(targetEntity = Account.class)
	private Account account;
	
	@ManyToOne(targetEntity = Good.class)
	private Good good;

	public GoodAction() {
	}

	public GoodAction(Long timeAction, String action, Boolean addedToCart, Account account, Good good) {
		this.timeAction = timeAction;
		this.action = action;
		this.addedToCart = addedToCart;
		this.account = account;
		this.good = good;
	}

}
