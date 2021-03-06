package com.zidan.fasic.tada.ui;

import com.zidan.fasic.tada.ui.db.entity.DictionaryEntity;
import com.zidan.fasic.tada.ui.db.repository.DictionaryRepository;
import org.ocpsoft.rewrite.annotation.Join;
import org.ocpsoft.rewrite.el.ELBeanName;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Scope(value = "session")
@Component(value = "searchController")
@ELBeanName(value = "searchController")
public class SearchController {
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
        if (entity == null) {
            entity = new DictionaryEntity();
        }
        else {
            if (entity.getStatus().equals(Statuses.REQUESTED.name)) {
                entity.setHitcount(entity.getHitcount() + 1);
                dictionaryRepository.save(entity);
            }
        }
        renderResult = true;
        RequestContext.getCurrentInstance().update("abbreviationResultForm:abbreviationResult");
    }

    public void explain() {
        DictionaryEntity dictionaryEntity = new DictionaryEntity();
        dictionaryEntity.setAbbreviation(searchValue);
        dictionaryEntity.setHitcount(1L);
        dictionaryEntity.setStatus(Statuses.REQUESTED.name);
        dictionaryRepository.save(dictionaryEntity);
        clearVariables();
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Your abbreviation has been submitted.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    private void clearVariables() {
        renderResult = false;
        entity = null;
        searchValue = null;
        RequestContext.getCurrentInstance().update("searchForm:searchValue");
        RequestContext.getCurrentInstance().update("abbreviationResultForm:abbreviationResult");
    }
}
