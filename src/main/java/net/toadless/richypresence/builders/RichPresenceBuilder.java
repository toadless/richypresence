package net.toadless.richypresence.builders;

import net.toadless.discordrpc.DiscordRichPresence;
import net.toadless.richypresence.Layout;

import java.util.Objects;

public class RichPresenceBuilder
{
    private String details;
    private String state;
    private String largeImageKey;
    private String smallImageKey;

    private boolean timer;

    public RichPresenceBuilder()
    {

    }

    public DiscordRichPresence build()
    {
        String details = getDetails();
        String state = getState();
        String largeImageKey = getLargeImageKey();
        String smallImageKey = getSmallImageKey();

        DiscordRichPresence presence = new DiscordRichPresence();
        presence.details = Objects.equals(details, Layout.DETAILS.getPlaceholder()) ? null : details;
        presence.state = Objects.equals(state, Layout.STATE.getPlaceholder()) ? null : state;
        presence.largeImageKey = Objects.equals(largeImageKey, Layout.LARGE_IMAGE_KEY.getPlaceholder()) ? null : largeImageKey;
        presence.smallImageKey = Objects.equals(smallImageKey, Layout.SMALL_IMAGE_KEY.getPlaceholder()) ? null : smallImageKey;

        if (timer) presence.startTimestamp = System.currentTimeMillis() / 1000;

        return presence;
    }

    public String getDetails()
    {
        return details;
    }

    public String getState()
    {
        return state;
    }

    public String getLargeImageKey()
    {
        return largeImageKey;
    }

    public String getSmallImageKey()
    {
        return smallImageKey;
    }

    public boolean getTimer() { return timer; }

    public RichPresenceBuilder setDetails(String details)
    {
        this.details = details;
        return this;
    }

    public RichPresenceBuilder setState(String state)
    {
        this.state = state;
        return this;
    }

    public RichPresenceBuilder setLargeImageKey(String largeImageKey)
    {
        this.largeImageKey = largeImageKey;
        return this;
    }

    public RichPresenceBuilder setSmallImageKey(String smallImageKey)
    {
        this.smallImageKey = smallImageKey;
        return this;
    }

    public RichPresenceBuilder enableTimer()
    {
        this.timer = true;
        return this;
    }
}