package main.org.example.server.server.commands;

import main.org.example.interfaces.Execute;
import main.org.example.main.Request;
import main.org.example.main.Response;
import main.org.example.main.TypeOfAnswer;
import main.org.example.server.server.Receiver;

public class LoginUserCommand  extends AbstractCommand implements Execute {
    private Receiver receiver;

    public LoginUserCommand(Receiver receiver) {
        super("add_new_user_to_system", "add new user to system", 2, "login , password", true, true);
        this.receiver = receiver;
    }
    @Override
    public Response execute(Request aRequest) {
        String username = aRequest.getSession().getName();
        String password = aRequest.getSession().getPassword();
        return receiver.loginUser(username, password)
                ? new Response(TypeOfAnswer.SUCCESSFUL)
                : new Response(TypeOfAnswer.NOTMATCH);
    }
}
