/**
 * Author:  manoel
 * Created: 12 de jun de 2020
 */

ALTER TABLE tb_kanban ADD owner VARCHAR(16) NOT NULL;
ALTER TABLE tb_kanban ADD FOREIGN KEY (owner) REFERENCES tb_user(id);