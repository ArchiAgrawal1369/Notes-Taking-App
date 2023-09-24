# Notes-Taking-App
#### Notes Taking Web Application | Technologies Used : Angular + SpringBoot + JPA + Java based 

The Notes Taking Application stores notes of different users, where a user can login and view 10 recent notes. The application deletes all the notes other than last 10 recent notes on the hourly basis using a cron job. It has been developed using Angular for implementing user authentication and CRUD operations in the frontend, and SpringBoot for exposing REST APIs in the backend.

## Backend
<ul>
  <li>Rest API for user registration.</li>
  <li>Rest API for user login  after proper authentication.</li>
  <li>Get 10 recent notes of a particular user.</li>
  <li>Rest API to support CRUD functionality on notes.</li>
  <li>Cron job to delete notes other than 10 recent notes on hourly basis.</li>
</ul>

## Frontend
<ul>
  <li> Home Component.<br>
    <img src="./Frontend-Application/src/assets/Screenshot 2023-09-22 162350.png">
  </li><br>
  <li> Registration Component with appropriate form validation.<br>
    <img src="./Frontend-Application/src/assets/Screenshot 2023-09-22 162452.png">
  </li><br>
  <li>  Login Component with appropriate form validation.<br>
    <img src="./Frontend-Application/src/assets/Screenshot 2023-09-22 162436.png">
  </li><br>
  <li>  View All Notes Component with Guards.<br>
    <img src="./Frontend-Application/src/assets/Screenshot 2023-09-22 163943.png">
  </li><br>
  <li>  View Note Description Component.<br>
    <img src="./Frontend-Application/src/assets/Screenshot 2023-09-23 150235.png">
  </li><br>
  <li>  Add Note Component with Guards.<br>
    <img src="./Frontend-Application/src/assets/Screenshot 2023-09-22 163959.png">
  </li><br>
  <li>  Edit Note Component Guards.<br>
    <img src="./Frontend-Application/src/assets/Screenshot 2023-09-22 164042.png">
  </li><br>
</ul>
