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
