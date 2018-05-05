#Server


import socket

port = input("Enter a port number.")

port = int(port)

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

sock.bind(('',port))

sock.listen(5)

print("Server On..")

while 1:
    req, address = sock.accept()
    print("Connected with")
    print (address)
    data = req.recv(1024)

    name = "send.txt"
    file = open(name, 'rb')
    process = file.read(1024)
    while(process):
        req.sendall(process)
        print("sending ")
        process = file.read(1024)

    file.close()
    print("File sent")
    req.close()
