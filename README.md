# Worrell
Worrell is a very early stage command line interface for getting financial 
market data (i.e. quotes) written in Java.  It currently uses the 
[YahooFinance API](http://financequotes-api.com/). 

## Building

### Prereqs
Worrell is a [Maven](https://maven.apache.org/) project.  In order to build 
and run it you must have the following installed.

    * The [Git Source Control Management System](https://git-scm.com/) 
      (included with Github Desktop, Sourcetree, and other Git interfaces)
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
Once you've build the project locate the worrell.jar file inside of the 
"target" directory created by Maven and treat it as an executable Jar.  For the
sake of specificity, let's assume you've cloned and built worrell and that 
you're still in the worrell folder from the command line.  Simply issue the 
following to get a quote for Google.

```Shell
$ java -jar target/worrell.jar quote GOOG
```

