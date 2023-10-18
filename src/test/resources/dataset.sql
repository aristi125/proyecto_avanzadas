insert into cuenta values (1, 'michael@gmail.com', '$2a$10$Wa6p2DL76D/kSO.3PcNPQuVxSMtMYipv7SspkI/91bdB7uESo8axq');
insert into cuenta values (2, 'stiven@gmail.com', '$2a$10$Wa6p2DL76D/kSO.3PcNPQuVxSMtMYipv7SspkI/91bdB7uESo8axq');
insert into cuenta values (3, 'nataly@gmail.com', '$2a$10$Wa6p2DL76D/kSO.3PcNPQuVxSMtMYipv7SspkI/91bdB7uESo8axq');
insert into cuenta values (4, 'diego@gmail.com', '$2a$10$Wa6p2DL76D/kSO.3PcNPQuVxSMtMYipv7SspkI/91bdB7uESo8axq');
insert into cuenta values (5, 'andres@gmail.com', '$2a$10$Wa6p2DL76D/kSO.3PcNPQuVxSMtMYipv7SspkI/91bdB7uESo8axq');

insert into cuenta values (6, 'michael1@gmail.com', '$2a$10$Wa6p2DL76D/kSO.3PcNPQuVxSMtMYipv7SspkI/91bdB7uESo8axq');
insert into cuenta values (7, 'stiven1@gmail.com', '$2a$10$Wa6p2DL76D/kSO.3PcNPQuVxSMtMYipv7SspkI/91bdB7uESo8axq');
insert into cuenta values (8, 'nataly1@gmail.com', '$2a$10$Wa6p2DL76D/kSO.3PcNPQuVxSMtMYipv7SspkI/91bdB7uESo8axq');
insert into cuenta values (9, 'diego1@gmail.com', '$2a$10$Wa6p2DL76D/kSO.3PcNPQuVxSMtMYipv7SspkI/91bdB7uESo8axq');
insert into cuenta values (10, 'andres1@gmail.com', '$2a$10$Wa6p2DL76D/kSO.3PcNPQuVxSMtMYipv7SspkI/91bdB7uESo8axq');

insert into paciente values ('1234567890', 'ARMENIA', 'ACTIVO', 'pepito', '3217122375', 'no_tieneFoto', 'no tiene alergias', 'NUEVA_EPS', '1999-12-12', 'A_NEGATIVO', 1);
insert into paciente values ('0987654321', 'BOGOTA', 'ACTIVO', 'cesar', '3217122375', 'no_tieneFoto', 'tiene alergias', 'SURA_EPS', '1998-10-10', 'O_POSITIVO', 2);
insert into paciente values ('9632587410', 'CALI', 'INACTIVO', 'ash', '3217122375', 'no_tieneFoto', 'no tiene alergias', 'COOMEVA_EPS','2000-04-04', 'AB_POSITIVO',3);
insert into paciente values ('9632587410', 'MEDELLIN', 'INACTIVO', 'ash', '3217122375', 'no_tieneFoto', 'no tiene alergias', 'ASMET_SALD_EPS','2001-10-04', 'O_POSITIVO',4);
insert into paciente values ('9632587410', 'CARTAGENA', 'INACTIVO', 'ash', '3217122375', 'no_tieneFoto', 'no tiene alergias', 'SANITAS_EPS','2002-05-12', 'AB_NEGATIVO',5);

insert into medico values('0147852369', 'ARMENIA', 'ACTIVO', 'Andres', '3217122375', 'no_tiene', 'CARDIOLGIA', 6);
insert into medico values('0147852369', 'MEDELLIN', 'ACTIVO', 'Raul', '3217122375', 'no_tiene', 'NEUTROLOGIA', 7);
insert into medico values('0147852369', 'CARTAGENA', 'ACTIVO', 'Maria', '3217122375', 'no_tiene', 'CIRUJANO_PLASTICO', 8);
insert into medico values('0147852369', 'BOGOTA', 'ACTIVO', 'Daniela', '3217122375', 'no_tiene', 'CARDIOLGIA', 9);
insert into medico values('0147852369', 'CALI', 'ACTIVO', 'Muricio', '3217122375', 'no_tiene', 'PEDIATRA', 10);

insert into cita values (1, 'PROGRAMADA', '2023-10-20 10:30:00', '2023-10-18 10:30:00','alergias por picadura de aveja', 6, 1);
insert into cita values (2, 'PROGRAMADA', '2023-10-20 10:30:00', '2023-10-18 10:30:00','alergias por picadura de aveja', 6, 2);
insert into cita values (3,'PROGRAMADA', '2023-10-20 10:30:00', '2023-10-18 10:30:00','alergias por picadura de aveja', 7, 3);
insert into cita values (4, 'PROGRAMADA', '2023-10-20 10:30:00', '2023-10-18 10:30:00','alergias por picadura de aveja', 10, 4);
insert into cita values (5, 'PROGRAMADA', '2023-10-20 10:30:00', '2023-10-18 10:30:00','alergias por picadura de aveja', 9, 5);

insert into dia_libre values (1, '2023-12-12', 6);
insert into dia_libre values (2, '2023-12-13', 7);
insert into dia_libre values (3, '2023-12-14', 8);
insert into dia_libre values (4, '2023-12-15', 9);
insert into dia_libre values (5, '2023-12-16', 10);

insert into horario_medico values(1, 'LUNES - VIERNES', '8:00:00', '17:00:00',6);
insert into horario_medico values(2, 'MARTES - SABADO', '8:00:00', '17:00:00',7);
insert into horario_medico values(3, 'LUNES - VIERNES', '8:00:00', '17:00:00',8);
insert into horario_medico values(4, 'MARTES - SABADO', '8:00:00', '17:00:00',9);
insert into horario_medico values(5, 'LUNES - VIERNES', '8:00:00', '17:00:00',10);

insert into atencion values(1,'Al paciente lo pico una aveja', 'se le inflamo el cueyo', 'el paciente debde tomar acetaminofen', 1);
insert into atencion values(2,'Al paciente lo pico una aveja', 'se le inflamo el cueyo', 'el paciente debde tomar acetaminofen', 2);
insert into atencion values(3,'Al paciente lo pico una aveja', 'se le inflamo el cueyo', 'el paciente debde tomar acetaminofen', 3);
insert into atencion values(4,'Al paciente lo pico una aveja', 'se le inflamo el cueyo', 'el paciente debde tomar acetaminofen', 4);
insert into atencion values(5,'Al paciente lo pico una aveja', 'se le inflamo el cueyo', 'el paciente debde tomar acetaminofen', 5);

insert into pqrs values (1,'APROBADO', '2023-10-18 13:32:00', 'El medio me atendio mal', 'me pico una avispa', 1);
insert into pqrs values (2, 'EN_PROCESO', '2023-10-18 13:32:00', 'El medio me atendio mal', 'me pico una avispa', 2);
insert into pqrs values (3, 'APROBADO', '2023-10-18 13:32:00', 'El medio me atendio mal', 'me pico una avispa', 3);
insert into pqrs values (4, 'APROBADO', '2023-10-18 13:32:00', 'El medio me atendio mal', 'me pico una avispa', 4);
insert into pqrs values (5, 'APROBADO', '2023-10-18 13:32:00', 'El medio me atendio mal', 'me pico una avispa', 5);

