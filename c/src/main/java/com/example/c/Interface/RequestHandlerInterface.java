package com.example.c.Interface;

import org.example.main.CommandFactory;
import org.example.main.Response;
import org.example.main.Session;
import org.example.models.StudyGroup;

import java.net.InetSocketAddress;

public interface RequestHandlerInterface {
    /**
     * Complete Command and Session into Request
     * @return
     */
    Response send(CommandFactory aCommand);

    /**
     * Complete Command with new Object and Session into Request
     * @return
     */
    Response send(CommandFactory aCommand, StudyGroup studyGroup);

    /**
     * Set destination of produced requests
     */
    void setRemoteHostSocketAddress(InetSocketAddress aSocketAddress);

    /**
     * Return information about RequestHandler
     */
    String getInformation();

    /**
     * Set Socket alive status(If Server is shut down)
     */
    void setSocketStatus(boolean aSocketStatus);

    /**
     * Return socket alive status
     */
    boolean getSocketStatus();

    void setSession(Session aSession);

    Session getSession();

    Response register(Session aSession);

    Response login(Session aSession);
}
