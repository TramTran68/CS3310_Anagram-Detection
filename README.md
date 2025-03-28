# CS 3310 - Anagram Sets Detection

## **Overview**
- This program reads an input file containing multiple words and identifies sets of anagrams. It processes the words efficiently by grouping them based on sorted character keys while maintaining their original case. The output displays the detected anagram groups in a formatted manner.
---

## **Compilation & Running Instructions**
1. Open a terminal or command prompt.
2. Navigate to the directory where Prog2.java is located.
3. Compile the Java file using: javac Prog2.java
4. Execute the compiled Java program with: java Prog2 words.txt
**Note:** Make words.txt is in the same directory.
---

## **Input File Format**
- Each line in words.txt contains a single word.
- The program reads all words and groups them based on their anagram equivalence.

**Example:**
Elvis
lives
silent
listen
enlist
---

## **Expected Output Format**
- The program prints sets of words that are anagrams of each other, preserving their original case.

**Example output:
[Elvis, lives]
[silent, listen, enlist]
---

## **Troubleshooting**
- Error: File not found: Ensure words.txt exists in the same directory.
- ClassNotFoundException: Make sure you compiled the program before running it.

