CREATE TABLE HOSPITAL (
    ID number NOT NULL,
    NAME varchar(255) NOT NULL,
    CITY varchar(255),
    RATING number,
    PRIMARY KEY (ID)
);

INSERT INTO HOSPITAL
VALUES (1001, 'Apollo Hospital', 'Chennai', 3.8);

select * from HOSPITAL;

drop table HOSPITAL;

CREATE SEQUENCE hospital_Id
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

drop sequence hospital_Id;