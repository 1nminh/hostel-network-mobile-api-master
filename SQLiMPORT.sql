CREATE TABLE `hostel_network`.`type` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_name` NVARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `hostel_network`.`benefit` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `benefit_name` NVARCHAR(50) NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `hostel_network`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `phone` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `fullname` NVARCHAR(255) NULL,
  `email` VARCHAR(255) NULL,
  `address` NVARCHAR(255) NULL,
  `regist_date` DATETIME NULL,
  `img_avatar` TEXT NULL,
  PRIMARY KEY (`id`));
CREATE TABLE `hostel_network`.`post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `type_id` INT NULL,
  `user_id` INT NULL,
  `title` NVARCHAR(255) NULL,
  `content` TEXT NULL,
  `location` NVARCHAR(255) NULL,
  `area` INT NULL,
  `price` DECIMAL(10,0) NULL,
  `deposit` DECIMAL(10,0) NULL,
  `post_date` DATETIME NULL,
  `img_link_poster` TEXT NULL,
  `status` BIT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`type_id`) REFERENCES `hostel_network`.`type` (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `hostel_network`.`user` (`id`));
CREATE TABLE `hostel_network`.`picture` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `post_id` INT NULL,
  `img_link` TEXT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`post_id`) REFERENCES `hostel_network`.`post` (`id`));
CREATE TABLE `hostel_network`.`benefit_in_post` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `post_id` INT NULL,
  `benefit_id` INT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`post_id`) REFERENCES `hostel_network`.`post` (`id`),
  FOREIGN KEY (`benefit_id`) REFERENCES `hostel_network`.`benefit` (`id`));
CREATE TABLE `hostel_network`.`appointment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `renter_id` INT NULL,
  `host_id` INT NULL,
  `post_id` INT NULL,
  `address_appointment` NVARCHAR(255) NULL,
  `time` DATETIME NULL,
  `create_date` DATETIME NULL,
  `status` INT NULL,
  `note` TEXT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`host_id`) REFERENCES `hostel_network`.`user` (`id`),
  FOREIGN KEY (`renter_id`) REFERENCES `hostel_network`.`user` (`id`),
  FOREIGN KEY (`post_id`) REFERENCES `hostel_network`.`post` (`id`));
CREATE TABLE `hostel_network`.`wish_list` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL,
  `post_id` INT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `hostel_network`.`user` (`id`),
  FOREIGN KEY (`post_id`) REFERENCES `hostel_network`.`post` (`id`));