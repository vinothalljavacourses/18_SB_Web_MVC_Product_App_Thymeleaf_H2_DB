package com.vinothit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

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
	
	@NotBlank(message = "Name is mandatory")
	@Size(min = 3, max = 15, message = "Name should have only 3 to 15 characters")
	private String name;
	
	@NotNull(message = "Price is mandatory")
	@Positive(message = "Price should be positive number")
	private Double price;
	
	@NotNull(message = "Quantity is mandatory")
	@Positive(message = "Quantity should be positive number")
	private Integer quantity;

}
