robotics
========

Robotics Portlet designed on Liferay 6.1 MVC having alloy ui ajax calls. Which caters the basic stuff of robot performed operations

Features of Robot Prototype :

A) Power Operated:
1. Robot works on battery and can walk for 5 km per charge. 
2. If remaining battery is less than 15%, a red light on Robot head should lit up indicating low battery.
B) Handling physical objects:
1. Robot can carry any object not weighing more than 10 Kg.
2. For every Kilogram carried by Robot, 2% extra [in addition to walking discharge] battery will be consumed.
3. If the weight of the object is more than 10 Kg, Robot display [LED display on chest] will show message "Overweight". 

Technology Stack
A) Robot logic is implemented over Observer Design Pattern.
B) Enriched Notification System.
C) Designed over JSR 286 portlet specification, able to deploy on liferay 6.1 or higher version server
D) Alloy UI Implementation to construct the UI
E) Junit has written up on top of PowerMock API.
F) Application can be executable as a standalone java application.

