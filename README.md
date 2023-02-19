<a name="readme-top"></a>
# Animal Shelter Management System
This app has been designed to help manage the day-to-day operations of an animal shelter, ensuring that animals are well-cared for, staff members are efficiently assigned tasks, and records are properly managed.


## Table of contents
* 🤖 [Technologies](#technologies-used)
* ⭐ [Features](#features)
* 📖 [Setting up](#getting-started)
* 🌸 [About Me](#about-me)


## Technologies Used
* Backend: Java, SpringBoot, Hibernate, PostgreSQL.
* Frontend: JavaScript, Thymeleaf, Bootstrap, HTML, CSS.
* APIs: Cloudinary API, Java Mail Sender.


## Features

### Dashboard
* User can see their pending tasks for the week, along with their deadline and a button to mark them as completed. 
* They can also see a list of notes with the option to delete and create new ones.
* Using Chart.js, current stats of the shelter are displayed, showing the number of animals, their species, and their availability.
<img src="src/main/resources/static/images/dashboard.png">


### Tasks
* Clicking on "add task" allows the user to create a new task by picking the staff, task description, and the deadline.
<img src="src/main/resources/static/images/add-task.png">
* Whenever the task is created, the person assigned to it gets a notification on their email containing the important information about the task. Feature implemented using JavaMailSender.
<img src="src/main/resources/static/images/email.png">
* On the tasks page, the user can see all the pending tasks, and they can delete the task when it's complete, which is also updated on the user's dashboard.
<img src="src/main/resources/static/images/all-tasks.png">


### Animals
* JavaScript script fetches all the animals from a REST API and creates animal cards for each animal in the list.
* User can filter the animals based on species, gender, and availability.
<img src="src/main/resources/static/images/all-animals.png">
* User can add a new animal filling up a form with all the relevant information about the new animal, including disposition and health. 
* Using Cloudinary API, the user can upload a picture of the animal.
<img src="src/main/resources/static/images/form-filled.png">
* Using Thymeleaf as a template engine, user can see everything about any particular animal by clicking on its name.
<img src="src/main/resources/static/images/anima-profile.png">


### Staff
* On the staff page, the user can see the information about the staff, add new staff members, and delete them.
<img src="src/main/resources/static/images/staffs.png">



## Getting Started

### Prerequisites
Install the software needed to run Java code:

* Visit [jdk.java.net](https://jdk.java.net/)
* Alternatively, AWS provides an easy-to-install JDK known as [Amazon Corretto](https://aws.amazon.com/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc)
* Click on the largest version in “Ready for use”
* Click on your preferred OS (Mac, Windows, or Linux) and continue installation depending on your OS

#### Windows
* Download the file and unzip into Program Files directory/folder
* Copy path to the unzipped program
* In Windows Settings app, search for env, and click Edit System Environment Variables
* Under System variables click New
* Variable name = ```JAVA_HOME ```, value = path you pasted to jdk unzip, then click **OK**

Update existing variable- ```PATH```
* Find ```PATH``` in list, click **edit**
* Click **New**
* Paste path to jdk such as ```C:\Program Files\jdk-17.0.1```
* Add ```\bin```

#### Mac
Follow the instructions for [Amazon Corretto](https://aws.amazon.com/corretto/?filtered-posts.sort-by=item.additionalFields.createdDate&filtered-posts.sort-order=desc)

Then in **~/.bash_profile**, execute the following:
```
export PATH=$HOME/Library/Java/JavaVirtualMachines/jdk-16.jdk/bin:$PATH
```
```
export JAVA_HOME=$HOME/Library/Java/JavaVirtualMachines/jdk-16.jdk/bin
```
and then…
```shell
$ source .bash_profile
```
#### Verify Successful Installation
Run the following command to verify your install:
```shell
$ java --version
```
### Installation
* Copy the [URL](https://github.com/GRISONRF/shelter.git) for the repository 
* Open **Terminal**
* Change the current working directory to the location where you want the cloned directory.
* Type git clone, and then paste the URL you copied earlier.
   ```sh
   git clone https://github.com/GRISONRF/shelter.git
   ```
* Press **Enter** to create your local clone.
```shell
$ git clone https://github.com/GRISONRF/shelter.git
> Cloning into `CoolProject`...
> remote: Counting objects: 52, done.
> remote: Compressing objects: 100% (50/50), done.
> remove: Total 10 (delta 1), reused 10 (delta 1)
> Unpacking objects: 100% (52/52), done.
```
<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]:https://img.shields.io/badge/CONTRIBUTERS-5-green
[contributors-url]: https://github.com/ileanahi/doctors-office/graphs/contributors
[forks-shield]: https://img.shields.io/badge/FORKS-2-blue
[forks-url]: https://github.com/ileanahi/doctors-office/network/members
[issues-shield]: https://img.shields.io/badge/ISSUES-0%20OPEN-yellow
[issues-url]: https://github.com/ileanahi/doctors-office/issues
[Java-shield]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=&logoColor=white
[Java-url]: https://www.java.com/en
[Thymeleaf-shield]: https://img.shields.io/badge/Thymeleaf-48892c?style=for-the-badge&logo=&logoColor=white
[Thymeleaf-url]: https://www.thymeleaf.org/
[SpringBoot-shield]: https://img.shields.io/badge/SpringBoot-8fce00?style=for-the-badge&logo=springboot&logoColor=white
[SpringBoot-url]: https://spring.io/
[Hibernate-shield]: https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white
[Hibernate-url]: https://hibernate.org/
[Register-Page-shield]: https://user-images.githubusercontent.com/81582376/217858466-336fd40a-c6e1-4d12-a8e1-c3694b91f294.png
[Patient-Portal-shield]: https://user-images.githubusercontent.com/81582376/217858611-4051169d-ce13-4a3c-b498-8366fdad0c62.png




## About me

