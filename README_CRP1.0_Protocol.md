# Chatroom-App

This is a base CRM that i coded as a final project for the Network class during my undergraduate program at Westminster College. 

Server[Server.java, Handler.java, Connection.java, BroadcastThread.java], Client[ReaderThread.java, ChatScreen.java]

Runs via CRP 1.0 protocol
run: Server.java and ChatScreen.java serverip username

# CHATROOM PROTOCOL (CRP 1.0)


Example protocol: https://datatracker.ietf.org/doc/html/rfc865 
TCP documentation(another example): https://www.rfc-editor.org/rfc/rfc793 

*Runs over TCP over port 15001
*End requests with newline \r\n
*Usernames must be alphanumeric and limited to 20 characters

Commands:
Join
Send "protocol command" and username/identification to join
The chat is joined
Send
Send “Protocol command” with message and username included between / to the server
Server parses username and message
Server sends message and username to the client 
Receive
The client just receives the message listening to the port
Leave
The client sends the request to the server who closes the socket connection

CRP1.0 = version

JOIN Syntax: CRP1.0JOIN username\r\n

SEND Syntax: CRP1.0SEND username message\r\n

LEAVE Syntax: CRP1.0LEAVE username\r\n
