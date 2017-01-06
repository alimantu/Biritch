ALTER TABLE User_Tags DROP FOREIGN KEY fk_user_tags_tid;
ALTER TABLE User_Tags DROP FOREIGN KEY fk_user_tags_uid;
ALTER TABLE News_Text DROP FOREIGN KEY fk_news_text_nmid;
ALTER TABLE News_Picture DROP FOREIGN KEY fk_news_picture_nmid;
ALTER TABLE News_Metadata_Tags DROP FOREIGN KEY fk_news_meta_tags_nmid;
ALTER TABLE News_Metadata_Tags DROP FOREIGN KEY fk_news_meta_tags_tid;
ALTER TABLE News_Metadata DROP FOREIGN KEY fk_news_meta_sid;

DROP TABLE users;
DROP TABLE tags;
DROP TABLE user_tags;
DROP TABLE News_Metadata;
DROP TABLE News_Text;
DROP TABLE News_Picture;
DROP TABLE Sources;
DROP TABLE News_Metadata_Tags;


CREATE TABLE users (
	uid INT(11) NOT NULL AUTO_INCREMENT,
	username CHAR(70) NOT NULL,
	password CHAR(70) NOT NULL,
	email CHAR(70) NOT NULL,
    registration_date DATETIME NOT NULL,
    enabled TINYINT NOT NULL DEFAULT 1,
    role varchar(45) NOT NULL CHECK (role IN ('ROLE_USER','ROLE_ADMIN')),
	PRIMARY KEY(uid)
);

CREATE TABLE Tags (
	tid INT(11) NOT NULL AUTO_INCREMENT,
    tname CHAR(70) NOT NULL,
    PRIMARY KEY(tid)
);

CREATE TABLE User_Tags (
	utid INT(11) NOT NULL AUTO_INCREMENT,
	uid INT(11) NOT NULL,
    tid INT(11) NOT NULL,
	likes FLOAT(7,4),
    PRIMARY KEY(utid)
);

ALTER TABLE User_Tags ADD CONSTRAINT fk_user_tags_tid FOREIGN KEY (tid) 
REFERENCES Tags(tid) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE User_Tags ADD CONSTRAINT fk_user_tags_uid FOREIGN KEY (uid) 
REFERENCES Users(uid) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TABLE News_Metadata (
	nmid INT(11) NOT NULL AUTO_INCREMENT,
    nmname CHAR(255) NOT NULL,
    release_date DATETIME NOT NULL,
    sid INT(4) NOT NULL,
    source_link CHAR(255),
    PRIMARY KEY(nmid)
);

CREATE TABLE News_Text (
	ntid INT(11) NOT NULL AUTO_INCREMENT,
    text TEXT NOT NULL,
    serial_number INT(3),
    nmid INT(11) NOT NULL,
    PRIMARY KEY(ntid)
);

CREATE TABLE News_Picture (
	npid INT(11) NOT NULL AUTO_INCREMENT,
    picture BLOB NOT NULL,
    serial_number INT(3),
    nmid INT(11) NOT NULL,
    PRIMARY KEY(npid)
);

ALTER TABLE News_Text ADD CONSTRAINT fk_news_text_nmid 
FOREIGN KEY (nmid) REFERENCES News_Metadata(nmid) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE News_Picture ADD CONSTRAINT fk_news_picture_nmid
FOREIGN KEY (nmid) REFERENCES News_Metadata(nmid) ON DELETE CASCADE ON UPDATE CASCADE;

CREATE TABLE Sources (
	sid INT(11) NOT NULL AUTO_INCREMENT,
    sname CHAR(250) NOT NULL,
    surl CHAR(255) NOT NULL,
    PRIMARY KEY(sid)
);

CREATE TABLE News_Metadata_Tags (
	nmtid INT(11) NOT NULL AUTO_INCREMENT,
	nmid INT(11) NOT NULL,
    tid INT(11) NOT NULL,
    percentage FLOAT(7,4),
    PRIMARY KEY(nmtid)
);

ALTER TABLE News_Metadata_Tags ADD CONSTRAINT fk_news_meta_tags_nmid 
FOREIGN KEY (nmid) REFERENCES News_Metadata(nmid) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE News_Metadata_Tags ADD CONSTRAINT fk_news_meta_tags_tid 
FOREIGN KEY (tid) REFERENCES Tags(tid) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE News_Metadata ADD CONSTRAINT fk_news_meta_sid 
FOREIGN KEY (sid) REFERENCES Sources(sid) ON DELETE CASCADE ON UPDATE CASCADE;


INSERT INTO users (uid, username, password, email, registration_date, enabled, role) 
VALUES (NULL, 'kompp', '111111', 'kompp@yandex.ru', STR_TO_DATE("07.01.2017",'%d.%m.%Y'), true, 'ROLE_USER');

INSERT INTO users (uid, username, password, email, registration_date, enabled, role) 
VALUES (NULL, 'masha', '222222', 'maria@mail.ru', STR_TO_DATE("07.01.2017",'%d.%m.%Y'), true, 'ROLE_ADMIN');

INSERT INTO users (uid, username, password, email, registration_date, enabled, role) 
VALUES (NULL, 'ololo', '333333', 'ololo@mail.ru', STR_TO_DATE("07.01.2017",'%d.%m.%Y'), true, 'ROLE_USER');
