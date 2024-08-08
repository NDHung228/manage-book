package vn.edu.likelion.manage_book.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

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

    public UserEntity(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
    }
}
