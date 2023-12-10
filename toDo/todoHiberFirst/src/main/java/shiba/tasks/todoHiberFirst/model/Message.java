package shiba.tasks.todoHiberFirst.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.MappedCollection;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long messageId;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_message_id")
    private User user;

    @ManyToOne
    private Task taskid;

    public Message(String descriptionName, User user) {
        this.description = descriptionName;
        this.user = user;
    }

    public Message() {

    }

    public long getIdTask() {
        return messageId;
    }

    public void setIdTask(int messageId) {
        this.messageId = messageId;
    }

    public String getDescriptionName() {
        return description;
    }

    public void setDescriptionName(String descriptionName) {
        this.description = descriptionName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
