-- SET FOREIGN_KEY_CHECKS = 0;

INSERT INTO `customer` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `address_line1`,
                        `address_line2`, `cap`, `city`, `country`, `avatar`, `bio`, `birthdate`, `email`, `first_name`,
                        `gender`, `holiday_mode`, `lang`, `last_visit`, `phone_number`, `position_city`,
                        `position_country`, `position_show_city`, `second_name`, `username`)
VALUES ('d31d535a-44ea-4148-91c1-e2e62ff0931b', NULL, NULL, NULL, NULL, 'Via Pagano 523', 'Appartamento 49', '77167',
        'San Karim ligure', 'Giamaica', NULL,
        'Eaque accusantium assumenda accusamus a dignissimos temporibus hic. Culpa et et ab ad.', '2000-12-09',
        'martinelli.jari@example.net', 'Baldassarre', 'FEMALE', '0', 'ENG', '2023-03-18 12:07:40.000000', '389 344 936',
        'Bianco veneto', 'Grecia', '1', 'Galli', 'aroldo48');
INSERT INTO `customer` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `address_line1`,
                        `address_line2`, `cap`, `city`, `country`, `avatar`, `bio`, `birthdate`, `email`, `first_name`,
                        `gender`, `holiday_mode`, `lang`, `last_visit`, `phone_number`, `position_city`,
                        `position_country`, `position_show_city`, `second_name`, `username`)
VALUES ('c4a40e5d-eb77-452f-aa02-7de38f39792e', NULL, NULL, NULL, NULL, 'Via De rosa 2 Piano 7', 'Appartamento 65',
        '00430', 'Quarto Erminio', 'Saint Vincent and the Grenadines', NULL,
        'Et quasi molestiae et omnis eveniet. Dolores vero quaerat eos id animi cumque qui. Eos aut facilis ducimus eveniet qui. Rem expedita voluptatem officiis dolor est commodi.',
        '2022-06-04', 'leone.lorenzo@example.com', 'Alessandro', 'FEMALE', '0', 'ITA', '2023-04-05 10:27:48.000000',
        '+01 8669 82810637', 'Ileana a mare', 'Uruguay', '1', 'Ferri', 'mariagiulia.benedetti');
INSERT INTO `customer` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `address_line1`,
                        `address_line2`, `cap`, `city`, `country`, `avatar`, `bio`, `birthdate`, `email`, `first_name`,
                        `gender`, `holiday_mode`, `lang`, `last_visit`, `phone_number`, `position_city`,
                        `position_country`, `position_show_city`, `second_name`, `username`)
VALUES ('b742d9c4-caae-4702-9f7b-932c4d83da13', NULL, NULL, NULL, NULL, 'Contrada Rosaria 9 Appartamento 18',
        'Appartamento 23', '02922', 'Pellegrini laziale', 'Marocco', NULL,
        'Repellendus sint vel vitae alias. Unde mollitia qui expedita aliquid dolorem corrupti. Hic facilis quis nulla vero voluptates asperiores. Ea delectus ex itaque accusantium labore.',
        '2008-07-05', 'dpalmieri@example.org', 'Ciro', 'FEMALE', '0', 'ITA', '2023-03-23 01:47:05.000000',
        '+59 99 6517497', 'Furio salentino', 'Aruba', '1', 'Amato', 'costantini.moreno');

INSERT INTO `brand` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `name`)
VALUES ('1', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-17 23:27:28.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-24 22:11:01.000000', 'commodi');
INSERT INTO `brand` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `name`)
VALUES ('2', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-17 01:42:37.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-21 02:08:20.000000', 'rerum');
INSERT INTO `brand` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `name`)
VALUES ('3', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-30 17:25:48.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-04-02 02:34:18.000000', 'magni');

INSERT INTO `category` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `name`)
VALUES ('1', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-02-22 16:58:27.000000',
        'c4a40e5d-eb77-452f-aa02-7de38f39792e', '2023-03-12 16:59:36.000000', 'qui');
INSERT INTO `category` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `name`)
VALUES ('2', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2022-12-06 07:34:27.000000',
        'c4a40e5d-eb77-452f-aa02-7de38f39792e', '2023-03-22 02:41:35.000000', 'voluptas');
