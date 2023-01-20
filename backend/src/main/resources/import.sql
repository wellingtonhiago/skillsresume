INSERT INTO tb_users (user_name, full_name, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES ('maria', 'Maria Rita', 'c0d6b7b7a97ac701f5466a38e317e49f2647f99b9f2f1e9a9f2c652a73e3ac0a60644e0f25db642f', 1, 1, 1, 1);
INSERT INTO tb_users (user_name, full_name, password, account_non_expired, account_non_locked, credentials_non_expired, enabled) VALUES ('flavio', 'Flavio Costa', 'ab95173bbf7bb94452c2b8ac1aa86c6e27418df4447d47b782aa1712a5b7f89a1001a5570bbac36a', true, true, true, true);

INSERT INTO tb_permission (description) VALUES ('ADMIN');
INSERT INTO tb_permission (description) VALUES  ('MANAGER');
INSERT INTO tb_permission (description) VALUES ('COMMON_USER');

INSERT INTO user_permission (id_user, id_permission) VALUES (1, 1);
INSERT INTO user_permission (id_user, id_permission) VALUES (2, 1);
INSERT INTO user_permission (id_user, id_permission) VALUES (1, 2);


INSERT INTO tb_curriculum (title, objetive) VALUES ('DESENVOLVEDOR FRONTEND', 'CONQUISTAR PRIMEIRA VAGA DEV');
INSERT INTO tb_curriculum (title, objetive) VALUES ('DESENVOLVEDOR BACKEND', 'CONQUISTAR PRIMEIRA VAGA DEV');
INSERT INTO tb_curriculum (title, objetive) VALUES ('DEVOPS', 'CONQUISTAR PRIMEIRA VAGA');

INSERT INTO tb_social_netowork (name, url, curriculum_id) VALUES ('GITHUB', 'https://github.com/joosecj', 1);
INSERT INTO tb_social_netowork (name, url, curriculum_id) VALUES ('LINKEDIN', 'https://www.linkedin.com/in/joosecj-dev/', 1);
INSERT INTO tb_social_netowork (name, url, curriculum_id) VALUES ('GITHUB', 'https://github.com/joosecj', 2);
INSERT INTO tb_social_netowork (name, url, curriculum_id) VALUES ('LINKEDIN', 'https://www.linkedin.com/in/joosecj-dev/', 2);

INSERT INTO tb_address (city, state, zip_code, curriculum_id) VALUES ('Rio de Janeiro', 'RJ', '26599-000', 1);
INSERT INTO tb_address (city, state, zip_code, curriculum_id) VALUES ('Urbelândia', 'MG', '25499-123', 2);
INSERT INTO tb_address (city, state, zip_code, curriculum_id) VALUES ('São Paulo', 'SP', '11568-345', 3);

INSERT INTO tb_experience (start_date, end_date, resume, curriculum_id) VALUES ('2018-10-06', '2019-08-10', 'Atendimento ao publico', 1);
INSERT INTO tb_experience (start_date, end_date, resume, curriculum_id) VALUES ('2018-10-06', '2019-08-10', 'Desenvolvedor Front', 1);
INSERT INTO tb_experience (start_date, end_date, resume, curriculum_id) VALUES ('2017-11-02', '2022-12-20', 'Telemarketing', 2);
INSERT INTO tb_experience (start_date, end_date, resume, curriculum_id) VALUES ('2017-11-02', '2022-12-20', 'Manutenção', 2);

INSERT INTO tb_skill (name, curriculum_id) VALUES ('Curso React', 1);
INSERT INTO tb_skill (name, curriculum_id) VALUES ('Curso JavaScript', 1);
INSERT INTO tb_skill (name, curriculum_id) VALUES ('Curso Java', 2);
INSERT INTO tb_skill (name, curriculum_id) VALUES ('Curso SpringBoot', 2);

INSERT INTO tb_formation (name, start_date, end_date, curriculum_id) VALUES ('FACULDADE', '2017-11-02', '2022-12-20', 1);
INSERT INTO tb_formation (name, start_date, end_date, curriculum_id) VALUES ('CURSO TECNICO', '2017-11-02', '2022-12-20', 1);
INSERT INTO tb_formation (name, start_date, end_date, curriculum_id) VALUES ('FACULDADE', '2017-11-02', '2022-12-20', 2);
INSERT INTO tb_formation (name, start_date, end_date, curriculum_id) VALUES ('FACULDADE', '2017-11-02', '2022-12-20', 2);
