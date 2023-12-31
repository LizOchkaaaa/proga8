package com.example.c.Handler;

import com.example.c.Interface.RequestHandlerInterface;
import com.example.c.Worker.ClientWorker;
import org.example.main.*;
import org.example.models.StudyGroup;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.util.ArrayList;

public class RequestHandler implements RequestHandlerInterface {
    private static RequestHandler instance;
    private InetSocketAddress socketAddress;
    private boolean socketStatus;
    private Session session;

    public static RequestHandler getInstance(){
        if(instance == null) instance = new RequestHandler();
        return instance;
    }

    private RequestHandler() {
    }

    public Response send(CommandFactory commandFactory) {
        try {
            Request request = new Request(commandFactory, session);
            ClientWorker clientWorker = new ClientWorker(socketAddress);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(4096);
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(request);
            session.setTypeofSession(TypeOfSession.Login);
            return clientWorker.sendRequest(byteArrayOutputStream.toByteArray());
        }  catch (IOException e) {
            return new Response(TypeOfAnswer.NOTSERIALIZED);
        }
    }

    public Response send(CommandFactory request , StudyGroup studyGroup){
        if(studyGroup != null) {
            request.addStudyGroup(studyGroup);
            return  send(request);
        }
        return new Response(TypeOfAnswer.OBJECTNOTEXIST);
    }

    @Override
    public void setRemoteHostSocketAddress(InetSocketAddress aSocketAddress) {
        socketAddress = aSocketAddress;
    }



    public String getInformation(){
        return "Connection\n" +  "remote host address: " + socketAddress;
    }

    public void setSocketStatus(boolean b) {
        socketStatus = b;
    }

    public boolean getSocketStatus(){
        return socketStatus;
    }

    public void setSession(Session aSession) {
        session = aSession;
    }

    @Override
    public Session getSession() {
        return this.session;
    }

    public Response register(Session aSession) {
        setSession(aSession);
        return send(new CommandFactory(TypeOfCommand.register, new ArrayList<String>()));
    }

    public Response login(Session aSession) {
        setSession(aSession);
        return send(new CommandFactory(TypeOfCommand.login, new ArrayList<String>()));
    }
}