INSERT INTO `category` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `name`)
VALUES ('3', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-01-22 15:24:15.000000',
        'c4a40e5d-eb77-452f-aa02-7de38f39792e', '2023-04-01 12:04:35.000000', 'dolores');

INSERT INTO `category_children` (`category_id`, `children_id`)
VALUES ('1', '2');

INSERT INTO `color` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `name`, `value_code`)
VALUES ('1', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2022-06-27 17:24:51.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-28 12:44:31.000000', 'Green', '#2c8a0d');
INSERT INTO `color` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `name`, `value_code`)
VALUES ('2', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2022-12-06 12:01:14.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-25 13:47:23.000000', 'MediumBlue', '#304061');
INSERT INTO `color` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `name`, `value_code`)
VALUES ('3', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2022-10-29 05:04:28.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-18 12:03:56.000000', 'Rosa', '#8e4e64');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('8567ceba-9fc4-5b13-8fb3-c574bc60a362', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-26 01:17:22.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-16 18:51:08.000000',
        'Commodi quia a ducimus eos ut dolores. Officia iusto impedit nobis sed eum. Vel reprehenderit dolorum sint fugit mollitia praesentium. Repudiandae sunt enim qui accusantium.',
        'SMALL', 2, 182, ' HIDE', 'Debitis dolorem eligendi ut aliquid est voluptatum reiciendis error.', 'OPTIMUM',
        '2', '3', '1', '3', 'c4a40e5d-eb77-452f-aa02-7de38f39792e');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('dbd7a94a-da77-5f27-bfb4-94e8b5a0d804', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-20 16:50:33.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-29 16:52:58.000000',
        'Quos neque pariatur iste sit ex sunt. Eveniet mollitia unde maiores. Ea laboriosam et illum et nihil reprehenderit totam. Sed autem quisquam odit veniam esse nihil aliquid earum. Quis tempore voluptatum vero est accusamus non totam minima.',
        'SMALL', 8, 390, 'VISIBLE', 'Hic omnis adipisci occaecati et saepe optio libero.', 'NEW_NO_LABEL', '1', '3',
        '1', '3', 'c4a40e5d-eb77-452f-aa02-7de38f39792e');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('d5ebe9ee-4c7e-56e6-b78e-4bb9f2c87829', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-29 15:45:30.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-04-04 02:48:07.000000',
        'Fugit hic quibusdam rerum sequi in itaque deleniti. Libero velit provident veritatis architecto. Quia perferendis sint quisquam laboriosam fuga. Eaque voluptatibus vel asperiores dolorem in vero.',
        'MEDIUM', 3, 140, ' HIDE', 'Quia sequi consequuntur ipsam minima eos natus.', 'NEW_NO_LABEL', '2', '3', '1',
        '2', 'c4a40e5d-eb77-452f-aa02-7de38f39792e');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('6f65ff49-6cc5-57eb-953e-352d694d2132', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-25 01:20:53.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-04-04 01:11:30.000000',
        'Quidem dolore commodi sunt autem ipsam eveniet est sed. Et odit voluptatem ut tempora et totam dolores. Quod recusandae deleniti velit. In illum alias facere ut ut delectus deleniti.',
        ' BIG', 7, 79, 'VISIBLE', 'Sapiente rerum voluptatibus aut impedit quia iusto.', 'AVERAGE', '3', '3', '1', '2',
        'c4a40e5d-eb77-452f-aa02-7de38f39792e');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('268e3663-d29e-5021-812c-9ba78de4ccf7', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-28 17:50:21.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-08 22:16:50.000000',
        'Et impedit consequatur labore ab dolorem dolorem sint. Mollitia atque eos sequi molestiae in perspiciatis quas. Eligendi ut similique est nulla sunt architecto ullam vel.',
        'SMALL', 1, 317, ' HIDE', 'Impedit velit est in ipsam iure.', 'NEW_NO_LABEL', '3', '3', '3', '3',
        'b742d9c4-caae-4702-9f7b-932c4d83da13');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('daab55ea-baaa-5fea-b37c-7ef801b4b46b', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-31 15:38:29.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-18 16:31:15.000000',
        'Omnis tempore tempore illo sed omnis. Aut similique quos quos non quas vel. Sit quaerat fugit fugiat neque reiciendis corporis veniam.',
        ' BIG', 3, 37, ' HIDE', 'Dolorum quia repellat voluptatem consectetur.', ' GOOD', '1', '3', '3', '3',
        'b742d9c4-caae-4702-9f7b-932c4d83da13');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('eacffeb0-65a8-5a4e-9429-982d580d6d02', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-23 01:24:15.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-09 15:14:28.000000',
        'Molestiae nihil natus pariatur in. Sit sed sit quibusdam eos rerum mollitia et. Pariatur rerum quaerat cum eos nostrum quo a. Error et consectetur sint.',
        'MEDIUM', 0, 70, 'VISIBLE', 'Cum ducimus neque sunt recusandae.', ' GOOD', '2', '3', '2', '2',
        'b742d9c4-caae-4702-9f7b-932c4d83da13');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('a4a406c8-77cc-5f32-97fa-3e6965b97970', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-24 07:42:22.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-31 05:04:29.000000',
        'Fugiat fugit libero optio libero. Illum qui quam totam mollitia delectus. Laudantium non veniam laudantium iste. Molestias velit doloremque sunt nihil modi.',
        'MEDIUM', 9, 274, 'VISIBLE', 'Omnis alias corrupti perferendis.', 'NEW_NO_LABEL', '3', '3', '3', '3',
        'b742d9c4-caae-4702-9f7b-932c4d83da13');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('d0c7cf9f-a806-5c28-8481-f7ecad16ac52', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-28 06:29:06.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-21 15:23:43.000000',
        'Ratione perspiciatis reiciendis suscipit tempora ut nesciunt. Nulla tempora quod odio reprehenderit qui tempora numquam. Quasi modi sit et nam ratione occaecati. Nesciunt qui eius ipsa commodi blanditiis doloremque deleniti.',
        'MEDIUM', 9, 499, ' HIDE', 'Amet distinctio qui debitis minus distinctio.', 'NEW_NO_LABEL', '2', '3', '2', '3',
        'b742d9c4-caae-4702-9f7b-932c4d83da13');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('bb4ad37b-2f38-5ae5-9ae3-88897859d51b', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-30 18:01:50.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-17 13:10:55.000000',
        'Dolores ut non et ipsa fuga ab. Et sequi esse beatae. Facilis modi temporibus deserunt voluptatem aliquam dolorem recusandae. Accusamus et ratione et sed ea sint.',
        'SMALL', 7, 392, 'VISIBLE', 'Quos animi quia incidunt repellat.', 'NEW_NO_LABEL', '1', '3', '1', '3',
        'b742d9c4-caae-4702-9f7b-932c4d83da13');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('b5226d25-d052-522b-a110-c6e6c431d851', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-18 15:46:19.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-30 14:55:41.000000',
        'Sapiente consectetur voluptatem unde perspiciatis quia consequuntur. Doloribus aut ut qui voluptatem saepe temporibus. Aut rerum voluptas necessitatibus est odit omnis omnis.',
        ' BIG', 0, 328, 'VISIBLE', 'Corrupti itaque quidem qui consequatur maxime.', ' GOOD', '2', '3', '1', '3',
        'b742d9c4-caae-4702-9f7b-932c4d83da13');

