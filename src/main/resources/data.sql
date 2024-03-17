insert into GENDER values('F', 'Female');
insert into GENDER values('M', 'Male');


insert into SPORT values(1, 'Tennis');
insert into SPORT values(2, 'Soccer');
insert into SPORT values(3, 'Basketball');
insert into SPORT values(4, 'Baseball');
insert into SPORT values(5, 'Football');
insert into SPORT values(6, 'Golf');
insert into SPORT values(7, 'Swimming');

insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (1, 'player1@fictionaltennis.com', 8, 27, 'M');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (2, 'player2@fictionaltennis.com', 9, 25, 'M');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (3, 'player3@fictionalsoccer.com', 6, 22, 'F');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (4, 'player4@fictionalsoccer.com', 10, 31, 'F');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (5, 'player5@fictionalbasketball.com', 7, 22, 'M');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (6, 'player6@fictionalbasketball.com', 9, 25, 'M');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (7, 'player7@fictionalbaseball.com', 5, 24, 'M');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (8, 'player8@fictionalbaseball.com', 10, 35, 'M');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (9, 'player9@fictionalfootball.com', 3, 20, 'M');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (10, 'player10@fictionalfootball.com', 9, 27, 'F');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (11, 'player11@fictionalswimming.com', 6, 27, 'M');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (12, 'player12@fictionalswimming.com', 7, 24, 'F');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (13, 'player13@fictionalswimming.com', 9, 22, 'M');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (14, 'player14@fictionalnosport.com', 2, 20, 'M');
insert into PLAYER (ID, EMAIL, LEVEL, AGE, GENDER) values (15, 'player15@fictionalnosport.com', 3, 19, 'F');

insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (1, 1);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (2, 1);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (3, 2);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (4, 2);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (5, 3);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (6, 3);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (7, 4);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (8, 4);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (9, 5);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (10, 5);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (11, 7);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (12, 7);
insert into SPORT_PLAYER (PLAYER_ID, SPORT_ID) values (13, 7);