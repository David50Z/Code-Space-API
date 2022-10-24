package webspace.demo.user;

import javax.persistence.*;

@Entity
@Table
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long id;
    private String name;
    private String email;
    private String password;

    public Source[] sources = new Source[1];

    private String preferedStyle;


    public User(
            Long id,
            String name,
            String email,
            String password,
            String preferedStyle
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferedStyle = preferedStyle;
    }

    public User(
            String name,
            String email,
            String password,
            String preferedStyle
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.preferedStyle = preferedStyle;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPreferedStyle() {return preferedStyle;}

    public Source[] getSources() {
        return sources;
    }
}
