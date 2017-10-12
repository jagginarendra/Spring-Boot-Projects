package com.example;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import java.util.Date;

public class ApplicationMain {

    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("something");
        ActorRef scheduleActor = system.actorOf(ScheduleActor.props(), "ScheduleActor");
        //for (Long id = 1L; id <= 1L; id++) {
            scheduleActor.tell("Failed", null);
        //}

        // This example app will ping pong 3 times and thereafter terminate the ActorSystem -
        // see counter logic in PingActor
        system.awaitTermination();
    }

}
