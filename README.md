# TP_EngSoft_2022.2_BancoDeQuestoes
Project for the discipline of Software Engineering II (2022.2) that consists in a bank of questions that can be consulted by techers and students.

# Membros do Grupo:
Lucas Augusto da Silva Gonçalves;<br />
Ailton Vinaud Junior;<br />
Igor Roiz Teixeira.<br />

# Sobre as tecnologias:
O trabalho foi feito usando o padrão de arquitetura MVC (Model View Controller), que é uma arquitetura que simplifica a troca de informações entre a interface e o banco de dados. É uma arquitetura separada em três camadas principais:Modelo, Controlador e Interface. Adicionamos uma camada extra mais abaixo com o acesso ao banco de dados, de forma que esse acesso possa ser controlado separado do resto do sistema.

No nosso trabalho usamos banco de dados MySQL. É usado DAO para acesso ao banco de dados. O DAO é um padrão de projeto com o objetivo de encapsular classes e funções responsáveis por acessar o banco de dados. O DAO faz a comunicação com o model, que tem as entidades e os serviços. As entidades são classes usadas para o desenvolvimento, como classe Aluno e classe Professor. Já os serviços fazem a ligação entre o controller e o dao. Por último, o controller faz a ligação entre o model e a interface do usuário, passando para o model informações inseridas na interface, e para a interface informações vindas do model.

# Algumas decisões que tomamos no desenvolvimento:
●	Temos dois tipos de usuário: Professor e Aluno, ambos herdando de Usuário, essa diferença é importante para definir se o usuário logado pode acessar as questões privadas ou não;<br /><br />
●	Tema e Relatorio são classes a parte que se relacionam com questão, isso foi feito pois um tema pode estar relacionado a várias questões, e essas podem ser pesquisadas por temas, com os temas sendo objetos evitamos incompatibilidades;<br /><br />
●	Questões podem ter ou não um relatório, isso poderia sobrecarregar de informações inúteis tanto a classe questão quanto a tabela no banco de dados, sem contar que complicaria a inclusão do relatório a parte na interface.<br /><br />
●	O parâmetro “publica” da classe Questao define se alunos podem ou não ver uma questão, o valor é TRUE para questões públicas que podem ser acessadas e FALSE para as privadas que apenas professores podem ver;<br /><br />
●	Questões podem possuir mais de um tema e compartilhar temas;<br /><br />
●	Temas são objetos a parte para se controlar os temas disponíveis dentro do sistema, facilitando consultas e evitando duplicidades






