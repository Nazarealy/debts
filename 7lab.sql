CREATE DATABASE IF NOT EXISTS family;
USE family;

DROP TABLE IF EXISTS family_values;
DROP TABLE IF EXISTS family_companion;
DROP TABLE IF EXISTS family_tree;
DROP TABLE IF EXISTS sex;
DROP TABLE IF EXISTS family_tree_has_family_values;
DROP TABLE IF EXISTS names_of_companions;

CREATE TABLE family_tree (
  id INT NOT NULL AUTO_INCREMENT,
  surname VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  birth_date DATE NOT NULL,
  death_date DATE NOT NULL,
  birth_place VARCHAR(45) NOT NULL,
  death_place VARCHAR(45) NOT NULL,
  number_card VARCHAR(45) NOT NULL,
  sex_id INT NOT NULL,
  parent_id INT,
  PRIMARY KEY (id));
  
CREATE TABLE family_values (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  estimated_cost INT NOT NULL,
  max_cost INT NOT NULL,
  min_cost INT NOT NULL,
  codep VARCHAR(45),
  PRIMARY KEY (id));
  
 CREATE TABLE family_companion (
  id INT NOT NULL AUTO_INCREMENT,
  surname VARCHAR(45) NOT NULL,
  name VARCHAR(45) NOT NULL,
  birth_date DATE NOT NULL,
  death_date DATE NOT NULL,
  birth_place VARCHAR(45) NOT NULL,
  death_place VARCHAR(45) NOT NULL,
  marriage_date DATE NOT NULL,
  partner_id INT NOT NULL,
  sex_id INT NOT NULL,
  PRIMARY KEY (id));
  
  CREATE TABLE  family_tree_has_family_values(
  family_tree_id INT NOT NULL,
  family_values_id INT NOT NULL,
  PRIMARY KEY (family_tree_id, family_values_id));
  
  CREATE TABLE  sex(
  id INT NOT NULL AUTO_INCREMENT,
  sex VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
  
  INSERT INTO family_tree (surname, name, birth_date, death_date, birth_place, death_place, number_card, sex_id, parent_id) VALUES
 ('Дорк', 'Олег', '2001-07-04', '2090-07-04', 'Львів', 'Чикаго', '23456789', 1, 2),
 ('Вигриновський', 'Максим', '2089-06-10', '2067-08-12', 'Київ', 'Черляни', '53216789', 1, 3),
 ('Шишла', 'Орест', '1999-03-23', '2055-07-04', 'Харків', 'Мюнхен', '53126789', 1, 4),
 ('Шутка', 'Денис', '1997-01-01', '2067-12-07', 'Городок', 'Львів', '24546789', 1, 5),
 ('Вовк', 'Ілона', '2003-03-06', '2089-11-09', 'Львів', 'Барселона', '29856789', 2, 6),
 ('Козак', 'Ірина', '2002-09-04', '2080-12-04', 'Львів', 'Москва', '23454389', 2, 7),
 ('Падучак', 'Олег', '2001-07-04', '2090-03-18', 'Львів', 'Речичани', '23498789', 1, 8),
 ('Ясниська', 'Юлія', '2000-11-24', '2065-02-24', 'Лаббок', 'Зимна Вода', '23421389', 2, 9),
 ('Мостова', 'Марія', '1998-07-04', '2078-01-14', 'Даллас', 'Київ', '23445389', 2, 10),
 ('Хоменко', 'Анастасія', '2005-06-25', '2034-06-07', 'Торонто', 'Чикаго', '23487289', 2, 1);
 
 INSERT INTO family_companion (surname, name, birth_date, death_date, birth_place, death_place, marriage_date, partner_id, sex_id) VALUES
 ('Буфан', 'Євген', '1995-07-04', '2090-07-04', 'Львів', 'Чикаго', '2045-07-04', 2, 1),
 ('Шмігер', 'Андрій', '1999-08-04', '2067-02-26', 'Київ', 'Черляни', '2033-06-14', 3, 1),
 ('Сурков', 'Євген', '1987-09-12', '2047-11-13', 'Харків', 'Мюнхен', '2045-04-30', 1, 1),
 ('Клочник', 'Ярослав', '1997-07-04', '2076-12-28', 'Городок', 'Львів', '2065-08-28', 4, 1),
 ('Боровець', 'Анастасія', '2001-04-04', '2086-04-27', 'Львів', 'Барселона', '2034-12-25', 7, 2),
 ('Дубневич', 'Соломія', '2002-03-01', '2065-08-03', 'Львів', 'Москва', '2046-11-13', 9, 2),
 ('Стучинський', 'Михайло', '2012-02-01', '2074-05-02', 'Львів', 'Речичани', '2034-01-12', 8, 1),
 ('Супрун', 'Яніна', '2002-07-04', '2073-05-12', 'Лаббок', 'Зимна Вода', '2036-06-19', 5, 2),
 ('Соколова', 'Уляна', '2003-05-07', '2087-03-23', 'Даллас', 'Київ', '2044-04-06', 6, 2),
 ('Тимошенко', 'Юлія', '2002-04-17', '2053-06-12', 'Торонто', 'Чикаго', '2033-06-04', 10, 2);
 
 INSERT INTO family_values (name, estimated_cost, max_cost, min_cost, codep) VALUES
 ('Рушник', 23, 120, 20, 'A2342'),
 ('Булава', 25, 110, 1, '3452'),
 ('Машина', 12, 160, 7, '2542'),
 ('Герб', 21, 280, 8, '3312'),
 ('Прапор', 56, 220, 3, '8387'),
 ('Картина', 45, 198, 5, '3122'),
 ('Ікона', 49, 122, 3, '7354'),
 ('Колечко', 53, 126, 7, '4672'),
 ('Сережки', 98, 125, 8, '7387'),
 ('Годинник', 27, 230, 4, '5312');
 
 INSERT INTO sex (sex) VALUES
 ('Чоловік'),
 ('Жінка');
 
 INSERT INTO family_tree_has_family_values (family_tree_id, family_values_id) VALUES
 (1, 5),
 (2, 3),
 (4, 6),
 (7, 9),
 (8, 10);
 
 DROP PROCEDURE IF EXISTS InsertFamilyCompanions;
 
 DELIMITER //
 CREATE PROCEDURE InsertFamilyCompanions(
       Surname varchar(45),
       Name varchar(45),
       BirthDate varchar(45),
       DeathDate varchar(45),
       BirthPlace varchar(45),
       DeathPlace varchar(45),
       MarriageDate varchar(45),
       PartnerId int,
       SexId int)
BEGIN
       INSERT INTO family_companion
              (surname, name, birth_date, death_date, birth_place, death_place, marriage_date, partner_id, sex_id)
       VALUES
              (Surname, Name, BirthDate, DeathDate, BirthPlace, DeathPlace, MarriageDate, PartnerId, SexId);
END//
DELIMITER ;

/*CALL InsertFamilyCompanions('Ляшко', 'Стефан', '1998-04-17', '2038-04-17', 'Стамбул', 'Катовіце', '2012-04-19', 2, 1);*/

DROP PROCEDURE IF EXISTS InsertPackage;

DELIMITER //
CREATE PROCEDURE InsertPackage()
BEGIN
DECLARE v_max INT UNSIGNED DEFAULT 10;
DECLARE v_counter INT UNSIGNED DEFAULT 0;
DECLARE namep INT UNSIGNED DEFAULT 0;

truncate table family_values;
  start transaction;
  while v_counter < v_max do
    SET namep = floor(rand() * 10);
    if concat('NoName', namep) not in (Select name from family_values) then
    insert into family_values (name, estimated_cost, max_cost, min_cost, codep) 
    values (concat('NoName', namep),  23, 120, 20, '2342');
    set v_counter=v_counter+1;
    end if;
  end while;
  commit;
  END//
  DELIMITER ;

/*CALL InsertPackage();*/

DROP PROCEDURE IF EXISTS CursIns;

DELIMITER //
CREATE PROCEDURE CursIns()
BEGIN
DECLARE finished INTEGER DEFAULT 0;
DECLARE nameOfCompanion varchar(100) DEFAULT "";
DEClARE curName
        CURSOR FOR 
            SELECT name FROM family_companion;
DECLARE CONTINUE HANDLER 
        FOR NOT FOUND SET finished = 1;
CREATE TABLE names_of_companions (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));
OPEN curName;
getName: LOOP
        FETCH curName INTO nameOfCompanion;
        IF finished = 1 THEN 
            LEAVE getName;
        END IF;
        insert into names_of_companions (name) 
    values (nameOfCompanion);
    END LOOP getName;
    CLOSE curName;
