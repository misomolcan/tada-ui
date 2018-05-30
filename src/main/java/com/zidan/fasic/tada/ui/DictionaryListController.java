package com.zidan.fasic.tada.ui;

import com.zidan.fasic.tada.ui.db.entity.DictionaryEntity;
import com.zidan.fasic.tada.ui.db.entity.Product;
import com.zidan.fasic.tada.ui.db.repository.DictionaryRepository;
import com.zidan.fasic.tada.ui.db.repository.ProductRepository;
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
@Component(value = "productList")
@ELBeanName(value = "productList")
@Join(path = "/", to = "/dictionary-list.jsf")
public class DictionaryListController {

    @Autowired
    private DictionaryRepository dictionaryRepository;
    private List<DictionaryEntity> dictionary;

    @Deferred
    @RequestAction
    @IgnorePostback
    public void loadData() {
        dictionary = dictionaryRepository.findAll();
    }

    public List<DictionaryEntity> getProducts() {
        return dictionary;
    }
}
