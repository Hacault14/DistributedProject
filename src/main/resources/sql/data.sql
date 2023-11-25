/*
insert into USERS (ID, PASSWORD, USERNAME, ENABLED)
VALUES (0, '', 'anonymous', true);
insert into USERS (ID, PASSWORD, USERNAME, ENABLED)
VALUES (1, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'admin', true);
insert into USERS (ID, PASSWORD, USERNAME, ENABLED)
VALUES (2, '$2a$06$OAPObzhRdRXBCbk7Hj/ot.jY3zPwR8n7/mfLtKIgTzdJa4.6TwsIm', 'user', true); */

MERGE INTO  AUTHORITIES (ID, AUTHORITY)
VALUES (0, 'ROLE_ANONYMOUS');
MERGE INTO  AUTHORITIES (ID, AUTHORITY)
VALUES (1, 'ROLE_ADMIN');
MERGE INTO  AUTHORITIES (ID, AUTHORITY)
VALUES (2, 'ROLE_USER');

/*
insert into USERS_AUTHORITIES (USER_ID, AUTHORITY_ID)
VALUES (1, 1);
insert into USERS_AUTHORITIES (USER_ID, AUTHORITY_ID)
VALUES (1, 2);
insert into USERS_AUTHORITIES (USER_ID, AUTHORITY_ID)
VALUES (2, 2);

insert into POSTS (ID, BODY, CREATION_DATE, TITLE, USER_ID)
VALUES (1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sit amet posuere ligula. Proin efficitur, turpis sed consequat maximus, turpis odio ullamcorper purus, ut malesuada justo dui sed dui. Nam eget placerat eros, eget interdum mi. Aliquam erat volutpat. Donec at magna euismod, aliquam diam sed, elementum quam. Sed sodales urna ac commodo imperdiet. Aliquam sodales nisl sed ornare consectetur. Praesent ultrices congue lacus sit amet malesuada. Nulla vitae vestibulum lorem, nec sodales arcu. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam non tempor erat, iaculis tempus eros.',
        '2023-11-24', 'Blog Post 1', 2);
insert into POSTS (ID, BODY, CREATION_DATE, TITLE, USER_ID)
VALUES (2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sit amet posuere ligula. Proin efficitur, turpis sed consequat maximus, turpis odio ullamcorper purus, ut malesuada justo dui sed dui. Nam eget placerat eros, eget interdum mi. Aliquam erat volutpat. Donec at magna euismod, aliquam diam sed, elementum quam. Sed sodales urna ac commodo imperdiet. Aliquam sodales nisl sed ornare consectetur. Praesent ultrices congue lacus sit amet malesuada. Nulla vitae vestibulum lorem, nec sodales arcu. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam non tempor erat, iaculis tempus eros.',
        '2023-11-24', 'Blog Post 2', 1);
insert into POSTS (ID, BODY, CREATION_DATE, TITLE, USER_ID)
VALUES (3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum sit amet posuere ligula. Proin efficitur, turpis sed consequat maximus, turpis odio ullamcorper purus, ut malesuada justo dui sed dui. Nam eget placerat eros, eget interdum mi. Aliquam erat volutpat. Donec at magna euismod, aliquam diam sed, elementum quam. Sed sodales urna ac commodo imperdiet. Aliquam sodales nisl sed ornare consectetur. Praesent ultrices congue lacus sit amet malesuada. Nulla vitae vestibulum lorem, nec sodales arcu. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam non tempor erat, iaculis tempus eros.',
        '2023-11-24', 'Blog Post 3', 2);

insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (1, 'comentras a', current_timestamp(), 1, 0);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (2, 'comentras a', current_timestamp(), 1, 2);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (3, 'comentras a', current_timestamp(), 1, 0);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (4, 'comentras a', current_timestamp(), 2, 0);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (5, 'comentras a', current_timestamp(), 2, 1);
insert into COMMENTS (ID, BODY, CREATION_DATE, POST_ID, USER_ID)
VALUES (6, 'comentras a', current_timestamp(), 1, 0);
*/

