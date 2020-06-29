/**
 * Author:  manoel
 * Created: 25 de jun de 2020
 */

CREATE TABLE tb_task (
	id VARCHAR(16) PRIMARY KEY,
	title VARCHAR(50) NOT NULL,
	description TEXT,
	creation_date TIMESTAMP NOT NULL,
	due_date TIMESTAMP,
	end_date TIMESTAMP,
	kanban_column BIGINT NOT NULL,
	FOREIGN KEY (kanban_column) REFERENCES tb_column(id)
);