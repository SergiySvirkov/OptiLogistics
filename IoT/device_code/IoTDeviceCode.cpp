// IoTDeviceCode.cpp

#include <iostream>
#include <string>
#include <chrono>
#include <thread>

class IoTDevice {
public:
    IoTDevice(int id, std::string name, std::string type, int shipmentId) 
        : deviceId(id), deviceName(name), deviceType(type), shipmentId(shipmentId) {}

    void startTracking() {
        while (true) {
            // Simulate tracking data
            double latitude = getRandomCoordinate();
            double longitude = getRandomCoordinate();

            // Send tracking data to the server
            sendTrackingData(latitude, longitude);

            // Sleep for a short interval before sending the next update
            std::this_thread::sleep_for(std::chrono::seconds(10));
        }
    }

private:
    int deviceId;
    std::string deviceName;
    std::string deviceType;
    int shipmentId;

    double getRandomCoordinate() {
        // Simulate generating random GPS coordinates
        return rand() % 180 + (-90 + rand() % 2 == 0 ? -1 : 1 * (rand() % 100) / 100.0);
    }

    void sendTrackingData(double latitude, double longitude) {
        // Simulate sending tracking data to the server
        std::cout << "Device " << deviceName << " sent tracking data - Lat: " << latitude << ", Long: " << longitude << std::endl;
        // Actual implementation would involve sending data over a network or using an IoT protocol
    }
};

int main() {
    // Create an instance of the IoTDevice
    IoTDevice tracker(101, "Tracker001", "GPS", 1);

    // Start the tracking process
    tracker.startTracking();

    return 0;
}