INSERT INTO `product` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `description`,
                       `pack_dimension`, `cent`, `euro`, `status`, `title`, `wear_condition`, `brand_id`, `category`,
                       `color1`, `color2`, `owner_id`)
VALUES ('30f4162c-eb72-5480-8ed1-f88f630be1c8', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-21 23:21:39.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-30 09:01:26.000000',
        'Id enim dolorem itaque rerum. Ullam magnam earum aut quas velit impedit. Repudiandae et ullam blanditiis quia quibusdam eos. Dicta eos aut dolores autem.',
        'SMALL', 5, 414, 'VISIBLE', 'Sit amet nemo hic consequatur consequatur magni voluptatem.', 'NEW_WITH_LABEL',
        '1', '3', '1', '1', 'd31d535a-44ea-4148-91c1-e2e62ff0931b');


INSERT INTO `customer_order` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `note`,
                              `status`, `customer_id`, `product_id`)
VALUES ('72c03b3a-9c4a-4bd7-87a7-9cb17ecbc554', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-26 15:23:26.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-14 18:46:47.000000',
        'Est autem corporis porro. Accusamus quam quidem qui est. Odio perspiciatis qui laborum voluptate nemo harum reiciendis neque. Iusto qui voluptatem sed animi. Et magnam aspernatur quia labore eos provident saepe.',
        0, 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '30f4162c-eb72-5480-8ed1-f88f630be1c8');
