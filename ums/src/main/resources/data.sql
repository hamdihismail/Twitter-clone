Insert INTO ROLES (id,role,description) 
select
	1,'subscriber',
	'This role allows the user to view content and subscribe to producers'	
where not exists (
	select * from ROLES
	where id = 1
	and role = 'subscriber');
Insert INTO ROLES (id,role,description) 
select
	2,'producer',
	'This role allows the user to create content'	
where not exists (
	select * from ROLES
	where id = 2
	and role = 'producer');
Insert INTO ROLES (id,role,description) 
select
	3,'admin',
	'This role allows the user to manage and delete users or content'	
where not exists (
	select * from ROLES
	where id = 3
	and role = 'admin');