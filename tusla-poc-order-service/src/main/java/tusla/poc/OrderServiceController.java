package tusla.poc;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import tusla.poc.ToggleFeature.ToggleFeature;

@Controller
public class OrderServiceController {

	@LoadBalanced
	@Bean
	public RestTemplate restTemplate(){

		return new RestTemplate();

	}

	@Autowired
	RestTemplate restTemplate;

	@GetMapping(value = "/getTyres/{vin}/{season}")
	public List<Tyre> getTires(@PathVariable String vin, @PathVariable String season) {

		URI uri = URI.create("http://TUSLA-POC-STOCK-SERVICE/checkStockForTyre/model/season");

		String json = restTemplate.getForObject(uri, String.class);
		System.out.println(" json reponse : " + json);
		List<Tyre> tyreList = getTireList(getModel(vin), season);

		if (ToggleFeature.AdvertisedTyres.isActive()) {
			tyreList.addAll(getAdvertisedTYreList(getModel(vin), season));
		}
		return tyreList;
	}
	private List<Tyre> getTireList(String model, String season) {
		List<Tyre> tyreList = new ArrayList<Tyre>();
		tyreList.add(new Tyre("1", "Tyre Model 1980"));
		tyreList.add(new Tyre("2", "Tyre Model 1985"));
		tyreList.add(new Tyre("3", "Tyre Model 1990"));
		return tyreList;
	}

	private List<Tyre> getAdvertisedTYreList(String model, String season) {
		List<Tyre> tyreList = new ArrayList<Tyre>();
		tyreList.add(new Tyre("4", "Tyre Model 2005"));
		tyreList.add(new Tyre("5", "Tyre Model 2010"));
		tyreList.add(new Tyre("6", "Tyre Model 2015"));
		return tyreList;
	}
	private String getModel(String vin) {
		return "model";
	}



}