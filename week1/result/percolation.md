See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY

Compilation:  PASSED
API:          PASSED

Findbugs:     FAILED (1 warning)
PMD:          PASSED
Checkstyle:   FAILED (0 errors, 2 warnings)

Correctness:  25/30 tests passed
Memory:       8/8 tests passed
Timing:       19/20 tests passed

Aggregate score: 89.00%
[Compilation: 5%, API: 5%, Findbugs: 0%, PMD: 0%, Checkstyle: 0%, Correctness: 60%, Memory: 10%, Timing: 20%]

ASSESSMENT DETAILS

The following files were submitted:
----------------------------------
2.2K Feb 20 10:05 Percolation.java
2.0K Feb 20 10:05 PercolationStats.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Percolation.java
*-----------------------------------------------------------

% javac PercolationStats.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Percolation:

PercolationStats:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% findbugs *.class
*-----------------------------------------------------------
M P SS_SHOULD_BE_STATIC SS: The instance variable 'CONFIDENCE_95' is final and initialized to a compile-time constant. Should it also be static?  At PercolationStats.java:[line 9]
Warnings generated: 1


================================================================


% pmd .
*-----------------------------------------------------------
PercolationStats.java:6: The private instance (or static) variable 'threshold' can be made 'final'; it is initialized only in the declaration or constructor. [ImmutableField]
PercolationStats.java:7: Can you replace the instance (or static) variable 'size' with a local variable? [SingularField]
PercolationStats.java:9: This instance variable should be turned into a class constant by adding the 'static' modifier. [FinalFieldCouldBeStatic]
PMD ends with 3 warnings.


================================================================


% checkstyle *.java
*-----------------------------------------------------------
[WARN] PercolationStats.java:9:26: The instance variable 'CONFIDENCE_95' must start with a lowercase letter and use camelCase. [MemberName]
Checkstyle ends with 0 errors and 1 warning.

% custom checkstyle checks for Percolation.java
*-----------------------------------------------------------

% custom checkstyle checks for PercolationStats.java
*-----------------------------------------------------------
[WARN] PercolationStats.java:1: The number (0) of calls to 'Integer.parseInt()' must equal the number (2) of integer command-line arguments. [CommandLineArgument]
Checkstyle ends with 0 errors and 1 warning.


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Percolation
*-----------------------------------------------------------
Running 15 total tests.

Tests 1 through 8 create a Percolation object using your code, then repeatedly
open sites by calling open(). After each call to open(), it checks the return
values of isOpen(), percolates(), numberOfOpenSites(), and isFull() in that order.
Except as noted, a site is opened at most once.

Tests 13 through 15 test backwash.

Test 1: open predetermined list of sites using file inputs
  * filename = input6.txt
  * filename = input8.txt
  * filename = input8-no.txt
  * filename = input10-no.txt
  * filename = greeting57.txt
  * filename = heart25.txt
==> passed

Test 2: open random sites until just before system percolates
  * n = 3
  * n = 5
  * n = 10
  * n = 10
  * n = 20
  * n = 20
  * n = 50
  * n = 50
==> passed

Test 3: open predetermined sites for n = 1 and n = 2 (corner case test)
  * filename = input1.txt
    - percolates() returns wrong value after 0 sites opened
    - student   percolates() = true
    - reference percolates() = false

  * filename = input1-no.txt
    - percolates() returns wrong value after 0 sites opened
    - student   percolates() = true
    - reference percolates() = false

  * filename = input2.txt
  * filename = input2-no.txt
==> FAILED

Test 4: check predetermined sites with long percolating path
  * filename = snake13.txt
  * filename = snake101.txt
==> passed

Test 5: open every site
  * filename = input5.txt
==> passed

Test 6: open random sites until just before system percolates,
        allowing open() to be called on a site more than once
  * n = 3
  * n = 5
  * n = 10
  * n = 10
  * n = 20
  * n = 20
  * n = 50
  * n = 50
==> passed

Test 7: call methods with invalid arguments
  * n = 10, (row, col) = (-1, 5)
  * n = 10, (row, col) = (11, 5)
  * n = 10, (row, col) = (0, 5)
  * n = 10, (row, col) = (5, -1)
  * n = 10, (row, col) = (5, 11)
  * n = 10, (row, col) = (5, 0)
  * n = 10, (row, col) = (-2147483648, -2147483648)
  * n = 10, (row, col) = (2147483647, 2147483647)
==> passed

