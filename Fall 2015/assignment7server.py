import socket
import sys
import random

def main():

    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    ipAddress = ""
    socketNum = input("Enter a socket: ")
    while 1:
        randomNumber = random.randrange(4)+1
        qotd1 = "Always remember that you are absolutely unique. Just like everyone else."
        qotd2 = "Do not take life too seriously. You will never get out of it alive."
        qotd3 = "If you haven't got anything nice to say about anybody, come sit next to me."
        qotd4 = "I'm sorry, if you were right, I'd agree with you."

        if randomNumber == 1:
            sock.sendto(qotd1.encode('ascii'), (ipAddress, int(socketNum)))
        elif randomNumber == 2:
            sock.sendto(qotd2.encode('ascii'), (ipAddress, int(socketNum)))
        elif randomNumber == 3:
            sock.sendto(qotd3.encode('ascii'), (ipAddress, int(socketNum)))
        elif randomNumber == 4:
            sock.sendto(qotd4.encode('ascii'), (ipAddress, int(socketNum)))
             
if __name__ == '__main__':
    main()
