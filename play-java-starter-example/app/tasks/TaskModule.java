package tasks;

import com.google.inject.AbstractModule;
import play.libs.akka.AkkaGuiceSupport;
import actor.PrintActor;

public class TaskModule extends AbstractModule implements AkkaGuiceSupport{

    protected void configure(){

        bind(MyTask.class).asEagerSingleton();
        bindActor(PrintActor.class, "print-actor");
    }
}
