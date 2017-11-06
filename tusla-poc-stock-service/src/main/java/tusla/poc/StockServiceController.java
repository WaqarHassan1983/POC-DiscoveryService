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
public class StockServiceController {



	@GetMapping(value ="/checkStockForTyre/{model}/{season}")
	public List<Tyre> checkStockForTyre(@PathVariable String model, @PathVariable String season){
		return getTireList(model,season);
	}
	private List<Tyre> getTireList(String model, String season){

		List<Tyre> tyreList = new ArrayList<Tyre>();
		tyreList.add(new Tyre("1","Tyre Model 1980"));
		tyreList.add(new Tyre("2","Tyre Model 1985"));
		tyreList.add(new Tyre("3","Tyre Model 1990"));
		return tyreList;

	}



}