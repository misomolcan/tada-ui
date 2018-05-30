package com.zidan.fasic.tada.ui;

import com.zidan.fasic.tada.ui.db.entity.DictionaryEntity;
import com.zidan.fasic.tada.ui.db.repository.DictionaryRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(value = "session")
@Component(value = "indexController")
@ELBeanName(value = "indexController")
@Join(path = "/", to = "/index.jsf")
public class IndexController {
    private String searchValue;
    private boolean renderResult;
    private DictionaryEntity entity;

    @Autowired
    private DictionaryRepository dictionaryRepository;

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public boolean isRenderResult() {
        return renderResult;
    }

    public DictionaryEntity getEntity() {
        return entity;
    }

    public void search() {
        entity = dictionaryRepository.findByAbbreviation(searchValue);
        if (entity == null)
            entity = new DictionaryEntity();
        renderResult = true;
        RequestContext.getCurrentInstance().update("indexForm:abbreviationResult");
    }

    public void explain() {
        DictionaryEntity dictionaryEntity = new DictionaryEntity();
        dictionaryEntity.setAbbreviation(searchValue);
        dictionaryEntity.setHitcount(1L);
        dictionaryEntity.setStatus("requested");
        dictionaryRepository.save(dictionaryEntity);
        clearVariables();
        RequestContext.getCurrentInstance().update("searchForm:SearchValue");
        RequestContext.getCurrentInstance().update("indexForm:abbreviationResult");
    }

    private void clearVariables() {
        renderResult = false;
        entity = null;
    }
}
