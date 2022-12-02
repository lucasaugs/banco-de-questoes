CREATE TABLE Professor(
    idUsr int(11) NOT NULL AUTO_INCREMENT,
    nomeUsr varchar(60) DEFAULT NULL,
    nome varchar(60) DEFAULT NULL,
    senha varchar(2000) NOT NULL,
    usrAluno tinyint(1) not null default 0,
    PRIMARY KEY (idUsr)
);

CREATE TABLE Aluno(
    idUsr int(11) NOT NULL AUTO_INCREMENT,
    matricula int(11) DEFAULT NULL,
    nomeUsr varchar(60) DEFAULT NULL,
    nome varchar(60) DEFAULT NULL,
    senha varchar(2000) NOT NULL,
    usrAluno tinyint(1) not null default 1,
    PRIMARY KEY (idUsr)
);

CREATE TABLE Tema(
    idTema int(11) NOT NULL AUTO_INCREMENT,
    nome varchar(60) DEFAULT NULL,
    PRIMARY KEY (idTema)
);

CREATE TABLE Relatorio(
    idRel int(11) NOT NULL AUTO_INCREMENT,
    semestre varchar(20) DEFAULT NULL,
    turma varchar(20) DEFAULT NULL,
    atividade varchar(50) DEFAULT NULL,
    notaMedia double DEFAULT NULL,
    PRIMARY KEY (idRel)
);

CREATE TABLE Questao(
    idQuestao int(11) NOT NULL AUTO_INCREMENT,
    enunciado varchar(500) DEFAULT NULL,
    publica BIT NOT NULL,
    resposta varchar(300) DEFAULT NULL,
    idRel int(11) DEFAULT NULL,
    FOREIGN KEY (idRel) REFERENCES Relatorio (idRel),
    PRIMARY KEY (idQuestao)
);

CREATE TABLE QuestaoXTema(
    idQuestao int(11) NOT NULL,
    idTema int(11) NOT NULL,
    CONSTRAINT PK_QuestaoxTema PRIMARY KEY (idQuestao, idTema),
    CONSTRAINT FK_QuestaoxTema2 FOREIGN KEY (idQuestao) REFERENCES Questao (idQuestao),
    CONSTRAINT FK_QuestaoxTema3 FOREIGN KEY (idTema) REFERENCES Tema (idTema)
);

INSERT INTO Professor (nomeUsr, senha) VALUES
    ('Clodoveu','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
    ('Raquel','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
    ('Eduardo','03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4');

INSERT INTO Aluno (nomeUsr, matricula, senha) VALUES
    ('Igor',7777777,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
    ('Misael',555555,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
    ('Guilherme',888888,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4'),
    ('Joao',3333333,'03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4');

INSERT INTO Tema (nome) VALUES
    ('Engenharia de Requisitos'),
    ('Testes de Software'),
    ('Diagrama de Classes'),
    ('Métodos Ageis');

INSERT INTO Relatorio (semestre,turma,atividade,notaMedia) VALUES
    ('2021/1','DCC633','Prova1',8.5),
    ('2021/1','DCC633','Prova1',10),
    ('2021/2','DCC60','Prova3',5.2);
    
INSERT INTO Questao (enunciado, publica, resposta, idRel) VALUES
    ('O que e um diagrama de classes?',1,'Um diagrama que mostra as classes',1),
    ('O que e um Teste?',0,'Uma coisa que testa',2),
    ('O que e um metodo agil?',0,'Um metodo rapido',3);

INSERT INTO QuestaoXTema (idQuestao,idTema) VALUES
    (1,3),
    (1,4),
    (2,2),
    (3,4),
    (3,2);
