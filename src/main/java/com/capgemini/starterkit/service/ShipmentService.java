package com.capgemini.starterkit.service;

import com.capgemini.starterkit.entity.Shipment;

public interface ShipmentService {


	public Shipment create(Shipment shipment);

	public void remove(Shipment shipment);
}
