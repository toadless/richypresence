package net.toadless.richypresence;

public enum Layout
{
    CLIENT_ID("Client Id"),
    DETAILS("Details"),
    STATE("State"),
    LARGE_IMAGE_KEY("Large Image Key"),
    SMALL_IMAGE_KEY("Small Image Key");

    private final String placeholder;

    Layout(String placeholder)
    {
        this.placeholder = placeholder;
    }

    public String getPlaceholder()
    {
        return placeholder;
    }
}
