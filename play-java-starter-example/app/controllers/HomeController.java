package controllers;

import akka.actor.ActorRef;
import play.mvc.*;

import akka.actor.*;
import play.mvc.*;
import scala.compat.java8.FutureConverters;
import javax.inject.*;
import java.util.concurrent.CompletionStage;
import actor.*;

import views.html.*;


import static akka.pattern.Patterns.ask;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    final ActorRef printActor;




    @Inject public HomeController(ActorSystem system) {
        printActor = system.actorOf(PrintActor.getProps());
    }


    public CompletionStage<Result> sayHello(String name) {
        return FutureConverters.toJava(ask(printActor, new HelloActorProtocol.SayHello(name), 1000))
                .thenApply(response -> ok((String) response));
    }


    public Result index() {
        return ok(index.render("Your new application is ready."));
    }



}
