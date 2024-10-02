select * from vets order by id desc;
select * from types order by name;
select * from types where id = 3;
select * from pets where owner_id = 10 and name = 'Sly';
select * from pets where owner_id = 10;
SELECT * FROM owners WHERE last_name LIKE concat('Davis','%');
select * from visits where pet_id = 3;
