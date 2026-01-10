import java.lang.Thread.sleep

// until now, not functioning as expected

fun boardPrint(board: MutableList<MutableList<Char>>) {
	for (row: MutableList<Char> in board) {
		for (col: Char in row) {
			print(col)
		}
		println()
	}
	println()
	println("-".repeat(board[0].size))
	println()
}

fun updateBoard(board: MutableList<MutableList<Char>>): MutableList<MutableList<Char>> {
	val newBoard: MutableList<MutableList<Char>> = board.map { row ->
		row.toMutableList()
	}.toMutableList()
	for (row: Int in 0 ..< board.size) {
		for (col: Int in 0 ..< board[row].size) {
			var neighbors: Int = 0
			for (neighborRowOffset: Int in -1 .. 1) {
				val neighborRow = row + neighborRowOffset
				for (neighborColOffset: Int in -1 .. 1) {
					val neighborCol = col + neighborColOffset
					if (neighborRow == 0 && neighborCol == 0) {
						// not a neighbor
						continue
					}
					if (neighborRow < 0 || neighborRow >= board.size || neighborCol < 0 || neighborCol >= board[row].size) {
						// out of bounds
						continue
					}
					if (board[neighborRow][neighborCol] == '#') {
						neighbors++
					}
				}
			}
			when (board[row][col]) {
				'#' -> {
					newBoard[row][col] = when {
						neighbors < 2 -> ' '
						neighbors > 3 -> ' '
						else -> '#'
					}
				}
				' ' -> {
					if (neighbors == 3) {
						newBoard[row][col] = '#'
					}
				}
			}
		}
	}
	return newBoard
}

fun main() {
	var board: MutableList<MutableList<Char>> = mutableListOf()
	val rows: Int = 16
	val cols: Int = 64
	for (row: Int in 0 ..< rows) {
		board.add(mutableListOf())
		for (col: Int in 0 ..< cols) {
			board[row].add(' ')
		}
	}
	boardPrint(board)
	board[3][5] = '#'
	board[4][6] = '#'
	board[5][4] = '#'
	board[5][5] = '#'
	board[5][6] = '#'
	boardPrint(board)
	sleep(1000)
	while (true) {
		board = updateBoard(board)
		boardPrint(board)
		sleep(1000)
	}
}