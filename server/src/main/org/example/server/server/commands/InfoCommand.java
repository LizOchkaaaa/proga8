package main.org.example.server.server.commands;

import main.org.example.interfaces.Execute;
import main.org.example.main.Request;
import main.org.example.main.Response;
import main.org.example.main.TypeOfAnswer;
import main.org.example.server.server.Receiver;


public class InfoCommand extends AbstractCommand implements Execute {
    private final Receiver receiver;
    public InfoCommand(Receiver receiver) {
        super("info", "print information about the collection to the standard output stream (initialization date, number of elements, etc)" , 0 , "" , false , true);
        this.receiver = receiver;
    }

    @Override
    public Response execute(Request request) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size of collection - " + receiver.getMainCollection().size() + "\n");
        stringBuilder.append("Data initialization - " + receiver.getDateOfInitialization() + "\n");
        stringBuilder.append("Data of last change - " + receiver.getDateOfLastChange());
        return new Response(stringBuilder.toString() , TypeOfAnswer.SUCCESSFUL);
    }
}
