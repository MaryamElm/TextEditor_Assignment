# TextEditor_Assignment
Background
Bob just got hired as a Java programmer at company ISC. His first work assignment is to implement yet another simple Text Editor in Java that provides the following functions:
1.	Allows users to enter textual information into the editor
2.	Allows users to undo actions performed
3.	Allows users to open pre-written text files
4.	Allows users to invoke a spell check operation to verify the correctness of the words in the text document
Bob’s Implementation
To implement the spell check operation, Bob made use of a file that contains the most commonly used English words listed in alphabetical order. We will refer to this file as the English Words List (EWL). In his program, he performs the following two steps:
1.	Reads the EWL file and stores its words in a Node List structure
2.	For each word in the text, checks if it can be found in the Node List. If it cannot be found, then the word is judged to be incorrectly spelled.
To implement the undo operation, Bob made use of a stack structure to store all user actions. Whenever undo is called, the last user action is popped, examined and its effects are reversed. For instance, if the last user action was adding a letter, the undo operation would delete that same letter.
Current Issues
Bob implemented the program, and to his disappointment, his boss raised the following issues:
1.	The spell check operation is too slow. Most of the time is wasted traversing the Node List to look for entries.
2.	The undo operation should not allow a user to reverse edits indefinitely. Number of allowable “undos” should be limited to 10 in order to limit the amount of previous actions saved in memory.
Bob quickly realized why he is facing these issues:
•	Searching for a word in a Node List is taking too long (worst case: O(n) word comparisons). He needs to make use of a structure and algorithm(s) that allows him to implement a better search mechanism (worst case: O(log2(n)) word comparisons).
•	His stack needs to be implemented in a way where its size does not grow beyond a preset limit. Once the size of the stack reaches this limit, it starts to leak and therefore dropping the oldest entries in the structure. He therefore needs a leaky stack!


**Your Task**

You are hired at ISC as a consultant in charge of helping Bob. You are responsible for the following tasks (after all, they are paying you a hefty salary):

•	Exercise 1 
- Employ an alternative structure to hold the words instead of the Node List (textEditor.core.structures.NodeList). Note that the words are already ordered alphabetically in the EWL file. Your new structure (which we have already seen in class) should allow the search mechanism to be optimized (refer to the HINT  below). In order to succeed at  this task, you have to:
o	Implement the new structure yourself (you cannot use one of the standard java structures). Note that all of the functions defined in its ADT must be implemented. The new structure should be placed in the textEditor.core.structures package.
o	Integrate an optimized search mechanism (O(log2n) complexity) into the new structure. Assume that each word comparison (test) is counted as one primitive operation, regardless of the length of the word.
o	Make sure the structure does not have a static size since other words may later be added to the EWL file. The program should be able to accommodate such updates of the EWL file without changing the implementation.
o	Edit the class textEditor.core.EwlListAdaptor in order to reference the new structure as opposed to the old one.

•	Exercise 2 
- Implement the leaky stack previously discussed using a linked structure. An array based implementation is not acceptable. In order to achieve this task, you need to extend the textEditor.core.structures.AbstractStack abstract class. Place your new class in the textEditor.core.structures package. Also, make sure the textEditor.gui.TextEditorGui class references the new stack instead of the old java.util.Stack.
 HINT: Since the words are already ordered alphabetically in the EWL file, reading them into an array list would allow you to perform a very effective search on the words using one of the algorithms we have seen in class. 

Side note: if you use an AVL tree, the numerous rebalancing will cause the load time (time it takes to load the words into the structure) to be larger than that of the array list implementation, think about it…  
