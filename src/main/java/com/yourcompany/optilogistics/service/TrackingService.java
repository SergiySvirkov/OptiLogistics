package com.yourcompany.optilogistics.service;

import com.yourcompany.optilogistics.model.Shipment;
import com.yourcompany.optilogistics.repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackingService {

    private final ShipmentRepository shipmentRepository;

    @Autowired
    public TrackingService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }

    public List<Shipment> getAllShipments() {
        return shipmentRepository.findAll();
    }

    public Shipment getShipmentById(int id) {
        Optional<Shipment> optionalShipment = shipmentRepository.findById(id);
        return optionalShipment.orElse(null);
    }

    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public Shipment updateShipment(int id, Shipment updatedShipment) {
        Optional<Shipment> optionalShipment = shipmentRepository.findById(id);

        if (optionalShipment.isPresent()) {
            Shipment existingShipment = optionalShipment.get();
            existingShipment.setOrigin(updatedShipment.getOrigin());
            existingShipment.setDestination(updatedShipment.getDestination());
            existingShipment.setStatus(updatedShipment.getStatus());
            existingShipment.setEstimatedDeliveryDate(updatedShipment.getEstimatedDeliveryDate());
            existingShipment.setActualDeliveryDate(updatedShipment.getActualDeliveryDate());

            return shipmentRepository.save(existingShipment);
        }

        return null;
    }

    public void deleteShipment(int id) {
        shipmentRepository.deleteById(id);
    }
}