Test 8: call constructor with invalid argument
  * n = -10
  * n = -1
  * n = 0
==> passed

Test 9: create multiple Percolation objects at the same time
        (to make sure you didn't store data in static variables)
==> passed

Test 10: open predetermined list of sites using file inputs,
         but permute the order in which methods are called
  * filename = input8.txt;  order =     isFull(),     isOpen(), percolates()
  * filename = input8.txt;  order =     isFull(), percolates(),     isOpen()
  * filename = input8.txt;  order =     isOpen(),     isFull(), percolates()
  * filename = input8.txt;  order =     isOpen(), percolates(),     isFull()
  * filename = input8.txt;  order = percolates(),     isOpen(),     isFull()
  * filename = input8.txt;  order = percolates(),     isFull(),     isOpen()
==> passed

Test 11: call all methods in random order until just before system percolates
  * n = 3
  * n = 5
  * n = 7
  * n = 10
  * n = 20
  * n = 50
==> passed

Test 12: call all methods in random order until almost all sites are open,
         but with inputs not prone to backwash
  * n = 3
  * n = 5
  * n = 7
  * n = 10
  * n = 20
  * n = 50
==> passed

Test 13: check for backwash with predetermined sites
  * filename = input20.txt
    - isFull() returns wrong value after 231 sites opened
    - student   isFull(18, 1) = true
    - reference isFull(18, 1) = false
  * filename = input10.txt
    - isFull() returns wrong value after 56 sites opened
    - student   isFull(9, 1) = true
    - reference isFull(9, 1) = false
  * filename = input50.txt
    - isFull() returns wrong value after 1412 sites opened
    - student   isFull(22, 28) = true
    - reference isFull(22, 28) = false
  * filename = jerry47.txt
    - isFull() returns wrong value after 1076 sites opened
    - student   isFull(11, 47) = true
    - reference isFull(11, 47) = false
  * filename = sedgewick60.txt
    - isFull() returns wrong value after 1577 sites opened
    - student   isFull(21, 59) = true
    - reference isFull(21, 59) = false
  * filename = wayne98.txt
    - isFull() returns wrong value after 3851 sites opened
    - student   isFull(69, 9) = true
    - reference isFull(69, 9) = false
==> FAILED

Test 14: check for backwash with predetermined sites that have
         multiple percolating paths
  * filename = input3.txt
    - isFull() returns wrong value after 4 sites opened
    - student   isFull(3, 1) = true
    - reference isFull(3, 1) = false
  * filename = input4.txt
    - isFull() returns wrong value after 7 sites opened
    - student   isFull(4, 4) = true
    - reference isFull(4, 4) = false
  * filename = input7.txt
    - isFull() returns wrong value after 12 sites opened
    - student   isFull(6, 1) = true
    - reference isFull(6, 1) = false
==> FAILED

Test 15: call all methods in random order until all sites are open,
         allowing isOpen() to be called on a site more than once
         (these inputs are prone to backwash)
  * n = 3
    - isFull() returns wrong value after 6 sites opened
    - student   isFull(3, 3) = true
    - reference isFull(3, 3) = false
    - failed on trial 2 of 40

  * n = 5
    - isFull() returns wrong value after 14 sites opened
    - student   isFull(4, 1) = true
    - reference isFull(4, 1) = false
    - failed on trial 1 of 20

  * n = 7
    - isFull() returns wrong value after 30 sites opened
    - student   isFull(7, 1) = true
    - reference isFull(7, 1) = false
    - failed on trial 1 of 10

  * n = 10
    - isFull() returns wrong value after 53 sites opened
    - student   isFull(9, 1) = true
    - reference isFull(9, 1) = false
    - failed on trial 1 of 5

  * n = 20
    - isFull() returns wrong value after 236 sites opened
    - student   isFull(18, 11) = true
    - reference isFull(18, 11) = false
    - failed on trial 1 of 2

  * n = 50
    - isFull() returns wrong value after 1561 sites opened
    - student   isFull(31, 8) = true
    - reference isFull(31, 8) = false
    - failed on trial 1 of 1

==> FAILED


Total: 11/15 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference Percolation)
********************************************************************************

Testing correctness of PercolationStats
*-----------------------------------------------------------
Running 15 total tests.

Test 1: check that methods in PercolationStats do not print to standard output
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 2: check that mean() returns value in expected range
  * n =   2, trials = 10000
  * n =   5, trials = 10000
  * n =  10, trials = 10000
  * n =  25, trials = 10000
==> passed

