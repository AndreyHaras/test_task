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
                        credit_limit VARCHAR(10) NOT NULL,
                        interest_rate VARCHAR(5) NOT NULL,
                        PRIMARY KEY (id)
);

CREATE TABLE bank (
                      id UUID NOT NULL,
                      uuid_customer UUID NOT NULL REFERENCES customer(id),
                      uuid_credit UUID NOT NULL REFERENCES credit(id),
                      PRIMARY KEY (id)
);

CREATE TABLE loan_offer(
                        id UUID NOT NULL,
                        uuid_customer UUID NOT NULL REFERENCES customer(id),
                        uuid_credit UUID NOT NULL REFERENCES credit(id),
                        credit_amount VARCHAR(20) NOT NULL,
                        PRIMARY KEY (id)
);

CREATE TABLE payment_schedule(
                        id UUID NOT NULL,
                        loan_offer_id UUID NOT NULL REFERENCES loan_offer(id),
                        date_of_pay VARCHAR(20) NOT NULL,
                        monthly_payment VARCHAR(20) NOT NULL,
                        principal_paid VARCHAR(20) NOT NULL,
                        interest_paid VARCHAR(20) NOT NULL,
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
VALUES ('3214a019-9502-4f89-9908-fd30fba46b96','600000', '15.75'),
       ('34118da5-3b69-2209-a3c9-ded1dgf80abf', '350000', '18.40'),
       ('35548da5-3789-2209-acc9-ded1dgf80abf', '1000000', '11.40'),
       ('8aa3defc-4f82-4402-b0f9-43cf2123270b', '800000', '12.40');

INSERT INTO bank (id, uuid_customer, uuid_credit)
VALUES ('8gg3defc-4f22-4d02-b0f9-43cf3323270b', '1b50843d-9771-4351-9860-d3bc8800573a', '34118da5-3b69-2209-a3c9-ded1dgf80abf'),
       ('5b50843d-9771-4351-9ff0-d3bc8800573a', '70518da5-3b69-4251-a3c9-ded1d6f80abf', '8aa3defc-4f82-4402-b0f9-43cf2123270b');

INSERT INTO loan_offer (id, uuid_customer, uuid_credit, credit_amount)
VALUES ('8gg3defc-4f22-4d02-b0f9-43cf3hg3270b', '1b50843d-9771-4351-9860-d3bc8800573a', '34118da5-3b69-2209-a3c9-ded1dgf80abf', '350000'),
       ('5b50843d-9771-4aa1-9ff0-d3bc8800573a', '70518da5-3b69-4251-a3c9-ded1d6f80abf', '8aa3defc-4f82-4402-b0f9-43cf2123270b', '800000');

INSERT INTO payment_schedule(id, loan_offer_id, date_of_pay, monthly_payment, principal_paid, interest_paid)
VALUES ('2694a019-9502-4f89-9788-fd30fba46b96','8gg3defc-4f22-4d02-b0f9-43cf3hg3270b','2021-08-08','5737,49','5398,68', '338,81'),
       ('ffr4a019-9502-4f89-9788-fd30fba46b96','8gg3defc-4f22-4d02-b0f9-43cf3hg3270b','2021-09-07','5737,49','5481,46','256,03'),
       ('2694az19-aaaa-4f89-9788-fd30fba46b96','8gg3defc-4f22-4d02-b0f9-43cf3hg3270b','2021-10-06','5737,49','5565,51','171,98'),
       ('2694a0g9-bbbb-4f89-9788-fd30fba46b96','8gg3defc-4f22-4d02-b0f9-43cf3hg3270b','2021-11-06','5737,49','5650,84','86,65');
INSERT INTO payment_schedule(id, loan_offer_id, date_of_pay, monthly_payment, principal_paid, interest_paid)
VALUES ('22381c2a-e28b-405e-aec7-d9cc42c3f4c3','5b50843d-9771-4aa1-9ff0-d3bc8800573a','2021-08-08','9808,17','9413,03', '395,14'),
       ('ceb88a9a-5915-4daa-a711-e8a55ab2fa5e','5b50843d-9771-4aa1-9ff0-d3bc8800573a','2021-09-07','9808,17','9510,30','297,88'),
       ('fdfdac80-15bb-46b5-b307-c14ea7eda8a4','5b50843d-9771-4aa1-9ff0-d3bc8800573a','2021-10-06','9808,17','9608,57','199,60'),
       ('227d299f-49e6-4f82-a9a9-4ec67316e063','5b50843d-9771-4aa1-9ff0-d3bc8800573a','2021-11-06','9808,17','9707,86','100,31');
