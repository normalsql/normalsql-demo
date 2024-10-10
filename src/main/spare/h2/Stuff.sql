SELECT * FROM Vets ORDER BY id DESC;

SELECT * FROM Types ORDER BY name;

SELECT * FROM Types WHERE id = 3;

SELECT * FROM Pets WHERE owner_id = 10 AND name = 'Sly';

SELECT * FROM Pets WHERE owner_id = 10;

SELECT * FROM Owners WHERE last_name LIKE CONCAT('Davis', '%');

SELECT * FROM Visits WHERE pet_id = 3;
