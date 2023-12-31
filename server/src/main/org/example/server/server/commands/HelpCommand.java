package main.org.example.server.server.commands;

import main.org.example.server.server.Interfaces.Execute;
import main.org.example.server.server.Receiver;
import org.example.main.Request;
import org.example.main.Response;
import org.example.main.TypeOfAnswer;

import java.util.Collection;

public class HelpCommand extends AbstractCommand implements Execute {
    private final Receiver receiver;
    Collection<AbstractCommand> collectionOfCommands;

    public HelpCommand(Receiver receiver, Collection<AbstractCommand> collectionOfCommands) {
        super("help", "display help on available commands" , 0 , "" , false , true);
        this.receiver = receiver;
        this.collectionOfCommands = collectionOfCommands;
    }

    @Override
    public Response execute(Request request) {
        StringBuilder execution = new StringBuilder();
        for (org.example.interfaces.Execute command : collectionOfCommands) {
            execution.append(command.toString() + "\n");
        }
        execution.delete(execution.toString().length() - 1, execution.toString().length());
        return new Response(execution.toString() , TypeOfAnswer.SUCCESSFUL);
    }
}
