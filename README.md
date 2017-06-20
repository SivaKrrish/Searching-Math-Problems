# Searching-Math-Problems
The user can type one keyword or multiple keywords separated by commas. When the user hits the search button, the search result returns. : Part I. using single keyword - regular part of the project Part II. Supporting multiple keywords 


In this project, I develop a web application to search for math problems and concepts based on the keywords given. In a search field, you can type one or multiple keywords. The search result shows both problems and concepts that match the given keywords.
Technologies I had used:
•	Spring MVC 3 Framework
•	Ajax to access the data at the sever side 
•	JSON
•	I used java configuration file.
•	Retrieving data from properties file 
•	Spring data JPA.
•	Hibernate
Homepage: 
When a user comes to the web application, a search field with a search button is displayed as follows
In this case user can enter only one keyword. If a user enters multiple keywords separated by commas, only take the first one and ignore the remaining keywords. The search result is displayed in a table similar to the one below, with the main difference: using one problem row instead of three problem rows in the picture.

The first column contains the buttons for problems and concepts. When you click the button, the matching items are displayed right below the current row as follows After the + button is pressed, it changes to the - button. When you press the - button, the listed items disappear, and the button is changed back to the + button. The second column of the previous screen provides the number of matched items for that row.
Part 2
When a user enters multiple keywords separated by commas as follows, first it returns partial search result as follows,
In the above partial search result, each keyword is associated with a number that means the number of matched items for this keyword. When you check or uncheck any checkbox, you will get the search result information for the selected keywords as follows
