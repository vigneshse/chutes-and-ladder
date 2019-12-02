
[![Build Status](https://travis-ci.org/vigneshse/chutes-and-ladder.svg?branch=master)](https://travis-ci.org/vigneshse/chutes-and-ladder)

Chutes And Ladder
-----------------

Maven Java application for Chutes and Ladders Game.

## Architecture

![Flow Diagram](https://github.com/vigneshse/chutes-and-ladder/blob/master/Architecture.png)

### Execute Runnable JAR

The runnable JAR of this application could be downloaded from AWS S3 location:

[Download here]( https://vigneshse.s3-us-west-2.amazonaws.com/chutes-and-ladders.jar)

Once downloaded, navigate to ~Downloads and run the following command:

```
    java -jar chutes-and-ladders.jar 
```

### Project Tree

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

#### Two Players
```------------------------------------------------
           WELCOME TO CHUTES AND LADDER!
   -------------------------------------------------
   Enter the name of players in comma-separated values [2 or more]: Eric, Paul
```

#### Four Players
```------------------------------------------------
           WELCOME TO CHUTES AND LADDER!
   -------------------------------------------------
   Enter the name of players in comma-separated values [2 or more]: Eric, Paul, Katy, Carrie
```

Sample output
-------------
#### Two Players
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
GAME OVER!
Wish to play again? [Y / N]:

```

#### Four Players

```
1: Carrie: 0 --> 4 --LADDER--> 14
2: Eric: 0 --> 1 --LADDER--> 38
3: Paul: 0 --> 2
4: Katy: 0 --> 3
5: Carrie: 14 --> 16 --CHUTE--> 6
6: Eric: 38 --> 43
7: Paul: 2 --> 5
8: Katy: 3 --> 6
9: Carrie: 6 --> 9 --LADDER--> 31
10: Eric: 43 --> 47 --CHUTE--> 26
11: Paul: 5 --> 6
12: Katy: 6 --> 9 --LADDER--> 31
13: Carrie: 31 --> 33
14: Eric: 26 --> 30
15: Paul: 6 --> 8
16: Katy: 31 --> 35
17: Carrie: 33 --> 34
18: Eric: 30 --> 32
19: Paul: 8 --> 9 --LADDER--> 31
20: Katy: 35 --> 40
21: Carrie: 34 --> 37
22: Eric: 32 --> 33
23: Paul: 31 --> 35
24: Katy: 40 --> 41
25: Carrie: 37 --> 38
26: Eric: 33 --> 38
27: Paul: 35 --> 37
28: Katy: 41 --> 42
29: Carrie: 38 --> 39
30: Eric: 38 --> 42
31: Paul: 37 --> 43
32: Katy: 42 --> 47 --CHUTE--> 26
33: Carrie: 39 --> 40
34: Eric: 42 --> 44
35: Paul: 43 --> 45
36: Katy: 26 --> 28 --LADDER--> 84
37: Carrie: 40 --> 44
38: Eric: 44 --> 49 --CHUTE--> 11
39: Paul: 45 --> 50
40: Katy: 84 --> 86
41: Carrie: 44 --> 50
42: Eric: 11 --> 15
43: Paul: 50 --> 52
44: Katy: 86 --> 87 --CHUTE--> 24
45: Carrie: 50 --> 56 --CHUTE--> 53
46: Eric: 15 --> 20
47: Paul: 52 --> 54
48: Katy: 24 --> 30
49: Carrie: 53 --> 58
50: Eric: 20 --> 21 --LADDER--> 42
51: Paul: 54 --> 59
52: Katy: 30 --> 31
53: Carrie: 58 --> 62 --CHUTE--> 19
54: Eric: 42 --> 44
55: Paul: 59 --> 62 --CHUTE--> 19
56: Katy: 31 --> 33
57: Carrie: 19 --> 23
58: Eric: 44 --> 45
59: Paul: 19 --> 25
60: Katy: 33 --> 37
61: Carrie: 23 --> 27
62: Eric: 45 --> 46
63: Paul: 25 --> 27
64: Katy: 37 --> 41
65: Carrie: 27 --> 29
66: Eric: 46 --> 50
67: Paul: 27 --> 28 --LADDER--> 84
68: Katy: 41 --> 45
69: Carrie: 29 --> 30
70: Eric: 50 --> 52
71: Paul: 84 --> 89
72: Katy: 45 --> 46
73: Carrie: 30 --> 32
74: Eric: 52 --> 58
75: Paul: 89 --> 93 --CHUTE--> 73
76: Katy: 46 --> 52
77: Carrie: 32 --> 37
78: Eric: 58 --> 59
79: Paul: 73 --> 75
80: Katy: 52 --> 53
81: Carrie: 37 --> 42
82: Eric: 59 --> 60
83: Paul: 75 --> 77
84: Katy: 53 --> 59
85: Carrie: 42 --> 44
86: Eric: 60 --> 61
87: Paul: 77 --> 79
88: Katy: 59 --> 63
89: Carrie: 44 --> 50
90: Eric: 61 --> 67
91: Paul: 79 --> 85
92: Katy: 63 --> 66
93: Carrie: 50 --> 56 --CHUTE--> 53
94: Eric: 67 --> 71 --LADDER--> 91
95: Paul: 85 --> 87 --CHUTE--> 24
96: Katy: 66 --> 71 --LADDER--> 91
97: Carrie: 53 --> 57
98: Eric: 91 --> 93 --CHUTE--> 73
99: Paul: 24 --> 28 --LADDER--> 84
100: Katy: 91 --> 96
101: Carrie: 57 --> 61
102: Eric: 73 --> 74
103: Paul: 84 --> 87 --CHUTE--> 24
104: Katy: 96 --> 100
The winner is Katy
GAME OVER!
Wish to play again? [Y / N]:

```