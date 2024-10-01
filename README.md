# amartha-test

Repository for test automation scripts

Supported Features :

1REST API using rest-assured
2Cucumber

## Prerequisites

* [JDK 11](https://jdk.java.net/11/) or later version
* [Git](https://git-scm.com/downloads)
* [Intellij IDEA](https://www.jetbrains.com/idea/download/)

Optional:

* [Allure](https://docs.qameta.io/allure/#_installing_a_commandline) for reports

## Getting started

1. Clone the test repo, and some prerequisites:

    - make sure you use JDK 11 or above

2Compile the project
    * run `./gradlew clean assemble` in the terminal

## Testing

### Command-line

Use following command-line to execute the test.

    ./gradlew test

or
    
    gradle test

Use following command for spesific class

    ./gradlew test "HomeTest.testHamburgerButton"

This will run the example test suite. Change the config and suiteXmlFile as needed.

### Allure Report

make sure you have allure installed in your machine.

for mac user, you can install allure using brew    
    
    brew install allure

for windows user, you can download allure from 

    https://docs.qameta.io/allure/#_installing_a_commandline

for linux user, you can download allure from
    
    https://docs.qameta.io/allure/#_installing_a_commandline

To generate Allure report, run the following command after finish running the test.:

    allure serve build/allure-results

or to get html file
    
    allure generate build/allure-results --clean && allure open

### Intellij IDEA

* Open `Run > Edit Configurations`
* Pick `Templates > TestNG` from the list
* Add `-Dconfig="config/dev.yaml"` to VM Options

## Helpful Links

* https://www.baeldung.com/install-maven-on-windows-linux-mac
* https://installvirtual.com/how-to-install-openjdk-13-on-mac-using-brew/

## Notes

Feel free to add more stuff as necessary, just try to keep this clean.


[1]: https://projectlombok.org/