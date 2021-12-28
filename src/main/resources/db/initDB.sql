DROP TABLE cat;

CREATE TABLE cat
(
    id             BIGSERIAL PRIMARY KEY,
    name           VARCHAR  NOT NULL,
    vote          INTEGER  NOT NULL,
    image          bytea  NOT NULL

);

INSERT INTO cat ( id, name, vote, image )
VALUES ( 1, 'бублик', 0, pg_read_binary_file('C:\static\1.jpg')::bytea),
       ( 2,  'пырик', 0, pg_read_binary_file('C:\static\2.jpg')::bytea),
       ( 3,  'чирик', 0, pg_read_binary_file('C:\static\3.jpg')::bytea),
( 4,  'котей', 0, pg_read_binary_file('C:\static\4.jpg')::bytea),
( 5,  'гордей', 0, pg_read_binary_file('C:\static\5.jpg')::bytea),
( 6,  'тупик', 0, pg_read_binary_file('C:\static\6.jpg')::bytea),
( 7,  'бырик', 0, pg_read_binary_file('C:\static\7.jpg')::bytea),
( 8,  'додик', 0, pg_read_binary_file('C:\static\8.jpg')::bytea),
( 9,  'коржик', 0, pg_read_binary_file('C:\static\9.jpg')::bytea),
( 10,  'карамелька', 0, pg_read_binary_file('C:\static\10.jpg')::bytea)
;
