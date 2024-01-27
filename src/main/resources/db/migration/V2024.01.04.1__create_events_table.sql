#
V2024.01.04.1__create_events_table.sql


CREATE TABLE `events`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT,
    `name`         varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `trigger_time` timestamp                               NOT NULL,
    `created_at`   timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci