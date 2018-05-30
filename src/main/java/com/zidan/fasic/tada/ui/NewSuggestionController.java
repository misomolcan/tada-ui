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

    private String abbreviation;
    private String fullText;
    private String description;

    public String confirm() {
        DictionaryEntity dictionaryEntity = new DictionaryEntity();
        dictionaryEntity.setAbbreviation(abbreviation);
        dictionaryEntity.setExplanation(fullText);
        dictionaryEntity.setNotes(description);
        productRepository.save(dictionaryEntity);
//        productRepository.save(product);
//        product = new Product();
        return "/product-list.xhtml?faces-redirect=true";
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
