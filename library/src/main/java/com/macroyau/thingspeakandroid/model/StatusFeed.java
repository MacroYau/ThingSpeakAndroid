package com.macroyau.thingspeakandroid.model;

import java.util.Date;

/***
 * Data model of a ThingSpeak Channel's status feed entry. Refer to https://thingspeak.com/docs/channels#get_status for details.
 *
 * @author Macro Yau
 */
public class StatusFeed {

    private Date createdAt;
    private long entryId;
    private String status;

    /***
     * Get the date of creation of the status feed entry.
     *
     * @return the date of creation
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /***
     * Get the ID of the status feed entry.
     *
     * @return the ID
     */
    public long getEntryId() {
        return entryId;
    }

    /***
     * Get the status message of the status feed entry.
     *
     * @return the status message
     */
    public String getStatus() {
        return status;
    }
}
