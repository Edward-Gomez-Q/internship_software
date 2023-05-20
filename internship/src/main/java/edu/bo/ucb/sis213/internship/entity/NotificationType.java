package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "notification_type")
public class NotificationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification_type")
    private Long notificationTypeId;

    @Column(name = "notification_type", nullable = false)
    private String notificationType;

    @Column(name = "core_msg", nullable = false)
    private String coreMsg;

    public NotificationType() {
    }

    public NotificationType(Long notificationTypeId, String notificationType, String coreMsg) {
        this.notificationTypeId = notificationTypeId;
        this.notificationType = notificationType;
        this.coreMsg = coreMsg;
    }

    public Long getNotificationTypeId() {
        return notificationTypeId;
    }

    public void setNotificationTypeId(Long notificationTypeId) {
        this.notificationTypeId = notificationTypeId;
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

    @Override
    public String toString() {
        return "NotificationType{" +
                "notificationTypeId=" + notificationTypeId +
                ", notificationType='" + notificationType + '\'' +
                ", coreMsg='" + coreMsg + '\'' +
                '}';
    }
}