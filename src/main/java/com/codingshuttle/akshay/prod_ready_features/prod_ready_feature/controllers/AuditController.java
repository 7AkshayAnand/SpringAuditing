package com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.controllers;

import com.codingshuttle.akshay.prod_ready_features.prod_ready_feature.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/audit")
public class AuditController {
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping(path="/posts/{postId}")
    public List<PostEntity> getPostRevision(@PathVariable Long postId){
        AuditReader reader= AuditReaderFactory.get(entityManagerFactory.createEntityManager());
//        now this reader can be use to get all the information related to changes about any entity in our database

      List<Number> revisions=  reader.getRevisions(PostEntity.class,postId);

     return revisions.
              stream()
              .map(revisionNumber->reader.find(PostEntity.class,postId,revisionNumber))
              .collect(Collectors.toList());
//        i want to get information of changes about the PostEntity and for this postId
    }
}
