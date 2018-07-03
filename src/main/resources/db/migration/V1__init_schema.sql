CREATE TABLE type (
  id_type int(11) NOT NULL AUTO_INCREMENT,
  name varchar(45) NOT NULL,
  PRIMARY KEY (id_type)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE transistor (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(25) NOT NULL,
  type_id int(11) NOT NULL,
  specs_link varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY fk_type_id_idx (type_id),
  CONSTRAINT fk_type_id FOREIGN KEY (type_id) REFERENCES type (id_type) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;