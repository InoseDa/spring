CREATE TABLE anime (
  id int unsigned AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  original_writer VARCHAR(100) NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO anime (title, original_writer) VALUES ("ジョジョの奇妙な冒険", "荒木飛呂彦");
INSERT INTO anime (title, original_writer) VALUES ("銀魂", "空知英秋");
