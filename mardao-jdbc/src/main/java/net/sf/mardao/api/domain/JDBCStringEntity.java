/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.mardao.api.domain;

/**
 * 
 * @author os
 */
public abstract class JDBCStringEntity extends JDBCCreatedUpdatedEntity<String> {

    /**
     * 
     */
    private static final long serialVersionUID = -8380169217299802124L;

    @Override
    public final Class<String> getIdClass() {
        return String.class;
    }

}
