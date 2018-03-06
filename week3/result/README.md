See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

Findbugs:     FAILED (5 warnings)
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 7 warnings)

Correctness:  36/41 tests passed
Memory:       1/1 tests passed
Timing:       41/41 tests passed

Aggregate score: 92.68%
[Compilation: 5%, API: 5%, Findbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
3.2K Mar  6 07:21 BruteCollinearPoints.java
2.9K Mar  6 07:21 FastCollinearPoints.java
1.5K Mar  6 07:21 Point.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Point.java
*-----------------------------------------------------------

% javac BruteCollinearPoints.java
*-----------------------------------------------------------

% javac FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Point:

BruteCollinearPoints:

FastCollinearPoints:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% findbugs *.class
*-----------------------------------------------------------
H C RCN_REDUNDANT_NULLCHECK_WOULD_HAVE_BEEN_A_NPE RCN: Checks whether the variable 'points' is null [line 36], even though it can't be null because it was previously dereferenced.  At BruteCollinearPoints.java:[line 35]
L P UPM_UNCALLED_PRIVATE_METHOD UPM: The private method 'printOut()' is never called.  At BruteCollinearPoints.java:[lines 57-60]
L D FE_FLOATING_POINT_EQUALITY FE: Tests for exact floating-point equality. Because floating-point calculations may involve rounding, the calculated values may be imprecise.  At BruteCollinearPoints.java:[line 20]
L P UPM_UNCALLED_PRIVATE_METHOD UPM: The private method 'printOut()' is never called.  At FastCollinearPoints.java:[lines 60-64]
L D FE_FLOATING_POINT_EQUALITY FE: Tests for exact floating-point equality. Because floating-point calculations may involve rounding, the calculated values may be imprecise.  At FastCollinearPoints.java:[line 21]
Warnings generated: 5


================================================================


% pmd .
*-----------------------------------------------------------
BruteCollinearPoints.java:9: The private instance (or static) variable 'lineSegments' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
BruteCollinearPoints.java:56: Avoid unused private methods, such as 'printOut(Point)'. [UnusedPrivateMethod]
FastCollinearPoints.java:9: The private instance (or static) variable 'lineSegments' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
FastCollinearPoints.java:59: Avoid unused private methods, such as 'printOut(Point)'. [UnusedPrivateMethod]
PMD ends with 4 warnings.


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] BruteCollinearPoints.java:12:13: The local variable 'N' must start with a lowercase letter and use camelCase. [LocalVariableName]
[WARN] FastCollinearPoints.java:14:13: The local variable 'N' must start with a lowercase letter and use camelCase. [LocalVariableName]
[WARN] FastCollinearPoints.java:22:25: Control variable 'last' is modified inside loop. [ModifiedControlVariable]
[WARN] Point.java:24:16: The local variable 'X' must start with a lowercase letter and use camelCase. [LocalVariableName]
[WARN] Point.java:25:16: The local variable 'Y' must start with a lowercase letter and use camelCase. [LocalVariableName]
[WARN] Point.java:31:21: Use a 'double' literal instead of a 'float' literal. [Float]
[WARN] Point.java:56:19: The class 'bySlope' must start with an uppercase letter and use CamelCase. [TypeName]
Checkstyle ends with 0 errors and 7 warnings.

% custom checkstyle checks for Point.java
*-----------------------------------------------------------

% custom checkstyle checks for BruteCollinearPoints.java
*-----------------------------------------------------------

% custom checkstyle checks for FastCollinearPoints.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Point
*-----------------------------------------------------------
Running 3 total tests.

Test 1: p.slopeTo(q)
  * positive infinite slope, where p and q have coordinates in [0, 500)
  * positive infinite slope, where p and q have coordinates in [0, 32768)
  * negative infinite slope, where p and q have coordinates in [0, 500)
  * negative infinite slope, where p and q have coordinates in [0, 32768)
  * positive zero     slope, where p and q have coordinates in [0, 500)
  * positive zero     slope, where p and q have coordinates in [0, 32768)
  * symmetric for random points p and q with coordinates in [0, 500)
  * symmetric for random points p and q with coordinates in [0, 32768)
  * transitive for random points p, q, and r with coordinates in [0, 500)
  * transitive for random points p, q, and r with coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 500)
  * slopeTo(), where p and q have coordinates in [0, 32768)
  * slopeTo(), where p and q have coordinates in [0, 10)
  * throw a java.lang.NullPointerException if argument is null
