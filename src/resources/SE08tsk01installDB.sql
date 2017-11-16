CREATE SCHEMA chat;

SET search_path TO chat;

DROP TABLE Roles;
CREATE TABLE Roles (
  role_id    SERIAL,
  role_name  VARCHAR(25) NOT NULL,
  can_read   BOOLEAN     NOT NULL DEFAULT FALSE,
  can_write  BOOLEAN     NOT NULL DEFAULT FALSE,
  can_update BOOLEAN     NOT NULL DEFAULT FALSE,
  can_revoke BOOLEAN     NOT NULL DEFAULT FALSE,
  misc       TEXT,

  PRIMARY KEY (role_name),
  CONSTRAINT uk_roles UNIQUE (role_id)
);

INSERT INTO roles (role_name, can_read, can_revoke, can_update, can_write)
VALUES ('admin', TRUE, TRUE, TRUE, TRUE),
  ('updaters', TRUE, TRUE, TRUE, TRUE),
  ('moderators', TRUE, TRUE, TRUE, FALSE);
INSERT INTO Roles(role_name, can_read, can_write, can_update, can_revoke) VALUES ('guest',TRUE ,FALSE ,FALSE ,
                                                                                        FALSE );

DROP TABLE Users;
CREATE TABLE Users (
  user_id  SERIAL,
  login    VARCHAR(25) NOT NULL,
  password VARCHAR(50) NOT NULL,
  role_id  INT         NOT NULL,

  PRIMARY KEY (login),
  CONSTRAINT uk_users UNIQUE (user_id)
);

INSERT INTO users (login, password, role_id)
VALUES ('admin', 'qwerty', (SELECT role_id
                            FROM roles
                            WHERE role_name = 'admin'));
INSERT INTO users (login, password, role_id)
VALUES ('mercenery', 'Pa$$w0Rd', 3);
INSERT INTO users (login, password, role_id)
VALUES ('lamer', 'asd', 1);
INSERT INTO users (login, password, role_id)
VALUES ('anonymus', '***', 2);
INSERT INTO users (login, password, role_id)
VALUES ('Mr.Robot', 'Robot', 3);

ALTER TABLE users
  ADD CONSTRAINT fk_users_roles_id FOREIGN KEY (role_id)
REFERENCES Roles (role_id)
ON DELETE CASCADE;


SELECT *
FROM Users;
SELECT *
FROM Roles;