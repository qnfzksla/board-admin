-- 테스트 계정
-- TODO: 테스트용이지만 비밀번호가 노출된 데이터 세팅. 개선하는 것이 좋을 지 고민해 보자.
insert into Admin_account (user_id, user_password,role_types, nickname, email, memo, created_at, created_by, modified_at,
                          modified_by)
values ('qnfzksla', '{noop}1584','ADMIN', 'Uno', 'uno@mail.com', 'I am Uno.', now(), 'qnfzksla', now(), 'qnfzksla'),
       ('mark', '{noop}1584','MANAGER', 'Mark', 'mark@mail.com', 'I am Mark.', now(), 'qnfzksla', now(), 'qnfzksla'),
       ('susan', '{noop}1584','MANAGER' ,'Susan', 'Susan@mail.com', 'I am Susan.', now(), 'qnfzksla', now(), 'qnfzksla'),
       ('jim', '{noop}1584','USER', 'Jim', 'jim@mail.com', 'I am Uno.', now(), 'qnfzksla', now(), 'qnfzksla');
