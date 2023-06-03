package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.Document;

public class DocumentDto {
    private int id_document;
    private String document;
    private String complement;
    private DocumentTypeDto document_type_id;
    //Constructor
    public DocumentDto() {
    }
    //Constructor
    public DocumentDto(int id_document, String document, String complement, DocumentTypeDto document_type_id) {
        this.id_document = id_document;
        this.document = document;
        this.complement = complement;
        this.document_type_id = document_type_id;
    }
    //Constructor
    public DocumentDto(Document document){
        this.id_document = document.getDocumentId();
        this.document = document.getDocument();
        this.complement = document.getComplement();
        this.document_type_id = new DocumentTypeDto(document.getDocumentType());
    }

    public int getId_document() {
        return id_document;
    }

    public void setId_document(int id_document) {
        this.id_document = id_document;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public DocumentTypeDto getDocument_type_id() {
        return document_type_id;
    }

    public void setDocument_type_id(DocumentTypeDto document_type_id) {
        this.document_type_id = document_type_id;
    }
    //ToString

    @Override
    public String toString() {
        return "DocumentDto{" +
                "id_document=" + id_document +
                ", document='" + document + '\'' +
                ", complement='" + complement + '\'' +
                ", document_type_id=" + document_type_id +
                '}';
    }
    //Funcion para convertir de DocumentDto a Document
    public Document toDocument(){
        Document document = new Document();
        document.setDocumentId(this.id_document);
        document.setDocument(this.document);
        document.setComplement(this.complement);
        document.setDocumentType(this.document_type_id.toDocumentType());
        return document;
    }
}
