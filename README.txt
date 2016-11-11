


















							John Vincent
							Assignment 5
					Spell Checker Using  Binary Search Trees 
							Due 11/11/2016


























Problem 
	compare the words of given text file to given dictionary words. then output number of words found correct, number of words not found correct, and the average number of comparisons for both proceeding outputs.

Program Design 
	first set up and initialize an array of  BinarySearchTrees . Second add a Node for  each dictionary word given according to first characters ASCII value into one of the array indexes. Third read a line from given text file , remove non-word characters from the words, and force the line to all lower-case. Finally read and compare individual text file words to stored dictionary words with the same starting character in a loop, while keeping a tally number of comparisons, matches between words, and words without matches. 

Observations
	This code is much more efficient compared to the LinkedList version with average 
comparisons, and run time being a fraction of the assignment 4 code. 

Output
Found: 914193
Not Found: 63149
Average comparisons for word found: 16.35
Average comparisons for word not found: 11.38

run time 3 sec
