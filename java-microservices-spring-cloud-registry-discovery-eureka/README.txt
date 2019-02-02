Run configurations
In /etc/hosts file, make two below names like below

127.0.0.1 peer1
127.0.0.1 peer2
and then in IDE , run as  
-Dspring.profiles.active=peer1
-Dspring.profiles.active=peer2