==> passed

Test 2: p.compareTo(q)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p and q have coordinates in [0, 500)
  * antisymmetric, where p and q have coordinates in [0, 32768)
  * transitive, where p, q, and r have coordinates in [0, 500)
  * transitive, where p, q, and r have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 500)
  * sign of compareTo(), where p and q have coordinates in [0, 32768)
  * sign of compareTo(), where p and q have coordinates in [0, 10)
  * throw java.lang.NullPointerException exception if argument is null
==> passed

Test 3: p.slopeOrder().compare(q, r)
  * reflexive, where p and q have coordinates in [0, 500)
  * reflexive, where p and q have coordinates in [0, 32768)
  * antisymmetric, where p, q, and r have coordinates in [0, 500)
  * antisymmetric, where p, q, and r have coordinates in [0, 32768)
  * transitive, where p, q, r, and s have coordinates in [0, 500)
  * transitive, where p, q, r, and s have coordinates in [0, 32768)
  * sign of compare(), where p, q, and r have coordinates in [0, 500)
     -  wrong order: slope-descending instead of slope-ascending
  * sign of compare(), where p, q, and r have coordinates in [0, 32768)
     -  wrong order: slope-descending instead of slope-ascending
  * sign of compare(), where p, q, and r have coordinates in [0, 10)
     -  wrong order: slope-descending instead of slope-ascending
  * throw java.lang.NullPointerException if either argument is null
==> FAILED


Total: 2/3 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference Point and LineSegment)
********************************************************************************

Testing correctness of BruteCollinearPoints
*-----------------------------------------------------------
Running 17 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - no 5 (or more) points are collinear
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
  * filename = horizontal25.txt
==> passed

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
  *  5 random horizontal line segments
  * 10 random horizontal line segments
  * 15 random horizontal line segments
==> passed

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
  * filename = vertical25.txt
==> passed

Test 3b: random vertical line segments
  *  1 random vertical line segment
  *  5 random vertical line segments
  * 10 random vertical line segments
  * 15 random vertical line segments
==> passed

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
==> passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==> passed

Test 5: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==> passed

Test 6: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 7: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 8: random line segments, none vertical or horizontal
  *  1 random line segment
  *  5 random line segments
  * 10 random line segments
  * 15 random line segments
==> passed

Test 9: random line segments
  *  1 random line segment
  *  5 random line segments
  * 10 random line segments
  * 15 random line segments
==> passed

Test 10: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
  * equidistant.txt
==> passed

Test 11: check that data type does not mutate the constructor argument
  * input8.txt
    - data type mutated the points[] array
    - data type should have no side effects unless documented in API

  * equidistant.txt
    - data type mutated the points[] array
    - data type should have no side effects unless documented in API

==> FAILED

Test 12: numberOfSegments() is consistent with segments()
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = horizontal5.txt
  * filename = vertical5.txt
  * filename = random23.txt
==> passed

Test 13: throws an exception if either the constructor argument is null
         or any entry in array is null
  * argument is null
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     0

  * Point[] of length 10, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     10
      2100   679
     26529 26379
     27483 25026
     19513 26845
     13692 31331
     null
      4605 12716
     31826 22917
     29476  4506
     17483 30633

  * Point[] of length 10, number of null entries = 10
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     10
     null
     null
     null
     null
     null
     null
     null
     null
     null
     null

  * Point[] of length 4, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     4
     null
     22481 30667
     17780  2107
      9519 23942

  * Point[] of length 3, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     3
     12174 10335
     null
     19530 10520

  * Point[] of length 2, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     2
     20716 24800
     null

  * Point[] of length 1, number of null entries = 1
    - constructor fails to throw an exception
     1
     null

==> FAILED

Test 14: check that the constructor throws an exception if duplicate points
  * 50 points
  * 25 points
  * 5 points
    - failed on trial 5 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points
     5
      6797  3982
     12637 12989
     12637 12989
      5637  9527
      2256  5330

  * 4 points
    - failed on trial 4 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points
     4
     20656 26414
     20656 26414
     20971 14832
     10855 23564

  * 3 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points
     3
     22996 14755
     22996 14755
     32292 11738

  * 2 points
    - failed on trial 1 of 100
    - constructor fails to throw a java.lang.IllegalArgumentException when passed duplicate points
     2
      4449  8434
      4449  8434

