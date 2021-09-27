package com.charlie.online.foodchain;

import com.charlie.online.foodchain.dao.MenuItemRepository;
import com.charlie.online.foodchain.entities.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({"com.charlie.online.foodchain"})
public class CharlieFoodChainAppApplication  implements CommandLineRunner  {

	@Autowired
	private MenuItemRepository menuItemRepository;

	public static void main(String[] args) {
		SpringApplication.run(CharlieFoodChainAppApplication.class, args);
	}

	@Override
	public void run(String... args)  {

		MenuItem menuItem = new MenuItem();
		menuItem.setName("Chicken Fry");
		menuItem.setType("Non-Veg");
		menuItem.setPrice("100");

		menuItemRepository.save(menuItem);

		MenuItem menuItem1 = new MenuItem();
		menuItem1.setName("Chicken Fry 1");
		menuItem1.setType("Non-Veg");
		menuItem1.setPrice("1000");

		menuItemRepository.save(menuItem1);


		MenuItem menuItem2 = new MenuItem();
		menuItem2.setName("Chicken Fry 2");
		menuItem2.setType("Non-Veg");
		menuItem2.setPrice("10000");

		menuItemRepository.save(menuItem2);
	}
}

