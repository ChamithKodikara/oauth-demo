
-- DDL
CREATE SCHEMA IF NOT EXISTS `oauth_demo` DEFAULT CHARACTER SET latin1 ;

CREATE TABLE IF NOT EXISTS `oauth_demo`.`oauth_client_details`(
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

CREATE TABLE IF NOT EXISTS `oauth_demo`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NULL DEFAULT NULL,
  `username` VARCHAR(100) NULL DEFAULT NULL,
  `password` VARCHAR(100) NULL DEFAULT NULL,
  `status` VARCHAR(10) NOT NULL,
  `failed_login_attempt_count` INT(2) NOT NULL,
  `last_failed_login_date` DATETIME  NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
  
  
  CREATE TABLE IF NOT EXISTS `oauth_demo`.`role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(1000) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
  CREATE TABLE IF NOT EXISTS `oauth_demo`.`authority` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `code` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));
  
  
  CREATE TABLE IF NOT EXISTS `oauth_demo`.`role_authority` (
  `role_id` INT NOT NULL,
  `authority_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `authority_id`),
  INDEX `fk_role_has_authority_authority1_idx` (`authority_id` ASC),
  INDEX `fk_role_has_authority_role_idx` (`role_id` ASC),
  CONSTRAINT `fk_role_has_authority_role`
    FOREIGN KEY (`role_id`)
    REFERENCES `oauth_demo`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_has_authority_authority1`
    FOREIGN KEY (`authority_id`)
    REFERENCES `oauth_demo`.`authority` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE IF NOT EXISTS `oauth_demo`.`user_role` (
  `role_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`role_id`, `user_id`),
  INDEX `fk_role_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_role_has_user_role1_idx` (`role_id` ASC),
  CONSTRAINT `fk_role_has_user_role1`
    FOREIGN KEY (`role_id`)
    REFERENCES `oauth_demo`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `oauth_demo`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- DML

INSERT INTO `oauth_demo`.`oauth_client_details` (`client_id`, `resource_ids`, `client_secret`, `scope`, `authorized_grant_types`,
`web_server_redirect_uri`, `authorities`, `access_token_validity`, `refresh_token_validity`, `additional_information`, `autoapprove`)
 VALUES ('OAUTH_DEMO_CLIENT_ID', 'OAUTH_DEMO', '$2a$10$5IZ9f4x6xS3UnRix.57Y8.dNieo4oP4w0ZZr5S94ZUp.Tb70QwKtS', 'OAUTH_DEMO', 'password,refresh_token', '', NULL, '1800', '86400', NULL, NULL);

INSERT INTO `oauth_demo`.`authority` (`name`, `code`) VALUES ('Test Authority', 'test');
INSERT INTO `oauth_demo`.`role` (`name`, `description`) VALUES ('Admin', 'Admin');

INSERT INTO `oauth_demo`.`user` (`name`, `username`, `password`, `status`, `failed_login_attempt_count`)
 VALUES ('Admin', 'admin', '$2a$10$5IZ9f4x6xS3UnRix.57Y8.dNieo4oP4w0ZZr5S94ZUp.Tb70QwKtS', 'A', 0);

INSERT INTO `oauth_demo`.`user_role` (role_id, user_id) VALUES ((SELECT id FROM `oauth_demo`.`role` WHERE name = 'Admin'),
(SELECT id FROM `oauth_demo`.`user` WHERE username = 'admin'));

INSERT INTO oauth_demo.role_authority (role_id, authority_id)
VALUES ((SELECT id FROM oauth_demo.role WHERE name = 'Admin'), (SELECT id FROM oauth_demo.authority WHERE code = 'test'));






