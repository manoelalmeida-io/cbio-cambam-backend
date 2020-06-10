/**
 * Author:  manoel
 * Created: 10 de jun de 2020
 */

CREATE TABLE tb_user(
    id varchar(15) PRIMARY KEY,
    name varchar(50) NOT NULL,
    email varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    github_username varchar(50)
);