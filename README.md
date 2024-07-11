👋 Hi there! Just a few words about what to expect to see in this project

* This application will fetch top 100 stations for radio.net api
* It will display them through a recycler view, it will show name of station, country and if available, a concatenation of genres in the same line, and topics in a third one
* By the way, the app should show an image for each station, but fetching the logo300x300 or logo100x100 through coil library is failing, I tried the url on a browser too, the request is also failing and there seems to be a problem on the backend side
* The application will handle error cases: 
  * 1- if there is no connection, or immediate error after starting the app, the error will be displayed in a text view with a retry button
  * 2- if the response was empty, empty data msg will be shown in the same place with a retry button
  * 3- if there were already some data displayed previously (like the case of losing internet connection while the app is running), then only a toast message will be displayed, without losing already existing list
  * 4- same previous implementation can be useful also when implementation caching later (because data could be fetched from local cache, and then only a toast msg will be enough for errors)
* In addition, the project contains unit testing for both view model, and repository with some useful test cases
* On general, I made sure to apply best practices for a performant app with a good UI/UX. Also, I made sure to implement a clean solution with a modern architecture
* TODO: 1- implement details screen when used click an item of the list, by creating a fragment that shows the details.
* TODO: 2- add ROOM database to cache station information, app will then display cached version by default, and only make an api request on a new run, and update the cache, or when user try to refresh.