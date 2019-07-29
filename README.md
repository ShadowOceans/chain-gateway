# UNIEX Exchange Web Frontend
## Local Test Run
### Preparation
 - Java Runtime
 - Gradle Runtime

### Test Run
Under project's root directory, execute:

```
$ gradle appRun
```

Then gradle will build this project and bring up embeded tomcat8, then run this project in foreground.

THen check the web application at: <http://localhost:8080>

The embeded tomcat8 is brought up by gretty plugin of Gradle, look at __`build.gradle`__ for configuration details and change accordingly.

The default ports are:

 - http: 8080
 - https: 8443

Which were also defined in __`build.gradle`__ file.

### Stop Run
Just press Ctrl-C.
