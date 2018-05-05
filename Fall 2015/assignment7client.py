import socket
import sys


def main():
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    #ask for ip address and socket
    url = input("Enter an ipaddress: ")
    socketAddress = input("Enter a socket: ")

    ipAddress = socket.gethostbyname(url)

    sock.bind((ipAddress, int(socketAddress)))

    sock.settimeout(10)

    testCondition = True
    testNumber = 1
    while testCondition:
        print("Attempt number " + str(testNumber))
        try:
            message, address = sock.recvfrom(8192)
        
            print(message.decode('ascii'))
            print(address)
            testCondition = False
        except socket.timeout:
            testNumber = testNumber + 1
            if testNumber > 3:
                testCondition = False
                print("Socket Timeout.")
                print("Now closing program.")
                            
    raise SystemExit(0)

if __name__ == '__main__':
    main()



