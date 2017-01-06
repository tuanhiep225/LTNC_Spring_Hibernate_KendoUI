package mta.th12a.tuanhiep.dto;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Cart {
	private Map<Integer,ItemDTO> cartItems;

	public Cart() {
		cartItems=new HashMap<>();
	}

	public Cart(Map<Integer, ItemDTO> cartItem) {
		this.cartItems = cartItem;
	}

	public Map<Integer, ItemDTO> getCartItem() {
		return cartItems;
	}

	public void setCartItem(Map<Integer, ItemDTO> cartItem) {
		this.cartItems = cartItem;
	}
	public void insertToCart(int key,ItemDTO item)
	{
		boolean check=cartItems.containsKey(key);
		if(check)
		{
			int quantity_old=cartItems.get(key).getQuantity();
			item.setQuantity(quantity_old+1);
			cartItems.put(item.getProduct().getProductStoreId(), item);
		}
		else
		{
			cartItems.put(item.getProduct().getProductStoreId(), item);
		}
	}
	
	public int removeToCart(int key)
	{
	        boolean check = cartItems.containsKey(key);
	        if (check) 
	        {
	            cartItems.remove(key);
	            return 1;
	        }
	        return 0;
	}
	public int updatToCart(int key,int quantity)
	{
		boolean check = cartItems.containsKey(key);
		if(check)
		{
			ItemDTO item=cartItems.get(key);
			cartItems.get(key).setQuantity(quantity);
			cartItems.put(key, item);
			return 1;
		}
		return 0;
	}
	public int countItem()
	{
        int count = 0;
        count = cartItems.size();
        return count;
	}
	public double total()
	{
		double total=0;
		for(Entry<Integer, ItemDTO> entry:cartItems.entrySet())
		{
			total+=entry.getValue().getProduct().getPrice()*entry.getValue().getQuantity();
		}
		return total;
	}
}
