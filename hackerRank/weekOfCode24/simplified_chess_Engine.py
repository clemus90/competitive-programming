def move(piece,x,y):
    destroy_piece_if_existent(piece,x,y)
    piece.board[piece['x']][piece['y']] = None
    piece['x'] += x
    piece['y'] += y
    piece.board[piece['x']][piece['y']] = piece

def check_valid_movement(piece, x, y):
  new_x = piece['x'] + x
  new_y = piece['y'] + y
  if (0 <= new_x <= 4) and (0 <= new_y <= 4):
    board = piece['board']
    if(board[new_x][new_y] is None):
      return True
    else:
      if(board[new_x][new_y]['color'] != piece['color']):
        return True
  return False

def destroy_piece_if_existent(piece,x,y):
  '''Destroys the piece of the enemy team if it exist on destination cell'''
  new_x = piece['x'] + x
  new_y = piece['y'] + y
  if(board[new_x][new_y] is not None):
    board[new_x][new_y]['alive'] = False



def copy_board(board):
  c_board = []
  for x in range(4):
    c_board.append([])
    for y in range(4):
      c_board[x].append({'x': board[x][y]['x'], 'y':board[x][y]['y'], 'board': c_board, 'alive': True})

def can_kill(killer, victim):
  distance_vector = {
    'x': victim['x'] - killer['x'],
    'y': victim['y'] - killer['y'],
  }

movements{
  'Q': [
    lambda piece, n: move(piece, n, 0),
    lambda piece, n: move(piece, -n, 0),
    lambda piece, n: move(piece, 0, n),
    lambda piece, n: move(piece, 0, -n),
    lambda piece, n: move(piece, n, n),
    lambda piece, n: move(piece, n, -n),
    lambda piece, n: move(piece, -n, n),
    lambda piece, n: move(piece, -n, -n)
  ],
  'N': [
    lambda piece: move(piece, 1, 2),
    lambda piece: move(piece, 1, -2),
    lambda piece: move(piece, -1, 2),
    lambda piece: move(piece, -1, -2)
  ],
  'B':[
    lambda piece, n: move(piece, n, n),
    lambda piece, n: move(piece, n, -n),
    lambda piece, n: move(piece, -n, n),
    lambda piece, n: move(piece, -n, -n)
  ],
  'R':[
    lambda piece, n: move(piece, n, 0),
    lambda piece, n: move(piece, -n, 0),
    lambda piece, n: move(piece, 0, n),
    lambda piece, n: move(piece, 0, -n),
  ]
}

games = int(input().strip())

for g in range(games):
  white, black, moves = map(int, input().split())
  white_pieces = {}
  black_pieces = {}
  board = [[None for x in range(4)] for y in range(4)]
  for i in range(white):