==> FAILED


Total: 14/17 tests passed!


================================================================
Testing correctness of FastCollinearPoints
*-----------------------------------------------------------
Running 21 total tests.

The inputs satisfy the following conditions:
  - no duplicate points
  - all x- and y-coordinates between 0 and 32,767

Test 1: points from a file
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = input299.txt
==> passed

Test 2a: points from a file with horizontal line segments
  * filename = horizontal5.txt
  * filename = horizontal25.txt
  * filename = horizontal50.txt
  * filename = horizontal75.txt
  * filename = horizontal100.txt
==> passed

Test 2b: random horizontal line segments
  *  1 random horizontal line segment
  *  5 random horizontal line segments
  * 10 random horizontal line segments
  * 15 random horizontal line segments
==> passed

Test 3a: points from a file with vertical line segments
  * filename = vertical5.txt
  * filename = vertical25.txt
  * filename = vertical50.txt
  * filename = vertical75.txt
  * filename = vertical100.txt
==> passed

Test 3b: random vertical line segments
  *  1 random vertical line segment
  *  5 random vertical line segments
  * 10 random vertical line segments
  * 15 random vertical line segments
==> passed

Test 4a: points from a file with no line segments
  * filename = random23.txt
  * filename = random38.txt
  * filename = random91.txt
  * filename = random152.txt
==> passed

Test 4b: random points with no line segments
  *  5 random points
  * 10 random points
  * 20 random points
  * 50 random points
==> passed

Test 5a: points from a file with 5 or more on some line segments
  * filename = input9.txt
  * filename = input10.txt
  * filename = input20.txt
  * filename = input50.txt
  * filename = input80.txt
  * filename = input300.txt
  * filename = inarow.txt
==> passed

Test 5b: points from a file with 5 or more on some line segments
  * filename = kw1260.txt
  * filename = rs1423.txt
==> passed

Test 6: points from a file with fewer than 4 points
  * filename = input1.txt
  * filename = input2.txt
  * filename = input3.txt
==> passed

Test 7: check for dependence on either compareTo() or compare()
        returning { -1, +1, 0 } instead of { negative integer,
        positive integer, zero }
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = input299.txt
==> passed

Test 8: check for fragile dependence on return value of toString()
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
==> passed

Test 9: random line segments, none vertical or horizontal
  *  1 random line segment
  *  5 random line segments
  * 25 random line segments
  * 50 random line segments
  * 100 random line segments
==> passed

Test 10: random line segments
  *  1 random line segment
  *  5 random line segments
  * 25 random line segments
  * 50 random line segments
  * 100 random line segments
==> passed

Test 11: random distinct points in a given range
  * 5 random points in a 10-by-10 grid
  * 10 random points in a 10-by-10 grid
  * 50 random points in a 10-by-10 grid
  * 90 random points in a 10-by-10 grid
  * 200 random points in a 50-by-50 grid
==> passed

Test 12: m*n points on an m-by-n grid
  * 3-by-3 grid
  * 4-by-4 grid
  * 5-by-5 grid
  * 10-by-10 grid
  * 20-by-20 grid
  * 5-by-4 grid
  * 6-by-4 grid
  * 10-by-4 grid
  * 15-by-4 grid
  * 25-by-4 grid
==> passed

Test 13: check that data type is immutable by testing whether each method
         returns the same value, regardless of any intervening operations
  * input8.txt
  * equidistant.txt
==> passed

Test 14: check that data type does not mutate the constructor argument
  * input8.txt
  * equidistant.txt
==> passed

Test 15: numberOfSegments() is consistent with segments()
  * filename = input8.txt
  * filename = equidistant.txt
  * filename = input40.txt
  * filename = input48.txt
  * filename = horizontal5.txt
  * filename = vertical5.txt
  * filename = random23.txt
==> passed

Test 16: throws an exception if either constructor argument is null
         or any entry in array is null
  * argument is null
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     0

  * Point[] of length 10, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     10
     null
     30487 17380
     11535  7344
     27554 27751
     30670 13497
     30772  9107
     32406 14945
     29763  3078
     21621 31296
      8176 31143

  * Point[] of length 10, number of null entries = 10
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     10
     null
     null
     null
     null
     null
     null
     null
     null
     null
     null

  * Point[] of length 4, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     4
     30047  5213
     22794 17880
      5654 13668
     null

  * Point[] of length 3, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     3
      8604 23551
     null
     17369 29054

  * Point[] of length 2, number of null entries = 1
    - constructor throws wrong exception
    - constructor throws a java.lang.NullPointerException
    - constructor should throw a java.lang.IllegalArgumentException
     2
     null
     17305 28974

  * Point[] of length 1, number of null entries = 1
    - constructor fails to throw an exception
     1
     null

