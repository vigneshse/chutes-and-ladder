
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
1: Paul: 6 --> 11
2: Eric: 0 --> 3
3: Paul: 11 --> 14
4: Eric: 3 --> 9 --LADDER--> 31
5: Paul: 14 --> 19
6: Eric: 31 --> 37
7: Paul: 19 --> 21 --LADDER--> 42
8: Eric: 37 --> 42
9: Paul: 42 --> 47 --CHUTE--> 26
10: Eric: 42 --> 46
11: Paul: 26 --> 27
12: Eric: 46 --> 51 --LADDER--> 67
13: Paul: 27 --> 32
14: Eric: 67 --> 68
15: Paul: 32 --> 36 --LADDER--> 44
16: Eric: 68 --> 74
17: Paul: 44 --> 48
18: Eric: 74 --> 76
19: Paul: 48 --> 54
20: Eric: 76 --> 80 --LADDER--> 100
The winner is Eric