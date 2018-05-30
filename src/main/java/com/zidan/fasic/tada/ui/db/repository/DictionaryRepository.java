package com.zidan.fasic.tada.ui.db.repository;

import com.zidan.fasic.tada.ui.db.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by viktor on 30.5.2018.
 */
public interface DictionaryRepository extends JpaRepository<DictionaryEntity, Long> {
    DictionaryEntity findByAbbreviation(String abbreviation);

    DictionaryEntity findByAbbreviationAndExplanationAndNotes(String abbreviation, String explanation, String notes);
}
