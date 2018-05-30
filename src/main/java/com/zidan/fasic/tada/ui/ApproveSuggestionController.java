package com.zidan.fasic.tada.ui;

import com.zidan.fasic.tada.ui.db.entity.DictionaryEntity;
import com.zidan.fasic.tada.ui.db.repository.DictionaryRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "approveSuggerstionController")
@ELBeanName(value = "approveSuggerstionController")
@Join(path = "/approve", to = "/approve-suggestion.jsf")
public class ApproveSuggestionController {

    @Autowired
    private DictionaryRepository productRepository;

    private String abbreviation;
    private String fullText; // explanation
    private String description; // notes

    public String confirm() {
        DictionaryEntity dictionaryEntity = productRepository.findByAbbreviationAndExplanationAndNotes(abbreviation, fullText, description);
        if (dictionaryEntity != null) {
            dictionaryEntity.setHitcount(dictionaryEntity.getHitcount() + 1);
        } else {
            dictionaryEntity = new DictionaryEntity();
            dictionaryEntity.setAbbreviation(abbreviation);
            dictionaryEntity.setExplanation(fullText);
            dictionaryEntity.setNotes(description);

            dictionaryEntity.setHitcount(1L);
            dictionaryEntity.setStatus("suggested");
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

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
