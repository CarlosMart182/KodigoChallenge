# KodigoChallenge
This api provide different endpoints for get, update, save or delete information related to Person.

Technologies behind the API:
Java 8
Spring boot
Spring Rest
Postgresql DB

Instalation requirements:
JDK 1.8
Postman
Git
You can clone the project using git or you can directly download the project from GitHub and then unzip the file. If you want to clone the project using git, please open the terminal and type:
https://github.com/CarlosMart182/KodigoChallenge.git

Configuring Postman
Open PostMan application and press the button import and select the file which is located under the cloned project restAPI with name RestItemApi.postman_collection.json. This file contains all the requests of the API.

There is no need to send a token for the request

You can do a Post, Get, Put or Delete request without the need of a token

Here is a Post request example:
{
    "first_name": "Juan",
    "last_name": "Ruiz"
}

Here is a Get request example:
 "id_person": 1,
        "first_name": "Juan",
        "last_name": "Ruiz",
        "notesList": [],
        "contactList": []
    },
    {
        "id_person": 2,
        "first_name": "dsfdf",
        "last_name": "fdgd",
        "notesList": [],
        "contactList": []
    }
    
    the endpoints will return status 200 for Get and 201 for Post.

