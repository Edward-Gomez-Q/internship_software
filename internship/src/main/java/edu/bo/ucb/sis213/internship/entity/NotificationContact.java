package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notification_contact")
public class NotificationContact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private int notificationId;


    @ManyToOne
    @JoinColumn(name = "contact_id_contact", referencedColumnName = "id_contact")
    private Contact contactId;

    @ManyToOne
    @JoinColumn(name = "notification_type_id_notification_type", referencedColumnName = "id_notification_type")
    private NotificationType notificationTypeId;

    @Column(name = "msg", nullable = false)
    private String message;

    @Column(name = "notification_date", nullable = false)
    private Date date;

    @Column(name = "\"state\"", nullable = false)
    private Boolean state;

    public NotificationContact() {
    }

    public NotificationContact(int notificationId, Contact contactId, NotificationType notificationTypeId, String message,
                               Date date, Boolean state) {
        this.notificationId = notificationId;
        this.contactId = contactId;
        this.notificationTypeId = notificationTypeId;
        this.message = message;
        this.date = date;
        this.state = state;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public Contact getContactId() {
        return contactId;
    }

    public void setContactId(Contact contactId) {
        this.contactId = contactId;
    }

    public NotificationType getNotificationTypeId() {
        return notificationTypeId;
    }

    public void setNotificationTypeId(NotificationType notificationTypeId) {
        this.notificationTypeId = notificationTypeId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "NotificationContact{" +
                "notificationId=" + notificationId +
                ", contactId=" + contactId +
                ", notificationTypeId=" + notificationTypeId +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}