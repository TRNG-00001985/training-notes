package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.exception.ProductException;
import dto.ProductRequest;
import dto.ProductResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.ProductService;


@WebServlet("/products/*")
public class ProductController extends HttpServlet{
	
	private ProductService productService;
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub		
		System.out.println("init");
		
		this.productService = new ProductService(); 
	}
	
//	@Override
//	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		super.service(arg0, arg1);
//		
//		
//		PrintWriter out = arg1.getWriter();
//		
//		out.println("get method");
//	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		// TODO Auto-generated method stub		
		System.out.println("get method invoked");
		
		System.out.println(req.getRequestURI().substring("revshop-servlets/products".length()+1));
		
		//revshop-servelets/products/
		if(req.getRequestURI().substring("revshop-servlets/products".length()+1).equals("/all")) {
			try {
				List<ProductResponse> products = productService.getAllProducts();
				
				out.println("<H1>Product Controller</H1>");
				
				for(ProductResponse p: products) {
					out.printf("<p> %d </p>", p.getId() );
					out.printf("<p> %s </p>", p.getName() );
					out.printf("<p> %s </p>", p.getSkuCode() );
					out.printf("<p> %f </p>", p.getPrice() );

					
				}
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else {
		
		
	

		Long id = Long.parseLong(req.getRequestURI().substring("revshop-servlets/products/".length()+1));
		try {
			RequestDispatcher rd = req.getRequestDispatcher("/success");

			ProductResponse product = productService.getProductById(id);
			
			out.println("<H1>Product Controller</H1>");
			out.printf("<p> %s </p>", product.getName() );
			
			rd.forward(req, resp);
			
			
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		

		
		
		
		
		
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		String name = req.getParameter("name");
		String skuCode = req.getParameter("skuCode");
		float price = Float.parseFloat(req.getParameter("price"));
		
		ProductRequest productRequest = new ProductRequest(name, skuCode, price);
		
		boolean response = productService.createProduct(productRequest);
		
		PrintWriter out = res.getWriter();
		
		if(response) {
			
			out.println("product created");
			
		}
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		super.destroy();
		
		System.out.println("destroyed");
	}

}
