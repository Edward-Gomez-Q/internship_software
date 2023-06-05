/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "notification_contact")
@NamedQueries({
    @NamedQuery(name = "NotificationContact.findAll", query = "SELECT n FROM NotificationContact n"),
    @NamedQuery(name = "NotificationContact.findByIdNotification", query = "SELECT n FROM NotificationContact n WHERE n.idNotification = :idNotification"),
    @NamedQuery(name = "NotificationContact.findByMsg", query = "SELECT n FROM NotificationContact n WHERE n.msg = :msg"),
    @NamedQuery(name = "NotificationContact.findByNotificationDate", query = "SELECT n FROM NotificationContact n WHERE n.notificationDate = :notificationDate"),
    @NamedQuery(name = "NotificationContact.findByState", query = "SELECT n FROM NotificationContact n WHERE n.state = :state")})
public class NotificationContact implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_notification")
    private Integer idNotification;
    @Basic(optional = false)
    @Column(name = "msg")
    private String msg;
    @Basic(optional = false)
    @Column(name = "notification_date")
    @Temporal(TemporalType.DATE)
    private Date notificationDate;
    @Basic(optional = false)
    @Column(name = "state")
    private boolean state;
    @JoinColumn(name = "contact_id_contact", referencedColumnName = "id_contact")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Contact contactIdContact;
    @JoinColumn(name = "notification_type_id_notification_type", referencedColumnName = "id_notification_type")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NotificationType notificationTypeIdNotificationType;

    public NotificationContact() {
    }

    public NotificationContact(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public NotificationContact(Integer idNotification, String msg, Date notificationDate, boolean state) {
        this.idNotification = idNotification;
        this.msg = msg;
        this.notificationDate = notificationDate;
        this.state = state;
    }

    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public Contact getContactIdContact() {
        return contactIdContact;
    }

    public void setContactIdContact(Contact contactIdContact) {
        this.contactIdContact = contactIdContact;
    }

    public NotificationType getNotificationTypeIdNotificationType() {
        return notificationTypeIdNotificationType;
    }

    public void setNotificationTypeIdNotificationType(NotificationType notificationTypeIdNotificationType) {
        this.notificationTypeIdNotificationType = notificationTypeIdNotificationType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotification != null ? idNotification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificationContact)) {
            return false;
        }
        NotificationContact other = (NotificationContact) object;
        if ((this.idNotification == null && other.idNotification != null) || (this.idNotification != null && !this.idNotification.equals(other.idNotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.NotificationContact[ idNotification=" + idNotification + " ]";
    }
    
}
