-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
insert into Funcionario (id, nome, cref, endereco, telefone) values(nextval('hibernate_sequence'), 'Karina Varela', 'CREF 055555-G/SP','Rua 10 Casa 10', '21999999129');
insert into Funcionario (id, nome, cref, endereco, telefone) values(nextval('hibernate_sequence'), 'Andre Brandão', 'CREF 000050-G/RO','Rua 11 Casa 11', '61999999112');
insert into Funcionario (id, nome, cref, endereco, telefone) values(nextval('hibernate_sequence'), 'John Doe', 'CREF 016490-G/DF','Rua 11 Casa 11', '21999999129');
insert into Funcionario (id, nome, cref, endereco, telefone) values(nextval('hibernate_sequence'), 'Ian V.', 'CREF 990050-G/RJ','Rua 12 Casa 12', '61999929112');
insert into Funcionario (id, nome, cref, endereco, telefone) values(nextval('hibernate_sequence'), 'Hector B.', 'CREF 016230-G/DF','Rua 13 Casa 13', '21999913232');
