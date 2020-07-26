# HermesApp

_Navigation App for NMAMIT, Nitte._

![newapplogo](https://user-images.githubusercontent.com/49337267/88473030-0e66f200-cf37-11ea-922c-f45ac3419dbc.png)

## About The App

### Scope

HermesApp is a flexible, user-friendly app designed with the sole purpose of being a highly efficient app for the students. The app, at its core, is a navigation device.

### Importance

The target audience for this app are the freshers, but it can be used by anyone, even the professors, or people visiting the college. As the college campus is quite massive, navigating efficiently for a someone new is not easy. This app helps remove that problem by providing the shortest path possible to user’s intended destination. The application is implemented on android platform.

### Objective

The objective of this project is a mobile application developed for navigation in the college premises. Since navigating in the same building through multiple floors is not an easy ordeal, this app uses photos to familiarise the user about his surroundings. The user can look around and use his surroundings to help with deciding the source.


## Implementation

HermesApp has been designed to automate and manage the routes internally. No user is given the privilege to alter the routes that are generated by the app. This prevents fraud routes or change of route over time by the users.

### App Functionality

The app runs based on an algorithm that helps decide the shortest distance from the intended source to the expected destination. The app then finds the shortest route possible taking into consideration all the intermediate routes. This way, the route is found as the shortest one to the destination, but not necessarily the one with least crowd. The app runs with the ideology that students will familiarise themselves with the route after multiple use, and that the app will be used only during initial days when the destination is hard to find.
Once familiar with the route, if the user is one with privileges, then he/she will be allowed to alter the route to make it more feasible to access. This flexibility given to the app makes it more user-friendly, as it evolves after multiple usage.

## Working of the App

* **Home screen** _(The landing page of the app, which shows the map of the current floor)_

![home](https://user-images.githubusercontent.com/49337267/88475695-fa7bba00-cf4f-11ea-8924-864a63622157.png)


* **Brief information** (Brief information on the selected tab is given to the user. Name of the room, Name of the professor the room is assigned to, Qualification and Designation)

![brief](https://user-images.githubusercontent.com/49337267/88475709-1da66980-cf50-11ea-81bd-745d2b6615b1.png)


* **Path Generation** _(On selecting a source and destination from the dropdowns provided, and then clicking on the 'Generate' button, a virtual path is displayed on the map. This path starts from the source node and traverses through multiple intermediate nodes, before reaching the destination node)_

![generate](https://user-images.githubusercontent.com/49337267/88475711-2a2ac200-cf50-11ea-9d09-b5a1ba61d413.png)


* **Navigation** _(The navigation is done photographically. Node and path are alternated to provide a more comprehensive and confusion-free access to intended locations. One reaching the destination node, a popup message appears notifying that the destination has been reached. The user can also go back to the previous location, in case they get lost during traversing)_ 

![route](https://user-images.githubusercontent.com/49337267/88475565-c05de880-cf4e-11ea-86a8-07bdbb99c8b9.png)


## Miscellaneous

Two themes have been added to the app to provide users with the option to switch it to suit their liking.

**Frost**

![theme](https://user-images.githubusercontent.com/49337267/88475713-3282fd00-cf50-11ea-929d-1b1674ab8988.png)

**Ember**

![ember](https://user-images.githubusercontent.com/49337267/88475448-8213f980-cf4d-11ea-8402-c0607aee19d0.png)

