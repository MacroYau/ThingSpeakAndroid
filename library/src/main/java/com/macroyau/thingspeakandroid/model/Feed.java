package com.macroyau.thingspeakandroid.model;

import java.util.Date;

/***
 * Data model of a ThingSpeak Channel's feed entry. Refer to https://thingspeak.com/docs/channels#get_feed for details.
 *
 * @author Macro Yau
 */
public class Feed {

    private Date createdAt;
    private long entryId;
    private String field1, field2, field3, field4, field5, field6, field7, field8;

    /***
     * Get the date of creation of the feed entry.
     *
     * @return the date of creation
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /***
     * Get the ID of the feed entry.
     *
     * @return the ID
     */
    public long getEntryId() {
        return entryId;
    }

    /***
     * Get the value of Field1 of the feed entry.
     *
     * @return the value of Field1
     */
    public String getField1() {
        return field1;
    }

    /***
     * Get the value of Field2 of the feed entry.
     *
     * @return the value of Field2
     */
    public String getField2() {
        return field2;
    }

    /***
     * Get the value of Field3 of the feed entry.
     *
     * @return the value of Field3
     */
    public String getField3() {
        return field3;
    }

    /***
     * Get the value of Field4 of the feed entry.
     *
     * @return the value of Field4
     */
    public String getField4() {
        return field4;
    }

    /***
     * Get the value of Field5 of the feed entry.
     *
     * @return the value of Field5
     */
    public String getField5() {
        return field5;
    }

    /***
     * Get the value of Field6 of the feed entry.
     *
     * @return the value of Field6
     */
    public String getField6() {
        return field6;
    }

    /***
     * Get the value of Field7 of the feed entry.
     *
     * @return the value of Field7
     */
    public String getField7() {
        return field7;
    }

    /***
     * Get the value of Field8 of the feed entry.
     *
     * @return the value of Field8
     */
    public String getField8() {
        return field8;
    }

    /***
     * Get the value of fields of the feed entry with Field1 as index 0, and so on.
     *
     * @return the value of fields
     */
    public String[] getFields() {
        return new String[] { field1, field2, field3, field4, field5, field6, field7, field8 };
    }

    /***
     * Get the value of a specific field.
     *
     * @param fieldId The ID of a field.
     * @return the name of the specific field
     */
    public String getField(int fieldId) {
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

}
