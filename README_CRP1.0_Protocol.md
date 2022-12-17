# Chatroom-App

 CHATROOM PROTOCOL


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
