package net.toadless.richypresence;

import net.toadless.discordrpc.*;
import net.toadless.richypresence.builders.RichPresenceBuilder;
import net.toadless.richypresence.util.ListenerUtils;

public class RichPresence
{
    private final RichyPresence richyPresence;
    private final DiscordEventHandlers handlers;

    public RichPresence(RichyPresence richyPresence)
    {
        this.richyPresence = richyPresence;
        this.handlers = new DiscordEventHandlers();

        //
        // Callbacks
        //
        handlers.ready = (user) -> System.out.println("Started!");
        handlers.disconnected = (int errorCode, String message) -> ListenerUtils.showPopup("Disconnected from discord! Error: " + message);
        handlers.errored = (int errorCode, String message) -> ListenerUtils.showPopup("An error occured! Error: " + message);
    }

    public void initialize()
    {
        String applicationId = richyPresence.getClientIdTextField().getText();
        if (applicationId == null || applicationId.equals("Client ID") || applicationId.equals(""))
        {
            ListenerUtils.showPopup("Please provide a valid client id!");
            return;
        }

        richyPresence.setInitialized(true);
        DiscordRPC.discordInitialize(applicationId, handlers, true);

        DiscordRichPresence presence = new RichPresenceBuilder()
                    .setDetails(richyPresence.getDetailsTextField().getText())
                    .setState(richyPresence.getStateTextField().getText())
                    .setLargeImageKey(richyPresence.getLargeImageKeyTextField().getText())
                    .setSmallImageKey(richyPresence.getSmallImageKeyTextField().getText())
                    .enableTimer()
                    .build();

        DiscordRPC.discordUpdatePresence(presence);

        startCallbackThread();
    }

    public void update()
    {
        DiscordRichPresence presence = new RichPresenceBuilder()
                .setDetails(richyPresence.getDetailsTextField().getText())
                .setState(richyPresence.getStateTextField().getText())
                .setLargeImageKey(richyPresence.getLargeImageKeyTextField().getText())
                .setSmallImageKey(richyPresence.getSmallImageKeyTextField().getText())
                .enableTimer()
                .build();

        DiscordRPC.discordUpdatePresence(presence);
    }

    public void startCallbackThread()
    {
        new Thread(() ->
        {
            while (!Thread.currentThread().isInterrupted())
            {
                DiscordRPC.discordRunCallbacks();
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException ignored)
                {}
            }
        }).start();
    }
}