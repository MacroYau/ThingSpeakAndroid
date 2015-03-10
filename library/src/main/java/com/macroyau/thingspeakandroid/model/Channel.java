package com.macroyau.thingspeakandroid.model;

import java.util.Date;
import java.util.List;

/***
 * Data model of a ThingSpeak Channel.
 *
 * @author Macro Yau
 */
public class Channel {

    private long id;
    private String name, description;
    private String latitude, longitude, elevation;
    private String field1, field2, field3, field4, field5, field6, field7, field8;
    private Date createdAt, updatedAt;
    private long lastEntryId;
    private int ranking;
    private String metadata;
    private List<String> tags;
    private String username;
    private List<ApiKey> apiKeys;

    /***
     * Get the ID of the Channel.
     *
     * @return the ID
     */
    public long getId() {
        return id;
    }

    /***
     * Get the name of the Channel.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /***
     * Get the description of the Channel.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /***
     * Get the latitude of the Channel's geolocation.
     *
     * @return the latitude in degrees
     */
    public String getLatitude() {
        return latitude;
    }

    /***
     * Get the longitude of the Channel's geolocation.
     *
     * @return the longitude in degrees
     */
    public String getLongitude() {
        return longitude;
    }

    /***
     * Get the elevation of the Channel's geolocation.
     *
     * @return the elevation in meters
     */
    public String getElevation() {
        return elevation;
    }

    /***
     * Get the name of Field1 of the Channel.
     *
     * @return the name of Field1
     */
    public String getField1() {
        return field1;
    }

    /***
     * Get the name of Field2 of the Channel.
     *
     * @return the name of Field2
     */
    public String getField2() {
        return field2;
    }

    /***
     * Get the name of Field3 of the Channel.
     *
     * @return the name of Field3
     */
    public String getField3() {
        return field3;
    }

    /***
     * Get the name of Field4 of the Channel.
     *
     * @return the name of Field4
     */
    public String getField4() {
        return field4;
    }

    /***
     * Get the name of Field5 of the Channel.
     *
     * @return the name of Field5
     */
    public String getField5() {
        return field5;
    }

    /***
     * Get the name of Field6 of the Channel.
     *
     * @return the name of Field6
     */
    public String getField6() {
        return field6;
    }

    /***
     * Get the name of Field7 of the Channel.
     *
     * @return the name of Field7
     */
    public String getField7() {
        return field7;
    }

    /***
     * Get the name of Field8 of the Channel.
     *
     * @return the name of Field8
     */
    public String getField8() {
        return field8;
    }

    /***
     * Get the name of fields of the Channel with Field1 as index 0, and so on.
     *
     * @return the name of fields
     */
    public String[] getFieldNames() {
        return new String[] { field1, field2, field3, field4, field5, field6, field7, field8 };
    }

    /***
     * Get the name of a specific field.
     *
     * @param fieldId The ID of a field.
     * @return the name of the specific field
     */
    public String getFieldName(int fieldId) {
        switch (fieldId) {
            case 1:
                return field1;
            case 2:
                return field2;
            case 3:
                return field3;
            case 4:
                return field4;
            case 5:
                return field5;
            case 6:
                return field6;
            case 7:
                return field7;
            case 8:
                return field8;
            default:
                return null;
        }
    }

    /***
     * Get the date that the Channel is created.
     * @return the date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /***
     * Get the last update date of the Channel.
     *
     * @return the date
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /***
     * Get the ID of the last feed entry of the Channel.
     *
     * @return the ID of the feed entry
     */
    public long getLastEntryId() {
        return lastEntryId;
    }

    /***
     * Get the ranking of the Channel. Available in the "List Public Channels" and "List My Channels" responses only.
     *
     * @return the ranking
     */
    public int getRanking() {
        return ranking;
    }

    /***
     * Get the metadata of the Channel. Available in the "List My Channels" responses only.
     *
     * @return the metadata
     */
    public String getMetadata() {
        return metadata;
    }

    /***
     * Get the tags of the Channel. Available in the "List Public Channels" and "List My Channels" responses only.
     *
     * @return the tag objects
     */
    public List<String> getTags() {
        return tags;
    }

    /***
     * Get the username associated with the Channel. Available in the "List Public Channels" and "List My Channels" responses only.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /***
     * Get the API keys associated with the Channel. Available in the "List My Channels" responses only.
     *
     * @return the API key objects
     */
    public List<ApiKey> getApiKeys() {
        return apiKeys;
    }

    public static class ApiKey {

        private String apiKey;
        private boolean writeFlag;

        /***
         * Get the API Key.
         *
         * @return the API Key
         */
        public String getApiKey() {
            return apiKey;
        }

        /***
         * Return true if it is a Write API Key, otherwise it is a Read API Key.
         *
         * @return true if it is a Write API Key, otherwise it is a Read API Key
         */
        public boolean isWriteKey() {
            return writeFlag;
        }

    }

    public static class Tag {

        private long id;
        private String name;

        /***
         * Get the ID of the tag
         *
         * @return the ID
         */
        public long getId() {
            return id;
        }

        /***
         * Get the name of the tag
         *
         * @return the name
         */
        public String getName() {
            return name;
        }

    }

}
