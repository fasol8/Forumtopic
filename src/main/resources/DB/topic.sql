CREATE DATABASE topic;

USE topic;

CREATE TABLE profile(
    id_profile int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    PRIMARY KEY (id_profile)
);

CREATE TABLE course(
    id_course int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    category varchar(50),
    PRIMARY KEY(id_course)
);

CREATE TABLE user(
    id_user int NOT NULL AUTO_INCREMENT,
    name varchar(50) NOT NULL,
    mail varchar(50) NOT NULL,
    password varchar(70) NOT NULL,
    id_profile int NOt NULL,
    PRIMARY KEY(id_user),
    FOREIGN KEY (id_profile) REFERENCES profile (id_profile)
);

CREATE TABLE response(
    id_response int NOT NULL AUTO_INCREMENT,
    message varchar(255) NOT NULL,
    date varchar(25) NOT NULL,
    id_user int NOT NULL,
    solution BOOLEAN,
    PRIMARY KEY(id_response),
    FOREIGN KEY (id_user) REFERENCES user (id_user)
);


CREATE TABLE topic(
    id_topic int NOT NULL AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    message varchar(255) NOT NULL,
    date varchar(25) NOT NULL,
    tag varchar(20) NOT NULL,
    id_user int NOT NULL,
    id_course int NOT NULL,
    id_response int,
    PRIMARY KEY (id_topic),
    FOREIGN KEY (id_user) REFERENCES user (id_user),
    FOREIGN KEY (id_course) REFERENCES course (id_course),
    FOREIGN KEY (id_response) REFERENCES response (id_response)
);