END//
DELIMITER ;
        
/*CALL CursIns();*/

DROP FUNCTION IF EXISTS AvgSum;

DELIMITER //
CREATE FUNCTION AvgSum()
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
DECLARE average_max_price DECIMAL(10,2);
SET average_max_price = 0;
SELECT FLOOR(AVG(max_cost)) INTO average_max_price from family_values;
RETURN average_max_price;
END//
DELIMITER ;

/*SELECT * FROM family_values WHERE max_cost < AvgSum();*/

DROP FUNCTION IF EXISTS JoinCol;

DELIMITER //
CREATE FUNCTION JoinCol(SurnameFirst VARCHAR(45), NameFirst VARCHAR(45), SurnameSecond VARCHAR(45), NameSecond VARCHAR(45))
RETURNS VARCHAR(45)
DETERMINISTIC
BEGIN
DECLARE joined VARCHAR(45) DEFAULT '';
SET joined = concat(SurnameFirst, ' ', NameFirst, ' + ', SurnameSecond, ' ', NameSecond);
RETURN joined;
END//
DELIMITER ;

/*select family_companion.id, JoinCol(family_companion.surname, family_companion.name, family_tree.surname, family_tree.name) as lovecouple, family_companion.birth_date, family_companion.death_date, family_companion.birth_place, family_companion.death_place, family_companion.marriage_date
 from family_companion
 INNER JOIN family_tree ON family_companion.partner_id = family_tree.id;*/
 
