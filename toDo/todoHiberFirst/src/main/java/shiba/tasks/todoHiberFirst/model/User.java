package shiba.tasks.todoHiberFirst.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.PersistenceCreator;
import java.util.*;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "name_user", nullable = false)
    private String nameUser;

    @Column(name = "execute_role", nullable = false)
    private Boolean executeRole;

    @OneToMany(mappedBy = "userid")
    private List<Task> tasks;

    @OneToOne(cascade = CascadeType.ALL)
    private Message message;

    public User(String nameUser, Boolean executorRole) {
        this.nameUser = nameUser;
        this.executeRole = executorRole;
    }

    public User() {

    }

//    public long getId() {
//        return userId;
//    }
//
//    public void setId(int id) {
//        this.userId = id;
//    }
//
//    public String getNameUser() {
//        return nameUser;
//    }
//
//    public void setNameUser(String nameUser) {
//        this.nameUser = nameUser;
//    }
//
//    public Boolean getExecutorRole() {
//        return executeRole;
//    }
//
//    public void setExecutorRole(Boolean executorRole) {
//        this.executeRole = executorRole;
//    }
}
