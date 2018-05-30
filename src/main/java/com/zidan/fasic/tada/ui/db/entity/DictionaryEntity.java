package com.zidan.fasic.tada.ui.db.entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by viktor on 30.5.2018.
 */
@Entity
@Table(name = "dictionary", schema = "tada")
public class DictionaryEntity {
    private Integer id;
    private String abbreviation;
    private String explanation;
    private String notes;
    private String action;
    private Timestamp inserted;
    private Long hitcount;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "abbreviation", nullable = false, length = 200)
    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Basic
    @Column(name = "explanation", nullable = true, length = -1)
    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Basic
    @Column(name = "notes", nullable = true, length = -1)
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Basic
    @Column(name = "action", nullable = false, length = 45)
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Basic
    @Column(name = "inserted", nullable = false)
    public Timestamp getInserted() {
        return inserted;
    }

    public void setInserted(Timestamp inserted) {
        this.inserted = inserted;
    }

    @Basic
    @Column(name = "hitcount", nullable = false)
    public Long getHitcount() {
        return hitcount;
    }

    public void setHitcount(Long hitcount) {
        this.hitcount = hitcount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DictionaryEntity that = (DictionaryEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (abbreviation != null ? !abbreviation.equals(that.abbreviation) : that.abbreviation != null) return false;
        if (explanation != null ? !explanation.equals(that.explanation) : that.explanation != null) return false;
        if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;
        if (action != null ? !action.equals(that.action) : that.action != null) return false;
        if (inserted != null ? !inserted.equals(that.inserted) : that.inserted != null) return false;
        if (hitcount != null ? !hitcount.equals(that.hitcount) : that.hitcount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (abbreviation != null ? abbreviation.hashCode() : 0);
        result = 31 * result + (explanation != null ? explanation.hashCode() : 0);
        result = 31 * result + (notes != null ? notes.hashCode() : 0);
        result = 31 * result + (action != null ? action.hashCode() : 0);
        result = 31 * result + (inserted != null ? inserted.hashCode() : 0);
        result = 31 * result + (hitcount != null ? hitcount.hashCode() : 0);
        return result;
    }
}
