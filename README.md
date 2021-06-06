# Uptrillion-Handler

## Overview
This is a program called "_**handler**_" for retrieving transaction data from Uptrillion and then submitting requests to processors such as FDRC and CYBS. It includes a couple of functionalities that encrypting transaction data, preprocessing data and other extra logics which were previously inside of traditional POS machine.

## Build and Run

**Package maven project**
1. Open directory of pom.xlm in CMD
2. Assembly exectuable jar: `mvn clean compile assembly:single`
3. If have problem, then check the depedent reference by: `mvn dependency:tree -Dverbose > tree.txt`
4. Heading /target to find the exectuable jar: `updtrillion.xxx-jar-with-dependencies.jar`
5. Move the file user.json in /target/classes folder into /target, same directory with updtrillion.xxx-jar-with-dependencies.jar


**Run this program:**
###### In local machine: 
`java -jar name.jar`

###### AWS:
1. check processor list:
   `ps -ef | grep java`

2. nohup running exectuable jar: 
   `nohup java -jar  name.jar  &>  file-name-timeslot.out &ls`

3. kill process:
   `kill process_id`

###### Auto-lauch in Linux(Using Systemd):

1. Put your command into `handler-startup-script.sh` file.
2. Move this file to /usr/local/bin . `sudo mv handler-startup-script.sh /usr/local/bin`
3. Create a service file in systemd folder: 
   `sudo nano /etc/systemd/system/autolauch-handler.service` (service name can be defined by yourself, and may need root-user auth)
   copy and modify example script inside of file `autolauch-handler.service` . Or copy this file onto above path. 
   `sudo mv autolauch-handler.service /etc/systemd/system` 
   You can also customize it if you play well with `man systemd`:
   **P.S. If you want the handler restart automatically every time this process comes down, just uncomment the Restart line** 
   
4. Make our script executable: `chmod 744 /usr/local/bin/handler-startup-script.sh`
5. Setting read-write mode of service: 
   `chmod 664 /etc/systemd/system/autolauch-handler.service`
6. Reload system daemon and enable service unit to be executed:
   `systemctl daemon-reload`, `systemctl enable autolauch-handler.service`
7. Test your script before you reboot: `systemctl start autolauch-handler.service`
   
   Check status: `systemctl status autolauch-handler.service`

## Documentation

- Multithreading: Handler is making use of [a simple pattern](supplementaryDoc/multithreadingHandler.pdf) of multithreading. 
  The main thread can initialize sub-thread for each new phic and read status of them. 
  The sub-thread can update their own status and terminate once they finish work or get interrupted.
  
- Spring Boot: This is an advanced version of handler with Spring Boot Framework. 
## Get Started

...coming soon

# Contributing
...coming soon
