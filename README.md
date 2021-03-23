# FDM-HSBCJavaTest

## Location.java

This class file describes an object containing information about locations included in the JSON file, ignoring any data which relates only to the location's weather. This object is used in Runner.java, which analyses the JSON itself.

## Runner.java

### Main method

This class file, when run, will analyse the JSON and output the results to a file. The filename variable, which points to the desired location of your log file, can be changed to suit your system. Currently, it points to this git directory's location on my system.

### WriteFile Method

A generic method for appending data to a file at a given location; in this case the names_log.txt logfile.

### ReadLocationsFromJson Method

Accepts a URL as an argument, then reads the JSON file at the URL, extracts the list of locations and associated weather data, and returns a list of locations (without weather data).

### GetLocationsBeginningWithT Method

Extracts the name of each location in the list obtained using the readLocationsFromJson method above, and identifies any names where the first character is 'T' or 't'. These names are then written to the log file, followed by the total number of names.
