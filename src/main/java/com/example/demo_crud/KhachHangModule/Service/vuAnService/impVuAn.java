package com.example.demo_crud.KhachHangModule.Service.vuAnService;

import com.example.demo_crud.KhachHangModule.Entity.documentEntity;
import com.example.demo_crud.KhachHangModule.Entity.documentRequest;
import com.example.demo_crud.KhachHangModule.Entity.vuAnEntity;

import com.example.demo_crud.KhachHangModule.repository.documentRepository;
import com.example.demo_crud.KhachHangModule.repository.vuAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class impVuAn implements vuAnService {
    private final vuAnRepository vuAnRepository;
    private final documentRepository documentRepository;

    @Autowired
    public impVuAn(vuAnRepository vuAnRepository, documentRepository documentRepository) {
        this.vuAnRepository = vuAnRepository;
        this.documentRepository = documentRepository;
    }

    @Override
    public List<vuAnEntity> getVuAn() {
        return vuAnRepository.findAll();
    }

    @Override
    public vuAnEntity getById(Long id) throws Exception {
        if (vuAnRepository.findById(id).isEmpty()){
            throw new Exception("vu an khong ton tai");
        }
        return vuAnRepository.findById(id).get();

    }

    @Override
    public vuAnEntity create(vuAnEntity vuAn) {
        return vuAnRepository.save(vuAn);
    }

    @Override
    public documentEntity createDocument(long vuAnId, documentRequest newDocument) throws Exception {
        documentEntity documentSave = new documentEntity();
        Optional<vuAnEntity> vuAnOptional = vuAnRepository.findById(vuAnId);
        Optional<documentEntity> documentParent = documentRepository.findById(newDocument.getParent_document_id());
        if (vuAnOptional.isPresent() && documentParent.isPresent()) {
            documentSave.setVuAn(vuAnOptional.get());
            documentSave.setParentDocument(documentParent.get());
            documentSave.setName(newDocument.getName());
            documentSave.setType(newDocument.getType());
            documentSave.setUrl(newDocument.getUrl());
            System.out.println(newDocument);
            return documentRepository.save(documentSave);
        } else {
            throw new Exception("VuAn not found with ID: " + vuAnId);
        }
    }

}
