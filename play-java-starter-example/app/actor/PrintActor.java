package actor;

import akka.actor.*;
import akka.japi.*;
import actor.HelloActorProtocol.*;

public class PrintActor extends AbstractActor {

    public static Props getProps() {
        return Props.create(PrintActor.class);
    }

    public PrintActor(){

        System.out.println("PrintActor()");
    }


       /* public Receive createReceive() {
            return receiveBuilder()
                    .match(HelloActorProtocol.SayHello.class, hello -> {
                        String reply = "Hello, " + hello.name;
                        System.out.println("here");

                        sender().tell(reply, self());
                    })
                    .build();
        }*/

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, s -> {
                    System.out.println("Received String message: {}"+ s);
                })
                .match(HelloActorProtocol.SayHello.class, hello -> {
                    String reply = "Hello, " + hello.name;
                    System.out.println("here");

                    sender().tell(reply, self());
                })
                .build();
    }
}
