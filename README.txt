Group 29
Emma Chen, Ashley Luty, Joshua Wang

VIDEO LINK HERE:
https://www.youtube.com/watch?v=jNeDD0wQQ24&feature=youtu.be

Restrictions and Disclaimer
_______________________________

THE PROVIDED DOCUMENTS MUST BE AT LEAST FOUR WORDS (OR TOKENS) LONG. 

You may see a much larger percentage of error on small documents than for larger documents. Just as a reminder, the n-grams technique we
used here is NOT exactly perfect in calculating how much one document has plagiarized from another.

Set-Up
_______________________________

In the document titled "Github Link" there is a link that takes you to our public github repository. Download everything within the src 
folder of our github page and create a new project in whatever IDE you choose. Then put everything that you downloaded from our github 
and put it into the src folder of that new project.

Running/Testing the Program
_______________________________

There are two ways to run our program. One is using the UI, which is easier to use, but lacks the full funtionality of our program. 
We recommend directly testing our code through the class titled Main where example code can also be found.

ALL SIMILARITY PERCENTAGES ARE BASED OUT OF THE DOCUMENT THAT IS BEING SUSPECTED OF PLAGIARISM. 

Example:
	if the document suspected of plagiarism was "i love dogs so much" and the other document we are going to compare that document to 
	was "hey, i love dogs so much, you know?" then the exact similarity between the two documents is 100% because it is out of the 
	document that is "i love dogs so much." However, if you flip the roles of the document so that the document "hey i love dogs so much,
	you know?" was suspected of plagiarism and we checked it against the document "i love dogs so much," then the exact similarity would
	be 50%.

User Interface
______________

To run the user interface, you need to run the class titled PlagiarismChecker. Once that class is run, you should see a window pop up that
has two text boxes next to each other and the score labels at the bottom of the screen. The text box on the left is where you paste the 
document that you suspect has been plagiarized from another. The text box on the right is where you paste the document that you suspect 
the document on the left has plagiarized off of. Once you have done that, click the "Check" button at the bottom middle of the window
and the scores should show up at the below the button.

At the bottom of the screen, there are two score categories: exact score and exact + synonym score. The exact score is how much of the 
document on the left (suspected of plagiarism) has exactly plagiarized (copied directly) off of the document on the right 
(plagiarized off of). The exact + synonym score is essentially the same as the exact score, but includes a check for synonyms. 
Both are percentages.

Main
______________

The Main requires a lot more set up compared to the user interface, but it has a fuller functionality. We have provided example code with
the Main class already which can be deleted or modified to test our code.

The first step necessary which we have provided for you is to set up the "thesaurus" that will be used to check for synonyms between the 
two documents. Because the SynonymMap is comprised of mostly static fields and methods, this call is only needed once.

Example:
	SynonymMap.setupMap();

The second step is to call the Converter class, which is a class that converts a provided document (either a String or Scanner) into n-grams
of four. You either need to provide a String representation of the document or a Scanner for a File. You do not need to worry about the
presence of extraneous puntuation or consistent casing because the contrustor will take care of that. This step prepares before the document
comparison.

Example:
	//demonstrates how to create a Converter instance using Strings
     	Converter c = new Converter("i love dOGs so, Much");
        Converter d = new Converter("I LOVE dogs So& much! Cats are PretTY! great ToO");
	
	//demonstrates how to create a Converter instance using a Scanner with a File
        Converter e = new Converter(new Scanner(new File("hello.txt")));

The Converter class also provides a method called getNGrams which you call on an instance of the Converter class to get a Set<String> of
n-grams for the document of that Converter object.

Example:
        Set<String> cNGrams = c.getNGrams();
        Set<String> dNGrams = d.getNGrams();

The third step is where the actual comparison happens and our program does this through instantiating a class called Comparer. The Comparer
class takes in two Converters of the two documents that are up for comparison. The Converter of the document that you suspect of plagiarism
is the first parameter the Comparer constructor takes in and the Converter of the document that you suspect the other document has 
plagiarized off of is the second parameter.

Example: 
	//we suspect that the document of Converter c has plagiarized off of the document of Converter d, therefore, Converter c is
	//written before Converter d (when inputting the parameters)
	Comparer compareCD = new Comparer(c, d);

The fourth step, after a Comparer has been instantiated for the documents that are up for comparison, you can call two 
methods to get a score that will represent how much the first provided document has plagiarized off of the second provided document. 
The first method you can call on the Comparer object is called getExactScore which will return a percentage of how much of the first 
document is plagiarized off of the second document (directly copied, does not include synonyms). The second method you can call is called
getSynonymExactScoreMessage which will display a categorization that represents how much of the first document is plagiarized off of the 
second document when including both synonyms and copied portions of text. The categorization is based off of a synonym similarity score
percentage and a exact similarity score percentage however, due to some margin of error when applying the n-grams technique with synonyms,
we have decided to provide the synonym similarity score with an APPROXIMATE categorization of the amount plagiarized (this is explained more
in detail in our design document).

Example:
	//exact score
        System.out.println("The exact similarity score of document c and document d is " +
                            compareCD.getExactScore() + "%");
	//synonym score
        System.out.println(compareCD.getSynonymExactScoreMessage()); 

  
