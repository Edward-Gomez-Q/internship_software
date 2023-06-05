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
@Table(name = "notification_student")
@NamedQueries({
    @NamedQuery(name = "NotificationStudent.findAll", query = "SELECT n FROM NotificationStudent n"),
    @NamedQuery(name = "NotificationStudent.findByIdNotification", query = "SELECT n FROM NotificationStudent n WHERE n.idNotification = :idNotification"),
    @NamedQuery(name = "NotificationStudent.findByMsg", query = "SELECT n FROM NotificationStudent n WHERE n.msg = :msg"),
    @NamedQuery(name = "NotificationStudent.findByNotificationDate", query = "SELECT n FROM NotificationStudent n WHERE n.notificationDate = :notificationDate"),
    @NamedQuery(name = "NotificationStudent.findByState", query = "SELECT n FROM NotificationStudent n WHERE n.state = :state")})
public class NotificationStudent implements Serializable {

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
    @JoinColumn(name = "notification_type_id_notification_type", referencedColumnName = "id_notification_type")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private NotificationType notificationTypeIdNotificationType;
    @JoinColumn(name = "student_id_student", referencedColumnName = "id_student")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Student studentIdStudent;

    public NotificationStudent() {
    }

    public NotificationStudent(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public NotificationStudent(Integer idNotification, String msg, Date notificationDate, boolean state) {
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

    public NotificationType getNotificationTypeIdNotificationType() {
        return notificationTypeIdNotificationType;
    }

    public void setNotificationTypeIdNotificationType(NotificationType notificationTypeIdNotificationType) {
        this.notificationTypeIdNotificationType = notificationTypeIdNotificationType;
    }

    public Student getStudentIdStudent() {
        return studentIdStudent;
    }

    public void setStudentIdStudent(Student studentIdStudent) {
        this.studentIdStudent = studentIdStudent;
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
        if (!(object instanceof NotificationStudent)) {
            return false;
        }
        NotificationStudent other = (NotificationStudent) object;
        if ((this.idNotification == null && other.idNotification != null) || (this.idNotification != null && !this.idNotification.equals(other.idNotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.est.entity.NotificationStudent[ idNotification=" + idNotification + " ]";
    }
    
}
