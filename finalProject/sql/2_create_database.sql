CREATE DATABASE `workshopDB` DEFAULT CHARACTER SET utf8;


GRANT SELECT,INSERT,UPDATE,DELETE
    ON `workshopDB`.*
    TO workshop_user@'localhost';

GRANT SELECT,INSERT,UPDATE,DELETE
    ON `workshopDB`.*
    TO workshop_user@'%';