INSERT INTO tb_user(email, username, password) VALUES ('jc@gmail.com', 'joao', '$2a$12$AlnbeLG./9yRd4UVGkpRu.NaBKVnRRv/DdOyX2JYq.kTpNEH1EnkC');
INSERT INTO tb_user(email, username, password) VALUES ('julio@gmail.com', 'junior', '$2a$12$AlnbeLG./9yRd4UVGkpRu.NaBKVnRRv/DdOyX2JYq.kTpNEH1EnkC');
INSERT INTO tb_role(id, authority) VALUES (1, 'ROLE_USER');
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);