Test 3: check that stddev() returns value in expected range
  * n =   2, trials = 10000
  * n =   5, trials = 10000
  * n =  10, trials = 10000
  * n =  25, trials = 10000
==> passed

Test 4: check that PercolationStats creates trials Percolation objects, each of size n-by-n
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 5: check that PercolationStats calls open() until system percolates
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 6: check that PercolationStats does not call open() after system percolates
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 7: check that mean() is consistent with the number of intercepted calls to open()
        on blocked sites
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 8: check that stddev() is consistent with the number of intercepted calls to open()
        on blocked sites
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 9: check that confidenceLo() and confidenceHigh() are consistent with mean() and stddev()
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 10: check that exception is thrown if either n or trials is out of bounds
  * n = -23, trials =  42
  * n =  23, trials =   0
    - fails to throw an exception when calling constructor with invalid arguments

  * n = -42, trials =   0
  * n =  42, trials =  -1
  * n = -2147483648, trials = -2147483648
==> FAILED

Test 11: create two PercolationStats objects at the same time and check mean()
         (to make sure you didn't store data in static variables)
  * n1 =  50, trials1 =  10, n2 =  50, trials2 =   5
  * n1 =  50, trials1 =   5, n2 =  50, trials2 =  10
  * n1 =  50, trials1 =  10, n2 =  25, trials2 =  10
  * n1 =  25, trials1 =  10, n2 =  50, trials2 =  10
  * n1 =  50, trials1 =  10, n2 =  15, trials2 = 100
  * n1 =  15, trials1 = 100, n2 =  50, trials2 =  10
==> passed

Test 12: check that the methods return the same value, regardless of
         the order in which they are called
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 13: check that no calls to StdRandom.setSeed()
  * n = 20, trials = 10
  * n = 20, trials = 10
  * n = 40, trials = 10
  * n = 80, trials = 10
==> passed

Test 14: check distribution of number of sites opened until percolation
  * n = 2, trials = 100000
  * n = 3, trials = 100000
  * n = 4, trials = 100000
==> passed

Test 15: check that each site is opened the expected number of times
  * n = 2, trials = 100000
  * n = 3, trials = 100000
  * n = 4, trials = 100000
==> passed


Total: 14/15 tests passed!


================================================================
********************************************************************************
*  MEMORY (substituting reference Percolation)
********************************************************************************

Analyzing memory of PercolationStats
*-----------------------------------------------------------
Running 4 total tests.

Test 1a-1d: check memory usage as a function of T trials for n = 100
            (max allowed: 8*T + 128 bytes)

                 T        bytes
--------------------------------------------
=> passed       16          192         
=> passed       32          320         
=> passed       64          576         
=> passed      128         1088         
==> 4/4 tests passed


Estimated student memory = 8.00 T + 64.00   (R^2 = 1.000)

Total: 4/4 tests passed!

================================================================



********************************************************************************
*  TIMING (substituting reference Percolation)
********************************************************************************

Timing PercolationStats
*-----------------------------------------------------------
Running 4 total tests.

Test 1: count calls to StdStats.mean() and StdStats.stddev()
  * n =  20, trials =  10
    - calls StdStats.mean() the wrong number of times
    - number of student   calls to StdStats.mean() = 3
    - number of reference calls to StdStats.mean() = 1

    - calls StdStats.stddev() the wrong number of times
    - number of student   calls to StdStats.stddev() = 3
    - number of reference calls to StdStats.stddev() = 1

  * n =  50, trials =  20
    - calls StdStats.mean() the wrong number of times
    - number of student   calls to StdStats.mean() = 3
    - number of reference calls to StdStats.mean() = 1

    - calls StdStats.stddev() the wrong number of times
    - number of student   calls to StdStats.stddev() = 3
    - number of reference calls to StdStats.stddev() = 1

  * n = 100, trials =  50
    - calls StdStats.mean() the wrong number of times
    - number of student   calls to StdStats.mean() = 3
    - number of reference calls to StdStats.mean() = 1

    - calls StdStats.stddev() the wrong number of times
    - number of student   calls to StdStats.stddev() = 3
    - number of reference calls to StdStats.stddev() = 1

  * n =  64, trials = 150
    - calls StdStats.mean() the wrong number of times
    - number of student   calls to StdStats.mean() = 3
    - number of reference calls to StdStats.mean() = 1

    - calls StdStats.stddev() the wrong number of times
    - number of student   calls to StdStats.stddev() = 3
    - number of reference calls to StdStats.stddev() = 1

==> FAILED

Test 2: count calls to methods in StdRandom
  * n = 20, trials = 10
  * n = 20, trials = 10
  * n = 40, trials = 10
  * n = 80, trials = 10
==> passed

Test 3: count calls to methods in Percolation
  * n =  20, trials =  10
  * n =  50, trials =  20
  * n = 100, trials =  50
  * n =  64, trials = 150
==> passed

Test 4: Call PercolationStats methods with trials = 3 and values of n that go up
        by a factor of sqrt(2). The test passes when n reaches 2,896.

     The approximate order-of-growth is n ^ (log ratio)

         n  seconds log ratio
     ------------------------
       724     0.23       2.4
      1024     0.56       2.6
      1448     1.47       2.8
      2048     3.56       2.5
      2896     9.51       2.8
==> passed


Total: 3/4 tests passed!


================================================================



********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Percolation
*-----------------------------------------------------------
Running 4 total tests.

Test 1a-1d: check that total memory <= 17 n^2 + 128 n + 1024 bytes

                 n        bytes
--------------------------------------------
=> passed       64        37032         
=> passed      256       589992         
=> passed      512      2359464         
=> passed     1024      9437352         
==> 4/4 tests passed


Estimated student memory = 9.00 n^2 + 0.00 n + 168.00   (R^2 = 1.000)


Test 2 (bonus): check that total memory <= 11 n^2 + 128 n + 1024 bytes
   -  bonus available only if solution passes backwash correctness test
==> FAILED


Total: 4/4 tests passed!

================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing Percolation
*-----------------------------------------------------------
Running 16 total tests.

Test 1a-1e: Creates an n-by-n percolation system; open sites at random until
            the system percolates, interleaving calls to percolates() and open().
            Count calls to connected(), union() and find().

                                       2 * connected()
                 n       union()              + find()        constructor
-----------------------------------------------------------------------------------
=> passed       16          211                   312                   1         
=> passed       32          676                  1144                   1         
=> passed       64         3170                  5048                   1         
=> passed      128        10555                 18424                   1         
=> passed      256        46360                 77672                   1         
=> passed      512       182960                309370                   1         
=> passed     1024       745038               1248088                   1         
==> 7/7 tests passed


If one of the values in the table violates the performance limits
the factor by which you failed the test appears in parentheses.
For example, (9.6x) in the union() column indicates that it uses
9.6x too many calls.


Tests 2a-2f: Check whether the number of calls to union(), connected(), and find()
             is a constant per call to open(), isOpen(), isFull(), and percolates().
             The table shows the maximum number of union(), connected(), and
             find() calls made during a single call to open(), isOpen(), isFull(),
             and percolates().

                 n     per open()      per isOpen()    per isFull()    per percolates() 
---------------------------------------------------------------------------------------------
=> passed       16        4               0               1               1         
=> passed       32        4               0               1               1         
=> passed       64        4               0               1               1         
=> passed      128        4               0               1               1         
=> passed      256        4               0               1               1         
=> passed      512        4               0               1               1         
=> passed     1024        4               0               1               1         
==> 7/7 tests passed



Running time (in seconds) depends on the machine on which the script runs.


Test 3: Create an n-by-n percolation system; interleave calls to percolates()
        and open() until the system percolates. The values of n go up by a
        factor of sqrt(2). The test is passed if n >= 4096 in under 10 seconds.

     The approximate order-of-growth is n ^ (log ratio)

                        log   union-find     log
         n  seconds   ratio   operations   ratio
     -------------------------------------------
      1024     0.13     2.4      2702496     2.0
      1448     0.33     2.6      5490808     2.0
      2048     0.76     2.4     10827498     2.0
      2896     2.19     3.1     21777186     2.0
      4096     5.98     2.9     43525126     2.0
==> passed



Test 4: Create an n-by-n percolation system; interleave calls to open(),
        percolates(), isOpen(), isFull(), and numberOfOpenSites() until.
        the system percolates. The values of n go up by a factor of sqrt(2).
        The test is passed if n >= 4096 in under 10 seconds.

                        log   union-find     log
         n  seconds   ratio   operations   ratio
     -------------------------------------------
      1024     0.12     1.9      2716918     2.0
      1448     0.31     2.8      5394846     2.0
      2048     0.82     2.8     10925926     2.0
      2896     2.16     2.8     21695272     2.0
      4096     5.45     2.7     43517898     2.0
==> passed


Total: 16/16 tests passed!


================================================================


