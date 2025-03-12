CREATE TABLE game (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    publisher VARCHAR(100),
    release_date DATE,
    image_url TEXT,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE OR REPLACE FUNCTION update_timestamp()
RETURNS TRIGGER AS $$
BEGIN
  NEW.update_at = NOW();
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER trigger_update_game
BEFORE UPDATE ON game
FOR EACH ROW
EXECUTE FUNCTION update_timestamp();


INSERT INTO game(name, publisher, image_url, release_date) 
VALUES 
    ('Final Fantasy VII', 'Squaresoft', 'https://example.com/ff7.jpg', '1997-01-31'),
    ('Resident Evil 2', 'Capcom', 'https://example.com/re2.jpg', '1998-01-21'),
    ('Gran Turismo', 'Sony Computer Entertainment', 'https://example.com/gt.jpg', '1997-12-23'),
    ('Metal Gear Solid', 'Konami', 'https://example.com/mgs.jpg', '1998-09-03'),
    ('Silent Hill', 'Konami', 'https://example.com/sh.jpg', '1999-02-23'),
    ('Crash Bandicoot', 'Naughty Dog', 'https://example.com/crash.jpg', '1996-09-09'),
    ('The Legend of Dragoon', 'Sony Computer Entertainment', 'https://example.com/lod.jpg', '1999-12-02'),
    ('Castlevania: Symphony of the Night', 'Konami', 'https://example.com/castlevania.jpg', '1997-03-20'),
    ('Need for Speed: Hot Pursuit', 'Electronic Arts', 'https://example.com/nfs.jpg', '1998-09-30'),
    ('Dark Souls', 'FromSoftware', 'https://example.com/darksouls.jpg', '2011-09-22'),
    ('Parasite Eve 2','SQUARESOFT','https://romhustler.org/img/screenshots/psx_full/title/554c5002ef098.jpg','1999-12-16');

CREATE TABLE console (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    company VARCHAR(100),
    release_date DATE,
    image_url TEXT,
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT INTO console (name, company, release_date, image_url) VALUES
('Nintendo Entertainment System', 'Nintendo', '1983-07-15', 'https://example.com/nes.jpg'),
('Super Nintendo', 'Nintendo', '1990-11-21', 'https://example.com/snes.jpg'),
('Nintendo 64', 'Nintendo', '1996-06-23', 'https://example.com/n64.jpg'),
('GameCube', 'Nintendo', '2001-09-14', 'https://example.com/gamecube.jpg'),
('Wii', 'Nintendo', '2006-11-19', 'https://example.com/wii.jpg'),
('Wii U', 'Nintendo', '2012-11-18', 'https://example.com/wiiu.jpg'),
('Nintendo Switch', 'Nintendo', '2017-03-03', 'https://example.com/switch.jpg'),
('PlayStation', 'Sony', '1994-12-03', 'https://example.com/ps1.jpg'),
('PlayStation 2', 'Sony', '2000-03-04', 'https://example.com/ps2.jpg'),
('PlayStation 3', 'Sony', '2006-11-11', 'https://example.com/ps3.jpg'),
('PlayStation 4', 'Sony', '2013-11-15', 'https://example.com/ps4.jpg'),
('PlayStation 5', 'Sony', '2020-11-12', 'https://example.com/ps5.jpg'),
('Xbox', 'Microsoft', '2001-11-15', 'https://example.com/xbox.jpg'),
('Xbox 360', 'Microsoft', '2005-11-22', 'https://example.com/xbox360.jpg'),
('Xbox One', 'Microsoft', '2013-11-22', 'https://example.com/xboxone.jpg'),
('Xbox Series X', 'Microsoft', '2020-11-10', 'https://example.com/xboxseriesx.jpg'),
('Sega Genesis', 'Sega', '1988-10-29', 'https://example.com/genesis.jpg'),
('Sega Saturn', 'Sega', '1994-11-22', 'https://example.com/saturn.jpg'),
('Dreamcast', 'Sega', '1998-11-27', 'https://example.com/dreamcast.jpg');
