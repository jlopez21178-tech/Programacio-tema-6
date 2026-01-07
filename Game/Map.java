public class Map {
	private String[][] map;
	private int size;

	public Map(int size) {
		this.size = size;
		map = new String[size][size];
	}

	public void startGame(Player hero, Player monst) {
		hero.setRow((int) (Math.random() * (this.size - 1)));
		hero.setColumn((int) (Math.random() * ((this.size - 1) / 3)));
		monst.setRow((int) (Math.random() * (this.size - 1)));
		monst.setColumn((int) (Math.random() * ((this.size - 1) / 3) + ((this.size - 1) * 2 / 3)));
	}

	public void showMap() {
		for (int i = 0; i < this.size; i++) {
			System.out.print("\u001B[30m+---".repeat(this.size));
			System.out.print("+");
			System.out.println();
			for (int j = 0; j < this.size; j++) {
				System.out.print("|" + map[i][j]);
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.print("+---".repeat(this.size));
		System.out.print("+\u001B[30m");
		System.out.println();
	}

	public void clear() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				map[i][j] = "   ";
			}
		}
	}

	public void placePlayer(Player player) {
		map[player.getRow()][player.getColumn()] = " " + player.getColor() + player.getIcon() + "\u001B[30m ";
	}

	public boolean validMove(int row, int col) {
		return (map[row][col].equals("   ") && !(row < 0 || row >= this.size || col < 0 || col >= this.size));
	}

	public boolean inRange(Player hero, Player monst) {
		return Math.abs(monst.getRow() - hero.getRow()) <= 1 && Math.abs(monst.getColumn() - hero.getColumn()) <= 1;
	}

	public void moveMonst(Player monst, Player hero) {
		if (Math.abs(monst.getRow() - hero.getRow()) > 1) {
			if (monst.getRow() < hero.getRow()) {
				monst.setRow(monst.getRow() + 1);
			} else {
				monst.setRow(monst.getRow() - 1);
			}
		}
		if (Math.abs(monst.getColumn() - hero.getColumn()) > 1) {
			if (monst.getColumn() < hero.getColumn()) {
				monst.setColumn(monst.getColumn() + 1);
			} else {
				monst.setColumn(monst.getColumn() - 1);
			}
		}
	}

	public void moveHero(Player hero) {
		int newRow;
		int newCol;
		int option;
		do {
			System.out.println("On et vols moure?");
			do {
				option = Utils.validateInt(1, 9);
			} while (option == 5);

			newRow = hero.getRow();
			newCol = hero.getColumn();
			switch (option) {
				case 1 -> {
					newRow--;
					newCol--;
				}
				case 2 -> {
					newRow--;
				}
				case 3 -> {
					newRow--;
					newCol++;
				}
				case 4 -> {
					newCol--;
				}
				case 6 -> {
					newCol++;
				}
				case 7 -> {
					newRow++;
					newCol--;
				}
				case 8 -> {
					newRow++;
				}
				case 9 -> {
					newRow++;
					newCol++;
				}
			}
			if (!validMove(newRow, newCol)) {
				System.out.println("Error. Posicio no valida");
			}
		} while (!validMove(newRow, newCol));
		hero.setRow(newRow);
		hero.setColumn(newCol);
	}
}
