# MaiguaPaul_VGameAPI
This project is about the development of an android app named "VGameAPI", which serves as a database for storing game genres information.
## Tasks
In my project you'll be able to:
* Login
* Add elements (game genres names) to a local database
* See all the database elements inside a list
* Delete all the elements from the database
## Screenshots
### Login
The login section of the app is done through the main activity.\
![Login screen](/images/login_screen.png)
### Splash screen
This is the splash screen with the app logo that shows 2 seconds before the app starts.\
![Splash screen](/images/splash_screen.png)
### Home screen
The home section is a fragment which only shows a delete button for the DB.\
There's also the bottom navigation, which allows the user to navigate through all sections of the app.\
![Home screen](/images/home_screen.png)
### List screen
The list screen displays the list of items with the elements from the database.\
![List screen](/images/list_screen.png)
### Add screen
The add screen has an EditText to enter the name of a game genre and add it to the DB.\
![Add screen](/images/add_screen.png)
## Technologies
This project is developed with android studio and java. I've used this extra classes:
* SQLiteDatabase: for the local storage.
* Fragment Manager: to add/access the different fragments for each task.
* Recycler View: to show the items in the DB ordered in a list.
* Toast: to show a text message confirming that the task has been performed correctly.
## Extra information
### Access:
* Username: admin
* Password: admin
### Colors used:
Purple_500 (#6200EE), purple_700 (#3700B3) and white (#FFFFFF).
### Logo:
Controller.png image from assets_studio.\
![App logo](/images/app_logo.png)
### Errors:
- The delete button from the home screen crashes the app due to the DB not created yet after the login. The DB is created after choosing another screen.
- The delete button doesn't delete the default items in the list. This is because they're not inserted into the database.
## Finished / Unfinished tasks
- [x] Splash Screen
- [x] Bottom Navigation
- [x] Local Storage SQLite
- [x] Login
- [x] Add form
- [x] Recycler list
- [x] Database methods
- [x] Delete all data + dialog
- [x] Screens colors with Theme.xml 
