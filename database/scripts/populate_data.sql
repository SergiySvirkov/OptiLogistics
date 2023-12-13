-- populate_data.sql

-- Insert sample shipment data
INSERT INTO shipments (shipment_id, origin_location, destination_location, shipment_status, estimated_delivery_date, actual_delivery_date)
VALUES
    (1, 'Warehouse A', 'Customer X', 'In Transit', '2023-01-15', NULL),
    (2, 'Warehouse B', 'Customer Y', 'Delivered', '2023-01-10', '2023-01-09'),
    (3, 'Warehouse C', 'Customer Z', 'Pending', '2023-01-20', NULL);

-- Insert sample IoT device data
INSERT INTO iot_devices (device_id, device_name, device_type, shipment_id)
VALUES
    (101, 'Tracker001', 'GPS', 1),
    (102, 'Sensor002', 'Temperature', 2),
    (103, 'Tracker003', 'GPS', 3);

