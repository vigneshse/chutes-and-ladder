
[![Build Status](https://travis-ci.org/vigneshse/chutes-and-ladder.svg?branch=master)](https://travis-ci.org/vigneshse/chutes-and-ladder)

Chutes And Ladder
-----------------

Maven Java application for Chutes and Ladders Game.

### Prerequisites

Below pre-requisites are needed to run the application:

```
 JVM
```

## Project Tree

Below is the package structure:
```
.
├── README.md
├── chutes-and-ladders.iml
├── pom.xml
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── game
    │   │           └── assignment
    │   │               ├── Board.java
    │   │               ├── ChutesAndLadders.java
    │   │               ├── Game.java
    │   │               ├── LeaderBoard.java
    │   │               ├── Player.java
    │   │               └── Spinner.java
    │   └── resources
    └── test
        └── java
            └── com
                └── game
                    └── assignment
                        └── SpinnerTest.java
```

Sample Input
------------
Enter Player Names in the main method of ```ChutesAndLadders.java```:

```Game game = new Game(new String[]{"Eric", "Paul"});```

Sample output
-------------
```
1: Eric: 0 --> 6
2: Paul: 0 --> 5
3: Eric: 6 --> 8
4: Paul: 5 --> 6
5: Eric: 8 --> 11
6: Paul: 6 --> 7
7: Eric: 11 --> 14
8: Paul: 7 --> 13
9: Eric: 14 --> 18
10: Paul: 13 --> 15
11: Eric: 18 --> 21 --LADDER--> 42
12: Paul: 15 --> 21 --LADDER--> 42
13: Eric: 42 --> 48
14: Paul: 42 --> 44
15: Eric: 48 --> 52
16: Paul: 44 --> 50
17: Eric: 52 --> 55
18: Paul: 50 --> 56 --CHUTE--> 53
19: Eric: 55 --> 59
20: Paul: 53 --> 55
21: Eric: 59 --> 61
22: Paul: 55 --> 57
23: Eric: 61 --> 64 --CHUTE--> 60
24: Paul: 57 --> 62 --CHUTE--> 19
25: Eric: 60 --> 66
26: Paul: 19 --> 22
27: Eric: 66 --> 71 --LADDER--> 91
28: Paul: 22 --> 25
29: Eric: 91 --> 93 --CHUTE--> 73
30: Paul: 25 --> 27
31: Eric: 73 --> 79
32: Paul: 27 --> 32
33: Eric: 79 --> 83
34: Paul: 32 --> 35
35: Eric: 83 --> 88
36: Paul: 35 --> 38
37: Eric: 88 --> 93 --CHUTE--> 73
38: Paul: 38 --> 42
39: Eric: 73 --> 74
40: Paul: 42 --> 48
41: Eric: 74 --> 77
42: Paul: 48 --> 52
43: Eric: 77 --> 79
44: Paul: 52 --> 54
45: Eric: 79 --> 80 --LADDER--> 100
The winner is Eric