INSERT INTO `customer_order` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `note`,
                              `status`, `customer_id`, `product_id`)
VALUES ('ccdb133b-b9a0-49c6-8a2e-2093f8918b95', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-13 02:42:16.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-04-07 14:12:37.000000',
        'Exercitationem tenetur iure vitae. Fugit ea excepturi dolorem est. Voluptas explicabo aspernatur atque.', 0,
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '8567ceba-9fc4-5b13-8fb3-c574bc60a362');
INSERT INTO `customer_order` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `note`,
                              `status`, `customer_id`, `product_id`)
VALUES ('118ee6f5-23d7-4e41-92c0-c929aa04fa71', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-15 00:35:17.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-19 14:50:28.000000',
        'Minima sapiente soluta dolorem excepturi tempore sed quibusdam error. Consequuntur dolores reprehenderit ad et corrupti. Nemo quia suscipit rerum ullam sunt.',
        0, 'd31d535a-44ea-4148-91c1-e2e62ff0931b', 'dbd7a94a-da77-5f27-bfb4-94e8b5a0d804');
INSERT INTO `customer_order` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `note`,
                              `status`, `customer_id`, `product_id`)
VALUES ('5918f861-421e-42eb-a4b9-819ccf630b86', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-04-05 17:39:40.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-12 14:42:49.000000',
        'Maiores et tempora vel rerum dicta ipsam occaecati. Illum totam fugiat sit ipsa eos sit debitis. Recusandae molestias mollitia et voluptas ut minus non. Sed eum a nihil sunt alias.',
        0, 'd31d535a-44ea-4148-91c1-e2e62ff0931b', 'd5ebe9ee-4c7e-56e6-b78e-4bb9f2c87829');
INSERT INTO `customer_order` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `note`,
                              `status`, `customer_id`, `product_id`)
VALUES ('f8e40e46-156a-44bb-8f42-9ad603687a49', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-30 19:40:53.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-17 19:05:45.000000',
        'Expedita maiores vel aliquid alias. Quisquam dolore nesciunt tenetur natus ut aperiam. Inventore corrupti reiciendis minus quia praesentium.',
        0, 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '6f65ff49-6cc5-57eb-953e-352d694d2132');
INSERT INTO `customer_order` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `note`,
                              `status`, `customer_id`, `product_id`)
VALUES ('5cce4fa8-91fc-4988-9c79-a2340b5f1c81', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-17 05:27:18.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-13 08:07:13.000000',
        'Rem totam dolor officia corrupti voluptatem expedita ea. In in eum ipsa reprehenderit. Eum et exercitationem iusto laudantium consequatur pariatur sunt.',
        0, 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '268e3663-d29e-5021-812c-9ba78de4ccf7');
INSERT INTO `customer_order` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `note`,
                              `status`, `customer_id`, `product_id`)
VALUES ('8f42a548-0b57-4b85-8a77-329c1a0a9a17', 'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-16 12:39:43.000000',
        'd31d535a-44ea-4148-91c1-e2e62ff0931b', '2023-03-28 11:54:48.000000',
        'Reiciendis in ea aspernatur minus at. Rem exercitationem quam velit. Soluta unde suscipit tempore provident consequuntur. Mollitia accusantium culpa molestias beatae.',
        0, 'd31d535a-44ea-4148-91c1-e2e62ff0931b', 'daab55ea-baaa-5fea-b37c-7ef801b4b46b');

