package com.nbnote.service;

import com.nbnote.db.DbHandler;
import com.nbnote.model.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by K on 2017. 6. 14..
 */
public class NoteService extends Service{
    private static final Logger logger = LoggerFactory.getLogger(NoteService.class);

    public ArrayList<Note> getAllNote(String id){
       ArrayList<Note>  notes = new ArrayList<Note>();
       StringBuilder query = new StringBuilder("select * from note where writer=?");
       Connection con = conn.getConnection();
       ResultSet rs = null;
       try {
            PreparedStatement ptmt = con.prepareStatement(query.toString());
            ptmt.setString(1, id);
            rs = ptmt.executeQuery();
            while(rs.next()) {
                Note note = new Note();
                note.setTitle(rs.getString(2));
                note.setWriter(rs.getString(3));
                note.setWriteDate(rs.getString(4));
                note.setWeather(rs.getString(5));
                note.setTemperature(rs.getString(6));
                note.setPlace(rs.getString(7));
                note.setContent(rs.getString(8));
                note.setConsumeTitle(rs.getString(9));
                note.setIncomeTitle(rs.getString(10));
                note.setConsume(rs.getString(11));
                note.setIncome(rs.getString(12));
                notes.add(note);
            }
        } catch (SQLException e) {
            logger.debug(e.getMessage());
        }

       return notes;
    }

    public Note writeNode(Note note) {
        StringBuilder query = new StringBuilder("insert into note(title, writer, writeDate, weather, temperature, place, content, " +
                "consumeTitle, incomeTitle, consume, income) values (?,?,?,?,?,?,?,?,?,?,?,?)" );
        Connection con = conn.getConnection();
        PreparedStatement ptmt = null;
        try {
            ptmt = con.prepareStatement(query.toString());
            ptmt.setString(1,note.getTitle());
            ptmt.setString(2,note.getWriter());
            ptmt.setString(3,note.getWriteDate());
            ptmt.setString(4,note.getWeather());
            ptmt.setString(5,note.getTemperature());
            ptmt.setString(6,note.getPlace());
            ptmt.setString(7,note.getContent());
            ptmt.setString(8,note.getConsumeTitle());
            ptmt.setString(9,note.getIncomeTitle());
            ptmt.setString(11,note.getConsume());
            ptmt.setString(12,note.getIncome());
            ptmt.executeQuery();
        } catch (SQLException e) {
            logger.debug(e.getMessage());
        }

        return null;
    }

}
