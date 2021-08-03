package ru.borisova.dittask53.dto;

import ru.borisova.dittask53.entity.Document;

public class SaveDocumentDTO {
    private Long box_id;
    private Document document;

    public SaveDocumentDTO() {
    }

    public SaveDocumentDTO(Long box_id, Document document) {
        this.box_id = box_id;
        this.document = document;
    }

    public Long getBox_id() {
        return box_id;
    }

    public void setBox_id(Long box_id) {
        this.box_id = box_id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
