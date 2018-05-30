package com.zidan.fasic.tada.ui;

import com.zidan.fasic.tada.ui.db.entity.DictionaryEntity;
import com.zidan.fasic.tada.ui.db.repository.DictionaryRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "newSuggerstionController")
@ELBeanName(value = "newSuggerstionController")
@Join(path = "/new", to = "/new-suggestion.jsf")
public class NewSuggestionController {

    @Autowired
    private DictionaryRepository productRepository;
    @Autowired
    UserController userController;
    private String abbreviation;
    private String explanation;
    private String notes;

    public String addSuggestion() {
        DictionaryEntity dictionaryEntity = productRepository.findByAbbreviationAndExplanationAndNotes(abbreviation, explanation, notes);
        if (dictionaryEntity != null) {
            dictionaryEntity.setHitcount(dictionaryEntity.getHitcount() + 1);
        } else {
            dictionaryEntity = new DictionaryEntity();
            dictionaryEntity.setAbbreviation(abbreviation);
            dictionaryEntity.setExplanation(explanation);
            dictionaryEntity.setNotes(notes);
            dictionaryEntity.setHitcount(1L);
        }
        if (userController.isLoggedIn()) {
            dictionaryEntity.setStatus(Statuses.CONFIRMED.name);
        } else {
            dictionaryEntity.setStatus(Statuses.SUGGESTED.name);
        }
        productRepository.save(dictionaryEntity);
        return "/index.xhtml?faces-redirect=true";
    }


    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
