package com.revature.revshop.dto;

import com.revature.revshop.model.Product;
import com.revature.revshop.model.User;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductRequest {
	private String name;
	private String description;
    private Long userId;
	private Double price;

}
