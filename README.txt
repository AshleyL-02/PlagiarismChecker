Group 29
Emma Chen, Ashley Luty, Joshua Wang

If after looking at this guide you still have some confusion on how to test and run our program, we have provided
example code in the class titled "Main" with comments to help.

Video Link:
VIDEO LINK HERE

Where do I run/test the code?
_____________________________

The class titled "Main" is the best place to run and test our code. The output of our program should appear
within the console.

How do I compare two documents against each other?
__________________________________________________

1. Declare two new variables of type Converter and pass in either a String or Scanner (with a file name)
into them. These two Converter variables represent the document you want to check for plagiarism and the
document you want to check against. You don't need to worry about consistent casing and stray punctuation
(the provided document is converted into lowercase and all extraneous punctuation is removed)

Example: in this scenario, we suspect that Converter c contains a document that has been plagiarised from
the document from Converter d 

	Converter c = new Converter("i love dOGs so, much");
        Converter d = new Converter("I LOVE dogs so much! yay");

2. Every instance of the Converter class has a private Set<String> field called n-grams which can be accessed
by calling the getter method of the Converter class named getNGrams which returns the desired field.

Example:

	Set<String> cNGrams = c.getNGrams();
	Set<String dNGrams = d.getNGrams();

3. Within the Comparer class is where the plagiarism check actually occurs. The class includes a single static
method, thus creating a variable of type Comparer is unecessary. The method compareNGrams does the plagiarism
check by taking in two parameters of type Set<String> that are the n-grams of the documents that are to be
compared. Enter the n-grams of the document that is to be checked for plagiarism before the n-grams of the 
document that the other document is being checked against.

Example: in this scenario, we suspect that Converter c contains a document that has been plagiarised from
the document from Converter d (thus the n-grams for c are written before the n-grams for d)

	int similarityScore = Comparer.compareNGrams(c.getNGrams(), d.getNGrams());

What is the expected output and what does it represent?
_______________________________________________________

The expected output is a categorization of how plagiarized. 