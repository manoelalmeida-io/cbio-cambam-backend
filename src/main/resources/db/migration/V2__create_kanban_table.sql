/**
 * Author:  manoel
 * Created: 12 de jun de 2020
 */

CREATE TABLE tb_kanban (
    id VARCHAR(16) PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE
);