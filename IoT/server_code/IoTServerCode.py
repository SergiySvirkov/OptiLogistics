# IoTServerCode.py

import socket

class IoTServer:
    def __init__(self, port):
        self.port = port

    def start_server(self):
        with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server_socket:
            server_socket.bind(('localhost', self.port))
            server_socket.listen()

            print(f"Server listening on port {self.port}")

            while True:
                client_socket, address = server_socket.accept()
                with client_socket:
                    print(f"Connected to {address}")

                    while True:
                        data = client_socket.recv(1024)
                        if not data:
                            break

                        # Process the received data (in this case, simply print it)
                        print(f"Received data: {data.decode('utf-8')}")

if __name__ == "__main__":
    server = IoTServer(5000)
    server.start_server()
