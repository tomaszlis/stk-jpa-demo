package com.capgemini.starterkit.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.capgemini.starterkit.datatype.ShipmentType;

@Entity
//@DiscriminatorValue(value="AIR")
public class AirShipment extends Shipment {

	@Enumerated(EnumType.STRING)
	private ShipmentType type;

	public ShipmentType getType() {
		return type;
	}

	public void setType(ShipmentType type) {
		this.type = type;
	}


}
