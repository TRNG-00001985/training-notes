package com.revature.revshop.dto;

import java.util.List;

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
public class OrderRequest {
	private Long userId;
    private Double totalPrice;
    private String address;
    private String payment;
    private List<Long> productIds;


}
