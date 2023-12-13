package com.yourcompany.optilogistics.controller;

import com.yourcompany.optilogistics.model.Shipment;
import com.yourcompany.optilogistics.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tracking")
public class TrackingController {

    private final TrackingService trackingService;

    @Autowired
    public TrackingController(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @GetMapping("/shipments")
    public List<Shipment> getAllShipments() {
        return trackingService.getAllShipments();
    }

    @GetMapping("/shipments/{id}")
    public Shipment getShipmentById(@PathVariable int id) {
        return trackingService.getShipmentById(id);
    }

    @PostMapping("/shipments")
    public Shipment createShipment(@RequestBody Shipment shipment) {
        return trackingService.createShipment(shipment);
    }

    @PutMapping("/shipments/{id}")
    public Shipment updateShipment(@PathVariable int id, @RequestBody Shipment updatedShipment) {
        return trackingService.updateShipment(id, updatedShipment);
    }

    @DeleteMapping("/shipments/{id}")
    public void deleteShipment(@PathVariable int id) {
        trackingService.deleteShipment(id);
    }
}
