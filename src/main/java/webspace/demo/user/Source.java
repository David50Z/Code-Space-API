package webspace.demo.user;

import javax.persistence.*;

@Entity
@Table
public class Source {

    @Id
    @SequenceGenerator(
            name = "source_sequence",
            sequenceName = "source_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "source_sequence"
    )

    private Long id;

    private String url;
    private String img;

    private String priority;

    private int priorityLevel;

    Source(
            Long id,
            String url,
            String img,
            String priority,
            int priorityLevel
    ) {
        this.url = url;
        this.img = img;
        this.priority = priority;
        this.priorityLevel = priorityLevel;
    }

    Source(
            String url,
            String img,
            String priority,
            int priorityLevel
    ) {
        this.url = url;
        this.img = img;
        this.priority = priority;
        this.priorityLevel = priorityLevel;
    }

    Source() {

    }

    public Long getId() {
        return id;
    }
    public String getUrl() {
        return url;
    }

    public String getImg() {
        return img;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String newPriority) {
        this.priority = newPriority;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int newPriorityLevel) {
        this.priorityLevel = newPriorityLevel;
    }


}
