package vn.edu.likelion.manage_book.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")

public class UserEntity extends BaseEntity{

    @NonNull
    @Column(unique = true, nullable = false)
    private String username;

    @NonNull
    private String password;

    private int role_id;

    public @NonNull String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    public @NonNull String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public UserEntity(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }
}
