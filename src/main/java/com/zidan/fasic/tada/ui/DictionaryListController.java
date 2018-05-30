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
@Component(value = "dictionaryList")
@ELBeanName(value = "dictionaryList")
@Join(path = "/dictionary", to = "/dictionary-list.jsf")
public class DictionaryListController {

    @Autowired
    private DictionaryRepository dictionaryRepository;
    private List<DictionaryEntity> dictionary;
    private String filterString;

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        dictionary = dictionaryRepository.findAll();
        filterString = "";
    }

    public List<DictionaryEntity> getDictionary() {
        return dictionary;
    }

    public String getFilterString() {
        return filterString;
    }

    public void setFilterString(String filterString) {
        this.filterString = filterString;
    }

    public void doFilter() {
        if(filterString == null || filterString.trim().isEmpty()){
            dictionary = dictionaryRepository.findAll();
        } else {
            dictionary = dictionaryRepository.findByAbbreviationLike("%" + filterString + "%");
        }
    }

}
