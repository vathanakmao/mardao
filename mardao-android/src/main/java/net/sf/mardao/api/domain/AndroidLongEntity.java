/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.mardao.api.domain;

/**
 * 
 * @author os
 */
public abstract class AndroidLongEntity extends AndroidCreatedUpdatedEntity<Long> {

    /**
     * 
     */
    private static final long serialVersionUID = 206571318641512930L;

    @Override
    public final Class<Long> getIdClass() {
        return Long.class;
    }

}