package com.macroyau.thingspeakandroid.model;

import java.util.List;

/***
 * Data model of a ThingSpeak Channel's status updates. Refer to https://thingspeak.com/docs/channels#get_status for details.
 *
 * @author Macro Yau
 */
public class StatusUpdates {

    private Channel channel;
    private List<StatusFeed> feeds;

    /***
     * Get the basic information of the Channel.
     *
     * @return the Channel
     */
    public Channel getChannel() {
        return channel;
    }

    /***
     * Get the feed entries of the Channel's status updates.
     *
     * @return the feed entries
     */
    public List<StatusFeed> getFeeds() {
        return feeds;
    }

}