DELIMITER //
CREATE TRIGGER onDeleteFamilyTree
  BEFORE DELETE ON family_tree FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM family_companion where old.id = family_companion.id) = 1 THEN
         signal sqlstate '45000' set message_text = "Can't delete";
    end if;
  END//
DELIMITER ; 
 
DELIMITER //
CREATE TRIGGER onDeleteSexCompanion
  BEFORE DELETE ON sex FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM family_companion where old.id = family_companion.id) = 1 THEN
         signal sqlstate '45000' set message_text = "Can't delete";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER onDeleteSexTree
  BEFORE DELETE ON family_tree FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM family_tree where old.id = family_tree.id) = 1 THEN
         signal sqlstate '45000' set message_text = "Can't delete";
    end if;
  END//
DELIMITER ; 

DELIMITER //
CREATE TRIGGER onDeleteFamilyValues
  BEFORE DELETE ON family_values FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM family_tree_has_family_values where old.id = family_tree_has_family_values.family_values_id) = 1 THEN
         signal sqlstate '45000' set message_text = "Can't delete";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER onDeleteFamilyTreeVal
  BEFORE DELETE ON family_tree FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM family_tree_has_family_values where old.id = family_tree_has_family_values.family_tree_id) = 1 THEN
         signal sqlstate '45000' set message_text = "Can't delete";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER onCreateFamilyCompanion
  BEFORE INSERT ON family_companion FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM family_tree where new.id = family_tree.id) = 0 THEN
         signal sqlstate '45000' set message_text = "Can't insert";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER onCreateFamilyCompanionSex
  BEFORE INSERT ON family_companion FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM sex where new.id = sex.id) = 0 THEN
         signal sqlstate '45000' set message_text = "Can't insert";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER onCreateFamilyTreeSex
  BEFORE INSERT ON family_tree FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM sex where new.id = sex.id) = 0 THEN
         signal sqlstate '45000' set message_text = "Can't insert";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER onCreateFamilyTreeHasValues
  BEFORE INSERT ON family_tree_has_family_values FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM family_tree where new.family_tree_id = family_tree.id) = 0 THEN
         signal sqlstate '45000' set message_text = "Can't insert";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER onCreateFamilyTreeHasValues2
  BEFORE INSERT ON family_tree_has_family_values FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM family_values where new.family_values_id = family_values.id) = 0 THEN
         signal sqlstate '45000' set message_text = "Can't insert";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER onCreateFamilyTreeParent
  BEFORE INSERT ON family_tree FOR EACH ROW 
  BEGIN
    IF (SELECT COUNT(*) FROM family_tree where new.parent_id = family_tree.parent_id) = 0 THEN
         signal sqlstate '45000' set message_text = "Can't insert";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER checkDate
  BEFORE INSERT ON family_companion FOR EACH ROW 
  BEGIN
    IF (new.birth_date > '2063-07-01' or new.death_date > '2120-08-24') THEN
         signal sqlstate '45000' set message_text = "Date is too big!";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER checkCodeFormat
  BEFORE INSERT ON family_values FOR EACH ROW 
  BEGIN
    IF (select COUNT(*) from family_values where new.codep rlike '(A|M|Z)[0-9]{5}([a-zA-Z]{2})') = 0 THEN
         signal sqlstate '45000' set message_text = "Bad Format";
    end if;
  END//
DELIMITER ;

DELIMITER //
CREATE TRIGGER AfterDeleteCompanionMin3Row
AFTER DELETE
ON family_companion FOR EACH ROW
BEGIN
IF(SELECT COUNT(*) FROM family_companion) < 3
THEN SIGNAL SQLSTATE '45000'
SET MESSAGE_TEXT = 'Delete error MIN cardinality';

END IF;
END //
DELIMITER ;