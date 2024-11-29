SELECT O.Last_Name AS Last, P.Name AS First, T.Name AS Species, Birth_Date AS Dob
FROM Owners O
         LEFT JOIN Pets P ON O.Id = P.Owner_Id
         LEFT JOIN Types T ON P.Type_Id = T.Id
WHERE O.Last_Name ILIKE 'Mc%';
