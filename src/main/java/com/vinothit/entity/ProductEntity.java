package com.vinothit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_entity_tbl")
public class ProductEntity {
	
	@Id
	@GeneratedValue
	private Integer productId;
	private String name;
	private Double price;
	private Integer quantity;

}
