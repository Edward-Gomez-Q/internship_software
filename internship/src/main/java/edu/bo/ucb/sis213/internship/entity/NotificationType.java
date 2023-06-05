/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author HP
 */
@Entity
@Table(name = "notification_type")
@NamedQueries({
    @NamedQuery(name = "NotificationType.findAll", query = "SELECT n FROM NotificationType n"),
    @NamedQuery(name = "NotificationType.findByIdNotificationType", query = "SELECT n FROM NotificationType n WHERE n.idNotificationType = :idNotificationType"),
    @NamedQuery(name = "NotificationType.findByNotificationType", query = "SELECT n FROM NotificationType n WHERE n.notificationType = :notificationType"),
    @NamedQuery(name = "NotificationType.findByCoreMsg", query = "SELECT n FROM NotificationType n WHERE n.coreMsg = :coreMsg")})
public class NotificationType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_notification_type")
    private Integer idNotificationType;
    @Basic(optional = false)
    @Column(name = "notification_type")
    private String notificationType;
    @Basic(optional = false)
    @Column(name = "core_msg")
    private String coreMsg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationTypeIdNotificationType", fetch = FetchType.LAZY)
    private List<NotificationContact> notificationContactList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "notificationTypeIdNotificationType", fetch = FetchType.LAZY)
    private List<NotificationStudent> notificationStudentList;

    public NotificationType() {
    }

    public NotificationType(Integer idNotificationType) {
        this.idNotificationType = idNotificationType;
    }

    public NotificationType(Integer idNotificationType, String notificationType, String coreMsg) {
        this.idNotificationType = idNotificationType;
        this.notificationType = notificationType;
        this.coreMsg = coreMsg;
    }

    public Integer getIdNotificationType() {
        return idNotificationType;
    }

    public void setIdNotificationType(Integer idNotificationType) {
        this.idNotificationType = idNotificationType;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getCoreMsg() {
        return coreMsg;
    }

    public void setCoreMsg(String coreMsg) {
        this.coreMsg = coreMsg;
    }

    public List<NotificationContact> getNotificationContactList() {
        return notificationContactList;
    }

    public void setNotificationContactList(List<NotificationContact> notificationContactList) {
        this.notificationContactList = notificationContactList;
    }

    public List<NotificationStudent> getNotificationStudentList() {
        return notificationStudentList;
    }

    public void setNotificationStudentList(List<NotificationStudent> notificationStudentList) {
        this.notificationStudentList = notificationStudentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotificationType != null ? idNotificationType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificationType)) {
            return false;
        }
        NotificationType other = (NotificationType) object;
        if ((this.idNotificationType == null && other.idNotificationType != null) || (this.idNotificationType != null && !this.idNotificationType.equals(other.idNotificationType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.NotificationType[ idNotificationType=" + idNotificationType + " ]";
    }
    
}
