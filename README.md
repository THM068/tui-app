tui-app
=======

Assumptions:
  I created two users at the application startup. 
     username: gonzo pwd: bear
     username: kermit pwd: frog
     
  When you are asked to login use any of the two  above users.
  
  
  1. I used the httpbuilder library to call the Flickr webservice because it is a simple library to manipulate http 
  based resources plus it has common tasks such as building and parsing common content-types built into it.
  
  2. I used springsecurity as the main authentication system. As the requirements required a user to keep a reference to an image
  .I decided to create a user that could be authenticated and the images selected will be associated with that user.
  
  3. I used spock for testing. It provides an intuitive way of testing.
  
  4. For the search functionality I created a groovy bean called ImageSearch. There are setter methods used to add constraints to
  the search e.g imagesPerPage etc. Made it a groovy bean so that it is not tied to this application, I can use the bean in a stand alone 
  application.
  
  5. When you make a search, you specify the search term and the number of images to return. 
  
  6. After making a search, an export result button is displayed. This button exports the search results as xml. 
     When I make a search, I save the results to a session object. This enables me to have a reference to the search results
     when I am exporting them.
  
  7. Also after making a search, there is an add favourite link below the image. The link contains information about the 
   image e,g title, url. When you click the add to favourite , the attribute values of that link are saved to the database
   and their associated with that user. If the user is not logged in, the login dialog box is displayed. The graybox that holds
   the 'Add to favourites' link turns blue when a image is save successfully.
   

   
  
