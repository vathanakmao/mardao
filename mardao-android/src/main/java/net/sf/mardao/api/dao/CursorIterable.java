/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sf.mardao.api.dao;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import net.sf.mardao.api.domain.AndroidLongEntity;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

/**
 * 
 * @author os
 */
public class CursorIterable<T extends AndroidLongEntity> extends SQLiteCursor implements Iterable<T> {

    private boolean           iterating   = false;
    private boolean           inIteration = false;

    private AndroidDaoImpl<T> dao;

    public CursorIterable(final SQLiteDatabase db, final SQLiteCursorDriver driver, final String editTable,
            final SQLiteQuery query) {
        super(db, driver, editTable, query);
    }

    public CursorIterable(final SQLiteDatabase db, final SQLiteCursorDriver driver, final String editTable,
            final SQLiteQuery query, final AndroidDaoImpl<T> dao) {
        super(db, driver, editTable, query);
        this.dao = dao;
    }

    public Iterator<T> iterator() {
        moveToFirst();
        iterating = true;
        return new CursorIterator();
    }

    @Override
    public synchronized boolean onMove(final int oldPosition, final int newPosition) {
        if (inIteration) {
            if (!iterating) {
                throw new ConcurrentModificationException();
            }
        }
        else {
            iterating = false;
        }
        return super.onMove(oldPosition, newPosition);
    }

    private class CursorIterator implements Iterator<T> {
        public CursorIterator() {
        }

        public boolean hasNext() {
            return !isAfterLast();
        }

        public synchronized T next() {
            // use cursor, create domain object, move to next
            if (isAfterLast()) {
                return null;
            }
            T domain = dao.createDomain(CursorIterable.this);
            inIteration = true;
            moveToNext();
            inIteration = false;
            return domain;
        }

        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
}