INSERT INTO `photo` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `image`,
                     `product_id`)
VALUES ('29dc017a-985b-5836-a9b8-6394bf712a69', 'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-13 19:03:04.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-24 08:09:40.000000', NULL,
        '8567ceba-9fc4-5b13-8fb3-c574bc60a362');
INSERT INTO `photo` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `image`,
                     `product_id`)
VALUES ('3955fabf-32fe-5ce0-a70a-04acd1402172', 'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-10 01:51:36.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-04-01 03:59:43.000000', NULL,
        '8567ceba-9fc4-5b13-8fb3-c574bc60a362');
INSERT INTO `photo` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `image`,
                     `product_id`)
VALUES ('07a94948-581b-54a0-bbf2-c8169bcf6d8e', 'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-04-08 05:11:37.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-10 09:16:16.000000', NULL,
        '8567ceba-9fc4-5b13-8fb3-c574bc60a362');
INSERT INTO `photo` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `image`,
                     `product_id`)
VALUES ('e8ceec97-32b3-5c19-b25a-08e9645e5ddf', 'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-04-07 19:28:42.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-11 16:05:28.000000', NULL,
        '8567ceba-9fc4-5b13-8fb3-c574bc60a362');
INSERT INTO `photo` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `image`,
                     `product_id`)
VALUES ('15cbade4-f87c-5a5f-8f99-f07a814d19b0', 'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-04-02 22:14:12.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-19 12:59:39.000000', NULL,
        '8567ceba-9fc4-5b13-8fb3-c574bc60a362');
INSERT INTO `photo` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `image`,
                     `product_id`)
VALUES ('b09ab880-bf51-5260-b349-5d7ce05acaca', 'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-19 04:55:21.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-04-05 10:08:26.000000', NULL,
        'dbd7a94a-da77-5f27-bfb4-94e8b5a0d804');
INSERT INTO `photo` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `image`,
                     `product_id`)
VALUES ('0b677531-6f7a-57a0-9211-bb111aff53ce', 'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-04-02 11:45:10.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-08 17:54:26.000000', NULL,
        'd5ebe9ee-4c7e-56e6-b78e-4bb9f2c87829');
INSERT INTO `photo` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `image`,
                     `product_id`)
VALUES ('4928f020-2fdb-5a04-8c17-98c0a4aad55f', 'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-22 20:44:22.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-29 02:48:22.000000', NULL,
        '6f65ff49-6cc5-57eb-953e-352d694d2132');
INSERT INTO `photo` (`id`, `created_by`, `created_date`, `last_modified_by`, `last_modified_date`, `image`,
                     `product_id`)
VALUES ('8b24dee4-7a5f-5736-8ba7-ab9fca9c8cf8', 'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-30 01:00:01.000000',
        'b742d9c4-caae-4702-9f7b-932c4d83da13', '2023-03-26 01:31:54.000000', NULL,
        '268e3663-d29e-5021-812c-9ba78de4ccf7');

INSERT INTO `prefered` (`customer_id`, `product_id`)
VALUES ('b742d9c4-caae-4702-9f7b-932c4d83da13', 'eacffeb0-65a8-5a4e-9429-982d580d6d02');
INSERT INTO `prefered` (`customer_id`, `product_id`)
VALUES ('b742d9c4-caae-4702-9f7b-932c4d83da13', 'a4a406c8-77cc-5f32-97fa-3e6965b97970');
INSERT INTO `prefered` (`customer_id`, `product_id`)
VALUES ('b742d9c4-caae-4702-9f7b-932c4d83da13', 'd0c7cf9f-a806-5c28-8481-f7ecad16ac52');
INSERT INTO `prefered` (`customer_id`, `product_id`)
VALUES ('b742d9c4-caae-4702-9f7b-932c4d83da13', 'bb4ad37b-2f38-5ae5-9ae3-88897859d51b');
INSERT INTO `prefered` (`customer_id`, `product_id`)
VALUES ('b742d9c4-caae-4702-9f7b-932c4d83da13', 'b5226d25-d052-522b-a110-c6e6c431d851');

-- SET FOREIGN_KEY_CHECKS = 1;
