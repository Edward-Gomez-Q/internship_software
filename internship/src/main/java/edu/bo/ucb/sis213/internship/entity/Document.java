package edu.bo.ucb.sis213.internship.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_document")
    private Long documentId;

    @ManyToOne
    @JoinColumn(name = "document_type_id_document", referencedColumnName = "id_document")
    private DocumentType documentType;

    @Column(name = "complement", nullable = false)
    private String complement;

    @Column(name = "document", nullable = false)
    private String document;

    public Document() {
    }

    public Document(Long documentId, DocumentType documentType, String complement, String document) {
        this.documentId = documentId;
        this.documentType = documentType;
        this.complement = complement;
        this.document = document;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId=" + documentId +
                ", documentType=" + documentType +
                ", complement='" + complement + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
