# Worrell
Worrell is a very early stage command line interface for getting financial 
market data (i.e. quotes) written in Java.  It currently uses the 
[YahooFinance API](http://financequotes-api.com/). 

## Building

### Prereqs
Worrell is a [Maven](https://maven.apache.org/) project.  In order to build 
and run it you must have the following installed.

  * The [Git Source Control Management System](https://git-scm.com/) (included with Github Desktop, Sourcetree, and other Git interfaces)
  * The [Java 8 Development Kit](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
  * [Apache's Maven build tool for Java](https://maven.apache.org/)

### Build Steps
Assuming you have all of the prereqs installed simply issue the following at 
the command line.

```Shell
$ git clone https://github.com/mpatkisson/worrell.git
$ cd worrell
$ mvn install
```

In order, these commands will 

  1. Clone the worrell Git repo into a folder called "worrell"
  2. Change your working directory to the newly created "worrell" folder
  3. Build worrell and place the build artifacts in subfolder called "target"

## Running
Once you've built the project issue the following to see worrell print a few
default quotes.

```Shell
$ java -jar target/worrell.jar
^GSPC: 2055.01, bid: 2047.12, ask: 2060.15
^IXIC: 4846.62, bid: 0, ask: 0
```

### The .worrellrc File
Worrell looks for a file called .worrellrc in your home directory.  
Worrell reads this file for instructions on what securities to quote and which
service should be used to for market data (Yahoo Finance, IB, etc.). If the 
.worrellrc file is not found it will be placed there automatically the first 
time worrell is run.  Yahoo Finance is the default quote service and both the
S&P and NASDAQ indices are quoted.  This file can be edited by hand to change
any of the default values.

### Printing Adhoc Quotes
You can print the quote of any symbol the quote service specified in the 
.worrellrc file can handle simply by issuing it at the command line as the 
argument of worrell's "quote" command.

```Shell
$ java -jar target/worrell.jar quote goog
GOOG: 744.77, bid: 743.75, ask: 744.40
```

The quote command also supports multiple securities separated by commas.

```Shell
$ java -jar target/worrell.jar quote goog,rht,ibm,amzn,fb
GOOG: 744.77, bid: 743.75, ask: 744.40
IBM: 149.33, bid: 148.83, ask: 149.76
RHT: 73.49, bid: 70.25, ask: 73.72
AMZN: 593.86, bid: 591.30, ask: 592.49
FB: 116.14, bid: 116.11, ask: 116.15
```

### Helpful (and Experimental) Run Scripts
The target directory created by Maven includes a subdirectory called "dist" 
with very, very simple scripts which allow prevent you from having to invoke 
worrell via Java.  Use of these scripts will allow you to type `wrl` instead 
of `java -jar worrell.jar`
