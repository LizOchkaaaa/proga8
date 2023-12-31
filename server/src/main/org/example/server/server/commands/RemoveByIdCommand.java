package main.org.example.server.server.commands;


import main.org.example.server.server.Receiver;
import org.example.interfaces.Execute;
import org.example.main.Request;
import org.example.main.Response;

public class RemoveByIdCommand extends AbstractCommand implements Execute {
    private final Receiver receiver;

    public RemoveByIdCommand(Receiver receiver) {
        super("remove_by_id", "remove element from collection by its id", 1 , "id", false , true);
        this.receiver = receiver;

    }

    @Override
    public Response execute(Request request) {
        String username = request.getSession().getName();
        int id = Integer.parseInt(request.getCommand().getArg());
        return new Response(receiver.removeById(username, id));
    }
}
