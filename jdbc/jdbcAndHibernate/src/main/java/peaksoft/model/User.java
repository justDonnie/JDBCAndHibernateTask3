package peaksoft.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "users_gen")
    @SequenceGenerator(
            name = "users_gen",
            sequenceName = "users_seq",
            allocationSize = 1)
    private Long id;
    @Column (name = "first_name", length = 22, nullable = false)
    private String name;

    @Column (name = "last_name")
    private String lastName;

    @Column
    private Byte age;


}
















