package gss.zuul.gateway.flights.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gss.flights.blueair.dto.FlightModel;

@FeignClient(name = "BlueAirAPI", url = "${zuul.routes.blueair.url}")
public interface BlueairFeign {
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	List<FlightModel> getAll();
}
