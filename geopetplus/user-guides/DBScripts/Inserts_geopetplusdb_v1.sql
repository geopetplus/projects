USE `GEOPETPLUS_DEV`;
DELETE FROM `SERVICES`;
DELETE FROM `RATECARD`;
DELETE FROM `STATUSDETAIL`;
DELETE FROM `DISCOUNTCODES`;
DELETE FROM `DBPROPERTY`;

SHOW WARNINGS;
-- -----------------------------------------------------
-- INSERT table data
-- -----------------------------------------------------
INSERT INTO SERVICES VALUES ('SV01', 'CLINICAL');
INSERT INTO SERVICES VALUES ('SV02', 'LABORATORY');
INSERT INTO SERVICES VALUES ('SV03', 'PET STORES');
INSERT INTO SERVICES VALUES ('SV04', 'BREEDERS HUB');

-- -----------------------------------------------------
-- INSERT table data
-- -----------------------------------------------------
INSERT INTO RATECARD VALUES ('SV01', 'BASIC', 3,100,2000);
INSERT INTO RATECARD VALUES ('SV01', 'BASIC', 6,300,5985);
INSERT INTO RATECARD VALUES ('SV01', 'BASIC', 9,600,11970);
INSERT INTO RATECARD VALUES ('SV01', 'BASIC', 12,1200,23940);
INSERT INTO RATECARD VALUES ('SV01', 'PLUS', 3,200,2600);
INSERT INTO RATECARD VALUES ('SV01', 'PLUS', 6,600,7695);
INSERT INTO RATECARD VALUES ('SV01', 'PLUS', 9,1200,15390);
INSERT INTO RATECARD VALUES ('SV01', 'PLUS', 12,2400,30780);
INSERT INTO RATECARD VALUES ('SV01', 'ULTRA', 3,300,2800);
INSERT INTO RATECARD VALUES ('SV01', 'ULTRA', 6,900,8265);
INSERT INTO RATECARD VALUES ('SV01', 'ULTRA', 9,1800,16530);
INSERT INTO RATECARD VALUES ('SV01', 'ULTRA', 12,3600,33060);
INSERT INTO RATECARD VALUES ('SV02', 'BASIC', 3,100,2000);
INSERT INTO RATECARD VALUES ('SV02', 'BASIC', 6,300,5985);
INSERT INTO RATECARD VALUES ('SV02', 'BASIC', 9,600,11970);
INSERT INTO RATECARD VALUES ('SV02', 'BASIC', 12,1200,23940);
INSERT INTO RATECARD VALUES ('SV02', 'PLUS', 3,200,2600);
INSERT INTO RATECARD VALUES ('SV02', 'PLUS', 6,600,7695);
INSERT INTO RATECARD VALUES ('SV02', 'PLUS', 9,1200,15390);
INSERT INTO RATECARD VALUES ('SV02', 'PLUS', 12,2400,30780);
INSERT INTO RATECARD VALUES ('SV02', 'ULTRA', 3,300,2800);
INSERT INTO RATECARD VALUES ('SV02', 'ULTRA', 6,900,8265);
INSERT INTO RATECARD VALUES ('SV02', 'ULTRA', 9,1800,16530);
INSERT INTO RATECARD VALUES ('SV02', 'ULTRA', 12,3600,33060);
INSERT INTO RATECARD VALUES ('SV04', 'BASIC', 3,100,2000);
INSERT INTO RATECARD VALUES ('SV04', 'BASIC', 6,300,5985);
INSERT INTO RATECARD VALUES ('SV04', 'BASIC', 9,600,11970);
INSERT INTO RATECARD VALUES ('SV04', 'BASIC', 12,1200,23940);
INSERT INTO RATECARD VALUES ('SV04', 'PLUS', 3,200,2600);
INSERT INTO RATECARD VALUES ('SV04', 'PLUS', 6,600,7695);
INSERT INTO RATECARD VALUES ('SV04', 'PLUS', 9,1200,15390);
INSERT INTO RATECARD VALUES ('SV04', 'PLUS', 12,2400,30780);
INSERT INTO RATECARD VALUES ('SV04', 'ULTRA', 3,300,2800);
INSERT INTO RATECARD VALUES ('SV04', 'ULTRA', 6,900,8265);
INSERT INTO RATECARD VALUES ('SV04', 'ULTRA', 9,1800,16530);
INSERT INTO RATECARD VALUES ('SV04', 'ULTRA', 12,3600,33060);
INSERT INTO RATECARD VALUES ('SV03', 'BASIC', 3,100,2000);
INSERT INTO RATECARD VALUES ('SV03', 'BASIC', 6,300,5985);
INSERT INTO RATECARD VALUES ('SV03', 'BASIC', 9,600,11970);
INSERT INTO RATECARD VALUES ('SV03', 'BASIC', 12,1200,23940);
INSERT INTO RATECARD VALUES ('SV03', 'PLUS', 3,200,2600);
INSERT INTO RATECARD VALUES ('SV03', 'PLUS', 6,600,7695);
INSERT INTO RATECARD VALUES ('SV03', 'PLUS', 9,1200,15390);
INSERT INTO RATECARD VALUES ('SV03', 'PLUS', 12,2400,30780);
INSERT INTO RATECARD VALUES ('SV03', 'ULTRA', 3,300,2800);
INSERT INTO RATECARD VALUES ('SV03', 'ULTRA', 6,900,8265);
INSERT INTO RATECARD VALUES ('SV03', 'ULTRA', 9,1800,16530);
INSERT INTO RATECARD VALUES ('SV03', 'ULTRA', 12,3600,33060);

