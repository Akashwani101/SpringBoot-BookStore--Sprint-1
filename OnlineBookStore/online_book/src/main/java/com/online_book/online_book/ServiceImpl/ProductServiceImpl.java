package com.online_store2.online_store2.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online_store2.online_store2.Entities.Cart;
import com.online_store2.online_store2.Entities.Customer;
import com.online_store2.online_store2.Entities.Product;
import com.online_store2.online_store2.Entities.ProductException;
import com.online_store2.online_store2.Repositories.CartRepository;
import com.online_store2.online_store2.Repositories.CustomerRepository;
import com.online_store2.online_store2.Repositories.ProductRepository;
import com.online_store2.online_store2.Repositories.StoreRepository;
import com.online_store2.online_store2.Service.ProductService;
import com.online_store2.online_store2.Entities.Store;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	StoreRepository storeRepository;
	
	/*ProductServiceImpl(ProductRepository productrepository) 
	{
		this.productRepository=productRepository;
	}*/
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired 
	CustomerRepository customerRepository;

	@Override
	public Product createProduct(Product product) {   //adding recording into our table
	
		return	productRepository.save(product);
	
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findProductById(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		Product p=productRepository.findById(id).get();
		p.setName(product.getName());
		p.setStk(product.getStk());
		p.setPrice(product.getPrice());
		return productRepository.save(p);
	}

	@Override
	public String deleteProduct(Long id) {
		
		Product p=productRepository.findById(id).get();
		
		
		productRepository.deleteById(id);
		return "Your record has been deleted!";
		
	
		}

	@Override
	public String assignStoreToProduct(Long storeid, Long prodid) {
	
		Store store=storeRepository.findById(storeid).get();
		Product p=productRepository.findById(prodid).get();
		p.setStore(store);
		productRepository.save(p);
		
		
		/*List<Product> products=new ArrayList<>();
		products.add(p);
		store.setProduct(products);
		*/
		
		return "store is assigned";
		
	}

	@Override
	public String orderProduct(Customer customer) {
		List<Cart> cart=customer.getCart();
		Double sum=0.00;
		
		for(Cart i:cart)
		{
			Product p=productRepository.findById(i.getProdid()).get();
		
			try
			{
				if(i.getQty()>p.getStk())
					throw new ProductException("Out of stock");
			}
			catch(ProductException e)
			{
				return p.getName()+" is "+e.getMessage();
			}
			i.setTotal(i.getQty()*p.getPrice());
			i.setOrderno(customer);
		
			cartRepository.save(i);
			sum=sum+i.getTotal();  
			p.setStk(p.getStk()-i.getQty());
			productRepository.save(p);
		
		}

		
		customer.setTotalPrice(sum);
		customerRepository.save(customer);
	
		return "your order has been placed successfully";
		
	}
	
	@Override
	public List<Cart> orderDetails(Long orderno)
	{
		Customer customer=customerRepository.findById(orderno).get();
	List<Cart> cart=customer.getCart();		
		return cart;
	}

}
