# AndroidApp

Deze applicatie is een GUI voor een REST service. Deze service houd een stocklijst bij van mijn electronika labo in een online database.

Documentatie over de REST service is te vinden via volgende link.
http://boutsman.be/AndroidApp/RESTInventaris.php

Functies
•	Send: Deze neemt de tekst uit het EditText venster en drukt het af in een nieuw textview. Deze functie 	toont aan hoe er gewerkt moet worden met intents en hoe hiermee informatie wordt doorgegeven.
•	Show DB: vraagt de hele database op en verwerkt de JSON-array die ontvangen wordt.
	o	In de taakbalk van de bijhorende view zijn 2 extra functies: 1 die het scherm ververst en 1 die de 		gebruiker naar de “Search Item”-functie leidt.
•	Search Item: Met deze functie is het mogelijk om in de database te zoeken. Het item waarmee het id overeen 	stemt wordt opgeroepen. Als extra functionaliteit is hier de mogelijkheid toegevoegd om het item te 	verwijderen.
•	Subtract: Laat toe om het aantal stuks dat uit de opslagruimte genomen wordt af te trekken van het aantal 	stuks dat op dat moment in stock is, en daarna de database te updaten.
•	Edit: Laat toe om op id een item op te roepen en alle velden aan te passen.
•	AddItem: Laat toe om een nieuw record toe te voegen aan de database. Het id kan niet zelf gekozen worden, 	dit is een unieke waarde die door de database zelf wordt toegewezen.
