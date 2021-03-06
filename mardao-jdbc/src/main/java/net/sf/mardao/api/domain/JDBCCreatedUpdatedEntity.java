package net.sf.mardao.api.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author os
 * 
 */
public abstract class JDBCCreatedUpdatedEntity<ID extends Serializable> extends JDBCPrimaryKeyEntity<ID> {
    /**      */
    private static final long  serialVersionUID  = 6731780654367241162L;

    public static final String NAME_CREATED_DATE = "_created";
    public static final String NAME_UPDATED_DATE = "_updated";

    public static final Date   DATE_FLAG         = new Date(0);

    private Date               createdDate;
    private Date               updatedDate;

    /**
     * Returns when this Entity was created, i.e. first persisted
     * 
     * @return when this Entity was created, i.e. first persisted
     */
    public final Date getCreatedDate() {
        return createdDate;
    }

    /**
     * Returns when this Entity was last updated
     * 
     * @return when this Entity was last updated
     */
    public final Date getUpdatedDate() {
        return updatedDate;
    }

    @Override
    public final void _setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public final void _setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * Override this method to change the name under which the created date is stored
     * 
     * @return the name under which the created date is stored
     */
    public String _getNameCreatedDate() {
        return NAME_CREATED_DATE;
    }

    /**
     * Override this method to change the name under which the updated date is stored
     * 
     * @return the name under which the updated date is stored
     */
    public String _getNameUpdatedDate() {
        return NAME_UPDATED_DATE;
    }

}
