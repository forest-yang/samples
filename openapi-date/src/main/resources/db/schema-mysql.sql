-- 
-- Database schema script.
-- 
--

-- Change History

-- 2019.02.14
-- initial submit.

CREATE DATABASE IF NOT EXISTS `agvc` DEFAULT CHARSET utf8;

USE `agvc`;

CREATE TABLE `atc_vehicle_profile`
(
  `id`          bigint(20)   NOT NULL AUTO_INCREMENT,
  `device_id`   varchar(100) NOT NULL,
  `agv_ip`      varchar(100) NOT NULL,
  `status`      int(11)   DEFAULT '0' COMMENT '0 ready, 1 suspended',
  `create_time` datetime  default now(),
  `update_time` timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `atc_vp_uk_di` (`device_id`),
  UNIQUE KEY `atc_vp_uk_ai` (`agv_ip`)
) DEFAULT CHARSET = utf8;
