package com.capgemini.starterkit.service.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.starterkit.entity.Shipment;
import com.capgemini.starterkit.repository.ShipmentRepository;
import com.capgemini.starterkit.service.ShipmentService;

@Service
@Transactional
public class ShipmentServiceImpl implements ShipmentService {

	@Autowired
	private ShipmentRepository repository;

	@Override
	public Shipment create(Shipment shipment) {
		Shipment persisted = repository.save(shipment);
		return persisted;
	}

	@Override
	public void remove(Shipment shipment) {
		repository.delete(shipment);
	}


}
