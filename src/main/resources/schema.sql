CREATE TABLE customer (
                          id UUID NOT NULL,
                          fully_qualified_name VARCHAR(255) NOT NULL,
                          phone_number VARCHAR(13) NOT NULL,
                          email VARCHAR(60) NOT NULL,
                          passport_number VARCHAR(11) not null,
                          PRIMARY KEY (id)
);

CREATE TABLE credit (
                        id UUID NOT NULL,
                        credit_limit decimal(14,4) NOT NULL,
                        interest_rate decimal(4,2) NOT NULL,
                        PRIMARY KEY (id)
);

CREATE TABLE bank (
                      id UUID NOT NULL,
                      uuid_customer UUID NOT NULL REFERENCES customer(id),
                      uuid_credit UUID NOT NULL REFERENCES credit(id),
                      PRIMARY KEY (id)
);



INSERT INTO CUSTOMER (id, fully_qualified_name, phone_number, email, passport_number)
VALUES ('14878326-b111-42bf-a553-f74dd0bc0fa3', 'Иванов Александр Александрович', '89371876532', 'IvanovAlex@mail.com', '6678900456'),
       ('25eeb978-1bd2-4b99-a9a9-04f68521d4c9', 'Крюкова Ольга Петровна', '89267950005', 'Krukova@yandex.ru', '0042600456'),
       ('1b50843d-9771-4351-9860-d3bc8800573a', 'Воробьёв Иван Сергеевич', '89269389520', 'VorobeiIvan@mail.com', '4875846325'),
       ('2694a019-9502-4f89-9788-fd30fba46b96', 'Дудник Андрей Романович', '89688360945', 'DudnikAndrei@mail.com', '6213657812'),
       ('70518da5-3b69-4251-a3c9-ded1d6f80abf', 'Медведев Дмитрий Васильевич', '89060860056', 'MedvedevDm@mail.com', '5643709431'),
       ('8cc3defc-4f22-4d02-b0f9-43cf3323270b', 'Тринкер Борис Давидович', '89857114802', 'BorisRazor@yandex.ru', '4445140932');

INSERT INTO CREDIT (id, credit_limit , interest_rate)
VALUES ('3214a019-9502-4f89-9908-fd30fba46b96',600000, 15.75),
       ('34118da5-3b69-2209-a3c9-ded1dgf80abf', 350000, 18.40),
       ('35548da5-3789-2209-acc9-ded1dgf80abf', 1000000, 11.40),
       ('8aa3defc-4f82-4402-b0f9-43cf2123270b', 800000, 12.40);

INSERT INTO bank (id, uuid_customer, uuid_credit)
VALUES ('8gg3defc-4f22-4d02-b0f9-43cf3323270b', '1b50843d-9771-4351-9860-d3bc8800573a', '34118da5-3b69-2209-a3c9-ded1dgf80abf'),
       ('5b50843d-9771-4351-9ff0-d3bc8800573a', '70518da5-3b69-4251-a3c9-ded1d6f80abf', '8aa3defc-4f82-4402-b0f9-43cf2123270b');