# Learning-management-system project - backend implementation using Spring boot

This is the backend implementation for the project "Learning-management-system". It is implemented 
using Java Spring boot. It is an attempt to learn Java Spring by trying to implementing all
the Backend REST APIs using Spring. The same set of features are also implemented using
NodeJS(Express) as an attempt to learn NodeJS.

The NodeJS based backend of this project can be found [here](https://github.com/AshwinKAshok/learning-management-backend-node).

# What it does?

The Spring boot backend application APIs to:

* REST APIs to CRUD courses
* REST APIs to CRUD Lessons under courses
* REST APIs to CRUD modules under lessons

The service uses AWS RDS to persist data.

# Different parts of this project

This project was used as a way to learn different tech stacks. The frontend
and backend of the project has been implemented different using different technologies.
However, due to the consistency of API structure across 2 different
 backend technologies used, any frontend client can be connected to any of the 
 backend application and the web application will still run fine.
 
### Tech stacks used:
* ### Frontend:
    * React and redux based frontend can be found [here](https://github.com/AshwinKAshok/learning-management-frontend-react).
    * AngularJS based frontend can be found [here](https://github.com/AshwinKAshok/learning-management-frontend-angular).
* ### Backend:
    * Backend using Spring boot and AWS RDS for database is this repo.
    * Backend using NodeJS and MongoDB for database can be found [here](https://github.com/AshwinKAshok/learning-management-backend-node).
