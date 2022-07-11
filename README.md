Projeto de redes desenvolvido pelos alunos: Victor Hugo Sampaio Lima e Kleber Vasconcelos Oliveira Junior.

_Projeto testado exportando os arquivos como Runnable Jar File_

O projeto se baseia no famoso jogo da velha, onde cada jogador deve inserir o seu caracter (X ou O) em uma casa do tabuleiro (uma matriz 3 x 3). Ganha aquele que completar uma linha, coluna ou diagonal com os seus caracteres.
Caso o tabuleiro seja preenchido e ninguém venceu, o jogo acaba como empate.

Para jogar o nosso jogo, primeiro é preciso iniciar o arquivo Servidor.jar através do comando no cmd: java -jar Servidor.jar.
Após iniciar o servidor, ele criará um arquivo chamado server-config.properties, onde nele é possível alterar a porta em que o servidor operará. O arquivo já vem como default a porta '5678', caso deseje alterar a porta,
aperte as teclas CTRL + C no cmd para fechar o servidor. Após, você pode abrir o arquivo com um editor de texto e alterar o campo port. Após isso, basta executar o comando novamente para abrir o servidor.

Após configurado o servidor, é hora de configurar o cliente. Do mesmo jeito que iniciamos o servidor, vamos iniciar o cliente, porém apenas alterando o nome do arquivo para Cliente.jar (java -jar Cliente.jar).
Após iniciar o cliente, criar-se-á o arquivo client-config.properties, onde analogamente ao servidor, é possível alterar a porta, porém no cliente também é possível alterar o IP no qual o servidor está hospedado. O IP
padrão do cliente é 'localhost'. Para modificar algum campo, basta repetir o processo descrito na configuração do servidor.

Após configurado os dois arquivos, é hora de iniciar o jogo. Primeiro, deve-se abrir o arquivo do servidor com o comando mencionado anteriormente, e após iniciado, o servidor exibirá uma mensagem na tela: "Servidor iniciado!".
Agora, deve-se iniciar os dois arquivos do cliente, um para cada jogador. Ao iniciar, o cliente conectar-se-á automaticamente ao servidor, e receberá o seu caracter (X ou O). O servidor atribui o X para o primeiro cliente que se
conecta e atribui O para o segundo. Após ambos clientes se conectarem, o jogo inicia, e é a vez do jogador X. Para jogar, o jogador deve digitar um número de 1 a 9 referente á casa que deseja jogar. Exemplo:

Tabuleiro inicial:

# # # 1 2 3

# # # onde cada casa corresponde -> 4 5 6

# # # 7 8 9

Caso o jogador X digite '1', o servidor responderá com o tabuleiro atualizado:

X # #

#

#

Após o jogador X jogar corretamente\*, o servidor responderá que é a vez do jogador O jogar, e assim em diante, até o jogo acabar, ou seja, até alguém ganhar ou ocorrer um empate. Após finalizado, o servidor responderá com uma mensagem
com o caracter do vencedor 'O vencedor foi <X ou O>!, ou caso empate: 'Empate!', e após enviar, o servidor é fechado automaticamente. Após receberem uma dessas mensagens, o cliente se desconecta automaticamente do servidor,
e exibe a mensagem de jogo encerrado, fechando assim automaticamente o cliente.

\*jogar corretamente: Jogar corretamente é digitar um número entre 1-9 e cuja casa não tenha sida jogada antes. Em caso de jogada inválida, o servidor responderá com "Número inválido!", "O número deve ser entre 1 e 9!" ou
"A casa x já está ocupada!".
