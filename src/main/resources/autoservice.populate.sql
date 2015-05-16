USE autoService;

INSERT INTO auction (carBrand,model,lot,price,status,exactCloseDate,details,bids,sorted) VALUES ('Audi', 'A4','111A4','3100','available', '2015-09-03 07:01:00', '""{"img": "http://www.avtorinok.ru/news/pics/Audi_A4_pic_24667.jpg","modification":"","bodyType": "sedan","lot":"111A4","year":"2012","engineType": "petrol","volume": "3.3","mileage": "21000","transmission": "automatic"}""', {'id':'1231231','author':'ivanov','creationTime':'2015-05-01T12:22','price':'3800'},'alphabetically');

INSERT INTO auction (carBrand,model,lot,price,status,exactCloseDate,details,bids,sorted) VALUES ('Audi', 'A5','111A5','1100','available', '2015-09-03 07:01:00', '""{"img": "http://upload.wikimedia.org/wikipedia/commons/2/25/Audi_A5_Coup%C3%A9_2.0_TFSI_quattro_S_tronic_Gletscherwei%C3%9F_Facelift.JPG","modification":"","bodyType": "sedan","lot":"111A5","year":"2006","engineType": "petrol","volume": "3.3","mileage": "21000","transmission": "automatic"}""', null,'alphabetically');

INSERT INTO auction (carBrand,model,lot,price,status,exactCloseDate,details,bids,sorted) VALUES ('Audi', 'Q7','111Q7','2800','available', '2015-09-03 07:01:00', '""{"img": "http://mega-avto.com/Imaginary.ashx?img=/media/1049763/$(KGrHqV,!lMFHlsyWzJ3BR8z7ZKvsg~~_27.JPG&width=480&height=360&fill=true","modification":"","bodyType": "sedan","lot":"111Q7","year":"2006","engineType": "petrol","volume": "3.3","mileage": "21000","transmission": "automatic"}""', null,'alphabetically');

INSERT INTO auction (carBrand,model,lot,price,status,exactCloseDate,details,bids,sorted) VALUES ('BMW', 'X5','222X5','3400','available', '2015-09-03 07:01:00', '""{"img":"http://mega-avto.com/Imaginary.ashx?img=/media/1115567/$(KGrHqQOKp0FJF!T3e-GBSUR6b2hJg~~48_27.JPG&width=480&height=360&fill=true","modification":"","bodyType": "sedan","lot":"222X5","year":"2006","engineType": "petrol","volume": "3.3","mileage": "21000","transmission": "automatic"}""',null,'alphabetically');

INSERT INTO auction (carBrand,model,lot,price,status,exactCloseDate,details,bids,sorted) VALUES ('BMW', 'X6','222X6','5800','available', '2015-09-03 07:01:00', '""{"img": "http://avto-russia.ru/autos/bmw/photo/bmw_x6_1280x1024.jpg","modification":"","bodyType": "sedan","lot":"222X6","year":"2006","engineType": "petrol","volume": "3.3","mileage": "21000","transmission": "automatic"}', null,'alphabetically');


INSERT INTO catalog (partType,carBrand,model,title,price,status,details) VALUES ('engines','BMW', 'X6','Engine','400','available', '{"img": "http://f-avto.by/img/detail/157477.jpg","modification": "","bodyType": "sedan","year":"2013","engineType": "petrol","number": "AWT026371","power": "110","volume": "3.3","mileage": "21000","transmission": "automatic"}');

INSERT INTO catalog (partType,carBrand,model,title,price,status,details) VALUES ('engines','BMW', 'X5','Engine','800','available', '{"img": "http://f-avto.by/img/detail/163827.jpg","modification": "","bodyType": "sedan","year":"2013","engineType": "petrol","number": "AWT026371","power": "110","volume": "3.3","mileage": "21000","transmission": "automatic"}');

INSERT INTO catalog (partType,carBrand,model,title,price,status,details) VALUES ('engines','BMW', '6','Engine','440','available', '{"img": "http://f-avto.by/img/detail/158670.jpg","modification": "","bodyType": "sedan","year":"2013","engineType": "petrol","number": "AWT026371","power": "110","volume": "3.3","mileage": "21000","transmission": "automatic"}');

INSERT INTO catalog (partType,carBrand,model,title,price,status,details) VALUES ('engines','Audi', 'A4','Engine','400','available', '{"img": "http://f-avto.by/img/detail/157477.jpg","modification": "","bodyType": "sedan","year":"2013","engineType": "petrol","number": "AWT026371","power": "110","volume": "3.3","mileage": "21000","transmission": "automatic"}');

INSERT INTO catalog (partType,carBrand,model,title,price,status,details) VALUES ('engines','Audi', 'A6','Engine','100','available', '{"img": "http://f-avto.by/img/detail/157477.jpg","modification": "","bodyType": "sedan","year":"2013","engineType": "petrol","number": "AWT026371","power": "110","volume": "3.3","mileage": "21000","transmission": "automatic"}');

INSERT INTO catalog (partType,carBrand,model,title,price,status,details) VALUES ('body-parts','BMW', '6','Door','120','available', '{"img": "http://f-avto.by/img/detail/84940.jpg","modification": "","bodyType": "sedan","year":"2013","engineType": "petrol","number": "AWT026371","power": "110","volume": "3.3","mileage": "21000","transmission": "automatic"}');

INSERT INTO catalog (partType,carBrand,model,title,price,status,details) VALUES ('body-parts','Audi', 'A4','Roof','40','available', '{"img": "http://f-avto.by/img/detail/89881.jpg","modification": "","bodyType": "sedan","year":"2013","engineType": "petrol","number": "AWT026371","power": "110","volume": "3.3","mileage": "21000","transmission": "automatic"}');

INSERT INTO catalog (partType,carBrand,model,title,price,status,details) VALUES ('body-parts','Audi', 'A6','Door','100','available', '{"img": "http://f-avto.by/img/detail/130663.jpg","modification": "","bodyType": "sedan","year":"2013","engineType": "petrol","number": "AWT026371","power": "110","volume": "3.3","mileage": "21000","transmission": "automatic"}');

INSERT INTO catalog (partType,carBrand,model,title,price,status,details) VALUES ('wheels-tires','BMW', '6','Tire','100','available', '{"img": "http://f-avto.by/img/detail/70092.jpg","modification": "","bodyType": "sedan","year":"2013","engineType": "petrol","number": "AWT026371","power": "110","volume": "3.3","mileage": "21000","transmission": "automatic"}');