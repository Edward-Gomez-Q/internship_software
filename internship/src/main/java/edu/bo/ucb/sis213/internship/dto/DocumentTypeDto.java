package edu.bo.ucb.sis213.internship.dto;

import edu.bo.ucb.sis213.internship.entity.DocumentType;

public class DocumentTypeDto {
    private int id_document_type;
    private String type_of_document;
    //Constructor
    public DocumentTypeDto() {
    }
    //Constructor
    public DocumentTypeDto(int id_document_type, String type_of_document) {
        this.id_document_type = id_document_type;
        this.type_of_document = type_of_document;
    }
    //Constructor
    public DocumentTypeDto(DocumentType documentType){
        this.id_document_type = documentType.getDocumentId();
        this.type_of_document = documentType.getTypeOfDocument();
    }
    public int getId_document_type() {
        return id_document_type;
    }

    public void setId_document_type(int id_document_type) {
        this.id_document_type = id_document_type;
    }

    public String getType_of_document() {
        return type_of_document;
    }

    public void setType_of_document(String type_of_document) {
        this.type_of_document = type_of_document;
    }
    //Funcion para convertir de DocumentTypeDto a DocumentType
    public DocumentType toDocumentType(){
        DocumentType documentType = new DocumentType();
        documentType.setDocumentId(this.id_document_type);
        documentType.setTypeOfDocument(this.type_of_document);
        return documentType;
    }
    @Override
    public String toString() {
        return "DocumentTypeDto{" +
                "id_document_type=" + id_document_type +
                ", type_of_document='" + type_of_document + '\'' +
                '}';
    }
}