-- -----------------------------------------------------
-- INSERT table data
-- -----------------------------------------------------
INSERT INTO STATUSDETAIL VALUES ("A","ACTIVE");
INSERT INTO STATUSDETAIL VALUES ("B","BLOCKED");
INSERT INTO STATUSDETAIL VALUES ("C","CANCEL"); 
INSERT INTO STATUSDETAIL VALUES ("I","INACTIVE");
INSERT INTO STATUSDETAIL VALUES ("P","PENDING");
INSERT INTO STATUSDETAIL VALUES ("S","SAVE");

-- -----------------------------------------------------
-- INSERT table data
-- -----------------------------------------------------
INSERT INTO DISCOUNTCODES VALUES ("INTRO", 25, NOW(), adddate(NOW(), INTERVAL 10 YEAR));
INSERT INTO DISCOUNTCODES VALUES ("TRIAL", 100, NOW(), adddate(NOW(), INTERVAL 10 YEAR));
INSERT INTO DISCOUNTCODES VALUES ("PACK1", 10, NOW(), adddate(NOW(), INTERVAL 10 YEAR));
INSERT INTO DISCOUNTCODES VALUES ("PACK2", 20, NOW(), adddate(NOW(), INTERVAL 10 YEAR));
INSERT INTO DISCOUNTCODES VALUES ("PACK3", 30, NOW(), adddate(NOW(), INTERVAL 10 YEAR));
INSERT INTO DISCOUNTCODES VALUES ("PACK4", 40, NOW(), adddate(NOW(), INTERVAL 10 YEAR));
INSERT INTO DISCOUNTCODES VALUES ("PACK5", 50, NOW(), adddate(NOW(), INTERVAL 10 YEAR));

-- -----------------------------------------------------
-- INSERT table getsequence
-- -----------------------------------------------------
INSERT INTO GETSEQUENCE VALUES ("adminseq", 10000);
INSERT INTO GETSEQUENCE VALUES ("auditseq", 10000);
INSERT INTO GETSEQUENCE VALUES ("facilityseq", 10000);
INSERT INTO GETSEQUENCE VALUES ("policyseq", 10000);
INSERT INTO GETSEQUENCE VALUES ("transseq", 10000);

-- -----------------------------------------------------
-- INSERT table data
-- -----------------------------------------------------
INSERT INTO DBPROPERTY VALUES ("LOG_LEVEL", "INFO");

COMMIT;


SHOW WARNINGS;