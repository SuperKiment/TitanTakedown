# TitanTakedown
The version 2 of _OpenMonsterHunter_

I'm leaving **Processing** as a graphics library. I'm going for **LWJGL** for the OpenGL access.
Also I prefer having full control over the server. I was struggling with the interface in the tests..

Look forward to it ! I'm currently rebuilding everything I made in the old one...

# Build
I ran a Gradle 8.7 with a JDK 21.

Use `./gradlew build`

In each source folder 'client', 'server' and 'common', a 'build' should have appeared

# Run
Run the command 

`gradle client:run` for the client

`gradle server:run` for the server
