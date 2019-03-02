--
-- AGV Traffic Controller database initialize script.
--
--
USE `agvc`;

insert into atc_vehicle_profile (device_id, agv_ip)
values ('1000', '127.0.0.1:8082');