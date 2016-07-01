# K17TheMovieDb
The app has mainly 3 activities.
	-MainActivity
	-ActualMainActivity(Displays the list of all movies)
	-SecondActivity(Displays the details of the movie)

	The MainActivity checks for internet connection. If there is no internet connection a dialog box is diplayed that enables us to exit or refresh the app. The .setCancellable() is set to false so that the dialog cannot be cancelled by the press of back button.

 	There is a BackgroundDownloader.java which extends AsyncTask which runs in the background and retrieves the json string from the internet. Only the id of he mov The MainActivity executes this and the result of json strings is passed to ActualMainActivity.

	The noHistory of MainActivity is set to true in manifest so that MainActivity is not called when pressed back from ActualMainActivity

	I have created a CustomAdapter that creates a row for each movie entry. The images are loaded using Glide. OnClicking the custom adapter the SecondActivity is started.
	
	The SecondActivity just gets the intent and displays the parsed information.

	I AM NOT USING 3RD PARTY LIBRARIES FOR GETTING DATA FROM THEMOVIEDB. IF THE LIBRARY IS USED EVEN JSON PARSING IS NOT NEEDED.
