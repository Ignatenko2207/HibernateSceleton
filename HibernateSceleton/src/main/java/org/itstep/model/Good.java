package org.itstep.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "goods")
public class Good {

	@Id
	@Column(name = "good_id")
	private String goodId;

	@Column(name = "good_name")
	private String name;

	@Column(name = "price")
	private Integer price;
	
	public Good() {
	}

	public Good(String goodId, String name, int price) {
		this.goodId = goodId;
		this.name = name;
		this.price = price;
	}
	
	
}
