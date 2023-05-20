package edu.bo.ucb.sis213.internship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "document_type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document")
    private Long documentId;

    @Column(name = "type_of_document", nullable = false)
    private String typeOfDocument;

    public DocumentType() {
    }

    public DocumentType(Long documentId, String typeOfDocument) {
        this.documentId = documentId;
        this.typeOfDocument = typeOfDocument;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getTypeOfDocument() {
        return typeOfDocument;
    }

    public void setTypeOfDocument(String typeOfDocument) {
        this.typeOfDocument = typeOfDocument;
    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "documentId=" + documentId +
                ", typeOfDocument='" + typeOfDocument + '\'' +
                '}';
    }
}