==> FAILED

Test 17: check that the constructor throws an exception if duplicate points
  * 50 points
  * 25 points
  * 5 points
  * 4 points
  * 3 points
  * 2 points
==> passed


Total: 20/21 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Point
*-----------------------------------------------------------
Running 1 total tests.

The maximum amount of memory per Point object is 32 bytes.

Student memory = 24 bytes (passed)

Total: 1/1 tests passed!

================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing BruteCollinearPoints
*-----------------------------------------------------------
Running 10 total tests.

Test 1a-1e: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    16   0.00         546           0            546                   58         
=> passed    32   0.00        4930           0           4930                  153         
=> passed    64   0.00       41602           0          41602                  369         
=> passed   128   0.01      341250           0         341250                  866         
=> passed   256   0.02     2763266           0        2763266                 1977         
==> 5/5 tests passed

Test 2a-2e: Find collinear points among n/4 arbitrary line segments


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    16   0.00         632           0            632                   58         
=> passed    32   0.00        5213           0           5213                  151         
=> passed    64   0.00       43266           0          43266                  366         
=> passed   128   0.01      347699           0         347699                  862         
=> passed   256   0.03     2789932           0        2789932                 1985         
==> 5/5 tests passed

Total: 10/10 tests passed!


================================================================



Timing FastCollinearPoints
*-----------------------------------------------------------
Running 31 total tests.

Test 1a-1g: Find collinear points among n random distinct points


                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.01        7564       17898          43360                17981         
=> passed   128   0.01       31500       86367         204234                87423         
=> passed   256   0.07      128524      410718         949960               409580         
=> passed   512   0.33      519180     1888595        4296370              1892399         
=> passed  1024   0.45     2086924     8527026       19140976              8530620         
=> passed  2048   1.53     8368140    38005071       84378282             38040061         
==> 6/6 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (84378282 / 19140976) = 2.14
=> passed

==> 7/7 tests passed

Test 2a-2g: Find collinear points among the n points on an n-by-1 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        7564        4566          16696                 6822         
=> passed   128   0.00       31500       17406          66312                22677         
=> passed   256   0.00      128524       67943         264410                79384         
=> passed   512   0.01      519180      267857        1054894               291904         
=> passed  1024   0.04     2086924     1061948        4210820              1111716         
=> passed  2048   0.09     8368140     4225064       16818268              4327337         
=> passed  4096   0.30    33513484    16846869       67207222             17056123         
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (67207222 / 16818268) = 2.00
=> passed

==> 8/8 tests passed

Test 3a-3g: Find collinear points among the n points on an n/4-by-4 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        7564       14386          36336                16311         
=> passed   128   0.00       31500       42920         117340                62781         
=> passed   256   0.01      128524      147881         424286               241925         
=> passed   512   0.03      519180      544828        1608836               938799         
=> passed  1024   0.09     2086924     2081014        6248952              3677724         
=> passed  2048   0.29     8368140     8109673       24587486             14490518         
=> passed  4096   1.27    33513484    31965619       97444722             57411665         
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (97444722 / 24587486) = 1.99
=> passed

==> 8/8 tests passed

Test 4a-4g: Find collinear points among the n points on an n/8-by-8 grid

                                                      slopeTo()
             n    time     slopeTo()   compare()  + 2*compare()        compareTo()
-----------------------------------------------------------------------------------------------
=> passed    64   0.00        7564       17251          42066                18242         
=> passed   128   0.00       31500       74449         180398                83713         
=> passed   256   0.01      128524      229652         587828               336957         
=> passed   512   0.04      519180      849527        2218234              1334403         
=> passed  1024   0.14     2086924     3251178        8589280              5303591         
=> passed  2048   0.46     8368140    12679845       33727830             21141603         
=> passed  4096   1.89    33513484    50004769      133523022             84303859         
==> 7/7 tests passed

lg ratio(slopeTo() + 2*compare()) = lg (133523022 / 33727830) = 1.99
=> passed

==> 8/8 tests passed

Total: 31/31 tests passed!


================================================================