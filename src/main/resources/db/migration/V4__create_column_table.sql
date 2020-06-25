/**
 * Author:  manoel
 * Created: 25 de jun de 2020
 */

CREATE TABLE tb_column (
	id BIGSERIAL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	position INT NOT NULL,
	kanban VARCHAR(16),
	FOREIGN KEY (kanban) REFERENCES tb_kanban(id)
);