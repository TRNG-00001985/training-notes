package dto;

import java.util.List;

public class OrderResponse {
	
	
	private long orderId;
	private long userId;
	private float totalAmmount;
	private String createdAt;
	// address
	// payment info
	private List<Long> productIds;
	
	
	
	/* join
	 * 
select o.order_id, o.user_id, o.order_date, o.total_amount, group_concat(p.id) as productids, group_concat(p.name) as productNames, group_concat(p.price) as prices 
from Orders o
join
order_details od on o.order_id = od.order_id
join
Products p on od.product_id = p.id;
	 * 
	 * 
	 * 
	 * 
	 */
	


}
