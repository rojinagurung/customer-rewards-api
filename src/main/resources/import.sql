INSERT INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME) VALUES (1, 'FOO BAR');
INSERT INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME) VALUES (2, 'John Smith');
INSERT INTO CUSTOMER(CUSTOMER_ID, CUSTOMER_NAME) VALUES (3, 'Alice Baker');
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29001, 1, '2022-01-01', 125);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29002, 1, '2022-02-01', 89);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29003, 1, '2022-02-02', 76);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29004, 1, '2022-02-03', 49);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29005, 1, '2022-03-01', 51);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29006, 1, '2022-04-01', 36);

INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29007, 2, '2022-05-01', 10);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29008, 2, '2022-05-02', 30);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29009, 2, '2022-06-02', 70);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29010, 2, '2022-07-03', 80);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29011, 2, '2022-08-01', 120);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29012, 2, '2022-08-02', 180);

INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29013, 3, '2022-09-01', 80);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29014, 3, '2022-10-02', 80);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29015, 3, '2022-11-02', 80);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29016, 3, '2022-11-03', 80);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29017, 3, '2022-11-01', 80);
INSERT INTO TRANSACTION(transaction_id, customer_id, transaction_date, transaction_amount) VALUES (29018, 3, '2022-12-02', 80);

COMMIT;