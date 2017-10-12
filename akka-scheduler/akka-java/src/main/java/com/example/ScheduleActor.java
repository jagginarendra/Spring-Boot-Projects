package com.example;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.concurrent.duration.Duration;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by anand on 1/14/16.
 */
public class ScheduleActor extends UntypedActor {
    LoggingAdapter log = Logging.getLogger(getContext().system(), this);

    public static Props props() {
        return Props.create(ScheduleActor.class);
    }
	

    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            String status = (String) message;
            //Schedule newMsg = new Schedule(schedule.getId(), new Date());
            System.out.println("scheduler--"+message);
            getContext().system().scheduler().scheduleOnce(Duration.create(5, TimeUnit.SECONDS),() -> 
		    {
                        getSelf().tell("Failed", ActorRef.noSender());
                    }, getContext().system().dispatcher());
        } else {
            unhandled(message);
        }
    }
}
