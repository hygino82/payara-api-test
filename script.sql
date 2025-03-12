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

