package com.macroyau.thingspeakandroid.model;

import java.util.Date;

/**
 * Data model of a ThingSpeak TalkBack command. Refer to https://thingspeak.com/docs/talkback for details.
 *
 * @author Macro Yau
 */
public class TalkBackCommand {

    private String commandString;
    private Date createdAt, executedAt;
    private long id;
    private int position;

    /***
     * Get the command.
     *
     * @return the command
     */
    public String getCommandString() {
        return commandString;
    }

    /***
     * Get the date of creation of the command.
     *
     * @return the date of creation
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /***
     * Get the date of execution of the command.
     *
     * @return the date of execution
     */
    public Date getExecutedAt() {
        return executedAt;
    }

    /***
     * Get the ID of the command.
     *
     * @return the ID
     */
    public long getId() {
        return id;
    }

    /***
     * Get the position of the command.
     *
     * @return the position
     */
    public int getPosition() {
        return position;
    }

}
