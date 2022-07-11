package redes;

import java.io.IOException;

public class Game {
	
	private char[][] table;
	private Round round;
	
	public Game() {
		this.table = new char[3][3];
		this.round = Round.X;
		fillTable();
		
		sendMessage("A partida iniciou!");
		sendMessage(print());
		loop();
	}
	
	private void loop() {
		char winner = 'e';
		while(winner == 'e') {
			sendMessage("Vez do jogador " + round + " jogar!");
			read();
			if(checkDraw()) {
				sendMessage("Empate!");
				close();
				break;
			}
			winner = checkWinner();
		}
		
		if(winner != 'e') {
			sendMessage("O vencedor foi " + winner + "!");
			close();
		}
	}
	
	private void close() {
		try {
			Server.serverSocket.close();
			System.exit(1);
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	private void read() {
		try {
			while(true) {
				if(round == Round.X) {
					String xInput = Server.X.read();
					try {
						int slot = Integer.parseInt(xInput);
						if(slot < 1 || slot > 9) {
							Server.X.write("O número deve ser entre 1 e 9!");
						} else if(play('X', slot)) {
							round = Round.O;
							sendMessage(print());
							break;
						} else {
							Server.X.write("A casa " + slot + " já está ocupada!");
						}
					} catch (Exception e) {	Server.X.write("Número inválido!"); }
				} else {
					String oInput = Server.O.read();
					try {
						int slot = Integer.parseInt(oInput);
						if(slot < 1 || slot > 9) {
							Server.O.write("O número deve ser entre 1 e 9!");
						} else if(play('O', slot)) {
							round = Round.X;
							sendMessage(print());
							break;
						} else {
							Server.O.write("A casa " + slot + " já está ocupada!");
						}
					} catch (Exception e) {	Server.O.write("Número inválido!"); }
				}
			}
		} catch (Exception e) {	e.printStackTrace(); }
	}
	
	private void sendMessage(String message) {
		Server.X.write(message);
		Server.O.write(message);
	}
	
	private void fillTable() {
		for(int i = 0; i < 3; i++) { 
			for(int j = 0; j < 3; j++) {
				table[i][j] = '#';
			}
		}
	}
	
	public boolean play(char player, int location) {
		switch (location) {
		case 1:
			if(table[0][0] == '#') {
				table[0][0]	= player;
				return true;
			}
			break;
		case 2:
			if(table[0][1] == '#') {
				table[0][1]	= player;
				return true;
			}
			break;
		case 3:
			if(table[0][2] == '#') {
				table[0][2]	= player;
				return true;
			}
			break;
		case 4:
			if(table[1][0] == '#') {
				table[1][0]	= player;
				return true;
			}
			break;
		case 5:
			if(table[1][1] == '#') {
				table[1][1]	= player;
				return true;
			}
			break;
		case 6:
			if(table[1][2] == '#') {
				table[1][2]	= player;
				return true;
			}
			break;
		case 7:
			if(table[2][0] == '#') {
				table[2][0]	= player;
				return true;
			}
			break;
		case 8:
			if(table[2][1] == '#') {
				table[2][1]	= player;
				return true;
			}
			break;
		case 9:
			if(table[2][2] == '#') {
				table[2][2]	= player;
				return true;
			}
			break;
		}
		
		return false;
	}
	
	private char checkWinner() {
		if(table[0][0] != '#' && table[0][0] == table[0][1] && table[0][0] == table[0][2]) { //1 linha
			return table[0][0];
		} else if(table[1][0] != '#' && table[1][0] == table[1][1] && table[1][0] == table[1][2]) { //2 linha
			return table[1][0];
		} else if(table[2][0] != '#' && table[2][0] == table[2][1] && table[2][0] == table[2][2]) {// 3 linha
			return table[2][0];
		} else if(table[0][0] != '#' && table[0][0] == table[1][0] && table[0][0] == table[2][0]) {//1 coluna
			return table[0][0];
		} else if(table[0][1] != '#' && table[0][1] == table[1][1] && table[0][1] == table[2][1]) {//2 coluna
			return table[0][1];
		} else if(table[0][2] != '#' && table[0][2] == table[1][2] && table[0][2] == table[2][2]) {//3 coluna
			return table[0][2];
		} else if(table[0][0] != '#' && table[0][0] == table[1][1] && table[0][0] == table[2][2]) {//diagonal 1
			return table[0][0];
		} else if(table[0][2] != '#' && table[0][2] == table[1][1] && table[0][2] == table[2][0]) {//diagonal 2
			return table[0][2];
		} else {
			return 'e';
		}
	}
	
	private boolean checkDraw() {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(table[i][j] == '#') {
					return false;
				}
			}
		}
		
		return true;
	}
	
	private String print() {
		String map = "\n";
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				map += table[i][j] + " ";
			}
			map += "\n";
		}
		return map;
	}

	public char[][] getTable() {
		return table;
	}

	public void setTable(char[][] table) {
		this.table = table;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}
	
	public static enum Round {
		X, O;
	}
}
