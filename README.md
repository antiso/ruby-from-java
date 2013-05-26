Ruby with native libs from Java
-------------------------------


This sample shows ability to execute Ruby code with native dependencies. It's a Chef client in this case.
 To do so it executes native RVM which executes DRb server code to access required functionality. Then it
 executes DRb client code using JRuby to communicate with native Ruby. Finally, it passes results to Java code.

Preconditions
-------------

You should have following software installed to execute this code:

*   Java
*   Ant
*   JRuby
*   Chef (and Ruby as dependency)

Checkout this repository and edit _ruby-from-java.properties_ to point to your JRuby installation
 and Chef configuration.

Execution
---------

Just enter:

    sva@desert-lt$ ant


Sample output:

    Buildfile: /home/sva/IdeaProjects/ruby-from-java/build.xml

    clean:

    build:
        [javac] /home/sva/IdeaProjects/ruby-from-java/build.xml:19: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds
        [javac] Compiling 1 source file to /home/sva/IdeaProjects/ruby-from-java

    run:
         [java] ScriptEngineManager providers.next(): javax.script.ScriptEngineFactory: Provider com.sun.script.javascript.RhinoScriptEngineFactory not found
         [java] #<DRb::DRbObject:0x33697802 @uri="druby://127.0.0.1:1234", @ref=nil>
         [java] Nodes received from remote Ruby code:
         [java] desert-lt
         [java] precise32
         [java]
         [java] Nodes from Ruby script engine:
         [java] Node: desert-lt
         [java] Node: precise32

    all:

    BUILD SUCCESSFUL
