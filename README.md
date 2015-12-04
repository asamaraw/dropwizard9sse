# dropwizard9sse
Jersey server sent events implementation using Dropwizard 9

Execute ./gradlew clean run

Open two terminals and run 
curl localhost:8081/sse -H"Accept: text/event-stream"

Open third terminal and run 
curl localhost:8081/publish?msg=HelloWorld

Observe output on first two termina
