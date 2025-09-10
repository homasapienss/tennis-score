-- Таблица players
CREATE TABLE players (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) UNIQUE NOT NULL
);

-- Таблица matches (пока без внешних ключей)
CREATE TABLE matches (
    id INT PRIMARY KEY AUTO_INCREMENT,
    player_1 INT NOT NULL,
    player_2 INT NOT NULL,
    winner INT
);

-- Внешний ключ: player_1 → players.id
ALTER TABLE matches
ADD CONSTRAINT fk_player1
FOREIGN KEY (player_1) REFERENCES players(id)
ON DELETE RESTRICT ON UPDATE CASCADE;

-- Внешний ключ: player_2 → players.id
ALTER TABLE matches
ADD CONSTRAINT fk_player2
FOREIGN KEY (player_2) REFERENCES players(id)
ON DELETE RESTRICT ON UPDATE CASCADE;

-- Внешний ключ: winner → players.id
ALTER TABLE matches
ADD CONSTRAINT fk_winner
FOREIGN KEY (winner) REFERENCES players(id)
ON DELETE SET NULL ON UPDATE CASCADE;
