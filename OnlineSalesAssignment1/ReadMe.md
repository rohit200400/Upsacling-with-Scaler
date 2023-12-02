Assignment Task 1:
Task-1
Simulation of an Event that Follows Given Biasness

Problem Statement: Write a program that accepts a map of all possible outcomes of an event along with their
probabilities and every occurrence of the event would generate outcomes based on the given probabilities.
This could be seen as a generalization of events like rolling of a dice (could be biased) or flipping of a coin
(could be biased).
Examples
Rolling of a six-faced biased dice
Input: [ {1, 10}, {2, 30}, {3, 15}, {4, 15}, {5, 30}, {6, 0} ]
Flipping of a coin
Input [ {“Head”: 35}, {“Tail”: 65} ]
Rules
> > Input: Probabilities given are as integers and percentages.
> > Each occurrence of the event should only generate one of the outcomes given in input
> > The outcome of each occurrence is independent of that of others.
> > On observing a large number (say 1000) of occurrences, the probability distribution should roughly follow the given
> > biasness.
> > Example
> > Input: [ {1: 35}, {2: 65} ]  ## 1=Head, 2=Tail
> > Output:
> > On triggering the event 1000 times, Head appeared 332 times and Tail 668 times which is roughly inline with the
> > biasness given.
> > This is just one of the possibilities.
