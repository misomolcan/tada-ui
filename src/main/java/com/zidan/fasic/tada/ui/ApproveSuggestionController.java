package com.zidan.fasic.tada.ui;

import com.zidan.fasic.tada.ui.db.entity.DictionaryEntity;
import com.zidan.fasic.tada.ui.db.repository.DictionaryRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.annotation.RequestAction;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.ocpsoft.rewrite.faces.annotation.Deferred;
import org.ocpsoft.rewrite.faces.annotation.IgnorePostback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Scope(value = "session")
@Component(value = "approveSuggerstionController")
@ELBeanName(value = "approveSuggerstionController")
@Join(path = "/approve", to = "/approve-suggestion.jsf")
public class ApproveSuggestionController {

    @Autowired
    private DictionaryRepository dictionaryRepository;
    private List<DictionaryEntity> suggestions;
    private String filterString;


    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        filterString = "";
        doFilter();
    }

    public String getFilterString() {
        return filterString;
    }

    public void setFilterString(String filterString) {
        this.filterString = filterString;
    }

    public List<DictionaryEntity> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<DictionaryEntity> suggestions) {
        this.suggestions = suggestions;
    }

    public void doFilter() {
        if(filterString == null || filterString.trim().isEmpty()){
            suggestions = dictionaryRepository.findAllSuggestionsLike("%");
        } else {
            suggestions = dictionaryRepository.findAllSuggestionsLike("%" + filterString + "%");
        }
    }
}
