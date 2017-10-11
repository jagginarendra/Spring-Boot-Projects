package tasks;

import javax.inject.Named;
import javax.inject.Inject;


import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import scala.concurrent.ExecutionContext;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;


public class MyTask {

    private final ActorRef printActor;
    private final ActorSystem actorSystem;
    private final ExecutionContext executionContext;

    @Inject
    public MyTask(@Named("print-actor") ActorRef printActor, ActorSystem system, ExecutionContext executionContext) {

        System.out.println("MyTask Def Constructor");
        this.printActor = printActor;
        this.actorSystem = system;
        this.executionContext = executionContext;
        this.initialize();
    }


    private void initialize() {

         actorSystem.scheduler().schedule(
                Duration.create(0, TimeUnit.SECONDS), // initialDelay
                Duration.create(10, TimeUnit.SECONDS), // interval
                printActor,
                "hello world",
                executionContext,
                ActorRef.noSender()
        );

    }
}
