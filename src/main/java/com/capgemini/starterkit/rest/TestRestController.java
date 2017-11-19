package com.capgemini.starterkit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.starterkit.datatype.ShipmentType;
import com.capgemini.starterkit.entity.AirShipment;
import com.capgemini.starterkit.entity.Book;
import com.capgemini.starterkit.entity.SeaShipment;
import com.capgemini.starterkit.service.BookService;
import com.capgemini.starterkit.service.ShipmentService;


@RestController
public class TestRestController {

	@Autowired
	private ShipmentService shipmentService;

	@RequestMapping("/test")
	public String runForTest() {

		AirShipment airShipment = new AirShipment();
		airShipment.setDestination("PLWAW");
		airShipment.setOrigin("GBLON");
		airShipment.setType(ShipmentType.EXPRESS);

		shipmentService.create(airShipment);


		SeaShipment seaShipment = new SeaShipment();
		seaShipment.setDestination("CNSHA");
		seaShipment.setOrigin("DEHAM");
		seaShipment.setVesselName("Pinta");

		shipmentService.create(seaShipment);
		return "OK";
	}

}
