
insert into cuenta values (1, 'michael@gmail.com', '123');
insert into cuenta values (2, 'stiven@gmail.com', '456');
insert into cuenta values (3, 'nataly@gmail.com', '789');
insert into cuenta values (4, 'diego@gmail.com', '098');
insert into cuenta values (5, 'andres@gmail.com', '765');

insert into paciente values ('1234567890', 'ARMENIA', 'ACTIVO', 'pepito', '3217122375', 'no_tieneFoto', 'no tiene alergias', 'NUEVA_EPS', '1999-12-12', 'A_NEGATIVO', 1);
insert into paciente values ('0987654321', 'BOGOTA', 'ACTIVO', 'cesar', '3217122375', 'no_tieneFoto', 'tiene alergias', 'SURA_EPS', '1998-10-10', 'O_POSITIVO', 2);
insert into paciente values ('9632587410', 'CALI', 'INACTIVO', 'ash', '3217122375', 'no_tieneFoto', 'no tiene alergias', 'COOMEVA_EPS','2000-04-04', 'AB_POSITIVO',3);
insert into paciente values ('9632587410', 'MEDELLIN', 'INACTIVO', 'ash', '3217122375', 'no_tieneFoto', 'no tiene alergias', 'ASMET_SALD_EPS','2001-10-04', 'O_POSITIVO',4);
insert into paciente values ('9632587410', 'CARTAGENA', 'INACTIVO', 'ash', '3217122375', 'no_tieneFoto', 'no tiene alergias', 'SANITAS_EPS','2002-05-12', 'AB_NEGATIVO',5);

insert into medico values('0147852369', 'ARMENIA', 'ACTIVO', 'Andres', '3217122375', 'no_tiene', 'CARDIOLGIA', 1);
insert into medico values('0147852369', 'MEDELLIN', 'ACTIVO', 'Raul', '3217122375', 'no_tiene', 'NEUTROLOGIA', 2);
insert into medico values('0147852369', 'CARTAGENA', 'ACTIVO', 'Maria', '3217122375', 'no_tiene', 'CIRUJANO_PLASTICO', 3);
insert into medico values('0147852369', 'BOGOTA', 'ACTIVO', 'Daniela', '3217122375', 'no_tiene', 'CARDIOLGIA', 4);
insert into medico values('0147852369', 'CALI', 'ACTIVO', 'Muricio', '3217122375', 'no_tiene', 'PEDIATRA', 5);

insert into cita values('PROGRAMADA', '2023-10-20 10:30:00', '2023-10-18 10:30:00','alergias por picadura de aveja', 1, 1);
insert into cita values('PROGRAMADA', '2023-10-20 10:30:00', '2023-10-18 10:30:00','alergias por picadura de aveja', 2, 2);
insert into cita values('PROGRAMADA', '2023-10-20 10:30:00', '2023-10-18 10:30:00','alergias por picadura de aveja', 3, 3);
insert into cita values('PROGRAMADA', '2023-10-20 10:30:00', '2023-10-18 10:30:00','alergias por picadura de aveja', 4, 4);
insert into cita values('PROGRAMADA', '2023-10-20 10:30:00', '2023-10-18 10:30:00','alergias por picadura de aveja', 5, 5);

insert into atencion values(1,'Al paciente lo pico una aveja', 'se le inflamo el cueyo', 'el paciente debde tomar acetaminofen', 1);
insert into atencion values(2,'Al paciente lo pico una aveja', 'se le inflamo el cueyo', 'el paciente debde tomar acetaminofen', 2);
insert into atencion values(3,'Al paciente lo pico una aveja', 'se le inflamo el cueyo', 'el paciente debde tomar acetaminofen', 3);
insert into atencion values(4,'Al paciente lo pico una aveja', 'se le inflamo el cueyo', 'el paciente debde tomar acetaminofen', 4);
insert into atencion values(5,'Al paciente lo pico una aveja', 'se le inflamo el cueyo', 'el paciente debde tomar acetaminofen', 5);

insert into dia_libre values('2023-12-12', 1);
insert into dia_libre values('2023-12-13', 2);
insert into dia_libre values('2023-12-14', 3);
insert into dia_libre values('2023-12-15', 4);
insert into dia_libre values('2023-12-16', 5);

insert into horario_medico values(1, 'LUNES - VIERNES', '8:00:00', '17:00:00',1);
insert into horario_medico values(2, 'MARTES - SABADO', '8:00:00', '17:00:00',2);
insert into horario_medico values(3, 'LUNES - VIERNES', '8:00:00', '17:00:00',3);
insert into horario_medico values(4, 'MARTES - SABADO', '8:00:00', '17:00:00',4);
insert into horario_medico values(5, 'LUNES - VIERNES', '8:00:00', '17:00:00',5);

insert into pqrs values('APROBADO', '2023-10-18:13:32:00', 'El medio me atendio mal','me pico una avispa',1);
insert into pqrs values('EN_PROCESO', '2023-10-18:13:32:00', 'El medio me atendio mal','me pico una avispa',2);
insert into pqrs values('APROBADO', '2023-10-18:13:32:00', 'El medio me atendio mal','me pico una avispa',3);
insert into pqrs values('APROBADO', '2023-10-18:13:32:00', 'El medio me atendio mal','me pico una avispa',4);
insert into pqrs values('APROBADO', '2023-10-18:13:32:00', 'El medio me atendio mal','me pico una avispa',5);


