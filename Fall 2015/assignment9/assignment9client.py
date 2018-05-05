#Client


import socket

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

host = "localhost"

inputHost = input("Input the address: ")

port = input("Enter a port number: ")

port = int(port)

#sock.connect((inputHost, port))
sock.connect(('icarus.cs.weber.edu', port))

msg = "Attempting to connect"
print(msg)

sock.sendall(msg.encode('ascii'))
sock.shutdown(socket.SHUT_WR)


#fileName = input("What file are you looking for ex: ('received_file.txt') :" )

with open('sample.txt', 'wb') as file:
    print("receiving data")
    while 1:
        data = sock.recv(1024)
        if not data:
            break
        file.write(data)

file.close()
print("file download successful")
sock.close()
print("socket closed")
