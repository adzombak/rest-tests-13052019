# rest-tests-13052019
Steps to implement Serenity tooling into the project:
1) Add dependencies for 'serenity-rest-assured' and 'serenity-junit. Remove dependancy for Rest-assured library
2) Add dependancy 'slf4j-simple' for logging
3) POM file enhancement with 'serenity-maven-plugin' to have reports aggregated from test results
4) @Step annotation added to EndPoint classes
5) Add @RunWith and @Steps annotation to classes with tests and run them
6) check if file 'index.html' is in added to project folder\\IdeaProjects\rest-tests-13052019\target\site\serenity and open this report in browser
