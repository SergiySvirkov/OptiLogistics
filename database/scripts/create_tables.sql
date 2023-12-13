-- create_tables.sql

-- Table to store shipment information
CREATE TABLE shipments (
    shipment_id INT PRIMARY KEY,
    origin_location VARCHAR(255),
    destination_location VARCHAR(255),
    shipment_status VARCHAR(50),
    estimated_delivery_date DATE,
    actual_delivery_date DATE
);

-- Table to store IoT device information
CREATE TABLE iot_devices (
    device_id INT PRIMARY KEY,
    device_name VARCHAR(50),
    device_type VARCHAR(50),
    shipment_id INT,
    FOREIGN KEY (shipment_id) REFERENCES shipments(shipment_id)
);
