<a name="readme-top"></a>
# Animal Shelter Management System
This app has been designed to help manage the day-to-day operations of an animal shelter, ensuring that animals are well-cared for, staff members are efficiently assigned tasks, and records are properly managed.


## Table of contents
* 🤖 [Technologies](#technologies-used)
* ⭐ [Features](#features)
* 📖 [Setting up](#getting-started)
* 🌸 [About the Author](#about-the-author)


## Technologies Used
* Backend: Java, SpringBoot, Hibernate, PostgreSQL.
* Frontend: JavaScript, Thymeleaf, Bootstrap, HTML, CSS.
* APIs: Cloudinary API, Java Mail Sender.


## Features
<p align="right">(<a href="#readme-top">back to top</a>)</p>

### Dashboard
* User can see their pending tasks for the week, along with their deadline and a button to mark them as completed. 
* They can also see a list of notes with the option to delete and create new ones.
* Using Chart.js, current stats of the shelter are displayed, showing the number of animals, their species, and their availability.

https://user-images.githubusercontent.com/81582376/220479408-ad699ce5-e52c-4184-82e9-17ab0a7d8e1a.mp4


### Tasks
* Clicking on "add task" allows the user to create a new task by picking the staff, task description, and the deadline.
* Whenever the task is created, the person assigned to it gets a notification on their email containing the important information about the task. Feature implemented using JavaMailSender.
* On the tasks page, the user can see all the pending tasks, and they can delete the task when it's complete, which is also updated on the user's dashboard.

https://user-images.githubusercontent.com/81582376/220480844-0a6d959e-c83b-45dd-a239-b7efb04f7f3a.mp4


### Animals
* JavaScript script fetches all the animals from a REST API and creates animal cards for each animal in the list.
* User can filter the animals based on species, gender, and availability.
* User can add a new animal filling up a form with all the relevant information about the new animal, including disposition and health. 
* Using Cloudinary API, the user can upload a picture of the animal.
* Using Thymeleaf as a template engine, user can see everything about any particular animal by clicking on its name.

https://user-images.githubusercontent.com/81582376/220480886-742366d2-dcf7-44e8-9773-2990b53812c7.mp4


### Staff
* On the staff page, the user can see the information about the staff, add new staff members, and delete them.

https://user-images.githubusercontent.com/81582376/220480909-c83eb7d8-a992-4a54-a34c-2bc89d8bf5a8.mp4


## Getting Started
<p align="right">(<a href="#readme-top">back to top</a>)</p>

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




## About the Author
<p align="right">(<a href="#readme-top">back to top</a>)</p>
Rafaela completed a comprehensive full-stack bootcamp in the previous year, where she gained in-depth knowledge of several technologies, including Python, Flask, React, and Data Manipulation. <br>
Following her bootcamp, she continued her pursuit of knowledge by contributing her expertise to various open-source projects, and volunteered to HackforLA and Out in Tech, collaborating with fellow software engineers and exploring different tech stacks.<br>
In 2023, she embarked on a new journey to acquire proficiency in Java, and the Walmart vs. Hackbright bootcamp provided the necessary impetus to achieve this objective!
