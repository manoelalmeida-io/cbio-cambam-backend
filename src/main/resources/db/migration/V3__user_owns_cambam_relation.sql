/**
 * Author:  manoel
 * Created: 12 de jun de 2020
 */

ALTER TABLE tb_cambam ADD owner VARCHAR(16) NOT NULL;
ALTER TABLE tb_cambam ADD FOREIGN KEY (owner) REFERENCES tb_user(id);