package com.zidan.fasic.tada.ui.db.repository;

import com.zidan.fasic.tada.ui.db.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by viktor on 30.5.2018.
 */
public interface DictionaryRepository extends JpaRepository<DictionaryEntity, Long> {
    DictionaryEntity findByAbbreviation(String abbreviation);

    @Query("select entity from DictionaryEntity entity where entity.abbreviation like ?1 and entity.status='confirmed' ")
    List<DictionaryEntity> findByAbbreviationLike(String abbreviation);

    DictionaryEntity findByAbbreviationAndExplanationAndNotes(String abbreviation, String explanation, String notes);

    @Query("select entity from DictionaryEntity  entity " +
            "where entity.abbreviation like ?1 and entity.status='suggested' order by entity.hitcount desc ")
    List<DictionaryEntity> findAllSuggestionsLike(String abbreviation);
}
