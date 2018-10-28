insert into company(id,nombre,abrev,slogan,enable)
values
(1,'Municipalidad del Centro Poblado Santa Maria de Huachipa','MCPSMH','Trabajando por el cambio',true),
(2,'Municipalidad de Huachipa','MDH','Trabajando',false);

insert into tupa(id,anio,nombre,resolucion)
values
(1,2012,'TUPA DEL AÑO 2012','RESOLUCION 123213 TUO DS'),
(2,2013,'TUPA DEL AÑO 2013','RESOLUCION 123213 TUO DS');

insert into requisite(id,nombre,descripcion) 
	values
	(1,'Solicitud simple','Solicitud simple'),
	(2,'Constancia de Posesion','Constancia de Posesion'),
	(3,'Copia de Dni','Copia de Dni'),
	(4,'Ficha Ruc','Ficha Ruc'),
	(5,'Planes de evacuacion','Planes de evacuacion'),
	(6,'Certificado de Defensa Civil','Certificado de Defensa Civil');

insert into usuario (id,username,password,role)
values
(1,'user','password', 'ROLE_USER'),
(2,'admin','password', 'ROLE_ADMIN');