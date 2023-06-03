package edu.bo.ucb.sis213.internship.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notification_student")
public class NotificationStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notification")
    private int notificationId;

    @ManyToOne
    @JoinColumn(name = "student_id_student", referencedColumnName = "id_student")
    private Student studentId;

    @ManyToOne
    @JoinColumn(name = "notification_type_id_notification_type", referencedColumnName = "id_notification_type")
    private NotificationType notificationTypeId;

    @Column(name = "msg", nullable = false)
    private String message;

    @Column(name = "notification_date", nullable = false)
    private Date date;

    @Column(name = "\"state\"", nullable = false)
    private Boolean state;

    public NotificationStudent() {
    }

    public NotificationStudent(int notificationId, Student studentId, NotificationType notificationTypeId, String message,
                               Date date, Boolean state) {
        this.notificationId = notificationId;
        this.studentId = studentId;
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

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
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
        return "NotificationStudent{" +
                "notificationId=" + notificationId +
                ", studentId=" + studentId +
                ", notificationTypeId=" + notificationTypeId +
                ", message='" + message + '\'' +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}