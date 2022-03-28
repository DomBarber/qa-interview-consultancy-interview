# <ins>qa-interview</ins>

This take-home task comprises of two aspects: General coding questions, and a language-specific test task depending on your skillset. Do not worry if you don't have the time or knowledge to completely everything, as we are more interested in seeing how you approach the problems, and get a feel for your approach to coding. 

## <ins>General Coding Questions</ins>

Using whichever coding language you feel more comfortable with, please perform one or two of the code challenges below:


Q1: Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”. 
You should expect something like the following: 
```
1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz ...
```


Q2: 
```1, 1, 2, 3, 5, 8, 13 ``` are the first 1-7 numbers of the fibonacci sequence, print out the 35th number (9227465)
eg. Printing out the 7th number will print out 13.


Q3: Write a program that checks to see if every number between 1 and 1000 is both larger than 10 and a palindrome (i.e. "Radar") and outputs the numbers that are.
You should expect something like the following 
```
11, 22, 33, 44, 55, 66, 77, 88, 99, 101...
```

## Language Specific-questions
### <ins>Java</ins>

Inside `src/main/java/taxcalc`, there is a working tax calculator. 

- Refactor the tax calculator to work with best practice whilst still passing the tests specified in the `src/test` folder.
- Suggest any further tests we might want to add to increase our confidence in the calculator. Are there any other areas you would want to focus on to ensure this code remains relevant?

### <ins>JavaScript</ins>


The product owner gave the developers in your team the following specifications to build an application:

-  The homepage has a header "PokéDex!".
-  The text box will only accept alphabetical characters;
   - An error message will be shown reading "Invalid search term" otherwise.
- If a search yields no results, an error message should be shown with "Pokémon not found".
- If a search returns a successful result, a dropdown of valid results should render
- After selecting a result, the user is taken to a results page with:
    - The Pokémon's name
    - A picture of the Pokémon
    - A description or the Pokémon
    - A Table of the following stats:
        - Pokédex number
        - Height
        - Weight
        - Type
        - Held Items(this field will be hidden if empty)
    - The evolution chain of the Pokémon.

The developers created a front-end application pointing to an established API as a first iteration for this. The website is accessible on https://pokesearch-client.herokuapp.com/.

We have listed two different testing options based on your expertise below. You are only required to complete one of them, but feel free to tackle both if you wish.


#### <ins>Front-End Test</ins>
Familiarise yourself with the UI.

- Using a BDD approach, build a small test framework, and then choose & write 3 user acceptance tests focused the application's functionality. 
- Consider the idea that may want to run this particular testing framework outside of the backend development pipeline. Explain how you would approach this, including any tools, frameworks or CI pipelines you would consider using

#### <ins>Integration Testing</ins>
Find out the endpoint from the UI. Familiarise yourself with the endpoint using an application such as Postman.
- Build a small automated framework, writing 3 tests for these endpoints based on the functional requirements given by the product owner, including a test for the error handling if the search term is invalid.
- What other things might you be concerned with testing for this API? Are there any bugs/issues you noticed?

