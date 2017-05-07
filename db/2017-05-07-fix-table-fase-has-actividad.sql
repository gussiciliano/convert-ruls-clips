ALTER TABLE `SBC1074`.`fase_has_actividad` 
CHANGE COLUMN `fase_idfase` `fase_idfase` INT(11) NULL ,
CHANGE COLUMN `actividad_idactividad` `actividad_idactividad` INT(11) NULL ,
ADD COLUMN `id_fase_has_actividad` INT(11) NOT NULL AUTO_INCREMENT AFTER `fase_final`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id_fase_has_actividad`);