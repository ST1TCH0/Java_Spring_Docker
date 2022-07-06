# Java, Spring, Docker
## Description
Main goal of the project was an implementation of Web page which allows to manage information about vehicles. There are 2 classes: Mark (category) and Model (entity). For each class there is possibility of adding, editing and removing objects.
## Construction
Backend consists of three Java Spring applications: one for managing each class and one gateway. Data is stored in H2 database. Frontend is a set of simple html pages. Project was moved into Docker containers. One container has an application and the other one is a reverse proxy. Containers are connected to one network so you can access  application through reverse proxy at address "http://localhost:8085".
## Frontend view
<p align="center">
  <img class="image" src="https://user-images.githubusercontent.com/64905551/177439191-cdef51be-d655-4590-9a7c-767ab17f3b52.png" width="270" />
  <img class="image" src="https://user-images.githubusercontent.com/64905551/177438585-ef130b00-657e-425a-952d-fdf309133a28.png" width="250" />
  <img class="image" src="https://user-images.githubusercontent.com/64905551/177439345-688c431b-938e-4ce4-a8c3-61b9e49a7133.png" width="250" />
</p>


